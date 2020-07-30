package com.coffefreaks.timberwalle.service.Interface;

import com.coffefreaks.timberwalle.model.Request.CircuitRequest;
import com.coffefreaks.timberwalle.model.Response.CircuitResponse;

import java.util.List;

public interface CircuitService {

    List<CircuitResponse> getAll();

    CircuitResponse create(CircuitRequest circuitRequest);

    CircuitResponse getById(Integer id);

    CircuitResponse update(CircuitRequest circuitRequest);

    void delete(Integer id);
}
