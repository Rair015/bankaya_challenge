package com.bankaya.pokeapiconsumer.configs;

import com.bankaya.pokeapiconsumer.utils.PokemonIdToXMLAdapter;
import jakarta.xml.bind.JAXBException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public PokemonIdToXMLAdapter xmlAdapter() throws JAXBException {
        return new PokemonIdToXMLAdapter();
    }
}
