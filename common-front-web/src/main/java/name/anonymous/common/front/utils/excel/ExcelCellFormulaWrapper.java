package name.anonymous.common.front.utils.excel;

/**
 * Usefull for excel view to distinct String and Formula
 * @author anonymous
 *
 */
public class ExcelCellFormulaWrapper {
	private String cellForula;

	public String getCellForula() {
		return cellForula;
	}


	public void setCellForula(String cellForula) {
		this.cellForula = cellForula;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SupplierPortalExcelCellFormulaWrapper [cellForula=").append(cellForula).append("]");
		return builder.toString();
	}
}
