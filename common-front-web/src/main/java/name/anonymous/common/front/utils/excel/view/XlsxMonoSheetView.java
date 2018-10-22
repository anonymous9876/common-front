package name.anonymous.common.front.utils.excel.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

import name.anonymous.common.front.utils.excel.ExcelSheetBean;
import name.anonymous.common.front.utils.excel.ExcelSheetWriter;

public class XlsxMonoSheetView extends AbstractXlsxStreamingView {
	public class ModelAttributeName {
		private ModelAttributeName() {}
		public static final String FILE_NAME = "FILE_NAME";
		public static final String SHEET_BEAN = "SHEET_BEAN";
		public static final String DATA_TABLE_REQUEST_BEAN = "DATA_TABLE_REQUEST_BEAN";
		public static final String PAGINATED_DATA_BEAN = "PAGINATED_DATA_BEAN";
	}

	private static final String EXTENSION = ".xlsx";
	private ExcelSheetWriter excelSheetWriter;

	public XlsxMonoSheetView() {
		excelSheetWriter = new ExcelSheetWriter();
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExcelSheetBean sheetBean = (ExcelSheetBean) model.get(ModelAttributeName.SHEET_BEAN);
		String fileName = (String) model.get(ModelAttributeName.FILE_NAME);
		if (fileName == null) {
			fileName = "";
		}
		String fileNameWithExtension = fileName + EXTENSION;
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", fileNameWithExtension));

		SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet(sheetBean.getName());
		excelSheetWriter.write(sheet, sheetBean);
	}
}
