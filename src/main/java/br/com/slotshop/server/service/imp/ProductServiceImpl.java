package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.model.Product;
import br.com.slotshop.server.model.SubCategory;
import br.com.slotshop.server.repository.data.ProductData;
import br.com.slotshop.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl extends CrudServiceImpl<Product, Long> implements ProductService {

    @Autowired private ProductData productData;

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productData;
    }

    @Override
    public List<Product> findFirst10() {
        return productData.findTop12ByOrderByIdDesc();
    }

    @Override
    public Page<Product> findBySearchTerm(String search) {
        return productData.findByNameContainingOrDescriptionContainingIgnoreCase(search, search, pageRequest(0));
    }

    @Override
    public Page<Product> findBySearchTermAndPage(String search, Integer page) {
        return productData.findByNameContainingOrDescriptionContainingIgnoreCase(search, search, pageRequest(page));
    }

    @Override
    public Page<Product> findByCategory(Category category, Integer page) {
        return productData.findBySubCategoryCategory(category, pageRequest(page != null ? page : 0));
    }

    @Override
    public Page<Product> findBySubCategoryAndPage(SubCategory subCategory, Integer page) {
        return productData.findBySubCategory(subCategory, pageRequest(page != null ? page : 0));
    }

    private PageRequest pageRequest(int page) {
        return new PageRequest(page, 12, new Sort(Sort.Direction.ASC, "name"));
    }
}
