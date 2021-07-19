package com.spring.loan.service;

import java.util.Optional;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.loan.entities.LoanApplication;
import com.spring.loan.exception.InvalidLoanApplicationException;
import com.spring.loan.repository.LoanApplicationRepository;

/*Finance Verification Officer Service
 *IFinanceVerificationService checks for the existing of loan application and 
 *other field as per necessity if existing
 *
 * 
 * */

@Service
public class FinanceVerificationServiceImpl implements FinanceVerificationService {

	@Autowired
	LoanApplicationRepository fApplicationRepository;

	public FinanceVerificationServiceImpl(LoanApplicationRepository applicationRepository) {
		super();
		this.fApplicationRepository = applicationRepository;
	}

	@Override
	@Transactional
	// method to check loan application is present in the DB, update if application
	// is present else invoke Exception class
	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException {

		Optional<LoanApplication> optional = fApplicationRepository.findById(loanApplication.getApplicationId());
		if (optional.isPresent()) {
			fApplicationRepository.save(loanApplication);
			return loanApplication;
		} else {
			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");// returns updated loan
																								// application

		}
	}

}
//By Gaurav Shrivastava