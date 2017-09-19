package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Product;
import br.com.slotshop.server.model.ProductGallery;
import br.com.slotshop.server.repository.data.ProductGalleryData;
import br.com.slotshop.server.service.FileNotFoundCallback;
import br.com.slotshop.server.service.ProductGalleryService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
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

    private static final Logger logger = LoggerFactory.getLogger(ProductGalleryServiceImpl.class);

    @Autowired private ProductGalleryData productGalleryData;

    @Override
    protected JpaRepository<ProductGallery, Long> getRepository() {
        return productGalleryData;
    }

    @Value("${diretorio.imagens}")
    private String diretorioImagens;

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

    @Override
    public byte[] get(String file, FileNotFoundCallback fileNotFoundCallback) {
        try {
            String fileName = diretorioImagens + file;
            File arquivo = new File(fileName);
            if (!arquivo.exists()) {
                logger.info("Imagem não existe, obtendo imagem do callback");
                return fileNotFoundCallback.get();
            }
            InputStream in = new FileInputStream(arquivo);
            return IOUtils.toByteArray(in);
        } catch (Exception e) {
            logger.error("Erro ao obter imagem");
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity deleteImageAndFile(Long id) {
        if (deleteFile(id)){
            try {
                productGalleryData.delete(id);
                return ResponseEntity.ok().body(true);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }else{
            return ResponseEntity.badRequest().body("Erro ao remover imagem do servidor!");
        }
    }

    private boolean deleteFile(Long id) {
        /*try {
            FileUtils.touch(new File(diretorioImagens + productGalleryData.findOne(id).getPicture()));
            File fileToDelete = FileUtils.getFile(diretorioImagens + productGalleryData.findOne(id).getPicture());
            if(FileUtils.deleteQuietly(fileToDelete)) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;*/


        File file = new File(diretorioImagens + productGalleryData.findOne(id).getPicture());
        // Deleting the directory recursively with SpringUtil.
        if (FileUtils.deleteQuietly(file)) {
            return  true;
        }
        return false;
    }
}
