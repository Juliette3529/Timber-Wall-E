package com.coffefreaks.timberwallee.controller;

import com.coffefreaks.timberwallee.model.Request.MoveRequest;
import com.coffefreaks.timberwallee.model.Response.LocationResponse;
import com.coffefreaks.timberwallee.model.Response.MoveResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/move")
public class MoveController {

    /**
     * Unit move for robiot
     * @param moveRequest a moveRequest object
     * @return moveResponse
     */
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MoveResponse unitMove(@Valid @RequestBody MoveRequest moveRequest) {
        //TODO implement call service
        // return boolean if move completed ?

        return null;
    }

    /**
     * Get current location
     * @return a locationResponse
     */
    public LocationResponse getLocation() {


        return new LocationResponse();
    }


}
