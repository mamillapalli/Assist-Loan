package com.csme.assist.loan.mapper;

import com.csme.assist.loan.entity.Loan;
import com.csme.assist.loan.model.LoanDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface LoanMapper {

    Loan loanDTOToLoan(LoanDTO loanDTO);
    LoanDTO loanToLoanDTO(Loan loan);
    List<Loan> loanDTOsToLoan(List<LoanDTO> leaveDTOs);
    List<LoanDTO> loanToLoanDTOs(List<Loan> loan);
}
