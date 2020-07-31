package com.coffefreaks.timberwalle.service;

import com.coffefreaks.timberwalle.model.request.CartographyRequest;
import com.coffefreaks.timberwalle.model.response.CartographyResponse;
import com.coffefreaks.timberwalle.service.interfaces.CartographyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartographyServiceImpl implements CartographyService {

    /**
     * Get All Cartography
     * @return a list of cartographyResponse
     */
    @Override
    public List<CartographyResponse> getAll() {
        //TODO not implemented yet
        return new ArrayList<>();
    }

    /**
     * Create a cartography
     * @param cartographyRequest a cartographyRequest
     * @return a cartography response
     */
    @Override
    public CartographyResponse create(CartographyRequest cartographyRequest) {
        //TODO not implemented yet
        return null;
    }

    /**
     * Get a Cartography by Id
     * @param id cartographyId
     * @return a cartographyResponse
     */
    @Override
    public CartographyResponse getById(Integer id) {
        //TODO not implemented yet
        return new CartographyResponse();
    }

    /**
     * Update a cartography by cartographyRequest
     * @param cartographyRequest a cartographyRequest
     * @return a cartographyResponse
     */
    @Override
    public CartographyResponse update(CartographyRequest cartographyRequest) {
        //TODO not implemented yet
        return null;
    }

    /**
     * Delete Cartography by id
     * @param id cartographyId
     */
    @Override
    public void delete(Integer id) {
        //TODO not implemented yet
    }
}
