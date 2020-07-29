package com.coffefreaks.timberwallee.service.Interface;

import com.coffefreaks.timberwallee.model.Request.CartographyRequest;
import com.coffefreaks.timberwallee.model.Response.CartographyResponse;

import java.util.List;

public interface CartographyService {

    List<CartographyResponse> getAll();

    CartographyResponse create(CartographyRequest cartographyRequest);

    boolean getById(Integer id);

    CartographyResponse update(CartographyRequest cartographyRequest);

    void delete(Integer id);
}
