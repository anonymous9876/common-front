package name.anonymous.common.front.utils.excel;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ComparisonOperator;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant.QueryBuilderType;

/**
 * 
 * @author anonymous
 */
public class ExcelSheetWriter {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelSheetWriter.class);
	private static final int WIDTH_ARROW_BUTTON = 900;

	public AbstractExcelStyle getStyle(Workbook workbook, Class<? extends AbstractExcelStyle> clazz) {
		try {
			return clazz.getDeclaredConstructor(SXSSFWorkbook.class).newInstance(workbook);
		} catch (Exception e) {
			LOGGER.error(String.format("unable to instanciate style class %s, stop sheet writing", clazz), e);
			return null;
		}
	}

	public void write(SXSSFSheet sheet, ExcelSheetBean supplierPortalExcelSheetBean) {
		final int AUTO_SIZE_MAX_ROWS = 50;
		sheet.trackAllColumnsForAutoSizing();

		List<String> allSortedPropertyPaths = supplierPortalExcelSheetBean.getTableBean().getAllSortedPropertyPaths();
		Map<String, String> headerLabelsByName = supplierPortalExcelSheetBean.getTableBean().getHeaderLabelsByName();
		List<Map<String, Object>> bodyValuesByKeyInList = supplierPortalExcelSheetBean.getTableBean().getBodyValuesByKeyInList();
		Map<String, QueryBuilderType> typesByPropertyPath = supplierPortalExcelSheetBean.getTableBean().getTypesByPropertyPath();

		List<Integer> doubleColumnIndexList = new ArrayList<>();

		AbstractExcelStyle style = getStyle(sheet.getWorkbook(), supplierPortalExcelSheetBean.getExcelStyle());
		if (style == null) {
			return;
		}
		sheet.createFreezePane(0, 1, 0, 1);
		int rowCount = 0;
		int columnCount = 0;

		Row headerRow = sheet.createRow(rowCount++);
		for (String propertyPath : allSortedPropertyPaths) {
			QueryBuilderType type = typesByPropertyPath.get(propertyPath);
			if (QueryBuilderType.DOUBLE.equals(type)) {
				doubleColumnIndexList.add(columnCount);
			}

			Cell cell = headerRow.createCell(columnCount++);
			String headerLabel = headerLabelsByName.get(propertyPath);
			cell.setCellValue(headerLabel);
			cell.setCellStyle(style.getHeaderStyle(propertyPath));
		}

		for (int i = 0; i < columnCount; i++) {
			sheet.autoSizeColumn(i);
		}
		// https://websemantics.uk/articles/font-size-conversion/
		headerRow.setHeightInPoints(29);

		for (Map<String, Object> bodyValuesByKey : bodyValuesByKeyInList) {
			Row row = sheet.createRow(rowCount++);
			columnCount = 0;
			for (String propertyPath : allSortedPropertyPaths) {
				Cell cell = row.createCell(columnCount++);
				Object value = bodyValuesByKey.get(propertyPath);
				cell.setCellStyle(style.getBodyDateStyle(propertyPath, value));
				setCellValue(cell, propertyPath, value, style);
			}
			if (rowCount == AUTO_SIZE_MAX_ROWS) {
				autoResize(sheet, columnCount);
			}
		}
		int indexRowCount = rowCount - 1;
		int indexColumnCount = columnCount - 1;
		if (indexRowCount >= 0 && indexColumnCount >= 0) {
			CellRangeAddress allCellRange = new CellRangeAddress(0, indexRowCount, 0, indexColumnCount);
			sheet.setAutoFilter(allCellRange);
			formatEvenRow(sheet, allCellRange);

			List<CellRangeAddress> doubleCellRange = new ArrayList<>();
			for (Integer doubleColumnIndex : doubleColumnIndexList) {
				doubleCellRange.add(new CellRangeAddress(1, indexRowCount, doubleColumnIndex, doubleColumnIndex));
			}
			formatNegativeNumber(sheet, doubleCellRange.toArray(new CellRangeAddress[doubleCellRange.size()]));
		}

		if (rowCount < AUTO_SIZE_MAX_ROWS) {
			autoResize(sheet, columnCount);
		}
	}

	private void autoResize(SXSSFSheet sheet, int columnCount) {
		for (int i = 0; i < columnCount; i++) {
			int headerWidth = sheet.getColumnWidth(i);
			sheet.autoSizeColumn(i);
			int newWidth = sheet.getColumnWidth(i);

			int rest = WIDTH_ARROW_BUTTON - (newWidth - headerWidth);
			if (rest > 0) {
				sheet.setColumnWidth(i, headerWidth + rest);
			}
			sheet.untrackColumnForAutoSizing(i);
		}
	}

	private void formatNegativeNumber(SXSSFSheet sheet, CellRangeAddress[] regions) {
		ConditionalFormattingRule rule = sheet.getSheetConditionalFormatting().createConditionalFormattingRule(
				ComparisonOperator.LT,
				"0");
		FontFormatting fontFmt = rule.createFontFormatting();
		// https://stackoverflow.com/questions/47232915/exception-when-using-poi-fontformatting-setfontcolor
		fontFmt.setFontColorIndex((short) 1);
		fontFmt.setFontColor(new XSSFColor(Color.decode("#ff0000")));
		fontFmt.setFontStyle(false, true);

		sheet.getSheetConditionalFormatting().addConditionalFormatting(regions, rule);
	}

	private void formatEvenRow(SXSSFSheet sheet, CellRangeAddress cellRange) {
		ConditionalFormattingRule rule = sheet.getSheetConditionalFormatting().createConditionalFormattingRule("=ROW()=EVEN(ROW())");
		PatternFormatting pattFmt = rule.createPatternFormatting();
		pattFmt.setFillBackgroundColor(new XSSFColor(Color.decode("#ebebeb")));
		pattFmt.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

		CellRangeAddress[] regions = {
				cellRange
		};
		sheet.getSheetConditionalFormatting().addConditionalFormatting(regions, rule);
	}

	private void setCellValue(Cell cell, String propertyPath, Object value, AbstractExcelStyle style) {
		if (value != null) {
			if (value instanceof RichTextString) {
				cell.setCellValue((RichTextString) value);
			} else if (value instanceof Boolean) {
				cell.setCellValue((Boolean) value);
			} else if (value instanceof Long) {
				cell.setCellValue((Long) value);
			} else if (value instanceof Integer) {
				cell.setCellValue((Integer) value);
			} else if (value instanceof Number) {
				double doubleValue = ((Number) value).doubleValue();
				cell.setCellStyle(style.getBodyDoubleStyle(propertyPath, doubleValue));
				cell.setCellValue(doubleValue);
			} else if (value instanceof Date) {
				cell.setCellValue((Date) value);
				cell.setCellStyle(style.getBodyDateStyle(propertyPath, value));
			} else if (value instanceof Calendar) {
				cell.setCellValue((Calendar) value);
				cell.setCellStyle(style.getBodyDateStyle(propertyPath, value));
			} else if (value instanceof LocalDate) {
				LocalDate ld = (LocalDate) value;
				Calendar c = GregorianCalendar.getInstance();
				c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				cell.setCellValue(c);
				cell.setCellStyle(style.getBodyDateStyle(propertyPath, value));
			} else if (value instanceof ExcelCellFormulaWrapper) {
				cell.setCellFormula(((ExcelCellFormulaWrapper) value).getCellForula());
			} else {
				cell.setCellValue(value.toString());
			}
		}
	}
}
