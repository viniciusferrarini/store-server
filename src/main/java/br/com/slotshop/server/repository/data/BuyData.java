package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyData extends JpaRepository<Buy, Long> {
}
