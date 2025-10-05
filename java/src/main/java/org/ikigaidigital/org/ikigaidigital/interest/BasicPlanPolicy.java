package org.ikigaidigital.org.ikigaidigital.interest;

import org.ikigaidigital.TimeDeposit;

public class BasicPlanPolicy implements InterestPolicy {

    public double calculateInterest(TimeDeposit td)
    {

        if (td.getDays() <= NO_INTEREST_DAYS ) return 0; // Global;
        return td.getBalance() * PlanType.getPlanInterestRate(PlanType.BASIC) / TERM_MONTHS;

    }
}
