package name.anonymous.common.front.utils.excel.style;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import name.anonymous.common.front.utils.excel.AbstractExcelStyle;

public class DefaultExcelStyle extends AbstractExcelStyle {
	private XSSFCellStyle headerCellStyle;
	private XSSFCellStyle bodyCellStyle;
	private XSSFCellStyle bodyDateStyle;
	private XSSFCellStyle bodyDoubleStyle;
	
	public DefaultExcelStyle(SXSSFWorkbook workbook) {
		super(workbook);
		headerCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		bodyCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		bodyDateStyle = (XSSFCellStyle) workbook.createCellStyle();
		bodyDateStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("m/d/yy"));
		bodyDoubleStyle = (XSSFCellStyle) workbook.createCellStyle();
		bodyDoubleStyle.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
	}
	
	@Override
	public XSSFCellStyle getHeaderStyle(String propertyPath) {
		return headerCellStyle;
	}

	@Override
	public XSSFCellStyle getBodyStyle(String propertyPath, Object value) {
		return bodyCellStyle;
	}

	@Override
	public XSSFCellStyle getBodyDateStyle(String propertyPath, Object value) {
		return bodyDateStyle;
	}
	
	@Override
	public XSSFCellStyle getBodyDoubleStyle(String propertyPath, Object value) {
		return bodyDateStyle;
	}
}
