package name.anonymous.common.front.app.heros.controller.delegate;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import name.anonymous.common.front.app.heros.dto.table.ProductLineItemWebModel;
import name.anonymous.common.front.app.heros.service.delegate.ProductLineItemService;
import name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean;
import name.anonymous.common.front.utils.service.pagination.bean.response.PaginatedDataBean;

@RestController
@RequestMapping({
		"/{userType}/{bu}/heros"})
public class ProductLineItemController {
	@Autowired
	private ProductLineItemService productLineItemService;

	@GetMapping("product-line-items")
	public PaginatedDataBean<ProductLineItemWebModel> listProductLineItemsPaginated(String idMission, DataTableRequestBean dataTableRequestBean)
			throws IOException {
		return productLineItemService.listProductLineItemsPaginated(idMission, dataTableRequestBean);
	}


}
