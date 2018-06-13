/**
 * 
 */
package com.coderslab.hisab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.hisab.model.Wallet;
import com.coderslab.hisab.repository.WalletRepository;

/**
 * @author Zubayer Ahamed
 *
 */
@Service
public class WalletService {

	@Autowired private WalletRepository walletRepository;

	public boolean save(Wallet wallet) {
		Wallet w = walletRepository.save(wallet);
		return w == null ? false : true;
	}

	public Wallet findOne(Integer walletId) {
		return walletRepository.findOne(walletId);
	}

	public List<Wallet> findAllByUserId(Integer userId){
		return walletRepository.findAllByUserId(userId);
	}

	public void delete(Integer walletId) {
		walletRepository.delete(walletId);
	}
}
