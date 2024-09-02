package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.BudgetDetails;

@Repository
public interface BudgetDetailsRepository extends JpaRepository<BudgetDetails, Integer> {

}
