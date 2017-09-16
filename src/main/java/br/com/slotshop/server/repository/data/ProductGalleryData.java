package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.ProductGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGalleryData extends JpaRepository<ProductGallery, Long> {
}
