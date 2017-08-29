package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.Brand;
import br.com.slotshop.server.service.BrandService;
import br.com.slotshop.server.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brand")
public class BrandController extends RestCrudController<Brand, Long> {

    @Autowired private BrandService brandService;

    @Override
    protected CrudService<Brand, Long> getService() {
        return brandService;
    }
}
