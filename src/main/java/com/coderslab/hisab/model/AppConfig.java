/**
 * 
 */
package com.coderslab.hisab.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 *
 */
@Data
@Component
public class AppConfig {

	private String username;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userMobile;
	private Date lastLogin;
}
