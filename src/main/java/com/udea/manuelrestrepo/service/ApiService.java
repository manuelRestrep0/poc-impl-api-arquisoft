package com.udea.manuelrestrepo.service;

import org.springframework.stereotype.Service;

@Service
public class ApiService {

    public Integer suma(int a, int b) {
        return a + b;
    }
}
