package com.mybank.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_info")
public class BankInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	
	private int bankcode;
	@Column
	
	private int branchcode;
	@Column
	
	private long swiftcode;
	@Column
	
	private String active;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getBankcode() {
		return bankcode;
	}
	public void setBankcode(int bankcode) {
		this.bankcode = bankcode;
	}
	public int getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(int branchcode) {
		this.branchcode = branchcode;
	}
	public long getSwiftcode() {
		return swiftcode;
	}
	public void setSwiftcode(long swiftcode) {
		this.swiftcode = swiftcode;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
}
