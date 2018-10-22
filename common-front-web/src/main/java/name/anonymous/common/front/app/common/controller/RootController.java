package name.anonymous.common.front.app.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import name.anonymous.common.front.app.heros.service.EmailService;

@Controller
public class RootController {
	@Autowired
	private EmailService emailService;

	@GetMapping({ "/" })
	public String dev() {
		return "root";
	}
}
