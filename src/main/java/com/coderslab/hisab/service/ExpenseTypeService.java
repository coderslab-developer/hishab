/**
 * 
 */
package com.coderslab.hisab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.hisab.model.ExpenseType;
import com.coderslab.hisab.repository.ExpenseTypeRepository;

/**
 * @author Zubayer Ahamed
 *
 */
@Service
public class ExpenseTypeService {

	@Autowired private ExpenseTypeRepository expenseTypeRepository;
	
	public boolean save(ExpenseType expenseType) {
		ExpenseType et = expenseTypeRepository.save(expenseType);
		return et == null ? false : true;
	}

	public ExpenseType findOne(Integer expenseTypeId) {
		return expenseTypeRepository.findOne(expenseTypeId);
	}

	public List<ExpenseType> findAllByUserId(Integer userId) {
		return expenseTypeRepository.findAllByUserId(userId);
	}

	public void delete(Integer expenseTypeId) {
		expenseTypeRepository.delete(expenseTypeId);
	}
}
