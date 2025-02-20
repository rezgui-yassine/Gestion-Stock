package com.yassinecoding.gestiondestock.controller.api;

import com.yassinecoding.gestiondestock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryApi {

@PostMapping(value = "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody  CategoryDto categoryDto);

    @GetMapping(value = "/category/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE )
    CategoryDto findById(@PathVariable ("categoryId") Integer id);

    @GetMapping(value = "/category/{categorycode}", produces = MediaType.APPLICATION_JSON_VALUE )
    CategoryDto findByCode(@PathVariable("categorycode")  String code);
    CategoryDto findByDesignation(String designation);
    @GetMapping(value = "/category/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<CategoryDto> findAll();
    @DeleteMapping(value = "/category/delete/{categoryId}")
    void delete (@PathVariable("categoryId") Integer id);
}
