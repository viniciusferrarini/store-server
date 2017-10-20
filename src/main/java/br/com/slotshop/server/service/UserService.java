package br.com.slotshop.server.service;

import br.com.slotshop.server.model.User;

/**
 * Created by vinic on 19/06/2017.
 */
public interface UserService extends CrudService<User, Long>  {

    User getLoggedUser();

    User findByEmail(String emailOrUsername);

}
