package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelData extends JpaRepository<Model, Long> {

}
