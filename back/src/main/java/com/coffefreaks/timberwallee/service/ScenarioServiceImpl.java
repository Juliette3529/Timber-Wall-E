package com.coffefreaks.timberwallee.service;

import com.coffefreaks.timberwallee.model.request.CircuitRequest;
import com.coffefreaks.timberwallee.model.response.CircuitResponse;
import com.coffefreaks.timberwallee.service.interfaces.CircuitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioServiceImpl implements CircuitService {

    /**
     * GetAll Circuit
     * @return a list of CircuitResponse
     */
    @Override
    public List<CircuitResponse> getAll() {
        return new ArrayList<>();
    }

    /**
     * Create a new Circuit
     * @param circuitRequest a circuitRequest object
     * @return a new CircuitResponse
     */
    @Override
    public CircuitResponse create(CircuitRequest circuitRequest) {
        //TODO not implemented yet
        return null;
    }

    /**
     *  Get Circuit by Id
     * @param id circuit id
     * @return a CircuitResponse
     */
    @Override
    public CircuitResponse getById(Integer id) {
        //TODO not implemented yet
        return new CircuitResponse();
    }

    /**
     *  Update a circuit
     * @param circuitRequest a circuitRequest
     * @return a new CircuitResponse
     */
    @Override
    public CircuitResponse update(CircuitRequest circuitRequest) {
        //TODO not implemented yet
        return null;
    }

    /**
     * Delete a circuit
     * @param id a CircuitId
     */
    @Override
    public void delete(Integer id) {
        //TODO not implemented yet
    }
}
