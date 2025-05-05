package com.udea.manuelrestrepo.Service;

import com.udea.manuelrestrepo.service.ApiService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiServiceTest {
    @Test
    void testSuma() {
        ApiService apiService = new ApiService();
        Integer resultado = apiService.suma(3, 5);

        assertEquals(8, resultado);
    }

    @Test
    void testSumaNegativos() {
        ApiService apiService = new ApiService();
        Integer resultado = apiService.suma(-3, -5);

        assertEquals(-8, resultado);
    }

    @Test
    void testSumaCero() {
        ApiService apiService = new ApiService();
        Integer resultado = apiService.suma(0, 5);

        assertEquals(5, resultado);
    }
}
