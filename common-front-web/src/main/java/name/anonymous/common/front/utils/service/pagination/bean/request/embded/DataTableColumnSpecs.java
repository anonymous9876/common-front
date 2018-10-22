/**
 *
 */
package name.anonymous.common.front.utils.service.pagination.bean.request.embded;

/**
 * embded in :
 *
 * @see name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean
 *      Sent parameters by datatable library see "Sent parameters" section of
 *      official datatables library : https://datatables.net/manual/server-side
 * @author anonymous
 *
 */
public class DataTableColumnSpecs {

	private String data;
	private String name;
	private Boolean searchable;
	private Boolean orderable;
	private DataTableSearch search;

	/**
	 * https://datatables.net/reference/option/columns.data
	 *
	 * This property can be used to read and write data to and from any data source
	 * property, including deeply nested objects / properties. data can be given in
	 * a number of different ways which effect its behaviour as documented below.
	 *
	 * The data that is resolved to for a data point (between this option and
	 * columns.render) to will be used by DataTables for the requested data, with
	 * three special cases:
	 *
	 * undefined - the columns.defaultContent value will be used. If there is no
	 * default content specified, an error will be given. null - If columns.render
	 * is used, the data passed to the rendering function will be the original data
	 * source for the row. If there is no renderer the columns.defaultContent value
	 * will be used. If there is no default content specified, for display data an
	 * empty sting will be used. null will be used for all other data types.
	 * function - the function will be executed and the returned value used. As of
	 * DataTables 1.10.1 the function will be executed in the same scope as the data
	 * object for the row. The result of this is that an object instance can be used
	 * as the data source for a row. Note that data is both a getter and setter
	 * option. If you just require formatting of data for output, you will likely
	 * want to use columns.render which is simply a getter and thus much simpler to
	 * use!
	 *
	 * As of DataTables 1.10.3 this option can be used with a DOM sourced data to
	 * instruct DataTables where to write the data read for each column to in a data
	 * source object. By default DataTables will store the data in an array, but
	 * using this option you can provide object property names which describe the
	 * structure of the object to use (example).
	 *
	 * @return
	 */
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * https://datatables.net/reference/option/columns.name
	 *
	 * When working with DataTables' API, it is very common to want to be able to
	 * address individual columns so you can work with them (you wish to sum the
	 * numeric content of a column for example). DataTables has two basic methods of
	 * addressing columns:
	 *
	 * As a column index (automatically assigned when the table is initialised) With
	 * a name - assigned using this option! This can make working with columns in
	 * the API very easy - for example to access the data from the column named
	 * location you would use table.column( 'location:name' ).data() - append the
	 * string :name to indicate to DataTables that it should perform a column name
	 * selector operation. For more information about column selectors, please see
	 * the column() documentation.
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * Flag to indicate if this column is searchable (true) or not (false). This is
	 * controlled by columns.searchable :
	 * https://datatables.net/reference/option/columns.searchable Using this
	 * parameter, you can defined if DataTables should include this column in the
	 * filterable data in the table. You may want use this option to display
	 * filtering on generated columns such as 'Edit' and 'Delete' buttons for
	 * example.
	 *
	 * @return
	 */
	public Boolean getSearchable() {
		return searchable;
	}

	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}

	/**
	 * Flag to indicate if this column is orderable (true) or not (false). This is
	 * controlled by columns.orderable.
	 * https://datatables.net/reference/option/columns.orderable
	 *
	 * Using this parameter, you can remove the end user's ability to order upon a
	 * column. This might be useful for generated content columns, for example if
	 * you have 'Edit' or 'Delete' buttons in the table.
	 *
	 * Note that this option only effects the end user's ability to order a column.
	 * Developers are still able to order a column using the order option or the
	 * order() method if required.
	 *
	 * @return
	 */
	public Boolean getOrderable() {
		return orderable;
	}

	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}
	/**
	 * @return #link{DataTableSearch}
	 */
	public DataTableSearch getSearch() {
		return search;
	}

	public void setSearch(DataTableSearch search) {
		this.search = search;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataTableColumnSpecs [data=").append(data).append(", name=").append(name)
				.append(", searchable=").append(searchable).append(", orderable=").append(orderable).append(", search=")
				.append(search).append("]");
		return builder.toString();
	}
}
