package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.Product;
import br.com.slotshop.server.service.CrudService;
import br.com.slotshop.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends RestCrudController<Product, Long> {

    @Autowired private ProductService productService;

    @Override
    protected CrudService<Product, Long> getService() {
        return productService;
    }

    @GetMapping("/findFirst10")
    public @ResponseBody Page<Product> findFirst10(){
        return productService.findFirst10();
    }
}
