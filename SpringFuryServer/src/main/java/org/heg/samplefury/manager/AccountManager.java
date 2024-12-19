package org.heg.samplefury.manager;

import org.heg.samplefury.dto.AccountDto;
import org.heg.samplefury.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Logger;

@Service
public class AccountManager {

    private static final Logger LOG = Logger.getLogger(AccountManager.class.getName());

    public AccountDto findByAccountNo(final String accountNo) {
        LOG.info("Send Account using fury serialization");
        ClientDto clientDto = new ClientDto(1L, "Victor", "Hugo", "France");
        return new AccountDto(1L, "GE-0123456789", clientDto, "ACTIVE", LocalDate.now(), new BigDecimal("2000.00"));
    }
}
