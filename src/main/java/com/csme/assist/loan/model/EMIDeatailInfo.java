package com.csme.assist.loan.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EMIDeatailInfo {

    private String intrestType;
    private BigDecimal amount;
    private String currency;
    private BigDecimal intrestRate;
    private int durationInMonths;
    private BigDecimal emiAmount;
    private int numberOfEmis;
    private BigDecimal totalInterestAmt;
    private BigDecimal totalPayableAmt;
   // private String emiAmounts;
}
