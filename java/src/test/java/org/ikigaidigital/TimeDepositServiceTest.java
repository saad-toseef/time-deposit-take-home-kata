package org.ikigaidigital;

import jakarta.transaction.Transactional;
import org.ikigaidigital.dto.TimeDepositDTO;
import org.ikigaidigital.repository.TimeDepositRepository;
import org.ikigaidigital.repository.WithdrawalRepository;
import org.ikigaidigital.service.TimeDepositService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class TimeDepositServiceTest {
    // Given
    @Autowired
    private TimeDepositService service;
    @Autowired
    private TimeDepositRepository timeDepositRepository;
    //@Autowired
    //private WithdrawalRepository withdrawalRepository;

    @Test
    void getAllDepositTest() {

        // WHEN
        List<TimeDepositDTO> deposits = service.getAllDeposits();

        // Then
        assertThat(deposits).isNotNull();
        assertThat(deposits.get(0).id()).isNotNull();
        assertThat(deposits.get(0).balance()).isGreaterThan(0);
        assertThat(deposits.get(0).withdrawals()).isNotNull();
        assertThat(deposits.get(0).withdrawals().get(0).amount()).isGreaterThan(0);
    }

}
