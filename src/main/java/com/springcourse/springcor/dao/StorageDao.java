package com.springcourse.springcor.dao;


import com.springcourse.springcor.entity.ProductEntity;
import com.springcourse.springcor.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class StorageDao {

    @Autowired
    private ProductRepo productRepo;
    private final String FOLDER_PATH="C:/Users/DELL/Desktop/Youness_walid/app-server/ProductImage/";

    public void uploadProductImage(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();
       file.transferTo(new File(filePath));
    }
    public byte[] getPhoto(Integer id) throws Exception{
        ProductEntity p= productRepo.findById(id).get();
        String filePath=FOLDER_PATH+p.getProductPhoto();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

//    public byte[] downloadDocumentFromFileSystem(String fileName) throws IOException {
//        Optional<FileData> fileData = fileDataRepo.findByName(fileName);
//        String filePath=fileData.get().getFilePath();
//        byte[] images = Files.readAllBytes(new File(filePath).toPath());
//        return images;
//    }

}
