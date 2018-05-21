/**
 * 
 */
package com.coderslab.hisab.enums;

/**
 * @author Zubayer Ahamed
 *
 */
public enum TransactionType {
	EXPENSE("Expense"), INCOME("Income"), MONEY_TRANSFER("Money transfer");

	private String code;

	private TransactionType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
