package com.coffefreaks.timberwallee.service;

import com.coffefreaks.timberwallee.model.Request.CartoRequest;
import com.coffefreaks.timberwallee.model.Response.CartoResponse;
import com.coffefreaks.timberwallee.service.Interface.CartoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartoServiceImpl implements CartoService {

    @Override
    public List<CartoResponse> getAll() {
        return null;
    }

    @Override
    public CartoResponse create(CartoRequest cartoRequest) {
        return null;
    }

    @Override
    public boolean getById(Integer id) {
        return false;
    }

    @Override
    public CartoResponse update(CartoRequest cartoRequest) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
