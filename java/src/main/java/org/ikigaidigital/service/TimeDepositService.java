package org.ikigaidigital.service;

import org.ikigaidigital.TimeDepositCalculator;
import org.ikigaidigital.domain.TimeDeposit;
import org.ikigaidigital.domain.Withdrawal;
import org.ikigaidigital.dto.TimeDepositDTO;
import org.ikigaidigital.dto.WithdrawalDTO;
import org.ikigaidigital.repository.TimeDepositRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeDepositService {

    private final TimeDepositRepository repo;
    private final TimeDepositCalculator calculator;

    public TimeDepositService(TimeDepositRepository repo, TimeDepositCalculator calculator) {
        this.repo = repo;
        this.calculator = calculator;
    }

    public List<TimeDepositDTO> getAllDeposits() {
        return repo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // DTO Mappging

    private WithdrawalDTO mapWithdrawalToDTO(Withdrawal withdrawal) {
        return new WithdrawalDTO(
                withdrawal.getId(),
                withdrawal.getAmount(),
                withdrawal.getDate()
        );
    }

    private TimeDepositDTO mapToDTO(TimeDeposit td) {
        List<WithdrawalDTO> withdrawalDTOs = td.getWithdrawals().stream()
                .map(this::mapWithdrawalToDTO)
                .collect(Collectors.toList());

        return new TimeDepositDTO(
                td.getId(),
                td.getPlanType(),
                td.getBalance(),
                td.getDays(),
                withdrawalDTOs
        );
    }

}
