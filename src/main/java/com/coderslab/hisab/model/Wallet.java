/**
 * 
 */
package com.coderslab.hisab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 *
 */
@Data
@Entity
@Table(name = "wallet")
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "walletId", unique = true, nullable = false)
	private Integer walletId;

	@Column(name = "userId")
	private Integer userId;

	@Column(name = "walletName", length = 200)
	private String walletName;

	@Column(name = "currentBalance")
	private double currentBalance;

	@Column(name = "icon", length = 200)
	private String icon;

	@Column(name = "notes", length = 65535)
	private String notes;
}
