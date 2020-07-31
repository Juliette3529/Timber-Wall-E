package com.coffefreaks.timberwalle.service.interfaces;

import com.coffefreaks.timberwalle.model.request.CartographyRequest;
import com.coffefreaks.timberwalle.model.response.CartographyResponse;

import java.util.List;

public interface CartographyService {

    List<CartographyResponse> getAll();

    CartographyResponse create(CartographyRequest cartographyRequest);

    CartographyResponse getById(Integer id);

    CartographyResponse update(CartographyRequest cartographyRequest);

    void delete(Integer id);
}
