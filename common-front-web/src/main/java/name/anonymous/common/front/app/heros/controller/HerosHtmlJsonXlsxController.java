/**
 *
 */
package name.anonymous.common.front.app.heros.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import name.anonymous.common.front.app.heros.dto.table.MissionTableModel;
import name.anonymous.common.front.app.heros.dto.table.ProductLineItemWebModel;
import name.anonymous.common.front.app.heros.factory.HerosTableBeanFactory;
import name.anonymous.common.front.app.heros.service.MissionService;
import name.anonymous.common.front.app.heros.service.ProductLineItemService;
import name.anonymous.common.front.utils.excel.ExcelSheetBean;
import name.anonymous.common.front.utils.excel.style.LikeHtmlExcelStyle;
import name.anonymous.common.front.utils.excel.view.XlsxMonoSheetView;
import name.anonymous.common.front.utils.request.RequestUtil;
import name.anonymous.common.front.utils.service.pagination.PaginatedDataBeanService;
import name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean;
import name.anonymous.common.front.utils.service.pagination.bean.response.PaginatedDataBean;
import name.anonymous.common.front.utils.service.pagination.bean.response.facet.DataTableFacet;
import name.anonymous.common.front.utils.service.pagination.bean.response.facet.DtoDefinition;
import name.anonymous.common.front.utils.service.pagination.bean.response.helper.SupplierPortalTableBean;

@Controller
@RequestMapping({
		"/{userType}/{bu}/heros"})
public class HerosHtmlJsonXlsxController {
	@Autowired
	private RequestUtil requestUtil;

	@Autowired
	private HerosTableBeanFactory tableBeanFactory;

	@Autowired
	private PaginatedDataBeanService paginatedDataBeanService;

	@Autowired
	private MissionService missionService;

	@Autowired
	private ProductLineItemService productLineItemService;

	/**
	 * negative number return all data
	 */
	private static final int MAX_RESULT_XLSX = 10000;

	@ModelAttribute
	public void modelAttribute(Model model) {
		model.addAttribute("appName", "heros");
		model.addAttribute("requestUtil", requestUtil);
	}

	@GetMapping({
		"/",
		"/missions.html"
	})
	public String listOrders(Model model, Locale locale) {
		model.addAttribute("page", "MISSIONS");
		return "heros/html/missions.html";
	}

	@GetMapping("/missions.json")
	@ResponseBody
	public PaginatedDataBean<MissionTableModel> listOrdersPaginated(@Valid DataTableRequestBean dataTableRequestBean,@RequestParam(required = false) String commandePar)
			throws IOException {
		PaginatedDataBean<MissionTableModel> paginatedDataBean = missionService.listOrdersPaginated("1", dataTableRequestBean, commandePar);

		DataTableFacet dataTableFacet = new DataTableFacet();
		dataTableFacet.setTable(new DtoDefinition(tableBeanFactory.getOrderTableBean(paginatedDataBean.getData(), null)));
		paginatedDataBean.setFacet(dataTableFacet);
		paginatedDataBeanService.defaultUpdateJson(paginatedDataBean, dataTableRequestBean);
		return paginatedDataBean;
	}

	@PostMapping("/missions.json")
	public void newOrder(String heroSegment, MissionTableModel missionWebModel, HttpServletResponse httpServletResponse) {
		missionService.newOrder(heroSegment, missionWebModel);
		httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@PutMapping(value = "/missions.json",
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public void putOrder(MissionTableModel missionWebModel, HttpServletResponse httpServletResponse) {
		missionService.putOrder(missionWebModel);
		httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@PatchMapping(value = "/missions.json",
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public void patchOrder(MissionTableModel missionWebModel, HttpServletResponse httpServletResponse) {
		missionService.patchOrder(missionWebModel);
		httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@DeleteMapping("/missions.json")
	public void deleteOrder(@RequestBody String id, HttpServletResponse httpServletResponse) {
		missionService.deleteOrder(id);
		httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@GetMapping("/missions.xlsx")
	@ResponseBody
	public XlsxMonoSheetView listOrdersExcel(Model model, @Valid DataTableRequestBean dataTableRequestBean, @RequestParam(required = false) String commandePar,
			XlsxMonoSheetView xlsxMonoSheetView) throws IOException {
		dataTableRequestBean.setLength(MAX_RESULT_XLSX);

		PaginatedDataBean<MissionTableModel> paginatedDataBean = missionService.listOrdersPaginated("1", dataTableRequestBean, commandePar);

		SupplierPortalTableBean tableBean = tableBeanFactory.getOrderTableBean(
				paginatedDataBean.getData(), null);

		model.addAttribute(XlsxMonoSheetView.ModelAttributeName.FILE_NAME, String.format("missions %s", new SimpleDateFormat().format(new Date())));
		model.addAttribute(XlsxMonoSheetView.ModelAttributeName.SHEET_BEAN,
				new ExcelSheetBean("missions", tableBean, LikeHtmlExcelStyle.class));

		model.addAttribute(XlsxMonoSheetView.ModelAttributeName.DATA_TABLE_REQUEST_BEAN, dataTableRequestBean);
		model.addAttribute(XlsxMonoSheetView.ModelAttributeName.PAGINATED_DATA_BEAN, paginatedDataBean);
		return xlsxMonoSheetView;
	}

	@GetMapping("/mission-{idMission}-detail.html")
	public String listProductLineItem(@PathVariable String idMission, Model model, Locale locale) {
		model.addAttribute("page", "MISSION_DETAIL");
		model.addAttribute("idMission", idMission);
		return "heros/html/mission-detail.html";
	}

	@GetMapping("/mission-{idMission}-detail.json")
	@ResponseBody
	public PaginatedDataBean<ProductLineItemWebModel> listOrdersDetailPaginated(@PathVariable String idMission,
			@Valid DataTableRequestBean dataTableRequestBean) throws IOException {
		PaginatedDataBean<ProductLineItemWebModel> paginatedDataBean = productLineItemService.listProductLineItemsPaginated("1", idMission,dataTableRequestBean);

		DataTableFacet dataTableFacet = new DataTableFacet();
		dataTableFacet.setTable(new DtoDefinition(tableBeanFactory.getProductLineItemTableBean(paginatedDataBean.getData(), null)));
		paginatedDataBean.setFacet(dataTableFacet);
		paginatedDataBeanService.defaultUpdateJson(paginatedDataBean, dataTableRequestBean);
		return paginatedDataBean;
	}

	@GetMapping("/mission-{idMission}-detail.xlsx")
	@ResponseBody
	public XlsxMonoSheetView listProductLineItemExcel(@PathVariable String idMission, Model model,
			@Valid DataTableRequestBean dataTableRequestBean, XlsxMonoSheetView xlsxMonoSheetView) throws IOException {
		dataTableRequestBean.setLength(MAX_RESULT_XLSX);

		PaginatedDataBean<ProductLineItemWebModel> paginatedDataBean = productLineItemService.listProductLineItemsPaginated("1", idMission, dataTableRequestBean);

		SupplierPortalTableBean tableBean = tableBeanFactory.getProductLineItemTableBean(
				paginatedDataBean.getData(), null);

		model.addAttribute(XlsxMonoSheetView.ModelAttributeName.FILE_NAME, String.format("mission-%s-detail %s",
				idMission, new SimpleDateFormat().format(new Date())));
		model.addAttribute(XlsxMonoSheetView.ModelAttributeName.SHEET_BEAN, new ExcelSheetBean(
				String.format("mission-%s-detail", idMission), tableBean, LikeHtmlExcelStyle.class));

		model.addAttribute(XlsxMonoSheetView.ModelAttributeName.DATA_TABLE_REQUEST_BEAN, dataTableRequestBean);
		model.addAttribute(XlsxMonoSheetView.ModelAttributeName.PAGINATED_DATA_BEAN, paginatedDataBean);
		return xlsxMonoSheetView;
	}
}
