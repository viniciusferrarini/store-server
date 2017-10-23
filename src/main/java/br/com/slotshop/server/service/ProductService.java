package br.com.slotshop.server.service;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.model.Product;
import br.com.slotshop.server.model.SubCategory;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService extends CrudService<Product, Long> {

    List<Product> findFirst10();

    Page<Product> findBySearchTerm(String search);

    Page<Product> findBySearchTermAndPage(String search, Integer page);

    Page<Product> findByCategory(Category category, Integer page);

    Page<Product> findBySubCategoryAndPage(SubCategory subCategory, Integer page);

}
