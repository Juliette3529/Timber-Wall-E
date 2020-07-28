package com.coffefreaks.timberwallee.controller;

import com.coffefreaks.timberwallee.model.Request.CartoRequest;
import com.coffefreaks.timberwallee.model.Response.CartoResponse;
import com.coffefreaks.timberwallee.service.Interface.CartoService;
import com.coffefreaks.timberwallee.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carto")
public class CartoController {

    private final CartoService cartoService;

    @Autowired
    public CartoController(CartoService cartoService) {
        this.cartoService = cartoService;
    }

    @GetMapping("/")
    public List<CartoResponse> getCarto() {
        return this.cartoService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartoResponse createCarto(@RequestBody CartoRequest cartoRequest) {
        return this.cartoService.create(cartoRequest);
    }

    @PutMapping(value = "/{id}")
    public CartoResponse updateScenario(@PathVariable( "id" ) Integer id, @RequestBody CartoRequest cartoRequest) {
        RestPreconditions.checkFound(this.cartoService.getById(id));
        return this.cartoService.update(cartoRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteScenario(@PathVariable("id") Integer id) {
        this.cartoService.delete(id);
    }

}
