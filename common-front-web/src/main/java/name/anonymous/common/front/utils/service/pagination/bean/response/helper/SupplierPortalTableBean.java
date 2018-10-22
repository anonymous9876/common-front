package name.anonymous.common.front.utils.service.pagination.bean.response.helper;
import java.util.List;
import java.util.Map;

import name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant.QueryBuilderType;

/**
 * Describe a table (HTML, Excel) :
 * columns
 * types
 * header labels
 * values cell
 * @author anonymous
 *
 */
public interface SupplierPortalTableBean {
	public List<String> getAllSortedPropertyPaths();
	public Map<String, QueryBuilderType> getTypesByPropertyPath();
	public Map<String, String> getHeaderLabelsByName();
	public List<Map<String, Object>> getBodyValuesByKeyInList();
}
