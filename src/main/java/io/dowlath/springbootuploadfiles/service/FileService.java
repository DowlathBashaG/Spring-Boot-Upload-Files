package io.dowlath.springbootuploadfiles.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Dowlath
 * @create 7/14/2020 10:56 AM
 */
public interface FileService {
    void init();
    void deleteAll();
    void save(MultipartFile file);
}
