package name.anonymous.common.front.utils.service.pagination.bean.request.embded;

/**
 * embded in :
 * @see name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean
 * Sent parameters by datatable library
 * see "Sent parameters" section of official datatables library :
 * https://datatables.net/manual/server-side
 * @author anonymous
 *
 */
public class DataTableSearch {
	private String value;

	private Boolean regex;

	/**
	 * Global search value. To be applied to all columns which have searchable as true.
	 */
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 	true if the global filter should be treated as a regular expression for advanced searching, false otherwise. Note that normally server-side processing scripts will not perform regular expression searching for performance reasons on large data sets, but it is technically possible and at the discretion of your script.
	 */
	public Boolean getRegex() {
		return regex;
	}
	public void setRegex(Boolean regex) {
		this.regex = regex;
	}
}
