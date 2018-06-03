/**
 * 
 */
package com.coderslab.hisab.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController extends HishabController{

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@GetMapping
	public String loadIndexPage(Model model) {
		model.addAttribute("currentMonth", current_month.format(new Date()));
		return "views/index";
	}
}
