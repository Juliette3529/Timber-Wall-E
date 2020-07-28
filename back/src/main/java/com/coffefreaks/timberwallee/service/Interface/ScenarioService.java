package com.coffefreaks.timberwallee.service.Interface;

import com.coffefreaks.timberwallee.model.Request.ScenarioRequest;
import com.coffefreaks.timberwallee.model.Response.ScenarioResponse;

import java.util.List;

public interface ScenarioService {

    List<ScenarioResponse> getAll();

    ScenarioResponse create(ScenarioRequest scenarioRequest);

    ScenarioResponse getById(Integer id);

    ScenarioResponse update(ScenarioRequest scenarioRequest);

    void delete(Integer id);
}
