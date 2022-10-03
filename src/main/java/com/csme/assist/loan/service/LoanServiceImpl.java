package com.csme.assist.loan.service;

import com.csme.assist.loan.entity.Loan;
import com.csme.assist.loan.entity.StatusEnum;
import com.csme.assist.loan.entity.TransactionStatusEnum;
import com.csme.assist.loan.mapper.LoanMapper;
import com.csme.assist.loan.model.LoanDTO;
import com.csme.assist.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    LoanRepository loanRepository;
    @Autowired
    LoanMapper loanMapper;
    @Override
    public List<LoanDTO> getAll() {
        return loanMapper.loanToLoanDTOs(loanRepository.findAll());
    }



    @Override
    public List<LoanDTO> getLoansByTransactionStatus(TransactionStatusEnum transactionStatus) {
        return null;
    }


    @Override
    public List<LoanDTO> getLoans(String id) {

        Loan loan = loanRepository.getReferenceById(id);
        if (loan == null) throw new RuntimeException("Loan with id " + id + " does not exist");
        return (List<LoanDTO>) loanMapper.loanToLoanDTO(loan);
    }

    @Override
    public List<LoanDTO> getLoansByResourceIdAndStatus(String id, TransactionStatusEnum transactionStatus) {
        return null;
    }

    @Override
    public List<LoanDTO> getLoansByApproverId(String id) {
        return null;
    }

    @Override
    public LoanDTO addLoan(LoanDTO loanDTO) {
        return null;
    }

    @Override
    public LoanDTO updateLoan(int id, LoanDTO loanDTO) {
        return null;
    }

    @Override
    public LoanDTO approveLoan(int id, LoanDTO loanDTO) {
        return null;
    }

    @Override
    public LoanDTO rejectLoan(int id, LoanDTO loanDTO) {
        return null;
    }

    @Override
    public List<LoanDTO> getLoansByApproverIdAndStatus(String id, StatusEnum status) {
        return null;
    }





}
