package com.example.srpingdemo.command;

import com.example.srpingdemo.controller.HelloController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class InitializePreStart implements CommandLineRunner {

    private static final Logger LOG = LogManager.getLogger(InitializePreStart.class);

    @Override
    public void run(String... strings) throws Exception {
        LOG.info("delete jarDir begins...");
        Path path = Paths.get("jarDir");
        //会递归删除这个目录下的所有内容，最后把当前目录也删除掉
        FileSystemUtils.deleteRecursively(path.toFile());
    }
}
