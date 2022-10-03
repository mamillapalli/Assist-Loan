package com.csme.assist.loan.controller;

import com.csme.assist.loan.entity.TransactionStatusEnum;
import com.csme.assist.loan.model.LoanDTO;
import com.csme.assist.loan.service.LoanService;
import com.csme.assist.loan.service.LoanServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Loan")
@Slf4j
public class LoanController {

    @Autowired
    LoanServiceImpl loanServiceImpl;


    @GetMapping(path="/loans/{id}")
    public LoanDTO getLoanDetailsByloanReference(@PathVariable(name ="id") String id)
    {
        return (LoanDTO) loanServiceImpl.getLoans(id);

    }

    @CrossOrigin(origins = "http://localhost:8001/loans")
    @GetMapping (path = "/loans")
    public ResponseEntity<List<LoanDTO>> getAllLoans()
    {
        return new ResponseEntity<>(loanServiceImpl.getAll(), HttpStatus.OK);
    }


    @GetMapping (path = "/loanStatus/{TRANSACTIONSTATUS}")
    public ResponseEntity<List<LoanDTO>> getLoansByStatus(@PathVariable (name = "TRANSACTIONSTATUS") TransactionStatusEnum transactionStatus)
    {
        List<LoanDTO> loanDTO = loanServiceImpl.getLoansByTransactionStatus(transactionStatus);
        return new ResponseEntity<>(loanDTO, HttpStatus.OK);
    }


    @GetMapping (path = "/loansByResourceId/{id}")
    public ResponseEntity<List<LoanDTO>> getLeavesByResourceId( @PathVariable (name = "id") String id)
    {
        return new ResponseEntity<>(loanServiceImpl.getLoansByApproverId(id), HttpStatus.OK);

    }


    @GetMapping (path = "/loansByResourceId/{id}/{TRANSACTIONSTATUS}")
    public ResponseEntity<List<LoanDTO>> getLoansByResourceIdAndStatus( @PathVariable (name = "id") String id, @PathVariable (name = "TRANSACTIONSTATUS") TransactionStatusEnum status)
    {
        return new ResponseEntity<>(loanServiceImpl.getLoansByResourceIdAndStatus(id,status), HttpStatus.OK);

    }



    @PostMapping(path = "/loans")
    public ResponseEntity<LoanDTO> addLeave(@Valid @RequestBody LoanDTO LoanDTO) throws Exception {
        return new ResponseEntity<>(loanServiceImpl.addLoan(LoanDTO),HttpStatus.ACCEPTED);
    }


    @PutMapping(path = "/loans/{id}")
    public ResponseEntity<LoanDTO> updateLeave(@Valid @RequestBody LoanDTO loanDTO, @PathVariable (name = "id") int id)
    {
        return new ResponseEntity<>(loanServiceImpl.updateLoan(id,loanDTO),HttpStatus.ACCEPTED);
    }


    @PutMapping(path = "/approveLoan/{id}")
    public ResponseEntity<LoanDTO> approveLoan(@Valid @RequestBody LoanDTO loanDTO,@PathVariable (name = "id") int id)
    {
        LoanDTO loanDTOs = loanServiceImpl.approveLoan(id,loanDTO);
        return new ResponseEntity<>(loanDTOs, HttpStatus.OK);
    }


    @PutMapping(path = "/rejectLoans/{id}")
    public ResponseEntity<LoanDTO> rejectLoan(@Valid @RequestBody LoanDTO loanDTO,@PathVariable (name = "id") int id)
    {
        LoanDTO loanDTOs = loanServiceImpl.rejectLoan(id,loanDTO);
        return new ResponseEntity<>(loanDTO, HttpStatus.OK);
    }


//    @GetMapping (path = "/profile")
//    public Optional<Loan> getProfile()
//    {
//        Optional<Loan> resource = resourceRepository.findByEmailAddress(jwtUtil.extractUsernameFromRequest());
//        return resource;
//    }

}
