package com.ironhack.controllerdemo.controller.impl;

import com.ironhack.controllerdemo.controller.interfaces.IProductController;
import com.ironhack.controllerdemo.enums.Category;
import com.ironhack.controllerdemo.enums.Department;
import com.ironhack.controllerdemo.model.Product;
import com.ironhack.controllerdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements IProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getById(@PathVariable(name = "id") Long id) {

        Product producto = productRepository.findById(id).get();
        System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*" + producto.toString());
        return producto;
        // throw exception
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllByDepartmentAndCategory(@RequestParam(name = "department", defaultValue = "CLOTHING") String department, @RequestParam(name = "category") Optional<String> category) {
        if (category.isPresent()) {
            return productRepository.getAllByDepartmentAndCategory(Department.valueOf(department), Category.valueOf(category.get()));
        } else {
            return productRepository.getAllByDepartment(Department.valueOf(department));
        }
    }
}
