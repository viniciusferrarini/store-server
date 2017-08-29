package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Model;
import br.com.slotshop.server.repository.data.ModelData;
import br.com.slotshop.server.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ModelServiceImpl extends CrudServiceImpl<Model, Long> implements ModelService {

    @Autowired private ModelData modelData;

    @Override
    protected JpaRepository<Model, Long> getRepository() {
        return modelData;
    }
}
