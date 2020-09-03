package com.litiezhu.aclip.service.impl;

import com.litiezhu.aclip.mapper.UserMapper;
import com.litiezhu.aclip.service.UserService;
import com.litiezhu.aclip.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Li Kai
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String userName, String password) {
        String passwordEncrypted = MD5Util.MD5EncodeUtf8(password);
        // todo MD5加密
        int cnt = userMapper.selectLogin(userName, password);
        return cnt > 0;
    }
}
