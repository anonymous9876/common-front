package name.anonymous.common.front.utils.service.pagination.bean.response.facet;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import name.anonymous.common.front.utils.service.pagination.bean.response.facet.embed.DataTableFilter;
import name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant.QueryBuilderType;
import name.anonymous.common.front.utils.service.pagination.bean.response.helper.SupplierPortalTableBean;

public class DtoDefinition {
	private List<String> propertyPaths;
	private Map<String, DataTableFilter> filtersByPropertyPath;

	public DtoDefinition(SupplierPortalTableBean tableBean) {
		initPropertiyPathsToGetFieldOrderAndAvaillableFields(tableBean);
		initFiltersByPropertyPath(tableBean);
		setFiltersTitleToTranslateHeaderColumns(tableBean);
	}


	public void initPropertiyPathsToGetFieldOrderAndAvaillableFields(SupplierPortalTableBean tableBean) {
		setPropertyPaths(tableBean.getAllSortedPropertyPaths());
	}

	public void initFiltersByPropertyPath(SupplierPortalTableBean tableBean) {
		Map<String, QueryBuilderType> typesByPropertyPath = tableBean.getTypesByPropertyPath();
		Map<String, DataTableFilter> filtersByPropertyPath = typesByPropertyPath.entrySet().stream()
				.collect(Collectors.toMap(Entry::getKey, e -> {
					DataTableFilter filter = new DataTableFilter();
					filter.setType(e.getValue());
					return filter;
				}));
		setFiltersByPropertyPath(filtersByPropertyPath);
	}

	public void setFiltersTitleToTranslateHeaderColumns(SupplierPortalTableBean tableBean) {
		Map<String, String> headerLabelsByName = tableBean.getHeaderLabelsByName();
		Map<String, DataTableFilter> filtersByPropertyPath = getFiltersByPropertyPath();
		for (Entry<String, DataTableFilter> entry : filtersByPropertyPath.entrySet()) {
			DataTableFilter dataTableFilter = entry.getValue();
			dataTableFilter.setTitle(headerLabelsByName.get(entry.getKey()));
		}
	}

	/**
	 *
	 * @return default order of visible datatables columns
	 */
	public List<String> getPropertyPaths() {
		return propertyPaths;
	}

	public void setPropertyPaths(List<String> propertyPaths) {
		this.propertyPaths = propertyPaths;
	}

	public Map<String, DataTableFilter> getFiltersByPropertyPath() {
		return filtersByPropertyPath;
	}

	public void setFiltersByPropertyPath(Map<String, DataTableFilter> filtersByPropertyPath) {
		this.filtersByPropertyPath = filtersByPropertyPath;
	}
}
