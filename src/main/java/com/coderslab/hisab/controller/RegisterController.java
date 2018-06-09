/**
 * 
 */
package com.coderslab.hisab.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderslab.hisab.enums.Role;
import com.coderslab.hisab.model.Authorities;
import com.coderslab.hisab.model.User;
import com.coderslab.hisab.service.AuthoritiesService;
import com.coderslab.hisab.service.UserService;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	private static final Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private AuthoritiesService authoritiesService;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostMapping
	public ResponseEntity<String> registerUser(User user) {

		user.setArchive(false);
		user.setEnabled(true);
		user.setRegisterDate(new Date());
		user.setAuthority(Role.ROLE_CLIENT.name());
		user.setPassword(encoder.encode(user.getPassword()));

		Authorities authorities = new Authorities();
		authorities.setAuthority(Role.ROLE_CLIENT.name());
		authorities.setUsername(user.getUsername());
		authorities.setArchive(false);

		boolean stat = userService.save(user);
		if (Boolean.TRUE == stat) {
			boolean fintalStat = authoritiesService.save(authorities);
			if (Boolean.TRUE == fintalStat) {
				return new ResponseEntity<>("User create successfully", HttpStatus.OK);
			}
		}

		return new ResponseEntity<>("User not create", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
