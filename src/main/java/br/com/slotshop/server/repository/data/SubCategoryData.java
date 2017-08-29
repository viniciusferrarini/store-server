package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.SubCategory;
import br.com.slotshop.server.projection.SubCategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryData extends JpaRepository<SubCategory, Long> {

}

