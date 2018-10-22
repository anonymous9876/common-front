package name.anonymous.common.front.app.heros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import name.anonymous.common.front.utils.request.RequestUtil;

@Controller
@RequestMapping("/{userType}/{bu}/heros")
public class HerosJsController {
	@Autowired
	private RequestUtil requestUtil;

	@ModelAttribute
	public void modelAttribute(Model model) {
		model.addAttribute("requestUtil", requestUtil);
	}

	@GetMapping("/{page}/datatable-config.js")
	public String dataTableConfigJs(@PathVariable String page) {
		return "heros/js/" + page + "/datatable-config.js";
	}

	@GetMapping("/{page}/querybuilder-config.js")
	public String queryBuilderConfigJs(@PathVariable String page) {
		return "heros/js/" + page + "/querybuilder-config.js";
	}
}
