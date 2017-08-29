package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.service.CategoryService;
import br.com.slotshop.server.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController extends RestCrudController<Category, Long> {

    @Autowired private CategoryService categoryService;

    @Override
    protected CrudService<Category, Long> getService() {
        return categoryService;
    }
}
