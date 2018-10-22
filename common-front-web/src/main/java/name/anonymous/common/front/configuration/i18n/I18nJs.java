package name.anonymous.common.front.configuration.i18n;

import org.apache.commons.lang.builder.ToStringBuilder;

public class I18nJs {
	private String dataTable;
	private String queryBuilder;
	private String queryBuilderLocale;
	private String datePicker;
	private String datePickerLocale;
	private String moment;
	private String momentLocale;
	private String select;

	public String getDataTable() {
		return dataTable;
	}

	public void setDataTable(String dataTable) {
		this.dataTable = dataTable;
	}

	public String getQueryBuilder() {
		return queryBuilder;
	}

	public void setQueryBuilder(String queryBuilder) {
		this.queryBuilder = queryBuilder;
	}

	public String getQueryBuilderLocale() {
		return queryBuilderLocale;
	}

	public void setQueryBuilderLocale(String queryBuilderLocale) {
		this.queryBuilderLocale = queryBuilderLocale;
	}

	public String getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(String datePicker) {
		this.datePicker = datePicker;
	}
	
	public String getDatePickerLocale() {
		return datePickerLocale;
	}

	public void setDatePickerLocale(String datePickerLocale) {
		this.datePickerLocale = datePickerLocale;
	}
	
	public String getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public String getMomentLocale() {
		return momentLocale;
	}

	public void setMomentLocale(String momentLocale) {
		this.momentLocale = momentLocale;
	}
	
	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
