package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.User;
import br.com.slotshop.server.model.UserAdress;
import br.com.slotshop.server.repository.data.UserAdressData;
import br.com.slotshop.server.service.UserAdressService;
import br.com.slotshop.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAdressServiceImpl extends CrudServiceImpl<UserAdress, Long> implements UserAdressService {

    @Autowired private UserAdressData userAdressData;

    @Autowired private UserService userService;

    @Override
    protected JpaRepository<UserAdress, Long> getRepository() {
        return userAdressData;
    }

    @Override
    public UserAdress getUserAdressByUserAndCartZipCode(String zipCode) {
        List<UserAdress> byUserAndZipCode = userAdressData.findByUserAndZipCode(userService.getLoggedUser(), zipCode);
        Optional<UserAdress> first = byUserAndZipCode.stream().findFirst();
        return first.orElse(null);
    }

    @Override
    public List<UserAdress> findByUser(User user) {
        return userAdressData.findByUser(user);
    }
}
