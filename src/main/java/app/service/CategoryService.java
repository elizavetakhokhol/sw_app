package app.service;

import app.model.Category;
import app.storage.CategoryRepository;
import app.storage.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void addCategory (Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById (long id) {
        return categoryRepository.getOne(id);
    }

    public void deleteCategoryById (long id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> getAllCategories () {
        return categoryRepository.findAll();
    }
}
