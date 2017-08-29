package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.Model;
import br.com.slotshop.server.service.CrudService;
import br.com.slotshop.server.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("model")
public class ModelController extends RestCrudController<Model, Long> {

    @Autowired private ModelService modelService;

    @Override
    protected CrudService<Model, Long> getService() {
        return modelService;
    }
}
