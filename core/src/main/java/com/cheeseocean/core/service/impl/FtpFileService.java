package com.cheeseocean.core.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cheeseocean.core.service.FileService;

@Service("ftpFileService")
//@PropertySource("classpath:ftp.properties")
public class FtpFileService implements FileService {
//    private final Log logger = LogFactory.getLog(getClass());
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    private FtpUtils ftpUtils;
//
//    @Override
//    public boolean uploadFile(String path, String fileName, MultipartFile file) {
//        Assert.notNull(path, "path cannot be null");
//        Assert.notNull(file, "file cannot be null");
//
//        boolean result = false;
//        InputStream in = null;
//        FTPClient ftpClient = ftpUtils.getFTPClient();
//        if (ftpClient == null) {
//            throw new ExpectedException("can not get FTP client");
//        }
//        logger.info("start upload avatar");
//
//        //start upload avatar.........
//        try {
//
//            if (!ftpClient.changeWorkingDirectory(path)) {
//                if (path.contains("/")) {
//                    logger.info("no such dir, and you can't create a nested path");
//                    return false;
//                }
//                ftpClient.makeDirectory(path);
//                ftpClient.changeWorkingDirectory(path);
//            }
//            logger.info("current ftp server working dir: " + ftpClient.printWorkingDirectory());
//
//            in = file.getInputStream();
//
//            boolean done = ftpClient.storeUniqueFile(fileName, in);
//
//            if (done) {
//                logger.info("upload avatar: " + fileName + " successful");
//                result = true;
//            }
//            else{
//                logger.info(ftpClient.getStatus());
//                logger.info("upload file: " + fileName + " fail");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new ExpectedException("upload error");
//        } finally {
//            ftpUtils.close(in, null, ftpClient);
//        }
//
//        return result;
//    }
//
//


    @Override
    public boolean uploadFile(String path, String fileName, MultipartFile file) {
        return false;
    }

    @Override
    public void uploadFiles(String path, Map<String, MultipartFile> imageMap) {
        FileService.super.uploadFiles(path, imageMap);
    }
}
