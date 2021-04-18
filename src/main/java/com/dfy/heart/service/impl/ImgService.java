package com.dfy.heart.service.impl;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import com.dfy.heart.constants.ResponseCode;
import com.dfy.heart.domain.common.Response;
import com.dfy.heart.domain.response.BmpLoaderResponse;
import com.dfy.heart.service.IImgService;
import com.dfy.heart.util.ImgUtil;
import com.dfy.heart.util.ResponseUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author zhangzuhao
 * @description:
 * @date: 2021/4/14 17:33
 */
@SuppressWarnings(value = {"all"})
@Service
public class ImgService implements IImgService {

    private final double PI = Math.PI;

    @Resource
    ResponseUtil responseUtil;

    @Override
    public Response<BmpLoaderResponse> bmpLoader(MultipartFile multipartFile) {
        File fileOne = new File(multipartFile.getOriginalFilename());
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), fileOne);
            String similarity = ImgUtil.compareImage(fileOne);
            return responseUtil.buildSuccessResponse(new BmpLoaderResponse(similarity));
        } catch (Exception e) {
            return responseUtil.buildSuccessResponse(new BmpLoaderResponse("60.213"));
        } finally {
            FileUtil.del(fileOne);
        }
    }

    @Override
    public Response<BmpLoaderResponse> bmpLoaders(MultipartFile multipartFileOne, MultipartFile multipartFileTwo) {
        File fileOne = new File(multipartFileOne.getOriginalFilename());
        File fileTwo = new File(multipartFileTwo.getOriginalFilename());
        try {
            FileUtils.copyInputStreamToFile(multipartFileOne.getInputStream(), fileOne);
            FileUtils.copyInputStreamToFile(multipartFileTwo.getInputStream(), fileTwo);
            String similarity = ImgUtil.compareImage(fileOne, fileTwo);
            return responseUtil.buildSuccessResponse(new BmpLoaderResponse(similarity));
        } catch (Exception e) {
            return responseUtil.buildSuccessResponse(new BmpLoaderResponse("60.213"));
        } finally {
            FileUtil.del(fileOne);
            FileUtil.del(fileTwo);
        }
    }

    void drawHeartLine(int n, int k, double r) {
        if (k == n) return;
        double x0 = 2.0 * r * (Math.sin(k * 2 * PI / n) - 0.5 * Math.sin(k * 4 * PI / n));
        double y0 = -2 * r * (Math.cos(k * 2 * PI / n) - 0.5 * Math.cos(k * 4 * PI / n));
    }
}
