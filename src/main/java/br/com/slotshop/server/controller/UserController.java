package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.User;
import br.com.slotshop.server.service.CrudService;
import br.com.slotshop.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by vinic on 19/06/2017.
 */
@RestController
@RequestMapping("user")
public class UserController extends RestCrudController<User, Long> {

    @Autowired
    private UserService userService;

    @Override
    protected CrudService<User, Long> getService() {
        return userService;
    }

    @GetMapping("userLogged")
    public User userLogged(Principal principal){
        return userService.findByEmail(principal.getName());
    }

}
