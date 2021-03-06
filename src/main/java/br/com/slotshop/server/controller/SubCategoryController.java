package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.SubCategory;
import br.com.slotshop.server.model.dto.Navbar;
import br.com.slotshop.server.service.CrudService;
import br.com.slotshop.server.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("subCategory")
public class SubCategoryController extends RestCrudController<SubCategory, Long> {

    @Autowired private SubCategoryService subCategoryService;

    @Override
    protected CrudService<SubCategory, Long> getService() {
        return subCategoryService;
    }

    @GetMapping("/navbar")
    public @ResponseBody List<Navbar> getNavbar(){
        return subCategoryService.getNavbar();
    }
}
