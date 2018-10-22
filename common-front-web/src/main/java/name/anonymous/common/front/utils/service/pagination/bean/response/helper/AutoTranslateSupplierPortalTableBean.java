package name.anonymous.common.front.utils.service.pagination.bean.response.helper;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;

import name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant.QueryBuilderType;

/**
 * Associate a default message source code for each property paths
 * usefull, for generate header labels of a datatable or query builder filter labels.
 * generaly, code has this form : "application.propertyPath"
 * @author anonymous
 *
 */
public class AutoTranslateSupplierPortalTableBean implements SupplierPortalTableBean {
	private SupplierPortalTableBean tableBean;
	private MessageSource messageSource;
	private Locale locale;
	private String prefix;

	public AutoTranslateSupplierPortalTableBean(SupplierPortalTableBean tableBean, MessageSource messageSource, Locale locale, String prefix) {
		this.tableBean = tableBean;
		this.messageSource = messageSource;
		this.locale = locale;
		this.prefix = prefix;
	}

	private String getMessage(String code) {
		String newCode = prefix + code;
		return messageSource.getMessage(newCode, null, newCode, locale);
	}

	@Override
	public List<String> getAllSortedPropertyPaths() {
		return tableBean.getAllSortedPropertyPaths();
	}

	@Override
	public Map<String, String> getHeaderLabelsByName() {
		Map<String, String> headerLabelsByName = tableBean.getHeaderLabelsByName();
		for (String key : headerLabelsByName.keySet()) {
			headerLabelsByName.put(key, getMessage(key));
		}
		return headerLabelsByName;
	}

	@Override
	public List<Map<String, Object>> getBodyValuesByKeyInList() {
		return tableBean.getBodyValuesByKeyInList();
	}

	@Override
	public Map<String, QueryBuilderType> getTypesByPropertyPath() {
		return tableBean.getTypesByPropertyPath();
	}
}