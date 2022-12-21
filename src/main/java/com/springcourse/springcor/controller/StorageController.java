package com.springcourse.springcor.controller;

import com.springcourse.springcor.dao.StorageDao;
import com.springcourse.springcor.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/ProductImage")

public class StorageController {

    @Autowired
    private StorageDao storageDao;


    @PostMapping
    public void uploadProductImage(@RequestParam("image") MultipartFile file) throws IOException {
        storageDao.uploadProductImage(file);
    }

    @GetMapping(path="/getImage/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<?> getPhoto(@PathVariable("id") Integer id) throws Exception{
        byte[] imageData= storageDao.getPhoto(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("Image/png"))
                .body(imageData);
    }

//    @GetMapping("/{fileName}")
//    public ResponseEntity<?> downloadDocumentFromFileSystem(@PathVariable String fileName) throws IOException {
//        byte[] imageData=storageService.downloadDocumentFromFileSystem(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("document/png"))
//                .body(imageData);
//
//    }


}
