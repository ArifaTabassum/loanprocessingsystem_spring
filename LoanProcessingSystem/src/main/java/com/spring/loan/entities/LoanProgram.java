package com.spring.loan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Loanprogram")
public class LoanProgram {
	
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="LoanId")
private int loanId;

@Column(name="Loan_Name")
private String loanName;

@Column(name="Loan_Duration")
private int loanDuration;

@Column(name="Description")
private String description;

@Column(name="Interest_Rate")
private double interestRate;

public LoanProgram(int loanId, String loanName, int loanDuration, String description, double interestRate) {
	super();
	this.loanId = loanId;
	this.loanName = loanName;
	this.loanDuration = loanDuration;
	this.description = description;
	this.interestRate = interestRate;
}
public LoanProgram() {
	super();
	// TODO Auto-generated constructor stub
}
public long getLoanId() {
	return loanId;
}
public void setLoanId(int loanId) {
	this.loanId = loanId;
}
public String getLoanName() {
	return loanName;
}
public void setLoanName(String loanName) {
	this.loanName = loanName;
}
public int getLoanDuration() {
	return loanDuration;
}
public void setLoanDuration(int loanDuration) {
	this.loanDuration = loanDuration;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public double getInterestRate() {
	return interestRate;
}
public void setInterestRate(float interestRate) {
	this.interestRate = interestRate;
}

}
