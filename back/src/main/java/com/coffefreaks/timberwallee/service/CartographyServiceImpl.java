package com.coffefreaks.timberwallee.service;

import com.coffefreaks.timberwallee.model.Request.CartographyRequest;
import com.coffefreaks.timberwallee.model.Response.CartographyResponse;
import com.coffefreaks.timberwallee.service.Interface.CartographyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartographyServiceImpl implements CartographyService {

    /**
     * Get All Cartography
     * @return a list of cartographyResponse
     */
    @Override
    public List<CartographyResponse> getAll() {
        return null;
    }

    /**
     * Create a cartography
     * @param cartographyRequest a cartographyRequest
     * @return a cartography response
     */
    @Override
    public CartographyResponse create(CartographyRequest cartographyRequest) {
        return null;
    }

    /**
     * Get a Cartography by Id
     * @param id cartographyId
     * @return a cartographyResponse
     */
    @Override
    public CartographyResponse getById(Integer id) {
        return new CartographyResponse();
    }

    /**
     * Update a cartography by cartographyRequest
     * @param cartographyRequest a cartographyRequest
     * @return a cartographyResponse
     */
    @Override
    public CartographyResponse update(CartographyRequest cartographyRequest) {
        return null;
    }

    /**
     * Delete Cartography by id
     * @param id cartographyId
     */
    @Override
    public void delete(Integer id) {

    }
}
