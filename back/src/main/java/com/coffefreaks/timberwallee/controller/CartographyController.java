package com.coffefreaks.timberwallee.controller;

import com.coffefreaks.timberwallee.model.request.CartographyRequest;
import com.coffefreaks.timberwallee.model.response.CartographyResponse;
import com.coffefreaks.timberwallee.service.interfaces.CartographyService;
import com.coffefreaks.timberwallee.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cartography")
public class CartographyController {

    private final CartographyService cartographyService;

    /**
     * Constructor
     * @param cartographyService a cartographyService
     */
    @Autowired
    public CartographyController(CartographyService cartographyService) {
        this.cartographyService = cartographyService;
    }

    /**
     * GetListCartography
     * @return list of cartography
     */
    @GetMapping("/")
    public List<CartographyResponse> getCartography() {
        return this.cartographyService.getAll();
    }

    /**
     * Create a Cartography
     * @param cartographyRequest cartographyRequest object
     * @return a new cartography
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartographyResponse createCartography(@RequestBody CartographyRequest cartographyRequest) {
        return this.cartographyService.create(cartographyRequest);
    }

    /**
     * Update a cartography
     * @param id of cartography
     * @param cartographyRequest cartographyRequest object
     * @return updated cartography
     */
    @PutMapping(value = "/{id}")
    public CartographyResponse updateCartography(@PathVariable( "id" ) Integer id, @RequestBody CartographyRequest cartographyRequest) {
        RestPreconditions.checkFound(this.cartographyService.getById(id));
        return this.cartographyService.update(cartographyRequest);
    }

    /**
     * Delete a cartography
     * @param id Cartography Id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCartography(@PathVariable("id") Integer id) {
        this.cartographyService.delete(id);
    }

}
