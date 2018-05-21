/**
 * 
 */
package com.coderslab.hisab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderslab.hisab.model.Transaction;

/**
 * @author Zubayer Ahamed
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
