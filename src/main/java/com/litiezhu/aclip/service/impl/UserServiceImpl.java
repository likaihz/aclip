package com.litiezhu.aclip.service.impl;

import com.litiezhu.aclip.dataobject.UserDO;
import com.litiezhu.aclip.dto.UserInfoDTO;
import com.litiezhu.aclip.mapper.UserMapper;
import com.litiezhu.aclip.service.UserService;
import com.litiezhu.aclip.util.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Li Kai
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfoDTO login(String userName, String password) {
        String passwordEncrypted = MD5Util.MD5EncodeUtf8(password);
        UserDO userDO = userMapper.selectLogin(userName, passwordEncrypted);
        if(userDO == null) {
            return null;
        }
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userDO, userInfoDTO);
        userInfoDTO.setQuestion(null);

        return userInfoDTO;
    }

    @Override
    public int register(UserInfoDTO userInfoDTO, String password) {
        Assert.hasText(userInfoDTO.getUserName(), "用户名不能为空");
        Assert.hasText(password, "密码不能为空");
        Assert.hasText(userInfoDTO.getEmail(), "邮箱地址不能为空");
        Assert.hasText(userInfoDTO.getPhone(), "手机号码不能为空");
        Assert.hasText(userInfoDTO.getAnswer(), "验证答案不能为空");
        Assert.hasText(userInfoDTO.getQuestion(), "验证问题不能为空");

        Assert.isTrue(userMapper.countUserName(userInfoDTO.getUserName()) <= 0, "用户名已经存在");
        Assert.isTrue(userMapper.countEmail(userInfoDTO.getEmail()) <= 0, "email已经存在");
        Assert.isTrue(userMapper.countPhone(userInfoDTO.getPhone()) <= 0, "手机号已经存在");

        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userInfoDTO, userDO);
        userDO.setPasswordEncrypted(MD5Util.MD5EncodeUtf8(password));
        return userMapper.insert(userDO);
    }
}
