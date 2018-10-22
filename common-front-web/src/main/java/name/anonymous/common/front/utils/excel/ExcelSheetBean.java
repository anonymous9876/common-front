package name.anonymous.common.front.utils.excel;

import name.anonymous.common.front.utils.excel.style.DefaultExcelStyle;
import name.anonymous.common.front.utils.service.pagination.bean.response.helper.SupplierPortalTableBean;

/**
 * Describe a excel file
 * @author anonymous
 *
 */
public class ExcelSheetBean {
	private String name;
	private SupplierPortalTableBean tableBean;
	private Class<? extends AbstractExcelStyle> excelStyle;

	public ExcelSheetBean(String name, SupplierPortalTableBean tableBean) {
		super();
		this.name = name;
		this.tableBean = tableBean;
		this.excelStyle = DefaultExcelStyle.class;
	}

	public ExcelSheetBean(String name, SupplierPortalTableBean tableBean, Class<? extends AbstractExcelStyle> excelStyle) {
		super();
		this.name = name;
		this.tableBean = tableBean;
		this.excelStyle = excelStyle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<? extends AbstractExcelStyle> getExcelStyle() {
		return excelStyle;
	}

	public void setExcelStyle(Class<? extends AbstractExcelStyle> excelStyle) {
		this.excelStyle = excelStyle;
	}



	public SupplierPortalTableBean getTableBean() {
		return tableBean;
	}

	public void setTableBean(SupplierPortalTableBean tableBean) {
		this.tableBean = tableBean;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SupplierPortalExcelSheetBean [name=").append(name).append(", tableBean=").append(tableBean).append(", excelStyle=").append(excelStyle).append("]");
		return builder.toString();
	}
}
