package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.UserAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAdressData extends JpaRepository<UserAdress, Long> {
    List<UserAdress> findByUser(Long id);
}
