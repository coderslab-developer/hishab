/**
 * 
 */
package com.coderslab.hisab.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 *
 */
@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", unique = true, nullable = false)
	private Integer userId;

	@Column(name = "username", length = 200)
	private String username;

	@Column(name = "firstName", length = 200)
	private String firstName;

	@Column(name = "lastName", length = 200)
	private String lastName;

	@Column(name = "email", length = 200)
	private String email;

	@Column(name = "mobile", length = 11)
	private String mobile;

	@Column(name = "photo", length = 200)
	private String photo;

	@Column(name = "authority", nullable = false, length = 45)
	private String authority;

	@Column(name = "enabled", columnDefinition = "BOOLEAN")
	private boolean enabled;

	@Column(name = "archive", columnDefinition = "BOOLEAN")
	private boolean archive;

	@Temporal(TemporalType.DATE)
	@Column(name = "registerDate", nullable = false, length = 10)
	private Date registerDate;
}
