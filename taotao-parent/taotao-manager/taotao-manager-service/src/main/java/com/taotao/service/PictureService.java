package com.taotao.service;

import com.taotao.utils.PictureResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author:binblink
 * @Description
 * @Date: Create on  2018/4/20 10:30
 * @Modified By:binblink
 * @Version:1.0.0
 **/
public interface PictureService {

     PictureResult pictureUpload(MultipartFile multipartFile) throws Exception;
}
