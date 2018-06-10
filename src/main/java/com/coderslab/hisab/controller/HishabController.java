/**
 * 
 */
package com.coderslab.hisab.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.coderslab.hisab.model.AppConfig;
import com.coderslab.hisab.model.User;
import com.coderslab.hisab.service.UserService;

/**
 * @author Zubayer Ahamed
 *
 */
public class HishabController {

	public SimpleDateFormat current_month = new SimpleDateFormat("MMM, YYYY");

	@Autowired
	AppConfig appConfig;
	@Autowired
	UserService userService;

	@ModelAttribute("user")
	public User getUserInfo() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		User user = userService.findByUsername(username);

		appConfig.setUsername(user.getUsername());
		appConfig.setLastLogin(new Date());
		appConfig.setUserFirstName(user.getFirstName());
		appConfig.setUserLastName(user.getLastName());
		appConfig.setUserEmail(user.getEmail());
		appConfig.setUserMobile(user.getMobile());

		return user;
	}

}
