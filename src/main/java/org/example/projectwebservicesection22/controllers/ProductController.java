package org.example.projectwebservicesection22.controllers;

import org.example.projectwebservicesection22.entities.Product;
import org.example.projectwebservicesection22.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable(value = "id") Long id) {
        Product product = productService.findById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product){
        Product newProduct = productService.insert(product);

        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}
