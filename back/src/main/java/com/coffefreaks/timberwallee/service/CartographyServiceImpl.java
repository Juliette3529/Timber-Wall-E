package com.coffefreaks.timberwallee.service;

import com.coffefreaks.timberwallee.model.Request.CartographyRequest;
import com.coffefreaks.timberwallee.model.Response.CartographyResponse;
import com.coffefreaks.timberwallee.service.Interface.CartographyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartographyServiceImpl implements CartographyService {

    @Override
    public List<CartographyResponse> getAll() {
        return null;
    }

    @Override
    public CartographyResponse create(CartographyRequest cartoRequest) {
        return null;
    }

    @Override
    public boolean getById(Integer id) {
        return false;
    }

    @Override
    public CartographyResponse update(CartographyRequest cartoRequest) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
