package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Product;
import br.com.slotshop.server.repository.data.ProductData;
import br.com.slotshop.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl extends CrudServiceImpl<Product, Long> implements ProductService {

    @Autowired private ProductData productData;

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productData;
    }

    @Override
    public Page<Product> findFirst10() {
        return productData.findAll(new PageRequest(0, 10));
    }
}
