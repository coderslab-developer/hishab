/**
 * 
 */
package com.coderslab.hisab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderslab.hisab.model.Authorities;

/**
 * @author Zubayer Ahamed
 *
 */
@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer>{

}
