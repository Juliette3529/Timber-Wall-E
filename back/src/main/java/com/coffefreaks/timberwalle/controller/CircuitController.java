package com.coffefreaks.timberwalle.controller;

import com.coffefreaks.timberwalle.model.request.CircuitRequest;
import com.coffefreaks.timberwalle.model.response.CircuitResponse;
import com.coffefreaks.timberwalle.service.interfaces.CircuitService;
import com.coffefreaks.timberwalle.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/circuit")
public class CircuitController {

    private final CircuitService circuitService;

    /**
     * Class constructor
     * @param circuitService a circuitService
     */
    @Autowired
    public CircuitController(CircuitService circuitService) {
        this.circuitService = circuitService;
    }

    /**
     * Get All Circuit
     * @return a list of circuitResponse
     */
    @GetMapping("/")
    public List<CircuitResponse> getCircuit() {
        return this.circuitService.getAll();
    }

    /**
     * Create a circuit
     * @param circuitRequest a circuitRequest object
     * @return a circuitResponse
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CircuitResponse createCircuit(@RequestBody CircuitRequest circuitRequest) {
        return this.circuitService.create(circuitRequest);
    }

    /**
     * Update a Circuit
     * @param id circuit id
     * @param circuitRequest a circuitRequest object
     * @return a circuitResponse
     */
    @PutMapping(value = "/{id}")
    public CircuitResponse updateCircuit(@PathVariable( "id" ) Integer id, @RequestBody CircuitRequest circuitRequest) {
        RestPreconditions.checkFound(this.circuitService.getById(id));
        return this.circuitService.update(circuitRequest);
    }

    /**
     * Delete circuit
     * @param id a id of circuit
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCircuit(@PathVariable("id") Integer id) {
        this.circuitService.delete(id);
    }
}
