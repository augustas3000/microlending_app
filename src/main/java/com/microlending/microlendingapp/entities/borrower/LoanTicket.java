package com.microlending.microlendingapp.entities.borrower;

import com.microlending.microlendingapp.entities.converters.MonetaryAmountConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LOAN_TICKET")
public class LoanTicket {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BORROWER_ID", nullable = false) //make a foreign key column not nul lwhen hibernate generates schema
    private Borrower borrower; // a many-to-one association maps naturally to a foreign key column - BORROWER_ID in the LOAN_TICKET table

    @NotNull
    @Convert(
            converter = MonetaryAmountConverter.class,
            disableConversion = false)
    @Column(name = "LOAN_AMOUNT", length = 63)
    private MonetaryAmount loanAmount;

    @NotNull
    private Integer loanTenureInMonths;
    @NotNull
    private Double interestRate;
    @NotNull
    private Integer riskRating;
    @NotNull
    private String reasonForLoan;
    @NotNull
    private String abilityToRepay;
    @NotNull
    private String riskFactors;

    public LoanTicket() {
    }

    public LoanTicket(MonetaryAmount loanAmount, Integer loanTenureInMonths, Double interestRate, Integer riskRating, String reasonForLoan, String abilityToRepay, String riskFactors) {
        this.loanAmount = loanAmount;
        this.loanTenureInMonths = loanTenureInMonths;
        this.interestRate = interestRate;
        this.riskRating = riskRating;
        this.reasonForLoan = reasonForLoan;
        this.abilityToRepay = abilityToRepay;
        this.riskFactors = riskFactors;
    }

    public Long getId() {
        return id;
    }

    public MonetaryAmount getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(MonetaryAmount loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getLoanTenureInMonths() {
        return loanTenureInMonths;
    }

    public void setLoanTenureInMonths(Integer loanTenureInMonths) {
        this.loanTenureInMonths = loanTenureInMonths;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(Integer riskRating) {
        this.riskRating = riskRating;
    }

    public String getReasonForLoan() {
        return reasonForLoan;
    }

    public void setReasonForLoan(String reasonForLoan) {
        this.reasonForLoan = reasonForLoan;
    }

    public String getAbilityToRepay() {
        return abilityToRepay;
    }

    public void setAbilityToRepay(String abilityToRepay) {
        this.abilityToRepay = abilityToRepay;
    }

    public String getRiskFactors() {
        return riskFactors;
    }

    public void setRiskFactors(String riskFactors) {
        this.riskFactors = riskFactors;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}
