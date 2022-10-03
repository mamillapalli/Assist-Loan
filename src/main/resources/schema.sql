
DROP table public.LOAN_DETALS;

create table public.LOAN_DETALS
(
    LOAN_REF uuid  not null
        constraint LOAN_DETALS_pkey
            primary key,
    AMT varchar,
    CCY    varchar(3),
    INT_RATE     varchar(35),
    EMI_AMT       varchar(35),
    INT_TYPE      varchar(35),
    CREDIT_ACC_NUM      varchar(35),
    DEBIT_ACC_NUM varchar(35),
    ISSUE_DT  timestamp,
    MATURITY_DT       timestamp,
    OUTSTD_AMT    varchar(35),
    TOTAL_NO_EMI     varchar(35),
    PEND_NO_EMI       varchar(35),
    EMI_START_DATE        timestamp,
    EMI_END_DATE           timestamp,
    ISSUED_BY               varchar(255),
    APPROVED_BY      varchar(255)
);

alter table public.LOAN_DETALS
    owner to postgres;