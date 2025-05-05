package com.udea.manuelrestrepo.Controller;

import com.udea.manuelrestrepo.service.ApiService;
import com.udea.manuelrestrepo.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ApiService apiService;
    @Mock
    private PokemonService pokemonService;

    @Test
    void testPingEndpoint() throws Exception {
        mockMvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("pong"));
    }
}
