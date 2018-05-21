/**
 * 
 */
package com.coderslab.hisab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.hisab.repository.TransactionRepository;

/**
 * @author Zubayer Ahamed
 *
 */
@Service
public class TransactionService {

	@Autowired private TransactionRepository transactionRepository;
}
