package org.heg.samplefury;

import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.heg.samplefury.converter.FuryMessageConverter;
import org.heg.samplefury.dto.AccountDto;
import org.heg.samplefury.dto.ClientDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FuryConfig {

    @Bean
    public Fury createFury() {
        Fury fury = Fury.builder()
                .withLanguage(Language.JAVA)
                .withAsyncCompilation(true)
                .build();
        fury.register(AccountDto.class);
        fury.register(ClientDto.class);
        return fury;
    }

    @Bean
    public FuryMessageConverter createGensonMessageConverter() {
        return new FuryMessageConverter(createFury());
    }

}
