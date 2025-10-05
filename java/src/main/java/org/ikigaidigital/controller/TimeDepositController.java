package org.ikigaidigital.controller;

import org.ikigaidigital.domain.TimeDeposit;
import org.ikigaidigital.dto.TimeDepositDTO;
import org.ikigaidigital.service.TimeDepositService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time-deposits")
public class TimeDepositController {

    private final TimeDepositService service;

    public TimeDepositController(TimeDepositService service) {
        this.service = service;
    }

    @GetMapping
    public List<TimeDepositDTO> getAllDeposits() {
        return service.getAllDeposits();
    }

}
