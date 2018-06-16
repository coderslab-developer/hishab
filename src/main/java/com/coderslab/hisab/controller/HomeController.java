/**
 * 
 */
package com.coderslab.hisab.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderslab.hisab.enums.TransactionType;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController extends HishabController{

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@GetMapping
	public String loadIndexPage(Model model) {
		model.addAttribute("currentMonth", current_month.format(new Date()));

		Map<String, String> transactionTypes = new LinkedHashMap<>();
		transactionTypes.put(TransactionType.EXPENSE.name(), TransactionType.EXPENSE.getCode());
		transactionTypes.put(TransactionType.INCOME.name(), TransactionType.INCOME.getCode());
		transactionTypes.put(TransactionType.MONEY_TRANSFER.name(), TransactionType.MONEY_TRANSFER.getCode());
		model.addAttribute("transactionType", transactionTypes);

		return "views/index";
	}
}
