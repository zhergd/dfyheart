package com.dfy.heart.controller;

import com.dfy.heart.domain.common.Response;
import com.dfy.heart.domain.response.BmpLoaderResponse;
import com.dfy.heart.service.IImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author zhangzuhao
 * @description:
 * @date: 2021/4/14 17:22
 */
@Api(description = "图片相似度比较Controller")
@RestController
@RequestMapping("/dfy")
public class ImgController {

    @Resource
    IImgService imgService;


    @ApiOperation("获取心形匹配度")
    @PostMapping("/getImgBmp")
    public Response<BmpLoaderResponse> bmpLoader(@RequestParam("file") MultipartFile file) {
        return imgService.bmpLoader(file);
    }

    @ApiOperation("获取两张图片匹配度")
    @PostMapping("/bmpLoader")
    public Response<BmpLoaderResponse> bmpLoader(@RequestParam("file") MultipartFile file
            , @RequestParam("file2") MultipartFile file2) {
        return imgService.bmpLoaders(file, file2);
    }

}
