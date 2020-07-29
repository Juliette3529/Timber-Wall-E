package com.coffefreaks.timberwallee.service.Interface;

import com.coffefreaks.timberwallee.model.Request.CircuitRequest;
import com.coffefreaks.timberwallee.model.Response.CircuitResponse;

import java.util.List;

public interface CircuitService {

    List<CircuitResponse> getAll();

    CircuitResponse create(CircuitRequest circuitRequest);

    CircuitResponse getById(Integer id);

    CircuitResponse update(CircuitRequest circuitRequest);

    void delete(Integer id);
}
