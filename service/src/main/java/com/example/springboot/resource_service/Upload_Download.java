package com.example.springboot.resource_service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.testng.annotations.Test;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class Upload_Download {

    /**
     * @param multipartFile A representation of an uploaded file
     * @throws IOException
     */
    public void uploadTestResources(MultipartFile multipartFile) throws IOException {

        System.out.println("The size of the file in bytes is: "+multipartFile.getSize());

        // 判断文件手否有内容
        if (multipartFile.isEmpty()) {
            System.out.println("该文件无任何内容!!!");
        }

        //Return the original filename in the client's filesystem.
        // win os 有的浏览器如chrome获取到的是最基本的含 后缀的文件名,如myImage.png
        // win os 有的浏览器如ie获取到的是含整个路径的含后缀的文件名，如C:\\Users\\images\\myImage.png
        String originalFilename = multipartFile.getOriginalFilename();

        // 如果是获取的含有路径的文件名，那么截取掉多余的，只剩下文件名和后缀名
        int index = originalFilename.lastIndexOf("\\");
        if (index > 0) {
            originalFilename = originalFilename.substring(index + 1);
        }


        //当前工程根目录下面不存在jarDir就创建
        Path jarDir = Paths.get("jarDir");
        if(!jarDir.toFile().exists()){
            Files.createDirectories(jarDir);
        }

        //Path路径拼接
        Path target = jarDir.resolve(Paths.get(originalFilename));

        //Return an InputStream to read the contents of the file from.
        InputStream inputStream = multipartFile.getInputStream();

        //方式1：Copies all bytes from an input stream to a file
       //Files.copy(inputStream, target, StandardCopyOption.REPLACE_EXISTING);

        //方式2：transfer the received file to the given destination file.
        multipartFile.transferTo(target);
    }



    public ResponseEntity<InputStreamResource> downloadFile() throws IOException {
        String logReportDir = "C:\\Users\\epanhai\\git\\myproject\\spring-boot-demo\\jib";
        File zippedFile = packFile(logReportDir);
        FileSystemResource fsr = new FileSystemResource(zippedFile);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        InputStream in = fsr.getInputStream();
        return ResponseEntity.ok().headers(headers).contentLength(fsr.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream")).body(new InputStreamResource(in));
    }

    /**
     *
     * @param filePath 待压缩的目录
     * @return
     * @throws IOException
     */
    public  File packFile(String filePath) {
        File zippedFile = new File(filePath + ".zip");
        ZipUtil.pack(new File(filePath), zippedFile);//pack(File rootDir, File zip)
        return zippedFile;
    }




}
