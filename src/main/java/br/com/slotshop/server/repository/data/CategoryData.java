package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryData extends JpaRepository<Category, Long> {

}
