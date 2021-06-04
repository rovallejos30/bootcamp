package com.globant.bootcamp.EggCartonShopApi.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	String upload(MultipartFile file);

}
