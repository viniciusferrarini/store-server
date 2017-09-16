package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Product;
import br.com.slotshop.server.model.ProductGallery;
import br.com.slotshop.server.repository.data.ProductGalleryData;
import br.com.slotshop.server.service.ProductGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductGalleryServiceImpl extends CrudServiceImpl<ProductGallery, Long> implements ProductGalleryService {

    @Autowired private ProductGalleryData productGalleryData;

    @Override
    protected JpaRepository<ProductGallery, Long> getRepository() {
        return productGalleryData;
    }

    @Override
    public List<ProductGallery> uploadPictures(MultipartFile[] files, Long productId) {

        List<ProductGallery> productGalleryList = new ArrayList<>();

        try {
            for (MultipartFile file : files) {
                String pictureName = new SimpleDateFormat("ddMMyyhhmmssSSS").format(new Date()) + ".jpg";
                Path path = Paths.get("G:/Workspace/images/" + pictureName);
                Files.deleteIfExists(path);
                InputStream in = file.getInputStream();
                Files.copy(in, path);
                productGalleryList.add(productGalleryData.save(ProductGallery.builder()
                        .product(Product.builder()
                                .id(productId)
                                .build())
                        .picture(pictureName)
                        .build()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productGalleryList;
    }
}
