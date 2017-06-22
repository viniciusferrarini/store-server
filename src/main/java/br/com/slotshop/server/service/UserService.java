package br.com.slotshop.server.service;

import br.com.slotshop.server.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by vinic on 19/06/2017.
 */
public interface UserService extends UserDetailsService, CrudService<User, Long>  {


}
