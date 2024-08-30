package com.cvloo.dev.insuranceMotorPolicy.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class MotorPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Policy status cannot be null")
    @Enumerated(EnumType.STRING)
    private PolicyStatus policyStatus = PolicyStatus.ACTIVE;

    @NotNull(message = "Client cannot be null")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull(message = "Insurer cannot be null")
    @ManyToOne
    @JoinColumn(name = "insurer_id")
    private Insurer insurer;

    @NotNull(message = "Currency cannot be null")
    @Enumerated(EnumType.STRING)
    private Currency currency = Currency.USD;

    @NotNull(message = "Fleet or Individual cannot be null")
    @Enumerated(EnumType.STRING)
    private FleetOrIndividual fleetOrIndividual = FleetOrIndividual.INDIVIDUAL;

    @NotNull(message = "PeriodFrom cannot be null")
    private LocalDate periodFrom = LocalDate.now();
    @NotNull(message = "PeriodTo cannot be null")
    private LocalDate periodTo = LocalDate.now().plusYears(1);
    @NotNull(message = "Policy number cannot be null")
//    length undefined
//    @Size(min = 5, max = 15, message = "Policy number must be between 5 and 15 characters")
    private String policyNo = "DEFAULT12345";

    @NotNull(message = "Cover type cannot be null")
    @Enumerated(EnumType.STRING)
    private CoverType coverType = CoverType.COMPREHENSIVE;

    @NotNull(message = "Sum Insured cannot be null")
    private BigDecimal sumInsured = BigDecimal.valueOf(100000);


    @NotNull(message = "Premium cannot be null")
    private BigDecimal premium = BigDecimal.valueOf(500);

    @NotNull(message = "Rate cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Rate must be greater than zero")
    @DecimalMax(value = "100.0", message = "Sum Insured must be less than or equal to 100")
    private BigDecimal rate = BigDecimal.valueOf(5);

    // Getters and Setters
//    public PolicyStatus getPolicyStatus() {
//        return policyStatus;
//    }
//
//    public void setPolicyStatus(PolicyStatus policyStatus) {
//        this.policyStatus = policyStatus;
//    }
//
//    public enum FleetOrIndividual {
//        FLEET, INDIVIDUAL
//    }
//    public enum PolicyStatus {
//        ACTIVE, EXPIRED, PENDING, CANCELLED
//    }
//
//    public enum Currency {
//        USD, EUR, JPY, CAD, CNY, AUD
//    }
//
//    public enum CoverType {
//        COMPREHENSIVE, THIRD_PARTY_ONLY, COLLISION, THIRD_PARTY_FIRE_AND_THEFT
//    }
//
//    public LocalDate getPeriodFrom() {
//        return periodFrom;
//    }
//
//    public void setPeriodFrom(LocalDate periodFrom) {
//        this.periodFrom = periodFrom;
//    }
//
//    public LocalDate getPeriodTo() {
//        return periodTo;
//    }
//
//    public void setPeriodTo(LocalDate periodTo) {
//        this.periodTo = periodTo;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(PolicyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public FleetOrIndividual getFleetOrIndividual() {
        return fleetOrIndividual;
    }

    public void setFleetOrIndividual(FleetOrIndividual fleetOrIndividual) {
        this.fleetOrIndividual = fleetOrIndividual;
    }

    public LocalDate getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(LocalDate periodFrom) {
        this.periodFrom = periodFrom;
    }

    public LocalDate getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(LocalDate periodTo) {
        this.periodTo = periodTo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public enum FleetOrIndividual {
        FLEET, INDIVIDUAL
    }

    public enum PolicyStatus {
        ACTIVE, EXPIRED, PENDING, CANCELLED
    }

    public enum Currency {
        USD, EUR, JPY, CAD, CNY, AUD
    }

    public enum CoverType {
        COMPREHENSIVE, THIRD_PARTY_ONLY, COLLISION, THIRD_PARTY_FIRE_AND_THEFT
    }

}

