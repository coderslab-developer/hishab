/**
 * 
 */
package com.coderslab.hisab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.hisab.repository.UserRepository;

/**
 * @author Zubayer Ahamed
 *
 */
@Service
public class UserService {

	@Autowired private UserRepository userRepository;
}
