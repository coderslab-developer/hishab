/**
 * 
 */
package com.coderslab.hisab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.hisab.repository.ExpenseTypeRepository;

/**
 * @author Zubayer Ahamed
 *
 */
@Service
public class ExpenseTypeService {

	@Autowired private ExpenseTypeRepository expenseTypeRepository;
}
