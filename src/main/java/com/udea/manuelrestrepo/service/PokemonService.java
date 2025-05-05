package com.udea.manuelrestrepo.service;

import com.udea.manuelrestrepo.entities.PokemonDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PokemonService {
    private final WebClient webClient;

    public PokemonService(WebClient.Builder builder) {
        //Codigo para evitar el error de exceso de información al consultar la api de pokemon
        int maxSizeInBytes = 2 * 1024 * 1024;

        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(maxSizeInBytes))
                .build();

        this.webClient = builder
                .baseUrl("https://pokeapi.co/api/v2/")
                .exchangeStrategies(strategies)
                .build();    }

    public PokemonDTO getPokemonById(int id) {
        return webClient.get()
                .uri("pokemon/{id}", id)
                .retrieve()
                .bodyToMono(PokemonDTO.class)
                .block();
    }
}
