package name.anonymous.common.front.utils.service.pagination.bean.request.embded;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * embded in :
 * @see name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean
 * Sent parameters by datatable library
 * see "Sent parameters" section of official datatables library :
 * https://datatables.net/manual/server-side
 * @author anonymous
 *
 */
public class DataTableOrder {
	@NotNull
    @NotEmpty
	private Integer column;

	@NotNull
    @NotEmpty
	private String dir;

	/**
	 * 	Column to which ordering should be applied. This is an index reference to the columns array of information that is also submitted to the server.
	 * @return
	 */
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	/**
	 * Ordering direction for this column. It will be asc or desc to indicate ascending ordering or descending ordering, respectively.
	 * @return
	 */
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataTableOrder [column=").append(column).append(", dir=").append(dir).append("]");
		return builder.toString();
	}
}
