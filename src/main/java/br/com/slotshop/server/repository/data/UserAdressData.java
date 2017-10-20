package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.User;
import br.com.slotshop.server.model.UserAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAdressData extends JpaRepository<UserAdress, Long> {

    List<UserAdress> findByUserAndZipCode(User user, String zipCode);

    List<UserAdress> findByUser(User user);
}
