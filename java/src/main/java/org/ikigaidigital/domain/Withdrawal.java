package org.ikigaidigital.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "withdrawals")
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "withdrawal_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_deposit_id", nullable = false)
    private TimeDeposit timeDeposit;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "date", nullable = false)
    private LocalDate date;


    protected Withdrawal() {}

    public Withdrawal(TimeDeposit timeDeposit, Double amount, LocalDate date) {
        this.timeDeposit = timeDeposit;
        this.amount = amount;
        this.date = date;
    }



    public Integer getId()
    {
        return id;
    }

    public TimeDeposit getTimeDeposit() {
        return timeDeposit;
    }
    public void setTimeDeposit(TimeDeposit timeDeposit) {
        this.timeDeposit = timeDeposit;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}