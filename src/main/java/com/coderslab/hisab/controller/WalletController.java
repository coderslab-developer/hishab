/**
 * 
 */
package com.coderslab.hisab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping("/wallet")
public class WalletController {

	@GetMapping
	public String loadWalletStatusPage() {
		return "views/wallet-status";
	}
}
