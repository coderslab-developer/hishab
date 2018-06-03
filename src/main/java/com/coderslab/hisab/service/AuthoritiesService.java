/**
 * 
 */
package com.coderslab.hisab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.hisab.model.Authorities;
import com.coderslab.hisab.repository.AuthoritiesRepository;

/**
 * @author Zubayer Ahamed
 *
 */
@Service
public class AuthoritiesService {

	@Autowired
	private AuthoritiesRepository authoritiesRepository;

	public boolean save(Authorities authorities) {
		Authorities a = authoritiesRepository.save(authorities);
		return a != null ? true : false;
	}
}
