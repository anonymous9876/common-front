package name.anonymous.common.front.app.heros.util.bean;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;

import name.anonymous.common.front.utils.constant.MessageSourcePrefix;
import name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant.QueryBuilderType;
import name.anonymous.common.front.utils.service.pagination.bean.response.helper.SupplierPortalTableBean;



public class MissionTableBean implements SupplierPortalTableBean {
	private SupplierPortalTableBean tableBean;
	private MessageSource messageSource;
	private Locale locale;

	public MissionTableBean(SupplierPortalTableBean tableBean, MessageSource messageSource, Locale locale) {
		this.tableBean = tableBean;
		this.messageSource = messageSource;
		this.locale = locale;
	}

	private String getMessage(String code) {
		String newCode = MessageSourcePrefix.HEROS + code;
		return messageSource.getMessage(newCode, null, newCode, locale);
	}

	@Override
	public List<String> getAllSortedPropertyPaths() {
		return tableBean.getAllSortedPropertyPaths();
	}

	@Override
	public Map<String, String> getHeaderLabelsByName() {
		return tableBean.getHeaderLabelsByName();
	}

	@Override
	public List<Map<String, Object>> getBodyValuesByKeyInList() {
		return tableBean.getBodyValuesByKeyInList();
	}

	@Override
	public Map<String, QueryBuilderType> getTypesByPropertyPath() {
		return tableBean.getTypesByPropertyPath();
	}
}
