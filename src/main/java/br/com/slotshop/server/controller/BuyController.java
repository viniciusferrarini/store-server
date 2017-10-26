package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.Buy;
import br.com.slotshop.server.service.BuyService;
import br.com.slotshop.server.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("buy")
public class BuyController extends RestCrudController<Buy, Long> {

    @Autowired private BuyService buyService;

    @Override
    protected CrudService<Buy, Long> getService() {
        return buyService;
    }

    @GetMapping("/findAllOrderByDateDesc")
    public @ResponseBody List<Buy> findAllOrderByDateDesc(){
        return buyService.findAllOrderByDateDesc();
    }

}
