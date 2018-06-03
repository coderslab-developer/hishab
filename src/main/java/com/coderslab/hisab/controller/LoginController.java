package com.coderslab.hisab.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private static final String LOCATION = "views/login";

	@RequestMapping
	public String loadLoginPage(Model model, HttpSession session) {
		session.setAttribute("lastLogin", String.valueOf(new Date()));
		logger.info("Login page called at {}", new Date());
		return LOCATION;
	}

}
