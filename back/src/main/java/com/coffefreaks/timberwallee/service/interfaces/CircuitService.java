package com.coffefreaks.timberwallee.service.interfaces;

import com.coffefreaks.timberwallee.model.request.CircuitRequest;
import com.coffefreaks.timberwallee.model.response.CircuitResponse;

import java.util.List;

public interface CircuitService {

    List<CircuitResponse> getAll();

    CircuitResponse create(CircuitRequest circuitRequest);

    CircuitResponse getById(Integer id);

    CircuitResponse update(CircuitRequest circuitRequest);

    void delete(Integer id);
}
