package com.dfy.heart.controller;

import com.dfy.heart.domain.common.Response;
import com.dfy.heart.domain.request.AddAccessRequest;
import com.dfy.heart.domain.request.GetMottoRequest;
import com.dfy.heart.domain.response.BmpLoaderResponse;
import com.dfy.heart.service.ICommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author zhangzuhao
 * @description:
 * @date: 2021/4/17 11:29
 */
@Api(description = "通用Controller")
@RestController
@RequestMapping("/common")
public class CommonController {

    @Resource
    ICommonService commonService;

    @ApiOperation("添加埋点数据")
    @PostMapping("/addAccess")
    public Response<Boolean> addAccess(@RequestBody AddAccessRequest request) {
        return commonService.addAccess(request);
    }

    @ApiOperation("获取格言")
    @PostMapping("/bmpLoader")
    public Response<String> bmpLoader(@RequestBody GetMottoRequest request) {
        return commonService.getMotto(request);
    }
}
