/**
 * 
 */
package com.coderslab.hisab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderslab.hisab.model.IncomeSource;
import com.coderslab.hisab.model.User;
import com.coderslab.hisab.service.IncomeSourceService;

/**
 * @author Zubayer Ahamed
 *
 */
@Controller
@RequestMapping("/income")
public class IncomeController extends HishabController{

	@Autowired
	IncomeSourceService incomeSourceService;

	@GetMapping
	public String loadIncomeStatusPage() {
		return "views/income-status";
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveIncomeSource(IncomeSource incomeSource) {
		if(incomeSource.getIncomeSourceId() != null) {
			return updateIncomeSource(incomeSource);
		}

		incomeSource.setUserId(userService.findByUsername(appConfig.getUsername()).getUserId());
		boolean stat = incomeSourceService.save(incomeSource);
		if (Boolean.TRUE == stat) {
			return new ResponseEntity<>("Income source created successfully", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Income source not created", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<String> updateIncomeSource(IncomeSource incomeSource) {
		IncomeSource is = incomeSourceService.findOne(incomeSource.getIncomeSourceId());
		is.setIncomeSourceName(incomeSource.getIncomeSourceName());
		is.setNotes(incomeSource.getNotes());

		boolean stat = incomeSourceService.save(is);
		if (Boolean.TRUE == stat) {
			return new ResponseEntity<>("Income source update successfully", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Income source not update", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/findAll")
	public @ResponseBody List<IncomeSource> findAllWallet(){
		User user = userService.findByUsername(appConfig.getUsername());
		return incomeSourceService.findAllByUserId(user.getUserId());
	}

	@GetMapping("/delete/{incomeSourceId}")
	public ResponseEntity<String> deleteIncomeSource(@PathVariable("incomeSourceId") Integer incomeSourceId){
		incomeSourceService.delete(incomeSourceId);
		return new ResponseEntity<>("Income source deleted successfully", HttpStatus.OK);
	}
}
