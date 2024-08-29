package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Property_Group")
public class PropertyGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer propertyGroupId;

	private String propertyGroupName;

	public Integer getPropertyGroupId() {
		return propertyGroupId;
	}

	public void setPropertyGroupId(Integer propertyGroupId) {
		this.propertyGroupId = propertyGroupId;
	}

	public String getPropertyGroupName() {
		return propertyGroupName;
	}

	public void setPropertyGroupName(String propertyGroupName) {
		this.propertyGroupName = propertyGroupName;
	}

	@Override
	public String toString() {
		return "PropertyGroup [propertyGroupId=" + propertyGroupId + ", propertyGroupName=" + propertyGroupName + "]";
	}

}
