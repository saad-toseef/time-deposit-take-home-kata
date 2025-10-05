package org.ikigaidigital.org.ikigaidigital.interest;

import org.ikigaidigital.TimeDeposit;

public interface InterestPolicy  {

    int TERM_MONTHS = 12; // yearly interest
    int NO_INTEREST_DAYS = 30;

    double calculateInterest(TimeDeposit timeDeposit);

}

