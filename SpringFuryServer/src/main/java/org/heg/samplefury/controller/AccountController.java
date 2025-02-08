package org.heg.samplefury.controller;

import org.fm.fury.FuryMediaType;
import org.heg.samplefury.dto.AccountDto;
import org.heg.samplefury.manager.AccountManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private static final Logger LOG = Logger.getLogger(AccountController.class.getName());

    private final AccountManager accountManager;

    public AccountController(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @GetMapping(path = "/search", produces = {MediaType.APPLICATION_JSON_VALUE, FuryMediaType.APPLICATION_FURY_VALUE})
    public AccountDto getAccount(@RequestParam String accountNo, @RequestHeader HttpHeaders headers) {
        LOG.info("Send Account object using " + headers.get("Accept").get(0));
        return accountManager.findByAccountNo(accountNo);
    }

    @GetMapping(path = "/reactive/search", produces = {FuryMediaType.APPLICATION_FURY_VALUE})
    public Mono<AccountDto> getAccountReactive(@RequestParam String accountNo, @RequestHeader HttpHeaders headers) {
        LOG.info("[Reactive] Send Account object using " + headers.get("Accept").get(0));
        return Mono.just(accountManager.findByAccountNo(accountNo));
    }
}
