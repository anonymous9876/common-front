package name.anonymous.common.front.configuration.i18n;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class I18nJsFactory {
	private static final String DATA_TABLE_I18N_PATH = "/DataTables/i18n/";
	private static final String DATA_TABLE_I18N_FILENAME_PATERN = "%s.lang";

	private static final String QUERY_BUILDER_I18N_PATH = "/QueryBuilder/i18n/";
	private static final String QUERY_BUILDER_I18N_FILENAME_PATERN = "query-builder.%s.js";

	private static final String DATE_PICKER_I18N_PATH = "/bootstrap-datepicker/locales/";
	private static final String DATE_PICKER_I18N_FILENAME_PATERN = "bootstrap-datepicker.%s.min.js";

	private static final String SELECT_I18N_PATH = "/bootstrap-select/i18n/";
	private static final String SELECT_I18N_FILENAME_PATERN = "defaults-%s.js";

	private static final String MOMENT_I18N_PATH = "/moment/locale/";
	private static final String MOMENT_I18N_FILENAME_PATERN = "%s.js";

	private String resourcePath;
	private static final String BASE_PATH = "/resources/lib";

	private static final Logger LOGGER = LoggerFactory.getLogger(I18nJsFactory.class);

	private HashMap<Locale, String> dataTableI18nByLocale = new HashMap<>();
	private HashMap<Locale, String> queryBuilderI18nByLocale = new HashMap<>();
	private HashMap<Locale, String> datePickerI18nByLocale = new HashMap<>();
	private HashMap<Locale, String> momentI18nByLocale = new HashMap<>();
	private HashMap<Locale, String> selectI18nByLocale = new HashMap<>();

	@Autowired
	public I18nJsFactory(ServletContext servletContext) {
		resourcePath = servletContext.getRealPath("/"); //"/resources"
	}

	public I18nJs getI18nJs() {
		I18nJs i18nJs = new I18nJs();
		Locale locale = LocaleContextHolder.getLocale();
		i18nJs.setDataTable(getDataTableI18nUrl(locale));
		i18nJs.setQueryBuilder(getQueryBuilderI18nUrl(locale));
		i18nJs.setQueryBuilderLocale(getQueryBuilderI18Locale(locale));
		i18nJs.setDatePicker(getDatePicker(locale));
		i18nJs.setDatePickerLocale(getDatePickerLocale(locale));
		i18nJs.setMoment(getMoment(locale));
		i18nJs.setMomentLocale(getMomentLocale(locale));
		i18nJs.setSelect(getSelect(locale));
		return i18nJs;
	}

	private String getSelect(Locale locale) {
		return selectI18nByLocale.computeIfAbsent(locale, this::getSelectI18n);
	}

	private String getMomentLocale(Locale locale) {
		return momentI18nByLocale.computeIfAbsent(locale, this::getMomentI18nLocale);
	}


	private String getMoment(Locale locale) {
		String datePickerPath = BASE_PATH + MOMENT_I18N_PATH;
		return datePickerPath + String.format(MOMENT_I18N_FILENAME_PATERN, getQueryBuilderI18Locale(locale));
	}


	private String getDatePickerLocale(Locale locale) {
		return datePickerI18nByLocale.computeIfAbsent(locale, this::getDatePickerI18nLocale);
	}

	private String getDatePicker(Locale locale) {
		String datePickerPath = BASE_PATH + DATE_PICKER_I18N_PATH;
		return datePickerPath + String.format(DATE_PICKER_I18N_FILENAME_PATERN, getQueryBuilderI18Locale(locale));
	}

	public String getDataTableI18nUrl(Locale locale) {
		return dataTableI18nByLocale.computeIfAbsent(locale, this::getDataTableI18n);
	}

	public String getQueryBuilderI18Locale(Locale locale) {
		return queryBuilderI18nByLocale.computeIfAbsent(locale, this::getQueryBuilderI18nLocale);
	}

	public String getQueryBuilderI18nUrl(Locale locale) {
		String queryBuilderPath = BASE_PATH + QUERY_BUILDER_I18N_PATH;
		return queryBuilderPath + String.format(QUERY_BUILDER_I18N_FILENAME_PATERN, getQueryBuilderI18Locale(locale));
	}

	private boolean isFile(String path) {

		return new File(path).exists();
	}

	private String getDataTableI18n(Locale locale) {
		String dataTablePath = BASE_PATH + DATA_TABLE_I18N_PATH;
		String dataTableI18nUrl = dataTablePath + String.format(DATA_TABLE_I18N_FILENAME_PATERN, locale.getDisplayLanguage(Locale.US) + "-" + locale.getDisplayCountry(Locale.US));
		if (!isFile(resourcePath + dataTableI18nUrl)) {
			dataTableI18nUrl = dataTablePath + String.format(DATA_TABLE_I18N_FILENAME_PATERN, locale.getDisplayLanguage(Locale.US));
			if (!isFile(resourcePath + dataTableI18nUrl)) {
				dataTableI18nUrl = dataTablePath + "English.lang";
				if (LOGGER.isWarnEnabled()) {
					LOGGER.warn(String.format("dataTable has not i18n file for local %s", locale));
				}
			}
		}
		return dataTableI18nUrl;
	}

	private String getSelectI18n(Locale locale) {
		String selectPath = BASE_PATH + SELECT_I18N_PATH;
		String selectI18nUrl = selectPath + String.format(SELECT_I18N_FILENAME_PATERN, locale);
		if (!isFile(resourcePath + selectI18nUrl)) {
			selectI18nUrl = selectPath + String.format(SELECT_I18N_FILENAME_PATERN, locale.getLanguage());
			if (!isFile(resourcePath + selectI18nUrl)) {
				selectI18nUrl = selectPath + "defaults-en_US.js";
				if (LOGGER.isWarnEnabled()) {
					LOGGER.warn(String.format("select has not i18n file for local %s", locale));
				}
			}
		}
		return selectI18nUrl;
	}

	private String getQueryBuilderI18nLocale(Locale locale) {
		String queryTablePath = BASE_PATH + QUERY_BUILDER_I18N_PATH;
		String queryBuilderI18nUrl = queryTablePath + String.format(QUERY_BUILDER_I18N_FILENAME_PATERN, locale);
		String localeString = locale.toString();
		if (!isFile(resourcePath + queryBuilderI18nUrl)) {
			queryBuilderI18nUrl = queryTablePath + String.format(QUERY_BUILDER_I18N_FILENAME_PATERN, locale.getLanguage());
			localeString = locale.getLanguage();
			if (!isFile(resourcePath + queryBuilderI18nUrl)) {
				localeString = "en";
				if (LOGGER.isWarnEnabled()) {
					LOGGER.warn(String.format("queryBuilder has not i18n file for local %s", locale));
				}
			}
		}
		return localeString;
	}

	private String getDatePickerI18nLocale(Locale locale) {
		String queryTablePath = BASE_PATH + DATE_PICKER_I18N_PATH;
		String queryBuilderI18nUrl = queryTablePath + String.format(DATE_PICKER_I18N_FILENAME_PATERN, locale);
		String localeString = locale.toString();
		if (!isFile(resourcePath + queryBuilderI18nUrl)) {
			queryBuilderI18nUrl = queryTablePath + String.format(DATE_PICKER_I18N_FILENAME_PATERN, locale.getLanguage());
			localeString = locale.getLanguage();
			if (!isFile(resourcePath + queryBuilderI18nUrl)) {
				localeString = "en";
				if (LOGGER.isWarnEnabled()) {
					LOGGER.warn(String.format("datePicker has not i18n file for local %s", locale));
				}
			}
		}
		return localeString;
	}

	private String getMomentI18nLocale(Locale locale) {
		String queryTablePath = BASE_PATH + MOMENT_I18N_PATH;
		String queryBuilderI18nUrl = queryTablePath + String.format(MOMENT_I18N_FILENAME_PATERN, locale);
		String localeString = locale.toString();
		if (!isFile(resourcePath + queryBuilderI18nUrl)) {
			queryBuilderI18nUrl = queryTablePath + String.format(MOMENT_I18N_FILENAME_PATERN, locale.getLanguage());
			localeString = locale.getLanguage();
			if (!isFile(resourcePath + queryBuilderI18nUrl)) {
				localeString = "en";
				if (LOGGER.isWarnEnabled()) {
					LOGGER.warn(String.format("moment has not i18n file for local %s", locale));
				}
			}
		}
		return localeString;
	}
}
