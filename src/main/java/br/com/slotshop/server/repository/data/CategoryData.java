package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "objetos", path = "category")
public interface CategoryData extends JpaRepository<Category, Long> {

}
