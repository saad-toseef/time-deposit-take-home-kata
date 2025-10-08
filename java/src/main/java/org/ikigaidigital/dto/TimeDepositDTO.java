package org.ikigaidigital.dto;

import java.util.List;

public record TimeDepositDTO(
        Integer id,
        String planType,
        Double balance,
        int days,
        List<WithdrawalDTO> withdrawals
) {}