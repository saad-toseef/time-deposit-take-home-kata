package org.ikigaidigital;

import org.ikigaidigital.org.ikigaidigital.interest.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class TimeDepositCalculator {

    // As we have now linked the account and interest polices together so lets define them
    private final Map<PlanType , InterestPolicy> interstPolicies = new EnumMap<>(PlanType.class);

    public TimeDepositCalculator() {
        interstPolicies.put(PlanType.BASIC , new BasicPlanPolicy());
        interstPolicies.put(PlanType.STUDENT , new StudentPlanPolicy());
        interstPolicies.put(PlanType.PREMIUM , new PremiumPlanPolicy());
    }

    public void updateBalance(List<TimeDeposit> xs) {

        for (TimeDeposit td : xs ) {
            // define the Strategy for calc
            PlanType planType = PlanType.fromString(td.getPlanType());  // Plan - String to Enum
            InterestPolicy policy = interstPolicies.get(planType);      // What is the policy against this plan

            double interest = policy.calculateInterest(td);
            double balanceWithInterest =
                    td.getBalance() + (new BigDecimal(interest).setScale(2, RoundingMode.HALF_UP)).doubleValue();

            td.setBalance(balanceWithInterest);

        }
    }
s
    /*    public void updateBalance(List<TimeDeposit> xs) {
        for (int i = 0; i < xs.size(); i++) {
            double interest = 0;

            if (xs.get(i).getDays() > 30) {
                if (xs.get(i).getPlanType().equals("student")) {
                    if (xs.get(i).getDays() < 366) {
                        interest += xs.get(i).getBalance() * 0.03 / 12;
                    }
                } else if (xs.get(i).getPlanType().equals("premium")) {
                    if (xs.get(i).getDays() > 45) {
                        interest += xs.get(i).getBalance() * 0.05 / 12;
                    }
                } else if (xs.get(i).getPlanType().equals("basic")) {
                    interest += xs.get(i).getBalance() * 0.01 / 12;
                }
            }

            double a2d = xs.get(i).getBalance() + (new BigDecimal(interest).setScale(2, RoundingMode.HALF_UP)).doubleValue();
            xs.get(i).setBalance(a2d);
        }
    } */


}
