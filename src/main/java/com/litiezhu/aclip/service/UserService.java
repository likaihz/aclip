package com.litiezhu.aclip.service;

import com.litiezhu.aclip.dto.UserInfoDTO;

/**
 * @author Li Kai
 */
public interface UserService {
    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    UserInfoDTO login(String userName, String password);

    /**
     * 注册新用户。
     *
     * @param userInfoDTO
     * @param password
     * @return 用户id
     */
    int register(UserInfoDTO userInfoDTO, String password);
}
