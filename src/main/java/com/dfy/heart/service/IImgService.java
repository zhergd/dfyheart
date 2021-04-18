package com.dfy.heart.service;

import com.dfy.heart.domain.common.Response;
import com.dfy.heart.domain.response.BmpLoaderResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhangzuhao
 * @description:
 * @date: 2021/4/14 17:33
 */
public interface IImgService {

    Response<BmpLoaderResponse> bmpLoader(MultipartFile file);
    Response<BmpLoaderResponse> bmpLoaders(MultipartFile file, MultipartFile file2);
}
