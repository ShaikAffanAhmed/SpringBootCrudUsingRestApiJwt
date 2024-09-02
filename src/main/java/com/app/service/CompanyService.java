package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.BudgetDetails;
import com.app.entity.Company;
import com.app.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	// create
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	// fetch
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	// update
	public Company update(Integer id, Company company) {
		if (companyRepository.existsById(id)) {
			company.setCompanyId(id);
			return companyRepository.save(company);
		} else {
			throw new RuntimeException("Company not found with id " + id);
		}
	}

	// delete
	public String deletebyId(Integer id) {
		Optional<Company> details = this.companyRepository.findById(id);

		if (details.isEmpty()) {
			return "This ID doesn't exist";
		}

		this.companyRepository.deleteById(id);
		return "Deleted successfully";
	}
}
