package name.anonymous.common.front.utils.service.pagination.bean.response.helper;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant.QueryBuilderType;

/**
 * Remove table columns
 * @author anonymous
 *
 */
public class ProjectionTableBean  implements SupplierPortalTableBean {
	private SupplierPortalTableBean tableBean;
	private Set<String> tulpes;

	public ProjectionTableBean(SupplierPortalTableBean tableBean, Set<String> tulpes) {
		this.tableBean = tableBean;
		this.tulpes = tulpes;
	}

	@Override
	public List<String> getAllSortedPropertyPaths() {
		if (tulpes == null) {
			return tableBean.getAllSortedPropertyPaths();
		}
		return tableBean.getAllSortedPropertyPaths()
			.stream()
			.filter(s -> tulpes.contains(s)).collect(Collectors.toList());
	}

	@Override
	public Map<String, String> getHeaderLabelsByName() {
		if (tulpes == null) {
			return tableBean.getHeaderLabelsByName();
		}
		Map<String, String> headerLabelsByName = tableBean.getHeaderLabelsByName();
		headerLabelsByName
			.keySet()
			.stream()
			.collect(Collectors.toSet())
			.stream()
			.filter(s -> !tulpes.contains(s))
			.forEach(headerLabelsByName::remove);
		return headerLabelsByName;
	}

	@Override
	public Map<String, QueryBuilderType> getTypesByPropertyPath() {
		if (tulpes == null) {
			return tableBean.getTypesByPropertyPath();
		}
		Map<String, QueryBuilderType> typesByPropertyPath = tableBean.getTypesByPropertyPath();
		typesByPropertyPath
			.keySet()
			.stream()
			.collect(Collectors.toSet())
			.stream()
			.filter(s -> !tulpes.contains(s))
			.forEach(typesByPropertyPath::remove);
		return typesByPropertyPath;
	}

	@Override
	public List<Map<String, Object>> getBodyValuesByKeyInList() {
		return tableBean.getBodyValuesByKeyInList();
	}
}