package org.heg.samplefury;

import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.heg.samplefury.dto.AccountDto;
import org.heg.samplefury.dto.ClientDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Logger;

@SpringBootTest
class SimpleFuryTests {

	private static final Logger LOG = Logger.getLogger(SimpleFuryTests.class.getName());

	private static Fury fury;

	@BeforeAll
	public static void init() {
		fury = Fury.builder()
				.withLanguage(Language.JAVA)
				.withAsyncCompilation(true)
				.build();

		fury.register(AccountDto.class);
		fury.register(ClientDto.class);
	}

    @Test
    void basicSerDeser() {
		ClientDto clientDto = new ClientDto(1L, "Victor", "Hugo", "France");
		AccountDto accountDto = new AccountDto(1L, "GE-0123456789", clientDto, "ACTIVE", LocalDate.now(), new BigDecimal("2000.00"));

		byte[] serializedData = fury.serialize(accountDto);
		AccountDto accountDtoDeser = (AccountDto) fury.deserialize(serializedData);
		LOG.info(accountDtoDeser.toString());
    }

}
