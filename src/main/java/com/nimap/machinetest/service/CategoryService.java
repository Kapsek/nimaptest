package com.nimap.machinetest.service;


import com.nimap.machinetest.DTO.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface CategoryService {

    public Page<CategoryDto> getAllCategories(int page, int size);


    public CategoryDto getCategoryById(int id);


    public CategoryDto createCategory(CategoryDto categoryDto);

    public CategoryDto updateCategory(int id , CategoryDto categoryDto);

    public void daleteCategory(int id);
}
