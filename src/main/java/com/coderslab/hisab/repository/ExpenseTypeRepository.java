/**
 * 
 */
package com.coderslab.hisab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderslab.hisab.model.ExpenseType;

/**
 * @author Zubayer Ahamed
 *
 */
@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Integer>{

	List<ExpenseType> findAllByUserId(Integer userId);
}
