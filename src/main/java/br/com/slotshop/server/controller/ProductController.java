package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.Product;
import br.com.slotshop.server.service.CrudService;
import br.com.slotshop.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends RestCrudController<Product, Long> {

    @Autowired private ProductService productService;

    @Override
    protected CrudService<Product, Long> getService() {
        return productService;
    }
}
