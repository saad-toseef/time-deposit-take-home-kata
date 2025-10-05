package org.ikigaidigital.interest;

public enum PlanType {
    STUDENT(InterestRates.STUDENT_RATE),
    PREMIUM(InterestRates.PREMIUM_RATE),
    BASIC(InterestRates.BASIC_RATE);

    private final double interestRate;

    // Constructor - Set the plan type with the respective rate
    PlanType(double interestRate) {
        this.interestRate = interestRate;
    }

    public static double getPlanInterestRate(PlanType planType) {
        return planType.getInterestRate();
    }

    private double getInterestRate() {
        return this.interestRate;
    }

    public static PlanType fromString(String value) {
        return PlanType.valueOf(value.trim().toUpperCase());
    }

}
