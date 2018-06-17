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
@Table(name = "expensetype")
public class ExpenseType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "expenseTypeId", unique = true, nullable = false)
	private Integer expenseTypeId;

	@Column(name = "expenseTypeName", length = 200)
	private String expenseTypeName;

	@Column(name = "icon", length = 200)
	private String icon;

	@Column(name = "notes", length = 65535)
	private String notes;
	
	@Column(name = "userId")
	private Integer userId;
}
