package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

	public Integer getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Integer budgetId) {
		this.budgetId = budgetId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getPropertyGroupId() {
		return propertyGroupId;
	}

	public void setPropertyGroupId(Integer propertyGroupId) {
		this.propertyGroupId = propertyGroupId;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public Double getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(Double totalBudget) {
		this.totalBudget = totalBudget;
	}

	@Override
	public String toString() {
		return "BudgetDetails [budgetId=" + budgetId + ", companyId=" + companyId + ", propertyGroupId="
				+ propertyGroupId + ", serviceCode=" + serviceCode + ", amount=" + amount + ", vat=" + vat
				+ ", totalBudget=" + totalBudget + "]";
	}

}
