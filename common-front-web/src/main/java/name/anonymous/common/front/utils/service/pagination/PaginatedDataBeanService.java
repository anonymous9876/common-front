package name.anonymous.common.front.utils.service.pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.anonymous.common.front.configuration.i18n.I18nJs;
import name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean;
import name.anonymous.common.front.utils.service.pagination.bean.response.PaginatedDataBean;

@Service
public class PaginatedDataBeanService {
	@Autowired
	private I18nJs i18nJs;

	public void defaultUpdateJson(PaginatedDataBean<?> paginatedDataBean,
			DataTableRequestBean dataTableRequestBean) {
		setDraw(paginatedDataBean, dataTableRequestBean);
		paginatedDataBean.setMaxResult(10);
		paginatedDataBean.setLanguageUrl(i18nJs.getDataTable());
	}

	public void setDraw(PaginatedDataBean<?> paginatedDataBean, DataTableRequestBean dataTableRequestBean) {
		paginatedDataBean.setDraw(dataTableRequestBean.getDraw());
	}
}
