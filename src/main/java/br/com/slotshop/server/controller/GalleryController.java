package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.Gallery;
import br.com.slotshop.server.model.ProductGallery;
import br.com.slotshop.server.service.CrudService;
import br.com.slotshop.server.service.ProductGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("gallery")
public class GalleryController extends RestCrudController<Gallery, Long> {

    @Autowired
    private ProductGalleryService productGalleryService;

    @Override
    protected CrudService<Gallery, Long> getService() {
        return null;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody List<ProductGallery> uploadMultipleFileHandler(@RequestParam("files") MultipartFile[] files, @RequestParam("productId") Long productId) {
        return productGalleryService.uploadPictures(files, productId);
    }
}
