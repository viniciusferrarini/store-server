package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandData extends JpaRepository<Brand, Long> {

}