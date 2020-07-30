package com.coffefreaks.timberwalle.service.Interface;

import com.coffefreaks.timberwalle.model.Request.CartographyRequest;
import com.coffefreaks.timberwalle.model.Response.CartographyResponse;

import java.util.List;

public interface CartographyService {

    List<CartographyResponse> getAll();

    CartographyResponse create(CartographyRequest cartographyRequest);

    CartographyResponse getById(Integer id);

    CartographyResponse update(CartographyRequest cartographyRequest);

    void delete(Integer id);
}
