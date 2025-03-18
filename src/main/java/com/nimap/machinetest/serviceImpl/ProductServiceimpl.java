package com.nimap.machinetest.serviceImpl;

import com.nimap.machinetest.DTO.CategoryDto;
import com.nimap.machinetest.DTO.ProductDto;
import com.nimap.machinetest.exception.ResourceNotFoundException;
import com.nimap.machinetest.model.Category;
import com.nimap.machinetest.model.Product;
import com.nimap.machinetest.repositry.CategoryRepository;
import com.nimap.machinetest.repositry.ProductRepository;

import com.nimap.machinetest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

   public Page<ProductDto> getAllProducts(int page , int size){
       PageRequest pageRequest= PageRequest.of(page, size);
       Page<Product> productPage = productRepository.findAll(pageRequest);
       return productPage.map(this::convertToDto);
   }

   public ProductDto getProductById(int id){
       Product product = productRepository.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Product not found  with id  :" + id));

       return convertToDto(product);
   }


   @Transactional
    public ProductDto createdProduct(ProductDto productDto){
       Category category = categoryRepository.findById(productDto.getCategoryId())
               .orElseThrow(()->new ResourceNotFoundException("Category not found  with id  :" + productDto.getCategoryId()));

    Product product = new Product();
    product.setName(productDto.getName());
    product.setDecscription(productDto.getDescription());
    product.setPrice(productDto.getPrice());
    product.setCategory(category);

    Product savedProduct = productRepository.save(product);
    return convertToDto(savedProduct);

   }

   @Transactional
    public ProductDto updateProduct(int id , ProductDto productDto){
       Product product = productRepository.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Product not found  with id  :" + id));


       Category category = categoryRepository.findById(productDto.getCategoryId())
               .orElseThrow(()->new ResourceNotFoundException("Category not found  with id  :" + id));


       product.setName(productDto.getName());
       product.setDecscription(productDto.getDescription());
       product.setPrice(productDto.getPrice());
       product.setCategory(category);

       Product updateProduct = productRepository.save(product);
       return convertToDto(updateProduct);
   }



   private ProductDto convertToDto(Product product){
       ProductDto productDto = new ProductDto();
       productDto.setId(product.getId());
       productDto.setName(product.getName());
       productDto.setDescription(product.getDecscription());
       productDto.setPrice(product.getPrice());

       if(product.getCategory() != null){
           productDto.setCategoryId(product.getCategory().getId());

           CategoryDto categoryDto = new CategoryDto();
           categoryDto.setId(product.getCategory().getId());
           categoryDto.setName(product.getCategory().getName());
           categoryDto.setDescription(product.getCategory().getDecscription());
           productDto.setCategory(categoryDto);
       }
       return productDto;
   }


    @Transactional
    public void deleteProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
    }
}
