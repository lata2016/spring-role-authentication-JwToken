package com.dhurata.firstApp.ProductManager.service;

import com.dhurata.firstApp.ProductManager.model.Product;
import com.dhurata.firstApp.ProductManager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    private ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> listAll(){
        return productRepository.findAll();
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public Product get(Long id){
        return productRepository.findById(id).get();
    }
    public void delete(Long id){
         productRepository.deleteById(id);
    }


}
