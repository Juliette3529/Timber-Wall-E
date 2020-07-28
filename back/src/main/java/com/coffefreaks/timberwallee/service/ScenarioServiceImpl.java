package com.coffefreaks.timberwallee.service;

import com.coffefreaks.timberwallee.model.Request.ScenarioRequest;
import com.coffefreaks.timberwallee.model.Response.ScenarioResponse;
import com.coffefreaks.timberwallee.service.Interface.ScenarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioServiceImpl implements ScenarioService {

    @Override
    public List<ScenarioResponse> getAll() {
        return null;
    }

    @Override
    public ScenarioResponse create(ScenarioRequest scenarioRequest) {
        return null;
    }

    @Override
    public ScenarioResponse getById(Integer id) {
        return null;
    }

    @Override
    public ScenarioResponse update(ScenarioRequest scenarioRequest) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
