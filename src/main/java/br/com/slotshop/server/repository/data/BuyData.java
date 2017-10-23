package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.Buy;
import br.com.slotshop.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyData extends JpaRepository<Buy, Long> {
    List<Buy> findByUserOrderByIdDesc(User user);
}
