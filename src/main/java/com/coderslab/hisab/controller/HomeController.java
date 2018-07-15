/**
 * 
 */
package com.coderslab.hisab.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderslab.hisab.enums.TransactionType;
import com.coderslab.hisab.model.ExpenseType;
import com.coderslab.hisab.model.IncomeSource;
import com.coderslab.hisab.model.User;
import com.coderslab.hisab.model.Wallet;
import com.coderslab.hisab.service.ExpenseTypeService;
import com.coderslab.hisab.service.IncomeSourceService;
import com.coderslab.hisab.service.WalletService;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController extends HishabController{

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired WalletService walletService;
	@Autowired IncomeSourceService incomeSourceService;
	@Autowired ExpenseTypeService expenseTypeService;

	@GetMapping
	public String loadIndexPage(Model model) {
		model.addAttribute("currentMonth", current_month.format(new Date()));

		Map<String, String> transactionTypes = new LinkedHashMap<>();
		transactionTypes.put(TransactionType.EXPENSE.name(), TransactionType.EXPENSE.getCode());
		transactionTypes.put(TransactionType.INCOME.name(), TransactionType.INCOME.getCode());
		transactionTypes.put(TransactionType.MONEY_TRANSFER.name(), TransactionType.MONEY_TRANSFER.getCode());
		model.addAttribute("transactionType", transactionTypes);

		User user = userService.findByUsername(appConfig.getUsername());
		List<Wallet> wallets = walletService.findAllByUserId(user.getUserId());
		Map<Integer, String> walletsMap = new LinkedHashMap<>();
		for(Wallet wallet : wallets) {
			walletsMap.put(wallet.getWalletId(), wallet.getWalletName());
		}
		model.addAttribute("wallets", walletsMap);

		List<IncomeSource> incomeSources = incomeSourceService.findAllByUserId(user.getUserId());
		Map<Integer, String> incomeSourcesMap = new LinkedHashMap<>();
		for(IncomeSource incomeSource : incomeSources) {
			incomeSourcesMap.put(incomeSource.getIncomeSourceId(), incomeSource.getIncomeSourceName());
		}
		model.addAttribute("incomeSources", incomeSourcesMap);

		List<ExpenseType> expenseTypes = expenseTypeService.findAllByUserId(user.getUserId());
		Map<Integer, String> expenseTypesMap = new LinkedHashMap<>();
		for(ExpenseType expenseType : expenseTypes) {
			expenseTypesMap.put(expenseType.getExpenseTypeId(), expenseType.getExpenseTypeName());
		}
		model.addAttribute("expenseTypes", expenseTypesMap);

		return "views/index";
	}
}
