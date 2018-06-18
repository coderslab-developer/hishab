/**
 * 
 */
package com.coderslab.hisab.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 *
 */
@Data
@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transactionId", unique = true, nullable = false)
	private Integer transactionId;

	@Column(name = "transactionType", length = 200)
	private String transactionType;

	@Column(name = "expenseAmount")
	private double expenseAmount;

	@Column(name = "transferAmount")
	private double transferAmount;

	@Column(name = "incomeAmount")
	private double incomeAmount;

	@Column(name = "transactionCharge")
	private double transactionCharge;

	@Column(name = "fromWalletId")
	private Integer fromWalletId;

	@Column(name = "toWalletId")
	private Integer toWalletId;

	@Column(name = "incomeSourceId")
	private Integer incomeSourceId;

	@Column(name = "expenseTypeId")
	private Integer expenseTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name = "transactionDate", nullable = false, length = 10)
	private Date transactionDate;

	@Column(name = "transactionTime", length = 200)
	private String transactionTime;

	@Column(name = "notes", length = 65535)
	private String notes;

	@Column(name = "userId")
	private Integer userId;

	@Transient
	private List<Wallet> wallets;

	@Transient
	private List<ExpenseType> expenseTypes;
}
