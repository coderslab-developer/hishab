/**
 * 
 */
package com.coderslab.hisab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderslab.hisab.model.Wallet;

/**
 * @author Zubayer Ahamed
 *
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer>{

	List<Wallet> findAllByUserId(Integer userId);

}
