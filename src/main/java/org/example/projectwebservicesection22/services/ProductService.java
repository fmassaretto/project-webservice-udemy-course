package org.example.projectwebservicesection22.services;

import org.example.projectwebservicesection22.entities.Product;
import org.example.projectwebservicesection22.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll(){
        return ProductRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> product = ProductRepository.findById(id);

        return product.get();
    }
}
