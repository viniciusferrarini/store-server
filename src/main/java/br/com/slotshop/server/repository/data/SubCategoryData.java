package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryData extends JpaRepository<SubCategory, Long> {

    List<SubCategory> findAllByOrderByNameAsc();

}

