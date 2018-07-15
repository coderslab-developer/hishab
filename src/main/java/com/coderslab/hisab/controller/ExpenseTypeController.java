/**
 * 
 */
package com.coderslab.hisab.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderslab.hisab.model.ExpenseType;
import com.coderslab.hisab.model.User;
import com.coderslab.hisab.service.ExpenseTypeService;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping("/expensetype")
public class ExpenseTypeController extends HishabController {
	private static final Logger logger = LoggerFactory.getLogger(ExpenseTypeController.class);

	@Autowired ExpenseTypeService expenseTypeService;

	@PostMapping("/save")
	public ResponseEntity<String> saveExpenseType(ExpenseType expenseType) {
		logger.debug("Expense type {}", expenseType);
		if(expenseType.getExpenseTypeId() != null) {
			return updateExpenseType(expenseType);
		}

		expenseType.setUserId(userService.findByUsername(appConfig.getUsername()).getUserId());
		boolean stat = expenseTypeService.save(expenseType);
		if (Boolean.TRUE == stat) {
			return new ResponseEntity<>("Expense type created successfully", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Expense type not created", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<String> updateExpenseType(ExpenseType expenseType) {
		ExpenseType et = expenseTypeService.findOne(expenseType.getExpenseTypeId());
		et.setExpenseTypeName(expenseType.getExpenseTypeName());
		et.setNotes(expenseType.getNotes());

		boolean stat = expenseTypeService.save(et);
		if (Boolean.TRUE == stat) {
			return new ResponseEntity<>("Expense type update successfully", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Expense type not update", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/findAll")
	public @ResponseBody List<ExpenseType> findAllExpenseType(){
		User user = userService.findByUsername(appConfig.getUsername());
		return expenseTypeService.findAllByUserId(user.getUserId());
	}
}
