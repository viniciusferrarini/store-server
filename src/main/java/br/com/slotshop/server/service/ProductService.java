package br.com.slotshop.server.service;

import br.com.slotshop.server.model.Product;
import org.springframework.data.domain.Page;

public interface ProductService extends CrudService<Product, Long> {
    Page<Product> findFirst10();
}
