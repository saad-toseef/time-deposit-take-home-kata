package org.ikigaidigital.repository;


import org.ikigaidigital.domain.TimeDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeDepositRepository extends JpaRepository<TimeDeposit, Integer> {
}