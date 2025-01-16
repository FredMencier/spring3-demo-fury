package org.heg.samplefury.controller;

import org.fm.fury.FuryMediaType;
import org.heg.samplefury.dto.AccountDto;
import org.heg.samplefury.manager.AccountManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public AccountDto getAccount(@RequestParam String accountNo) {
        LOG.info("Send Account object");
        return accountManager.findByAccountNo(accountNo);
    }

    @GetMapping(path = "/reactive/search", produces = {FuryMediaType.APPLICATION_FURY_VALUE})
    public Mono<AccountDto> getAccountReactive(@RequestParam String accountNo) {
        LOG.info("[Reactive] Send Account object");
        return Mono.just(accountManager.findByAccountNo(accountNo));
    }
}
