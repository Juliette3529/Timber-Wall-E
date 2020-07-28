package com.coffefreaks.timberwallee.controller;

import com.coffefreaks.timberwallee.model.Request.ScenarioRequest;
import com.coffefreaks.timberwallee.model.Response.ScenarioResponse;
import com.coffefreaks.timberwallee.service.Interface.ScenarioService;
import com.coffefreaks.timberwallee.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/scenario")
public class ScenarioController {

    private final ScenarioService scenarioService;

    @Autowired
    public ScenarioController(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    @GetMapping("/")
    public List<ScenarioResponse> getActivity() {
        return this.scenarioService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScenarioResponse createScenario(@RequestBody ScenarioRequest scenarioRequest) {
        return this.scenarioService.create(scenarioRequest);
    }

    @PutMapping(value = "/{id}")
    public ScenarioResponse updateScenario(@PathVariable( "id" ) Integer id, @RequestBody ScenarioRequest scenarioRequest) {
        RestPreconditions.checkFound(this.scenarioService.getById(id));
        return this.scenarioService.update(scenarioRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteScenario(@PathVariable("id") Integer id) {
        this.scenarioService.delete(id);
    }
}
