package com.csme.assist.loan.model;

import com.csme.assist.loan.entity.StatusEnum;
import com.csme.assist.loan.entity.TransactionStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {

    private String loanReference;
    private BigDecimal Amount;
    private String CCY;
    private Float interestRate;
    private BigDecimal emiAmount;
    private String interestType;
    private String creditAccNo;
    private String debitAccNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" ,timezone = "Asia/Dubai")
    private Date issueDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" ,timezone = "Asia/Dubai")
    private Date  maturityDate;
    private BigDecimal outStandAmt;
    private int totalNoOfEmis;
    private int pendingNoOfEmis;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" ,timezone = "Asia/Dubai")
    private Date emiStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" ,timezone = "Asia/Dubai")
    private Date emiEndDate;
    private String issuedBy;
    private StatusEnum status;
    private TransactionStatusEnum transactionStatus;
    private String approvedBy;
    private String approverComments;
    private boolean deleteFlag;
}
