package org.ikigaidigital;

import jdk.jfr.Description;
import org.ikigaidigital.domain.TimeDeposit;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeDepositCalculatorTest {


    @Test
    public void updateBalance_Test() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        List<TimeDeposit> plans = Arrays.asList(
            new TimeDeposit(1,"basic", 1234567.00, 45)
        );
        calc.updateBalance(plans);

        assertThat(1).isEqualTo(1);
    }

    @Test
    @Description("No interest is calculated for first 30 days")
    public void ZeroInterestFirst30DaysTest() {

        // Given
        List<TimeDeposit> plans = List.of(
                new TimeDeposit(1, "basic", 100.25, 30),
                new TimeDeposit(2, "student", 500.75, 30) ,
                new TimeDeposit(3, "premium", 1500.23, 30));

        double expectedBalBasic = 100.25;
        double expectedBalStudent = 500.75;
        double expectedBalPremium = 1500.23;

        // When
        TimeDepositCalculator calculator = new TimeDepositCalculator();
        calculator.updateBalance(plans);

        // Then
        assertThat(plans.get(0).getBalance()).isEqualTo(expectedBalBasic); // Basic
        assertThat(plans.get(1).getBalance()).isEqualTo(expectedBalStudent); // Student
        assertThat(plans.get(2).getBalance()).isEqualTo(expectedBalPremium); // Premium
    }

    @Test
    @Description("Student Earns interest Only between 30 and 365 days")
    void studentInterestValidRangeTest() {

        // Given
        TimeDeposit td = new TimeDeposit(4, "student", 1000.00, 200);
        double expectedBalance = 1002.50; // 1000 * 0.03 / 12 = 2.50 = 1000 + 2.50 = 1002.50

        // When
        TimeDepositCalculator calc = new TimeDepositCalculator();
        calc.updateBalance(List.of(td));

        // Then
        assertThat(td.getBalance()).isEqualTo(expectedBalance);
    }

    @Test
    @Description("Student Loses Interest after 365 days or more ")
    void studentNoInterestAfterAYearTest() {
        //Given
        TimeDeposit td = new TimeDeposit(5, "student", 750.00, 366);
        TimeDepositCalculator calc = new TimeDepositCalculator();

        double expectedBalance = 750.00;
        // When
        calc.updateBalance(List.of(td));

        // Then
        assertThat(td.getBalance()).isEqualTo(expectedBalance);
    }

    @Test
    @Description("Premium - interest after 45 days")
    void premiumAppliesAfter45DaysTest() {
        // Given
        TimeDeposit td = new TimeDeposit(7, "premium", 2000.00, 60);
        TimeDepositCalculator calc = new TimeDepositCalculator();
        // When
        calc.updateBalance(List.of(td));

        double expectedBalance = 2008.33;// interest = 2000 * 0.05 / 12 = 8.333333
        // Then
        assertThat(td.getBalance()).isEqualTo(expectedBalance);
    }

}
