package com.cheeseocean.core.service.impl;

import com.cheeseocean.common.constant.AppConstants;
import com.cheeseocean.common.exception.ExpectedException;
import com.cheeseocean.core.service.FileService;
import com.cheeseocean.common.util.StreamUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Map;

@Service("jdkFileService")
public class JdkFileService implements FileService {
//    private final Log logger = LogFactory.getLog(getClass());
//
//    private static volatile boolean initialized = false;
//
//    @PostConstruct
//    protected void init(){
//        String basePath = AppConstants.LOCAL_PATH;
//        String mkdirPermissions = AppConstants.MKDIR_PERMISSIONS;
//        boolean basePathExist = Files.exists(Paths.get(basePath));
//        if(!basePathExist){
//            logger.error("Your system doesn't exist the dir : " + basePath + ", please run install.sh first to ensure this app run correctly");
//        }
//        initialized = true;
//    }
//
//    @Override
//    public boolean uploadFile(String path, String fileName, MultipartFile file) {
//
//        logger.info("path: " + path + ", filename: " + fileName);
//        Path imagePath = Paths.get(AppConstants.LOCAL_PATH + path + fileName);
//        try (BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(imagePath, StandardOpenOption.CREATE_NEW))){
//            StreamUtils.copyStream(file.getInputStream(), out, 1024);
//        }catch (IOException e){
//            logger.info("upload failed");
//            if(e instanceof AccessDeniedException){
//                throw new ExpectedException("access denied, may be you run program in a incorrect environment");
//            }
//            return false;
//        }
////        logger.info("upload successfully");
//        return true;
//    }


    @Override
    public boolean uploadFile(String path, String fileName, MultipartFile file) {
        return false;
    }

    @Override
    public void uploadFiles(String path, Map<String, MultipartFile> imageMap) {
        FileService.super.uploadFiles(path, imageMap);
    }
}

