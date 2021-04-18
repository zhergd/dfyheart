package com.dfy.heart.service;

import com.dfy.heart.domain.common.Response;
import com.dfy.heart.domain.request.AddAccessRequest;
import com.dfy.heart.domain.request.GetMottoRequest;

/**
 * @author zhangzuhao
 * @description:
 * @date: 2021/4/17 15:04
 */
public interface ICommonService {

    Response<Boolean> addAccess(AddAccessRequest addAccessRequest);

    Response<String> getMotto(GetMottoRequest getMottoRequest);
}
