package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.model.Product;
import br.com.slotshop.server.model.SubCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductData extends JpaRepository<Product, Long> {

    List<Product> findTop12ByOrderByIdDesc();

    Page<Product> findByNameContainingOrDescriptionContainingIgnoreCase(String searchName, String searchDescription, Pageable pageable);

    Page<Product> findBySubCategory(SubCategory subCategory, Pageable pageable);

    Page<Product> findBySubCategoryCategory(Category category, Pageable pageable);
}
