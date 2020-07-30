package com.coffefreaks.timberwalle.controller;

import com.coffefreaks.timberwalle.exception.TimberResourceNotFoundException;
import com.coffefreaks.timberwalle.model.Request.LocationRequest;
import com.coffefreaks.timberwalle.model.Response.LocationResponse;
import com.coffefreaks.timberwalle.service.Interface.RobiotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/move")
public class MoveController {

    private final RobiotService robiotService;

    /***
     * Constructor
     * @param robiotService a RobiotService
     */
    @Autowired
    public MoveController(RobiotService robiotService) {
        this.robiotService = robiotService;
    }

    /**
     * Unit move for robiot
     * @param locationRequest a locationRequest object
     * @return moveResponse
     */
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LocationResponse unitMove(@Valid @RequestBody LocationRequest locationRequest) {

        boolean results = this.robiotService.move(locationRequest);
        if (!results) {
            throw new TimberResourceNotFoundException("Error : The movement could not be performed.");
        }
        return new LocationResponse(locationRequest.getPositionX(), locationRequest.getPositionY());
    }
}
