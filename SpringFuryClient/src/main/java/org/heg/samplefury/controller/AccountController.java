package org.heg.samplefury.controller;

import org.heg.samplefury.manager.AccountManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private final AccountManager accountManager;

    public AccountController(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @GetMapping(path = "/call")
    public void call() {
        accountManager.callGetAccount();
    }
}
