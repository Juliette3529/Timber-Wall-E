package com.coffefreaks.timberwallee.service;

import com.coffefreaks.timberwallee.model.Request.CircuitRequest;
import com.coffefreaks.timberwallee.model.Response.CircuitResponse;
import com.coffefreaks.timberwallee.service.Interface.CircuitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioServiceImpl implements CircuitService {

    /**
     * GetAll Circuit
     * @return a list of CircuitResponse
     */
    @Override
    public List<CircuitResponse> getAll() {
        return null;
    }

    /**
     * Create a new Circuit
     * @param circuitRequest a circuitRequest object
     * @return a new CircuitResponse
     */
    @Override
    public CircuitResponse create(CircuitRequest circuitRequest) {
        return null;
    }

    /**
     *  Get Circuit by Id
     * @param id circuit id
     * @return a CircuitResponse
     */
    @Override
    public CircuitResponse getById(Integer id) {
        return new CircuitResponse();
    }

    /**
     *  Update a circuit
     * @param circuitRequest a circuitRequest
     * @return a new CircuitResponse
     */
    @Override
    public CircuitResponse update(CircuitRequest circuitRequest) {
        return null;
    }

    /**
     * Delete a circuit
     * @param id a CircuitId
     */
    @Override
    public void delete(Integer id) {

    }
}
