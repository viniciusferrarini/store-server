package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.SubCategory;
import br.com.slotshop.server.repository.data.SubCategoryData;
import br.com.slotshop.server.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubCategoryServiceImpl extends CrudServiceImpl<SubCategory, Long> implements SubCategoryService {

    @Autowired private SubCategoryData subCategoryData;

    @Override
    protected JpaRepository<SubCategory, Long> getRepository() {
        return subCategoryData;
    }
}
