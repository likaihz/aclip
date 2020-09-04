package com.litiezhu.aclip.controller;

import com.litiezhu.aclip.common.AClipException;
import com.litiezhu.aclip.common.CommonConst;
import com.litiezhu.aclip.common.ResponseCode;
import com.litiezhu.aclip.dto.UserInfoDTO;
import com.litiezhu.aclip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Li Kai
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public void login(String username, String password, HttpSession session) {
        boolean loginSuccess = userService.login(username, password);

        if(!loginSuccess) {
            throw new AClipException(ResponseCode.ERROR.getCode(), "用户名或密码错误");
        }
        session.setAttribute(CommonConst.SESSION_KEY_USERNAME, username);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public int register(UserInfoDTO userInfoDTO, String password) {
        return userService.register(userInfoDTO, password);
    }

}
