package org.ikigaidigital.org.ikigaidigital.interest;

import org.ikigaidigital.TimeDeposit;

public class StudentPlanPolicy implements InterestPolicy {

    private static final int MAX_ELIGIBLE_DAYS = 365;

    public double calculateInterest(TimeDeposit td) {


        if (td.getDays() <= NO_INTEREST_DAYS ) return 0; // Global;
        if (td.getDays() >= MAX_ELIGIBLE_DAYS) return 0; // No interest after 1 year - harsh :)

        return td.getBalance() * PlanType.getPlanInterestRate(PlanType.STUDENT) / TERM_MONTHS;

    }
}
