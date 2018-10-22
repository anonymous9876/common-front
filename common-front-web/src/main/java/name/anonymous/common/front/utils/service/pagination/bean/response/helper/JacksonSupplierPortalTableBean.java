package name.anonymous.common.front.utils.service.pagination.bean.response.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

import name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant.QueryBuilderType;
import name.anonymous.common.front.utils.service.pagination.bean.response.helper.exception.GetValueException;

/**
 * Describe a table with a DTO json class (same property paths, order, types)
 *
 * @author anonymous
 *
 */
public class JacksonSupplierPortalTableBean implements SupplierPortalTableBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(JacksonSupplierPortalTableBean.class);
	private Class<?> targetTableBeanClazz;
	private List<?> datas;
	private List<String> sortedKeys;
	private ObjectMapper objectMapper;

	public <T> JacksonSupplierPortalTableBean(Class<T> targetTableBeanClazz, List<T> datas, ObjectMapper objectMapper) {
		this.targetTableBeanClazz = targetTableBeanClazz;
		this.datas = datas;
		this.objectMapper = objectMapper;
		init(targetTableBeanClazz);
	}

	private void init(Class<?> clazz) {
		sortedKeys = sortedKeys(clazz);
	}

	private List<String> sortedKeys(Class<?> clazz) {
		List<String> sortedKeys = new ArrayList<>();
		sortedKeysAux(clazz, sortedKeys, "");
		return sortedKeys;
	}

	private void sortedKeysAux(Class<?> clazz, List<String> sortedKeys, String prefix) {
		boolean isNotAQueryBuilderType = isNotAQueryBuilderType(clazz);
		if (isNotAQueryBuilderType) {
			return;
		}
		QueryBuilderType type = toType(clazz);
		if (QueryBuilderType.OBJECT.equals(type)) {
			for (BeanPropertyDefinition property : getAvailableProperties(clazz)) {
				sortedKeysAux(property.getField().getRawType(), sortedKeys, ("".equals(prefix) ? "" : prefix + ".") + property.getName());
			}
		} else {
			sortedKeys.add(prefix);
		}
	}

	private boolean isNotAQueryBuilderType(Class<?> clazz) {
		return clazz == null ||
				clazz.isAssignableFrom(UUID.class) ||
				clazz.isAssignableFrom(Iterable.class) ||
				clazz.isAssignableFrom(Map.class);
	}

	@Override
	public Map<String, String> getHeaderLabelsByName() {
		Map<String, String> headerLabelsBykey = new HashMap<>();
		for (String fieldName : sortedKeys) {
			headerLabelsBykey.put(fieldName, fieldName);
		}
		return headerLabelsBykey;
	}

	@Override
	public List<Map<String, Object>> getBodyValuesByKeyInList() {
		List<Map<String, Object>> bodyValuesByKeyList = new ArrayList<>();
		for (Object data : datas) {
			Map<String, Object> row = new HashMap<>();
			try {
				retrieveValuesByPropertyPathRecursively("", data, row);
			} catch (Exception e) {
				LOGGER.error(String.format("unable to get a value with object %s, row skiped", data), e);
			}
			bodyValuesByKeyList.add(row);
		}
		return bodyValuesByKeyList;
	}

	@Override
	public List<String> getAllSortedPropertyPaths() {
		return sortedKeys;
	}

	public Map<String, QueryBuilderType> getTypesByPropertyPath() {
		return getTypeByPropertyPath(targetTableBeanClazz);
	}

	private Map<String, QueryBuilderType> getTypeByPropertyPath(Class<?> clazz) {
		Map<String, QueryBuilderType> typeByfieldNamesFiltredAndSortedByJackson = new LinkedHashMap<>();
		retrieveTypesByPropertyPathRecursively("", clazz, typeByfieldNamesFiltredAndSortedByJackson);
		return typeByfieldNamesFiltredAndSortedByJackson;
	}

	private void retrieveTypesByPropertyPathRecursively(String prefix, Class<?> clazz, Map<String, QueryBuilderType> typesByPropertyPath) {
		boolean isNotAQueryBuilderType = isNotAQueryBuilderType(clazz);
		if (isNotAQueryBuilderType) {
			return;
		}
		QueryBuilderType type = toType(clazz);
		if (QueryBuilderType.OBJECT.equals(type)) {
			for (BeanPropertyDefinition property : getAvailableProperties(clazz)) {
				String newKey = null;
				if ("".equals(prefix)) {
					newKey = property.getName();
				} else {
					newKey = prefix + "." + property.getName();
				}
				retrieveTypesByPropertyPathRecursively(newKey, property.getGetter().getRawReturnType(), typesByPropertyPath);
			}
		} else {
			typesByPropertyPath.put(prefix, type);
		}
	}

	private void retrieveValuesByPropertyPathRecursively(String prefix, Object obj, Map<String, Object> valuesByPropertyPath) throws GetValueException {
		if (obj == null) {
			valuesByPropertyPath.put(prefix, obj);
		} else {
			Class<?> clazz = obj.getClass();
			QueryBuilderType type = toType(clazz);
			if (QueryBuilderType.OBJECT.equals(type)) {
				for (BeanPropertyDefinition property : getAvailableProperties(clazz)) {
					String newKey = null;
					if ("".equals(prefix)) {
						newKey = property.getName();
					} else {
						newKey = prefix + "." + property.getName();
					}
					retrieveValuesByPropertyPathRecursively(newKey, toValue(property, obj), valuesByPropertyPath);
				}
			} else {
				valuesByPropertyPath.put(prefix, obj);
			}
		}
	}

	private List<BeanPropertyDefinition> getAvailableProperties(Class<?> clazz) {
		JavaType javaType = objectMapper.getTypeFactory().constructType(clazz);
		SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
		BeanDescription beanDescription = serializationConfig.introspect(javaType);

		Set<String> ignoredProperties = serializationConfig.getAnnotationIntrospector()
				.findPropertyIgnorals(beanDescription.getClassInfo()).getIgnored();

		return beanDescription.findProperties().stream()
				.filter(property -> !ignoredProperties.contains(property.getName())).collect(Collectors.toList());
	}

	private QueryBuilderType toType(Class<?> clazz) {
		if (String.class.isAssignableFrom(clazz)) {
			return QueryBuilderType.STRING;
		} else if (Integer.class.isAssignableFrom(clazz)) {
			return QueryBuilderType.INTEGER;
		} else if (Number.class.isAssignableFrom(clazz)) {
			return QueryBuilderType.DOUBLE;
		} else if (Boolean.class.isAssignableFrom(clazz)) {
			return QueryBuilderType.BOOLEAN;
		} else if (LocalDateTime.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz)
				|| Calendar.class.isAssignableFrom(clazz)) {
			return QueryBuilderType.DATETIME;
		} else if (LocalDate.class.isAssignableFrom(clazz)) {
			return QueryBuilderType.DATE;
		} else if (LocalTime.class.isAssignableFrom(clazz) || OffsetTime.class.isAssignableFrom(clazz)) {
			return QueryBuilderType.TIME;
		} else {
			return QueryBuilderType.OBJECT;
		}
	}

	private Object toValue(BeanPropertyDefinition beanPropertyDefinition, Object object) throws GetValueException {
		try {
			return beanPropertyDefinition.getGetter().getAnnotated().invoke(object);
		} catch (Exception e) {
			GetValueException getValueException = new GetValueException(String.format("unable to get value of property name %s with object %s",
					beanPropertyDefinition == null ? "" : beanPropertyDefinition.getName(), object), e);
			getValueException.setBeanPropertyDefinition(beanPropertyDefinition);
			getValueException.setObject(object);
			throw getValueException;
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
