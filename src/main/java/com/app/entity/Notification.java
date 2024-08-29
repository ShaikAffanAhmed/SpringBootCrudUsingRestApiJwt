package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seqid;
	private Integer companyId;
	private Integer propertyGroupId;

	public Integer getSeqid() {
		return seqid;
	}

	public void setSeqid(Integer seqid) {
		this.seqid = seqid;
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

	@Override
	public String toString() {
		return "Notification [seqid=" + seqid + ", companyId=" + companyId + ", propertyGroupId=" + propertyGroupId
				+ "]";
	}

}
