package org.heg.samplefury.controller;

import org.heg.samplefury.dto.AccountDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void getAccount() {
        Map<String, String> vars = new HashMap<>();
        String accountNo = "GE-0123456789";
        vars.put("accountNo", accountNo);
        AccountDto accountDto = restTemplate.getForObject("http://localhost:" + port + "/accounts/search?accountNo={accountNo}", AccountDto.class, vars);
        Assertions.assertEquals(accountDto.getNoAccount(), accountNo);
    }
}