package app.service;

import app.model.Category;
import app.storage.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CategoryServiceTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void addCategory() {
        Category category = new Category(1,"categ");
        categoryRepository.save(category);
        categoryRepository.getOne(1L);
    }

    @Test
    void getCategoryById() {
        Category category = new Category(1,"categ");
        categoryRepository.save(category);
        categoryRepository.getOne(1L);
    }

    @Test
    void deleteCategoryById() {
        Category category = new Category(1,"categ");
        categoryRepository.save(category);
        categoryRepository.deleteById(1L);
        categoryRepository.findById(1L);
    }

    @Test
    void getAllCategories() {
        Category category = new Category(1,"categ");
        categoryRepository.save(category);
        Category category2 = new Category(2,"categ2");
        categoryRepository.save(category2);
        categoryRepository.findAll();
    }
}