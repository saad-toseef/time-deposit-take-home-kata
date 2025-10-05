package org.ikigaidigital.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "time_deposits")
public class TimeDeposit {

    @Id
    @Column(name = "time_deposit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "plan_type")
    private String planType;

    private Double balance;
    private int days;

    @OneToMany(mappedBy = "timeDeposit", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Withdrawal> withdrawals = new ArrayList<>();

    public TimeDeposit(int id, String planType, Double balance, int days) {
        this.id = id;
        this.planType = planType;
        this.balance = balance;
        this.days = days;
    }

    protected TimeDeposit() {};

    public int getId() { return id; }

    public String getPlanType() {
        return planType;
    }

    public Double getBalance() {
        return balance;
    }

    public int getDays() {
        return days;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Withdrawal> getWithdrawals() {
        return withdrawals;
    }
}
