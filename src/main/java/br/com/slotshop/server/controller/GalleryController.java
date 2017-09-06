package br.com.slotshop.server.controller;

import br.com.slotshop.server.model.Gallery;
import br.com.slotshop.server.service.CrudService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@RestController
@RequestMapping("gallery")
public class GalleryController extends RestCrudController<Gallery, Long> {

    @Override
    protected CrudService<Gallery, Long> getService() {
        return null;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String uploadMultipleFileHandler(@RequestParam("files") MultipartFile[] files) {

        try {
            for (MultipartFile file : files) {
                Path path = Paths.get("G:/Workspace/images/" + new SimpleDateFormat("ddMMyyhhmmssSSS").format(new Date()) + ".jpg");
                Files.deleteIfExists(path);
                InputStream in = file.getInputStream();
                Files.copy(in, path);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
