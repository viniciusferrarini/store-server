package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.repository.data.CategoryData;
import br.com.slotshop.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl extends CrudServiceImpl<Category, Long> implements CategoryService {

    @Autowired private CategoryData categoryData;

    @Override
    protected JpaRepository<Category, Long> getRepository() {
        return categoryData;
    }
}
