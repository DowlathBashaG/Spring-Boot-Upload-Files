package io.dowlath.springbootuploadfiles.service;

import io.dowlath.springbootuploadfiles.constants.MessageConstants;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author Dowlath
 * @create 7/14/2020 10:57 AM
 */
@Service
public class FileServiceImpl implements FileService{
    private final Path root = Paths.get("uploads");

    @Override
    public void init() {
        try{
            Files.createDirectory(root);
        }catch(Exception e){
             throw new RuntimeException(MessageConstants.FILE_PATH_NOT_CREATED);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());

    }

    @Override
    public void save(MultipartFile file) {
        try{
            Files.copy(file.getInputStream(),this.root.resolve(file.getOriginalFilename()));
        }catch(Exception e){
         throw new RuntimeException(MessageConstants.FILE_NOT_CREATED);
        }
    }
}
