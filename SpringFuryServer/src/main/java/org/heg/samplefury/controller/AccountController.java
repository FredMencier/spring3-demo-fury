package org.heg.samplefury.controller;

import org.fm.fury.FuryMediaType;
import org.heg.samplefury.dto.AccountDto;
import org.heg.samplefury.manager.AccountManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private final AccountManager accountManager;

    public AccountController(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @GetMapping(path = "/search", produces = {MediaType.APPLICATION_JSON_VALUE, FuryMediaType.APPLICATION_FURY_VALUE})
    public AccountDto getAccount(@RequestParam String accountNo) {
        return accountManager.findByAccountNo(accountNo);
    }
}
