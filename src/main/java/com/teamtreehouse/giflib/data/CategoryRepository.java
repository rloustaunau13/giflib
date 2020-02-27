package com.teamtreehouse.giflib.data;

import com.teamtreehouse.giflib.model.Category;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1001,"Animated"),
            new Category(1002,"People"),
            new Category(1003,"Shooting")
    );




    public List<Category> getAllCategories() {

        return ALL_CATEGORIES;
    }


    public Category findById(int id){

        for(Category category: ALL_CATEGORIES){

            if(category.getId() == id ){

                return category;
            }
        }
        return null;
    }
}



