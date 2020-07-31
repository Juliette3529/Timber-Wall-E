package com.coffefreaks.timberwallee.controller;

import com.coffefreaks.timberwallee.exception.TimberResourceNotFoundException;
import com.coffefreaks.timberwallee.model.request.LocationRequest;
import com.coffefreaks.timberwallee.model.response.LocationResponse;
import com.coffefreaks.timberwallee.service.interfaces.RobiotService;
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

        //FIXME missing test for straight move

        boolean results = this.robiotService.move(locationRequest);
        if (!results) {
            throw new TimberResourceNotFoundException("Error : The movement could not be performed.");
        }
        LocationResponse response = new LocationResponse(locationRequest.getPositionX(), locationRequest.getPositionY());

        //TODO test if destination is a tree to launch mesure module

        // retrieve the energy consumption after action
        double usage = this.robiotService.getBatteryUsage();
        if (usage < 0) {
            throw new TimberResourceNotFoundException("Error : The battery usage could not be retrieved.");
        }
        response.setBatteryUsage(usage);

        return response;
    }
}
