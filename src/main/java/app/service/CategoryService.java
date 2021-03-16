package app.service;

import app.model.Category;
import app.storage.CategoryRepository;
import app.storage.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void addCategory (Category category) {
        log.info("addCategory");
        categoryRepository.save(category);
    }

    public Category getCategoryById (long id) {
        log.info("get category by id");
        return categoryRepository.getOne(id);
    }

    public void deleteCategoryById (long id) {
        log.info("get category by id");
        categoryRepository.deleteById(id);
    }

    public List<Category> getAllCategories () {
        log.info("get all categories");
        return categoryRepository.findAll();
    }
}
