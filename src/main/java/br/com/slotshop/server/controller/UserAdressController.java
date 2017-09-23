package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.UserAdress;
import br.com.slotshop.server.service.CrudService;
import br.com.slotshop.server.service.UserAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userAdress")
public class UserAdressController extends RestCrudController<UserAdress, Long> {

    @Autowired private UserAdressService userAdressService;

    @GetMapping(value = "/findByUser/{id}")
    public @ResponseBody List<UserAdress> findByUser(@PathVariable("id") Long id){
        return userAdressService.findByUser(id);
    }

    @Override
    protected CrudService<UserAdress, Long> getService() {
        return userAdressService;
    }
}
