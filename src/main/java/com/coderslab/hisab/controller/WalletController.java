/**
 * 
 */
package com.coderslab.hisab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderslab.hisab.model.User;
import com.coderslab.hisab.model.Wallet;
import com.coderslab.hisab.service.WalletService;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping("/wallet")
public class WalletController extends HishabController {

	@Autowired
	WalletService walletService;

	@GetMapping
	public String loadWalletStatusPage() {
		return "views/wallet-status";
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveWallet(Wallet wallet) {
		if(wallet.getWalletId() != null) {
			return updateWallet(wallet);
		}

		wallet.setUserId(userService.findByUsername(appConfig.getUsername()).getUserId());
		boolean stat = walletService.save(wallet);
		if (Boolean.TRUE == stat) {
			return new ResponseEntity<>("Wallet created successfully", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Wallet not created", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<String> updateWallet(Wallet wallet) {
		Wallet rw = walletService.findOne(wallet.getWalletId());
		rw.setWalletName(wallet.getWalletName());
		rw.setNotes(wallet.getNotes());
		rw.setCurrentBalance(wallet.getCurrentBalance());
		boolean stat = walletService.save(rw);
		if (Boolean.TRUE == stat) {
			return new ResponseEntity<>("Wallet update successfully", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Wallet not update", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/findAll")
	public @ResponseBody List<Wallet> findAllWallet(){
		User user = userService.findByUsername(appConfig.getUsername());
		return walletService.findAllByUserId(user.getUserId());
	}

	@GetMapping("/delete/{walletId}")
	public ResponseEntity<String> deleteWallet(@PathVariable("walletId") Integer walletId){
		walletService.delete(walletId);
		return new ResponseEntity<>("Wallet deleted successfully", HttpStatus.OK);
	}
}
