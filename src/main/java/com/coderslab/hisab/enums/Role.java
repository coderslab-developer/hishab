/**
 * 
 */
package com.coderslab.hisab.enums;

/**
 * @author Zubayer Ahamed
 *
 */
public enum Role {
	ROLE_ADMIN("Admin"), ROLE_CLIENT("Client");

	private String code;

	private Role(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
