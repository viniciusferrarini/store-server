package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.projection.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryData extends JpaRepository<Category, Long> {

}
