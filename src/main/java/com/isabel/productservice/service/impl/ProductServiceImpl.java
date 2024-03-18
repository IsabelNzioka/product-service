package com.isabel.productservice.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isabel.productservice.entity.Product;
import com.isabel.productservice.model.ProductCreateRequest;
import com.isabel.productservice.model.ProductCreateResponse;
import com.isabel.productservice.repository.ProductRepository;
import com.isabel.productservice.service.ProductService;


@Service // class can now be injected
public class ProductServiceImpl implements ProductService {

    
    private final ProductRepository productRepository;

    // constructor injection
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

      @Override
    public ProductCreateResponse createProduct(ProductCreateRequest productCreateRequest) {
       var savedProduct =  productRepository.save(mapToProductEntity(productCreateRequest));
       return mapToProductCreateResponse(savedProduct);
    }

    private Product mapToProductEntity(ProductCreateRequest source){
        Product target = new Product();
        System.out.println("target" + target);
        BeanUtils.copyProperties(source, target);
        System.out.println("target after" + target);
        
        return target;

    }
    private ProductCreateResponse mapToProductCreateResponse(Product source){
        ProductCreateResponse target = new ProductCreateResponse();
        BeanUtils.copyProperties(source, target);
        return target;

    }

    @Override
    public List<ProductCreateResponse> findAll() {
       return productRepository.findAll().stream().map(this::mapToProductCreateResponse).toList();
      }

    
}
