package name.anonymous.common.front.utils.service.pagination.bean.response;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import name.anonymous.common.front.utils.service.pagination.bean.response.facet.DataTableFacet;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Ajax response waiting by datatable js library for server side processing :
 * see "Returned data" section of offical datatables documentation :
 * https://datatables.net/manual/server-side
 *
 * @author anonymous
 *
 * @param <T> T is a DTO class
 */
@JsonPropertyOrder({ "draw", "error", "recordsFiltered", "recordsTotal", "maxResult", "languageUrl", "facet", "data" })
public class PaginatedDataBean<T> {
	@JsonInclude(Include.NON_NULL)
	private String error;
	private DataTableFacet facet;
	private Integer draw;
	private Integer recordsFiltered;
	private Integer recordsTotal;
	private Integer maxResult;
	private String languageUrl;
	private List<T> data;

	public PaginatedDataBean() {
		facet = new DataTableFacet();
		data = new ArrayList<>();
		recordsFiltered = 0;
		recordsTotal = 0;
		draw = 0;
	}

	/**
	 * No a official dataTable field
	 * @see name.anonymous.common.front.utils.service.pagination.bean.response.facet.DataTableFacet
	 * @return
	 */
	public DataTableFacet getFacet() {
		return facet;
	}

	public void setFacet(DataTableFacet facet) {
		this.facet = facet;
	}

	/**
	 * The draw counter that this object is a response to - from the draw parameter
	 * sent as part of the data request. Note that it is strongly recommended for
	 * security reasons that you cast this parameter to an integer, rather than
	 * simply echoing back to the client what it sent in the draw parameter, in
	 * order to prevent Cross Site Scripting (XSS) attacks.
	 *
	 * @return
	 */
	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	/**
	 * Total records, after filtering (i.e. the total number of records after
	 * filtering has been applied - not just the number of records being returned
	 * for this page of data).
	 *
	 * @return
	 */
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	/**
	 * Total records, before filtering (i.e. the total number of records in the
	 * database)
	 *
	 * @return
	 */
	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	/**
	 * The data to be displayed in the table. This is an array of data source
	 * objects, one for each row, which will be used by DataTables. Note that this
	 * parameter's name can be changed using the ajax option's dataSrc property.
	 *
	 * @return
	 */
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 * Optional: If an error occurs during the running of the server-side processing
	 * script, you can inform the user of this error by passing back the error
	 * message to be displayed using this parameter. Do not include if there is no
	 * error.
	 *
	 * @return
	 */
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getLanguageUrl() {
		return languageUrl;
	}
	/**
	 * No a official dataTable field
	 * url to get i18n datatable file
	 * @param languageUrl
	 */
	public void setLanguageUrl(String languageUrl) {
		this.languageUrl = languageUrl;
	}

	/**
	 * No a official dataTable field
	 * default number line by page for datatable pagination
	 * @return
	 */
	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
