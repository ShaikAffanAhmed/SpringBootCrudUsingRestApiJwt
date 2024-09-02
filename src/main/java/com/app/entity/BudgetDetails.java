package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Budget_Details")
public class BudgetDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer budgetId;

	private Integer companyId;
	private Integer propertyGroupId;
	private String serviceCode;
	private Double amount;
	private Double vat;
	private Double totalBudget;

	
}
