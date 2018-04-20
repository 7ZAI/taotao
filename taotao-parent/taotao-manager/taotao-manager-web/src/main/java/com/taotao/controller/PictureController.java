package com.taotao.controller;

import com.taotao.service.PictureService;
import com.taotao.utils.PictureResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author:binblink
 * @Description 上传图片
 * @Date: Create on  2018/4/20 14:40
 * @Modified By:binblink
 * @Version:1.0.0
 **/
@Controller
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    private PictureService pictureService ;


    @RequestMapping("/upload")
    @ResponseBody
    public PictureResult upload(MultipartFile uploadFile) throws Exception{
        return pictureService.pictureUpload(uploadFile);
    }
}
