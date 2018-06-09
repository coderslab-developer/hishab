/**
 * 
 */
package com.coderslab.hisab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.hisab.model.User;
import com.coderslab.hisab.repository.UserRepository;

/**
 * @author Zubayer Ahamed
 *
 */
@Service
public class UserService {

	@Autowired private UserRepository userRepository;

	public boolean save(User user) {
		User returnedUser = userRepository.save(user);
		return returnedUser != null ? true : false;
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
