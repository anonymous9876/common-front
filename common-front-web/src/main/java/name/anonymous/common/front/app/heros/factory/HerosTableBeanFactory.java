package name.anonymous.common.front.app.heros.factory;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import name.anonymous.common.front.app.heros.dto.table.MissionTableModel;
import name.anonymous.common.front.app.heros.dto.table.ProductLineItemWebModel;
import name.anonymous.common.front.app.heros.util.bean.ProductLineItemTableBean;
import name.anonymous.common.front.app.heros.util.bean.MissionTableBean;
import name.anonymous.common.front.utils.constant.MessageSourcePrefix;
import name.anonymous.common.front.utils.service.pagination.bean.response.helper.AutoTranslateSupplierPortalTableBean;
import name.anonymous.common.front.utils.service.pagination.bean.response.helper.JacksonSupplierPortalTableBean;
import name.anonymous.common.front.utils.service.pagination.bean.response.helper.ProjectionTableBean;

@Service
public class HerosTableBeanFactory {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ObjectMapper objectMapper;

	private Locale getLocale() {
		return LocaleContextHolder.getLocale();
	}

	public MissionTableBean getOrderTableBean(List<MissionTableModel> data, Set<String> tulpes) {
		return new MissionTableBean(
				new AutoTranslateSupplierPortalTableBean(
						new ProjectionTableBean(
								new JacksonSupplierPortalTableBean(MissionTableModel.class, data, objectMapper), tulpes),
						messageSource, getLocale(), MessageSourcePrefix.HEROS),
				messageSource, getLocale());
	}

	public ProductLineItemTableBean getProductLineItemTableBean(List<ProductLineItemWebModel> data, Set<String> tulpes) {
		return new ProductLineItemTableBean(
				new AutoTranslateSupplierPortalTableBean(
						new ProjectionTableBean(
								new JacksonSupplierPortalTableBean(ProductLineItemWebModel.class, data, objectMapper), tulpes),
						messageSource, getLocale(), MessageSourcePrefix.HEROS),
				messageSource, getLocale());
	}
}
