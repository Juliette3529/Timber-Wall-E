package com.coffefreaks.timberwallee.service;

import com.coffefreaks.timberwallee.model.Request.CircuitRequest;
import com.coffefreaks.timberwallee.model.Response.CircuitResponse;
import com.coffefreaks.timberwallee.service.Interface.CircuitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioServiceImpl implements CircuitService {

    @Override
    public List<CircuitResponse> getAll() {
        return null;
    }

    @Override
    public CircuitResponse create(CircuitRequest scenarioRequest) {
        return null;
    }

    @Override
    public CircuitResponse getById(Integer id) {
        return null;
    }

    @Override
    public CircuitResponse update(CircuitRequest scenarioRequest) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
