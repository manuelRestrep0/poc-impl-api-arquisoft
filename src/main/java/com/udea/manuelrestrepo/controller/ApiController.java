package com.udea.manuelrestrepo.controller;

import com.udea.manuelrestrepo.entities.PokemonDTO;
import com.udea.manuelrestrepo.service.ApiService;
import com.udea.manuelrestrepo.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final ApiService apiService;
    private final PokemonService pokemonService;

    public ApiController(ApiService apiService, PokemonService pokemonService) {
        this.apiService = apiService;
        this.pokemonService = pokemonService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("/suma")
    public Integer suma(@RequestParam int a, @RequestParam int b) {
        return apiService.suma(a, b);
    }

    @GetMapping("/pokemon/{id}")
    public PokemonDTO getPokemon(@PathVariable int id) {
        return pokemonService.getPokemonById(id);
    }
}
