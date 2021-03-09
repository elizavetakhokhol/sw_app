package app.resource;

import app.model.Category;
import app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/category")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @PostMapping(path = "")
    public ResponseEntity<String> createCategory (@RequestBody Category category) {
        categoryService.addCategory(category);
        return new ResponseEntity<>("Category " + category.getName() + " created", HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Category> getCategoryById (@PathVariable(name = "id") long id) {
        Category categoryById = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryById, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCategoryById (@PathVariable(name = "id") long id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>("Category " + categoryService.getCategoryById(id).getName() + " deleted", HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Category>> getAllCategory () {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
}
