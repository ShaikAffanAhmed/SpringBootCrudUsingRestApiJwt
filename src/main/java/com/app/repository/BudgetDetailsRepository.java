package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.BudgetDetails;

public interface BudgetDetailsRepository extends JpaRepository<BudgetDetails, Integer> {

}
