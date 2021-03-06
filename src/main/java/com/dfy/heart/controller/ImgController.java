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
 * @description:
 * @date: 2021/4/14 17:22
 */
@Api(description = "心形controller")
@RestController
@RequestMapping("/dfy")
public class ImgController {

    @Resource
    IImgService imgService;

    @ApiOperation("1")
    @PostMapping("/getImgBmp")
    public Response<BmpLoaderResponse> bmpLoader(@RequestParam("file") MultipartFile file
            , @RequestParam("sign") String sign, @RequestParam("time") Long time) {
        return imgService.bmpLoader(file, sign, time);
    }
    @ApiOperation("2")
    @PostMapping("/bmpLoader")
    public Response<BmpLoaderResponse> bmpLoader(@RequestParam("file") MultipartFile file
            , @RequestParam("file2") MultipartFile file2
            , @RequestParam("sign") String sign, @RequestParam("time") Long time) {
        return imgService.bmpLoaders(file, file2, sign, time);
    }

}
