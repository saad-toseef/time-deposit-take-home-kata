package org.ikigaidigital.org.ikigaidigital.interest;

import org.ikigaidigital.TimeDeposit;

public class PremiumPlanPolicy implements InterestPolicy {

    private static final int NO_INTEREST_DAYS = 30;
    private static final int PREMIUM_START_DAYS = 45;

    public double calculateInterest(TimeDeposit td) {

        if (td.getDays() <= NO_INTEREST_DAYS ) return 0; // Global
        if (td.getDays() <= PREMIUM_START_DAYS) return 0;

        return td.getBalance() * PlanType.getPlanInterestRate(PlanType.PREMIUM) / TERM_MONTHS;

    }

}
