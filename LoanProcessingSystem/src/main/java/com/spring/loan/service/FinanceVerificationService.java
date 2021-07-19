package com.spring.loan.service;

import com.spring.loan.entities.LoanApplication;
import com.spring.loan.exception.InvalidLoanApplicationException;

/*Finance Verification Officer Service
 *IFinanceVerificationService checks for the existing of loan application and 
 *other field as per necessity if existing
 *
 * Author : Gaurav Shrivastava 
 * */

public interface FinanceVerificationService  {
	
public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException ;

	}
