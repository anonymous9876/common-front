package name.anonymous.common.front.utils.excel.style;

import java.awt.Color;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;

import name.anonymous.common.front.utils.excel.AbstractExcelStyle;

public class LikeHtmlExcelStyle extends AbstractExcelStyle {
	private static final double FONT_HEIGHT = 10.5;
	private static final String FONT_NAME = "Helvetica Neue";

	private XSSFCellStyle headerCellStyle;
	private XSSFCellStyle bodyCellStyle;
	private XSSFCellStyle bodyDateStyle;
	private XSSFCellStyle bodyDoubleStyle;

	public LikeHtmlExcelStyle(SXSSFWorkbook workbook) {
		super(workbook);
		initBodyStyle();
		initBodyDateStyle();
		initHeaderStyle();
		initBodyDoubleStyle();
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
		return bodyDoubleStyle;
	}

	private void initBodyStyle() {
		bodyCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		setBorderStyle(bodyCellStyle, BorderStyle.THIN);
		setBorderColorStyle(bodyCellStyle, new XSSFColor(Color.decode("#888888")));

		XSSFFont bodyFont = (XSSFFont) workbook.createFont();
		bodyFont.setFontName(FONT_NAME);
		bodyFont.setFontHeight(FONT_HEIGHT);
		bodyCellStyle.setFont(bodyFont);
	}

	private void initHeaderStyle() {
		headerCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		headerCellStyle.cloneStyleFrom(bodyCellStyle);

		XSSFFont headerFont = (XSSFFont) workbook.createFont();
		headerFont.setColor(new XSSFColor(Color.decode("#ffffff")));
		headerFont.setBold(true);
		headerFont.setFontName(FONT_NAME);
		//https://websemantics.uk/articles/font-size-conversion/
		headerFont.setFontHeight(FONT_HEIGHT);
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setIndention((short)1);
		headerCellStyle.setFillForegroundColor(new XSSFColor(Color.decode("#333333")));
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		setBorderStyle(headerCellStyle, BorderStyle.THIN);
		setBorderColorStyle(headerCellStyle, new XSSFColor(Color.decode("#888888")));
	}

	private void initBodyDateStyle() {
		bodyDateStyle = (XSSFCellStyle) workbook.createCellStyle();
		bodyDateStyle.cloneStyleFrom(bodyCellStyle);
		bodyDateStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("m/d/yy"));
	}

	private void initBodyDoubleStyle() {
		bodyDoubleStyle = (XSSFCellStyle) workbook.createCellStyle();
		bodyDoubleStyle.cloneStyleFrom(bodyCellStyle);
		bodyDoubleStyle.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
	}

	private void setBorderStyle(XSSFCellStyle style, BorderStyle borderStyle) {
		style.setBorderBottom(borderStyle);
		style.setBorderTop(borderStyle);
		style.setBorderLeft(borderStyle);
		style.setBorderRight(borderStyle);
	}

	private void setBorderColorStyle(XSSFCellStyle style, XSSFColor color) {
		style.setBottomBorderColor(color);
		style.setTopBorderColor(color);
		style.setLeftBorderColor(color);
		style.setRightBorderColor(color);
	}

}
