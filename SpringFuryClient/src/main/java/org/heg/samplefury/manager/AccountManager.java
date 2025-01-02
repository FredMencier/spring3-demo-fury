package org.heg.samplefury.manager;

import org.apache.fury.Fury;
import org.fm.fury.FuryMediaType;
import org.fm.fury.converter.FuryMessageConverter;
import org.heg.samplefury.dto.AccountDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.logging.Logger;

@Service
public class AccountManager {

    private static final Logger LOG = Logger.getLogger(AccountManager.class.getName());

    private final RestClient restClient;

    final
    Fury fury;

    public AccountManager(RestClient.Builder restClientBuilder, Fury fury) {
        this.restClient = restClientBuilder
                .baseUrl("http://localhost:8081")
                .messageConverters(httpMessageConverters -> httpMessageConverters.add(new FuryMessageConverter(fury)))
                .build();
        this.fury = fury;
    }

    public void callGetAccountUsingJsonSerialization() {
        LOG.info("Call getAccount to server using json serialization");
        String accountNo = "GE-0123456789";
        AccountDto accountDto = this.restClient
                .get()
                .uri("/accounts/search?accountNo={accountNo}", accountNo)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(AccountDto.class);
        LOG.info("Receive account from server : " + accountDto);
    }

    public void callGetAccountUsingFurySerialization() {
        LOG.info("Call getAccount to server using fury serialization");
        String accountNo = "GE-0123456789";
        AccountDto accountDto = this.restClient
                .get()
                .uri("/accounts/search?accountNo={accountNo}", accountNo)
                .accept(new MediaType("application", FuryMediaType.furySubType))
                .retrieve()
                .body(AccountDto.class);
        LOG.info("Receive account from server : " + accountDto);
    }
}
