package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.User;
import br.com.slotshop.server.repository.UserRepository;
import br.com.slotshop.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by vinic on 03/08/2017.
 */
@Service
public class UserServiceImpl extends CrudServiceImpl<User, Long> implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public User getLoggedUser() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userRepository.findByEmail(principal.getUsername());
        }
        return null;
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
