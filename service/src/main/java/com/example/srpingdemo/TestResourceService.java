package com.example.srpingdemo;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class TestResourceService {
    public void uploadTestResources(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getInputStream();
        Path jarDir = Paths.get("jarDir");
        Files.createDirectories(jarDir);
        Path path = jarDir.resolve(Paths.get(originalFilename));
        Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
    }
}
