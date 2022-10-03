package com.csme.assist.loan.repository;

import com.csme.assist.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, String> {
    List<Loan> findByLoanReference(String id);

    //List<Loan> findByLoanReferenceAndTransactionStatus(String id,TransactionStatusEnum transactionStatus);
    //Optional<List<Loan>> findByApproverId(String id);
   // Optional<List<Loan>> findByApproverIdAndStatus(String id, StatusEnum status);
    //List<Loan> findByTransactionStatusAndResourceIdNot(TransactionStatusEnum status,String id);
}
