package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.BudgetDetails;
import com.app.repository.BudgetDetailsRepository;

@Service
public class BudgetDetailsService {

	@Autowired
	private BudgetDetailsRepository detailsRepository;

	// create
	public BudgetDetails save(BudgetDetails budgetDetails) {
		return detailsRepository.save(budgetDetails);
	}

	// fetch
	public List<BudgetDetails> findAll() {
		return detailsRepository.findAll();
	}

	// update
	public BudgetDetails update(Integer id, BudgetDetails budgetDetails) {
		if (detailsRepository.existsById(id)) {
			budgetDetails.setBudgetId(id);
			return detailsRepository.save(budgetDetails);
		} else {
			throw new RuntimeException("BudgetDetails not found with id" + id);
		}
	}

	// delete
	public void deleteById(Integer id) {
		detailsRepository.deleteById(id);
	}

}
