package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
