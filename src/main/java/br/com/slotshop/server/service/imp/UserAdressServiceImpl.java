package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.UserAdress;
import br.com.slotshop.server.repository.data.UserAdressData;
import br.com.slotshop.server.service.UserAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdressServiceImpl extends CrudServiceImpl<UserAdress, Long> implements UserAdressService {

    @Autowired private UserAdressData userAdressData;

    @Override
    protected JpaRepository<UserAdress, Long> getRepository() {
        return userAdressData;
    }

    @Override
    public List<UserAdress> findByUser(Long id) {
        return userAdressData.findByUser(id);
    }
}
