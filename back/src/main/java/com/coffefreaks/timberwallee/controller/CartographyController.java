package com.coffefreaks.timberwallee.controller;

import com.coffefreaks.timberwallee.model.Request.CartographyRequest;
import com.coffefreaks.timberwallee.model.Response.CartographyResponse;
import com.coffefreaks.timberwallee.service.Interface.CartographyService;
import com.coffefreaks.timberwallee.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cartography")
public class CartographyController {

    private final CartographyService cartographyService;

    @Autowired
    public CartographyController(CartographyService cartographyService) {
        this.cartographyService = cartographyService;
    }

    @GetMapping("/")
    public List<CartographyResponse> getCartography() {
        return this.cartographyService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartographyResponse createCartography(@RequestBody CartographyRequest cartographyRequest) {
        return this.cartographyService.create(cartographyRequest);
    }

    @PutMapping(value = "/{id}")
    public CartographyResponse updateCartography(@PathVariable( "id" ) Integer id, @RequestBody CartographyRequest cartographyRequest) {
        RestPreconditions.checkFound(this.cartographyService.getById(id));
        return this.cartographyService.update(cartographyRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCartography(@PathVariable("id") Integer id) {
        this.cartographyService.delete(id);
    }

}
