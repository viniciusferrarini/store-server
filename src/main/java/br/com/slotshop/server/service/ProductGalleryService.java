package br.com.slotshop.server.service;

import br.com.slotshop.server.model.ProductGallery;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductGalleryService extends CrudService<ProductGallery, Long> {

    List<ProductGallery> uploadPictures(MultipartFile[] files, Long productId);

}
