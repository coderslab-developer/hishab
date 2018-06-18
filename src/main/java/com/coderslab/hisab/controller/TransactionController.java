/**
 * 
 */
package com.coderslab.hisab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderslab.hisab.service.TransactionService;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController extends HishabController{

	@Autowired TransactionService transactionService;

	
}
