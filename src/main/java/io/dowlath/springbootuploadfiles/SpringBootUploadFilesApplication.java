package io.dowlath.springbootuploadfiles;

import io.dowlath.springbootuploadfiles.service.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringBootUploadFilesApplication implements CommandLineRunner {

	@Resource
	FileService fileService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootUploadFilesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	  fileService.deleteAll();
	  fileService.init();

	}
}
