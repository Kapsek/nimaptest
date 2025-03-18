package com.nimap.machinetest.serviceImpl;

import com.nimap.machinetest.DTO.CategoryDto;
import com.nimap.machinetest.exception.ResourceNotFoundException;
import com.nimap.machinetest.model.Category;
import com.nimap.machinetest.repositry.CategoryRepository;

import com.nimap.machinetest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    // Get all categories with pagination
    public Page<CategoryDto> getAllCategories(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Category> categoryPage = categoryRepository.findAll(pageRequest);

        return categoryPage.map(this::convertToDto);
    }


    public CategoryDto getCategoryById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found  with id  :" + id));

        return convertToDto(category);
    }


    @Transactional
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDecscription(categoryDto.getDescription());

        Category savedCategeroy = categoryRepository.save(category);

        return convertToDto(savedCategeroy);

    }


    @Transactional
    public CategoryDto updateCategory(int id , CategoryDto categoryDto){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found  with id  :" + id));

        category.setName(categoryDto.getName());
        category.setDecscription(categoryDto.getDescription());

        Category updateCategory = categoryRepository.save(category);

        return convertToDto(updateCategory);

    }

    @Transactional
    public void daleteCategory(int id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found  with id  :" + id));

        categoryRepository.delete(category);
    }

    private CategoryDto convertToDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDecscription());


        return categoryDto;
    }

}



