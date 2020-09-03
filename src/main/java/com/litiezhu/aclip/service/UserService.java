package com.litiezhu.aclip.service;

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
    boolean login(String userName, String password);
}
