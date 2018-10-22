package name.anonymous.common.front.utils.excel;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/**
 * Describe a excel style for a excel table
 * @author anonymous
 *
 */
public abstract class AbstractExcelStyle {
	protected SXSSFWorkbook workbook;

	public AbstractExcelStyle(SXSSFWorkbook workbook) {
		super();
		this.workbook = workbook;
	}

	public SXSSFWorkbook getWorkbook() {
		return workbook;
	}

	public abstract XSSFCellStyle getHeaderStyle(String propertyPath);
	public abstract XSSFCellStyle getBodyStyle(String propertyPath, Object value);
	public abstract XSSFCellStyle getBodyDateStyle(String propertyPath, Object value);
	public abstract XSSFCellStyle getBodyDoubleStyle(String propertyPath, Object value);
}
