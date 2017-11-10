package br.com.slotshop.server.repository;

import br.com.slotshop.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by vinic on 19/06/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String emailOrUsername);

    List<User> findByRegisterDateIsGreaterThanEqual(Date date);

}
