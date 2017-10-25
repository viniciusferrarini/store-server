package br.com.slotshop.server.service;

import br.com.slotshop.server.model.User;
import br.com.slotshop.server.model.UserAdress;

import java.util.List;

public interface UserAdressService extends CrudService<UserAdress, Long> {

    UserAdress getUserAdressByUserAndCartZipCode(String zipCode);

    List<UserAdress> findByUser(User user);
    
}
