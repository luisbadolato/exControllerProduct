package com.ironhack.controllerdemo.controller.interfaces;

import com.ironhack.controllerdemo.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductController {

    Product getById(Long id);
    public List<Product> getAllByDepartmentAndCategory(String department, Optional<String> category);
}
