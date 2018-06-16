/**
 * 
 */
package com.coderslab.hisab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.hisab.model.IncomeSource;
import com.coderslab.hisab.repository.IncomeSourceRepository;

/**
 * @author Zubayer Ahamed
 *
 */
@Service
public class IncomeSourceService {

	@Autowired
	private IncomeSourceRepository incomeSourceRepository;

	public boolean save(IncomeSource incomeSource) {
		IncomeSource is = incomeSourceRepository.save(incomeSource);
		return is == null ? false : true;
	}

	public IncomeSource findOne(Integer incomeSourceId) {
		return incomeSourceRepository.findOne(incomeSourceId);
	}

	public List<IncomeSource> findAllByUserId(Integer userId) {
		return incomeSourceRepository.findAllByUserId(userId);
	}

	public void delete(Integer incomeSourceId) {
		incomeSourceRepository.delete(incomeSourceId);
	}
}
