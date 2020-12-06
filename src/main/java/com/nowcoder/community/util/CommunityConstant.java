package com.nowcoder.community.util;

public interface CommunityConstant {

    //激活成功
    int ACTIVATIB_SUCCESS = 0;

    int ACTIVATIB_REPEAT = 1;

    int ACTIVATIE_FAILURE = 2;

    //默认状态的登录超时时间
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;

    //记住状态下的登陆凭证超时时间
    int REMEMBER_EXPIRED_SECONDS = 3600 *24 * 100;
}
