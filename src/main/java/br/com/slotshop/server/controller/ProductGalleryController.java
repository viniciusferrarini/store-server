package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.ProductGallery;
import br.com.slotshop.server.service.CrudService;
import br.com.slotshop.server.service.ProductGalleryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("gallery")
public class ProductGalleryController extends RestCrudController<ProductGallery, Long> {

    private static final Logger logger = LoggerFactory.getLogger(ProductGalleryController.class);

    @Autowired private ProductGalleryService productGalleryService;

    @Autowired private ApplicationContext applicationContext;

    @Override
    protected CrudService<ProductGallery, Long> getService() {
        return productGalleryService;
    }

    @PostMapping(value = "/upload")
    public @ResponseBody List<ProductGallery> uploadMultipleFileHandler(@RequestParam("files") MultipartFile[] files, @RequestParam("productId") Long productId) {
        return productGalleryService.uploadPictures(files, productId);
    }

    @GetMapping(value = "/picture/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    private byte[] getFoto(@PathVariable("name") String name) {
        return productGalleryService.get(name + ".jpg", () -> {
            try {
                Resource resource = applicationContext.getResource("classpath:/static/images/avatar.png");
                InputStream in = resource.getInputStream();
                return IOUtils.toByteArray(in);
            } catch (Exception e) {
                logger.error("Erro ao obter imagem");
                return null;
            }
        });
    }

    @PostMapping(value = "/delete")
    public @ResponseBody ResponseEntity delete(@RequestBody ProductGallery productGallery) {
        return productGalleryService.deleteImageAndFile(productGallery);
    }
}
