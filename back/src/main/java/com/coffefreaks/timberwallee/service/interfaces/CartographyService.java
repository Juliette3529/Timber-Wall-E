package com.coffefreaks.timberwallee.service.interfaces;

import com.coffefreaks.timberwallee.model.request.CartographyRequest;
import com.coffefreaks.timberwallee.model.response.CartographyResponse;

import java.util.List;

public interface CartographyService {

    List<CartographyResponse> getAll();

    CartographyResponse create(CartographyRequest cartographyRequest);

    CartographyResponse getById(Integer id);

    CartographyResponse update(CartographyRequest cartographyRequest);

    void delete(Integer id);
}
