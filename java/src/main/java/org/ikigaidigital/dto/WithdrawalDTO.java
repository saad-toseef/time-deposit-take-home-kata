package org.ikigaidigital.dto;


import java.time.LocalDate;

public record WithdrawalDTO(
            Integer id,
            Double amount,
            LocalDate date
    ) {}

