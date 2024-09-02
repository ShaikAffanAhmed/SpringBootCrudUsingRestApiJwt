package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.BudgetDetails;
import com.app.service.BudgetDetailsService;

@RestController
@RequestMapping("/api/budgetDetails")
public class BudgetDetailsController {

	@Autowired
	private BudgetDetailsService detailsService;

	@PostMapping("/create")
	public BudgetDetails creatBudgetDetails(@RequestBody BudgetDetails budgetDetails) {
		return detailsService.save(budgetDetails);
	}

	@GetMapping("/fetchAll")
	public List<BudgetDetails> getAllBudgetDetails() {
		return detailsService.findAll();
	}

	@PutMapping("/update/{id}")
	public BudgetDetails updateBudgetDetails(@PathVariable Integer id, @RequestBody BudgetDetails budgetDetails) {
		budgetDetails.setBudgetId(id);
		return detailsService.save(budgetDetails);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBudgetDetails(@PathVariable Integer id) {
	return 	detailsService.deleteById(id);
	}
	
	@PostMapping("/insertWithNotification")
	public String creatBudgetDetailsWithNotification() {
		return detailsService.saveWithNotification();
	}
}
