package org.heg.samplefury.manager;

import org.heg.samplefury.dto.AccountDto;
import org.heg.samplefury.dto.ClientDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Logger;

@Service
public class AccountManager {

    private static final Logger LOG = Logger.getLogger(AccountManager.class.getName());

    private final RestClient restClient;

    public AccountManager(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }

    public void callGetAccount() {
        LOG.info("Call getAccount to server using fury serialization");
        String accountNo = "GE-0123456789";
        AccountDto accountDto = this.restClient.get().uri("/accounts/search?accountNo={accountNo}", accountNo).retrieve().body(AccountDto.class);
        LOG.info("Receive account from server : " + accountDto);
    }
}
