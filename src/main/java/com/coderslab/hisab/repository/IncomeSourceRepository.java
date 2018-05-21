/**
 * 
 */
package com.coderslab.hisab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderslab.hisab.model.IncomeSource;

/**
 * @author Zubayer Ahamed
 *
 */
@Repository
public interface IncomeSourceRepository extends JpaRepository<IncomeSource, Integer>{

}
