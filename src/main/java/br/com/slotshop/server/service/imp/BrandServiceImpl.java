package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Brand;
import br.com.slotshop.server.repository.data.BrandData;
import br.com.slotshop.server.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl extends CrudServiceImpl<Brand, Long> implements BrandService {

    @Autowired private BrandData brandData;

    @Override
    protected JpaRepository<Brand, Long> getRepository() {
        return brandData;
    }

}
