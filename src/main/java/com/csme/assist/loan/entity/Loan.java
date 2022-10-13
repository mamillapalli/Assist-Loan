package com.csme.assist.loan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "LOAN_DETALS", schema ="PUBLIC")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan extends Base {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="LOAN_REF")
    private String loanReference;
    @Column(name="AMT")
    private BigDecimal Amount;
    @Column(name="CCY")
    private String CCY;
    @Column(name="INT_RATE")
    private Float interestRate;
    @Column(name="EMI_AMT")
    private BigDecimal emiAmount;
    @Column(name="INT_TYPE")
    private String interestType;
    @Column(name="CREDIT_ACC_NUM")
    private String creditAccNo;
    @Column(name="DEBIT_ACC_NUM")
    private String debitAccNo;
    @Column(name="ISSUE_DT")
    private Date issueDate;
    @Column(name="MATURITY_DT")
    private Date  maturityDate;
    @Column(name="OUTSTD_AMT")
    private BigDecimal outStandAmt;
    @Column(name="TOTAL_NO_EMI")
    private int totalNoOfEmis;
    @Column(name="PEND_NO_EMI")
    private int pendingNoOfEmis;
    @Column(name="EMI_START_DATE")
    private Date emiStartDate;
    @Column(name="EMI_END_DATE")
    private Date emiEndDate;
    @Column(name="ISSUED_BY")
    private String issuedBy;
    @Column(name="APPROVED_BY")
    private String approvedBy;
    @Column (name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Column(name="APPROVER_COMMENTS")
    private String approverComments;
    @Column(name = "DELETE_FLAG")
    private boolean deleteFlag;

}
