package com.zy.zy_filesystem.controller.personalData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class personalDataController {

	@GetMapping("/personalData")
	public String toPersonalData() {
		return "personalData/personalData";
	}
}
