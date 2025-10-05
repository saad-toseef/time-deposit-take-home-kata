package org.ikigaidigital.repository;

import org.ikigaidigital.domain.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Integer> {
}
