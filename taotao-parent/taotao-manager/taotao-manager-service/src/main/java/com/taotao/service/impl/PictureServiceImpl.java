package com.taotao.service.impl;

import com.taotao.service.PictureService;
import com.taotao.utils.FtpUtil;
import com.taotao.utils.IDUtils;
import com.taotao.utils.PictureResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:binblink
 * @Description
 * @Date: Create on  2018/4/20 10:45
 * @Modified By:binblink
 * @Version:1.0.0
 **/
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FILE_UPLOAD_PATH}")
    private String FILE_UPLOAD_PATH;

    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Value("${FTP_SERVER_IP}")
    private String FTP_SERVER_IP;

    @Value("${FTP_SERVER_PORT}")
    private Integer FTP_SERVER_PORT;

    @Value("${FTP_SERVER_USERNAME}")
    private String FTP_SERVER_USERNAME;

    @Value("${FTP_SERVER_PASSWORD}")
    private String FTP_SERVER_PASSWORD;


    @Override
    public PictureResult pictureUpload(MultipartFile multipartFile) throws Exception {

        String path = savePicture(multipartFile);

        System.out.println("path----"+path);
        PictureResult pr = new PictureResult(0,IMAGE_BASE_URL+path);

        if(path == null){
            PictureResult prError = new PictureResult(1,"","上传图片失败！");
            return prError;
        }

        return pr;
    }


    private String savePicture(MultipartFile multipartFile) {

        String result = null;

        try {

            if (multipartFile.isEmpty()) {
                return result;
            }
            String fileName = "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
                    + new SimpleDateFormat("MM").format(new Date()) + "/"
                    + new SimpleDateFormat("dd").format(new Date());

            String originalName = multipartFile.getOriginalFilename();

            String newfileName = IDUtils.genImageName() + originalName.substring(originalName.lastIndexOf("."));

            Boolean uploadresult  = FtpUtil.uploadFile(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_SERVER_USERNAME, FTP_SERVER_PASSWORD, FILE_UPLOAD_PATH, fileName,
                    newfileName, multipartFile.getInputStream());

            if(uploadresult){
                result = fileName + "/" + newfileName;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return result;
    }

}
