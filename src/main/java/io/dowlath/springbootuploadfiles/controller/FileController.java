package io.dowlath.springbootuploadfiles.controller;

import io.dowlath.springbootuploadfiles.constants.MessageConstants;
import io.dowlath.springbootuploadfiles.messages.ResponseMessage;
import io.dowlath.springbootuploadfiles.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Dowlath
 * @create 7/14/2020 11:07 AM
 */
@RestController
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("files") MultipartFile[] files){
        String message;
        try{
                List<String> fileDetails = new ArrayList<>();
                Arrays.asList(files).stream().forEach(file -> {
                fileService.save(file);
                fileDetails.add(file.getOriginalFilename());
            });
            message = MessageConstants.FILE_UPLOADED + fileDetails;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }catch(Exception e){
            message = MessageConstants.FILE_FAIL_UPLOAD;
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }

}
