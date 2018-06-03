/**
 * 
 */
package com.coderslab.hisab.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderslab.hisab.model.User;
import com.coderslab.hisab.service.UserService;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	private static final Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired private UserService userService;

	@PostMapping
	public @ResponseBody String registerUser(User user) {
		
		user.setArchive(false);
		user.setEnabled(true);
		user.setRegisterDate(new Date());
		//userService.save(user);
		
		logger.info(user);
		return "success";
	}
}
