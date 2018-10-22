package name.anonymous.common.front.utils.service.pagination.bean.response.facet;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Contains config to initialize dataTable and eventually give meta data for update data after a page change
 * @author anonymous
 *
 */
public class DataTableFacet {
	private DtoDefinition table;
	private DtoDefinition post;
	private DtoDefinition put;
	private DtoDefinition patch;

	public DtoDefinition getTable() {
		return table;
	}

	public void setTable(DtoDefinition table) {
		this.table = table;
	}

	public DtoDefinition getPost() {
		return post;
	}

	public void setPost(DtoDefinition post) {
		this.post = post;
	}

	public DtoDefinition getPut() {
		return put;
	}

	public void setPut(DtoDefinition put) {
		this.put = put;
	}

	public DtoDefinition getPatch() {
		return patch;
	}

	public void setPatch(DtoDefinition patch) {
		this.patch = patch;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
