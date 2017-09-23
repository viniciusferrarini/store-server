package br.com.slotshop.server.service;

import br.com.slotshop.server.model.UserAdress;

import java.util.List;

public interface UserAdressService extends CrudService<UserAdress, Long> {
    List<UserAdress> findByUser(Long id);
}
