package com.example.springboot.controller;


import com.example.springboot.resource_service.Upload_Download;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin()
@RestController
@RequestMapping("/resource")
public class ResourceController {


    @Autowired
    private Upload_Download upload_download;

    private static final Logger LOG = LogManager.getLogger(ResourceController.class);


    /**
     * 上传jar到工程根目录/jarDir
     * @param file  A representation of an uploaded file
     * @throws IOException
     */
    @PostMapping("uploadJar")//等价于 @RequestMapping(value = "uploadJar", method = RequestMethod.POST)
    public void uploadResource(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException{
        LOG.info("Start to load resources");
        upload_download.uploadTestResources(file);
    }


    @GetMapping("downloadJar")
    public ResponseEntity<InputStreamResource> downloadJar() throws IOException {
        LOG.info("Start to download resources");
        ResponseEntity<InputStreamResource> inputStreamResourceResponseEntity = upload_download.downloadFile();
        return inputStreamResourceResponseEntity;

    }
}
