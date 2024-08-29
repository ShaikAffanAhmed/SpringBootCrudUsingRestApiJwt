package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void deletebyId(Integer id) {
		companyRepository.deleteById(id);
	}
}
