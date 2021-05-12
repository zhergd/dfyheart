package com.dfy.heart.domain.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @description:
 * @date: 2021/4/16 9:34
 */
public class BmpLoaderResponse implements Serializable {

    @ApiModelProperty("相似度")
    private String similarity;

    private static final long serialVersionUID = 1L;

    public BmpLoaderResponse() {

    }

    public BmpLoaderResponse(String similarity) {
        this.similarity = similarity;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}
