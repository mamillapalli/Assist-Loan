package com.csme.assist.loan.service;

import com.csme.assist.loan.entity.Loan;
import com.csme.assist.loan.entity.StatusEnum;
import com.csme.assist.loan.entity.TransactionStatusEnum;
import com.csme.assist.loan.mapper.LoanMapper;
import com.csme.assist.loan.model.EMIDeatailInfo;
import com.csme.assist.loan.model.LoanDTO;
import com.csme.assist.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        loanDTO.setStatus(StatusEnum.WAITING);
        Loan loan = loanMapper.loanDTOToLoan(loanDTO);
        loan.setStatus(StatusEnum.WAITING);
        System.out.println("status : "+loan.getStatus());
       loan.setTransactionStatus(TransactionStatusEnum.PENDING);
       loan.setCreationDetails("CreatedUser");
        return loanMapper.loanToLoanDTO(loanRepository.save(loan));
    }

    public EMIDeatailInfo getEmiDetails(EMIDeatailInfo eMIDeatailInfo) {
        BigDecimal TotalInterest = eMIDeatailInfo.getAmount().multiply(eMIDeatailInfo.getIntrestRate()).divide(new BigDecimal(100));
        BigDecimal  TotalPayableAmount = eMIDeatailInfo.getAmount().add(TotalInterest);
        BigDecimal emiAmount = TotalPayableAmount.divide(new BigDecimal(eMIDeatailInfo.getDurationInMonths()));
        eMIDeatailInfo.setTotalInterestAmt(TotalInterest);
        eMIDeatailInfo.setTotalPayableAmt(TotalPayableAmount);
        eMIDeatailInfo.setEmiAmount(emiAmount);
        eMIDeatailInfo.setNumberOfEmis(eMIDeatailInfo.getDurationInMonths());
        return eMIDeatailInfo;
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
    public LoanDTO approveLoan(String loanId, LoanDTO loanDTO) {

            if(loanRepository.findById(loanId).isEmpty()) throw new RuntimeException("Leave with id " + loanId + " does not exist");
            Loan existingLoanDetails = loanRepository.findById(loanId).get();
           // existingUserDetails.setAuthorizationDetails(jwtUtil.extractUsernameFromRequest());
            existingLoanDetails.setStatus(StatusEnum.APPROVED);
            existingLoanDetails.setTransactionStatus(TransactionStatusEnum.MASTER);
            //existingUserDetails.setApproverId(jwtUtil.extractUsernameFromRequest());
            existingLoanDetails.setApproverComments(loanDTO.getApproverComments());
            Loan savedUser = loanRepository.save(existingLoanDetails);
            if(savedUser.isDeleteFlag()) loanRepository.delete(savedUser);
            return loanMapper.loanToLoanDTO(savedUser);
        
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
