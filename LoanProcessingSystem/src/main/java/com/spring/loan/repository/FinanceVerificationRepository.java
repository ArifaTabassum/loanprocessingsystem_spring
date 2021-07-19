package com.spring.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.loan.entities.LoanApplication;

@Repository
public interface FinanceVerificationRepository extends JpaRepository<LoanApplication, Integer>{


}
