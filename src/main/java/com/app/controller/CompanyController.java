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

import com.app.entity.Company;
import com.app.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@PostMapping("/create")
	public Company createCompany(@RequestBody Company company) {
		return companyService.save(company);
	}

	@GetMapping("/fetchAll")
	public List<Company> getAllCompanies() {
		return companyService.findAll();
	}

	@PutMapping("/update/{id}")
	public Company updateCompany(@PathVariable Integer id, @RequestBody Company company) {
		company.setCompanyId(id);
		return companyService.save(company);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCompany(@PathVariable Integer id) {
		return companyService.deletebyId(id);
	}
	
}
