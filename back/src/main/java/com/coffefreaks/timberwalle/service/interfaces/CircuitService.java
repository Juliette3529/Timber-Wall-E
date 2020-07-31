package com.coffefreaks.timberwalle.service.interfaces;

import com.coffefreaks.timberwalle.model.request.CircuitRequest;
import com.coffefreaks.timberwalle.model.response.CircuitResponse;

import java.util.List;

public interface CircuitService {

    List<CircuitResponse> getAll();

    CircuitResponse create(CircuitRequest circuitRequest);

    CircuitResponse getById(Integer id);

    CircuitResponse update(CircuitRequest circuitRequest);

    void delete(Integer id);
}
