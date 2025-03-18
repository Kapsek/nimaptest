package com.nimap.machinetest.service;

import com.nimap.machinetest.DTO.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface ProductService {


    public Page<ProductDto> getAllProducts(int page , int size);

    public ProductDto getProductById(int id);

    public ProductDto createdProduct(ProductDto productDto);

    public ProductDto updateProduct(int id , ProductDto productDto);

    public void deleteProduct(int id);
}
