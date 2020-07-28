package com.coffefreaks.timberwallee.service.Interface;

import com.coffefreaks.timberwallee.model.Request.CartoRequest;
import com.coffefreaks.timberwallee.model.Response.CartoResponse;

import java.util.List;

public interface CartoService {

    List<CartoResponse> getAll();

    CartoResponse create(CartoRequest cartoRequest);

    boolean getById(Integer id);

    CartoResponse update(CartoRequest cartoRequest);

    void delete(Integer id);
}
