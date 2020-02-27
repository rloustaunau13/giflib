package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.CategoryRepository;
import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Category;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class CategoryRequest {


    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private GifRepository gifRepository;



    @RequestMapping("/categories")
    public String listcategory(ModelMap modelMap) {
        List<Category> allCategories = categoryRepository.getAllCategories();
        modelMap.put("categories", allCategories);
        return "categories";
    }


    @RequestMapping("/category/{id}")
    public String category(ModelMap modelMap,@PathVariable int id) {

    Category category= categoryRepository.findById(id);

    List<Gif> gifs = gifRepository.findByCategoryId(id);


        modelMap.put("category", category);
        modelMap.put("gifs",gifs);
        return "category";

    }



}