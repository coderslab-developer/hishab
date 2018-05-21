/**
 * 
 */
package com.coderslab.hisab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderslab.hisab.model.Wallet;

/**
 * @author Zubayer Ahamed
 *
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer>{

}
