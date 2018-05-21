/**
 * 
 */
package com.coderslab.hisab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.hisab.repository.WalletRepository;

/**
 * @author Zubayer Ahamed
 *
 */
@Service
public class WalletService {

	@Autowired private WalletRepository walletRepository;
}
