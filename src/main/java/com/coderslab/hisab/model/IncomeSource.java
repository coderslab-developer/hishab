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
@Table(name = "incomeSource")
public class IncomeSource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "incomeSourceId", unique = true, nullable = false)
	private Integer incomeSourceId;

	@Column(name = "incomeSourceName", length = 200)
	private String incomeSourceName;

	@Column(name = "icon", length = 200)
	private String icon;

	@Column(name = "note", length = 65535)
	private String note;
}
