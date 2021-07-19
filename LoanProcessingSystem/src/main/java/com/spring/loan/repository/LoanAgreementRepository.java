package com.spring.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.loan.entities.LoanAgreement;

@Repository
public interface LoanAgreementRepository extends JpaRepository<LoanAgreement, Long> {
	

}