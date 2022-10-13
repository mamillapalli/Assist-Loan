package com.csme.assist.loan.service;

import com.csme.assist.loan.entity.StatusEnum;
import com.csme.assist.loan.entity.TransactionStatusEnum;
import com.csme.assist.loan.model.LoanDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface  LoanService {
    List<LoanDTO> getAll();


   List<LoanDTO> getLoansByTransactionStatus(TransactionStatusEnum transactionStatus);

    List<LoanDTO> getLoans(String id);

    List<LoanDTO> getLoansByResourceIdAndStatus(String id,TransactionStatusEnum transactionStatus);


    List<LoanDTO> getLoansByApproverId(String id);

    LoanDTO addLoan(LoanDTO loanDTO);

    LoanDTO updateLoan(int id , LoanDTO loanDTO);

    LoanDTO approveLoan(int id,LoanDTO loanDTO);

    LoanDTO approveLoan(String laonId, LoanDTO loanDTO);

    LoanDTO rejectLoan(int id, LoanDTO loanDTO);

    List<LoanDTO> getLoansByApproverIdAndStatus(String id, StatusEnum status);
}
