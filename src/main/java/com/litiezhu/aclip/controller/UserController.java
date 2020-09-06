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
import java.util.UUID;

/**
 * @author Li Kai
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录接口
     *
     * @param username
     * @param password
     * @param session
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(String username, String password, HttpSession session) {
        UserInfoDTO userInfoDTO = userService.login(username, password);

        if(userInfoDTO != null) {
            session.setAttribute(CommonConst.SESSION_KEY_CURRENT_USER, userInfoDTO);
            return true;
        }
        return false;

    }

    /**
     * 登出接口
     *
     * @param session
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public void logout(HttpSession session) {
        session.removeAttribute(CommonConst.SESSION_KEY_CURRENT_USER);
    }

    /**
     * 注册接口
     *
     * @param userInfoDTO
     * @param password
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public int register(UserInfoDTO userInfoDTO, String password) {
        return userService.register(userInfoDTO, password);
    }

    /**
     * 检查用户名、邮箱地址、手机号等是否合法以及是否已经存在。
     * 如果是不合法的字符串则抛异常（应该在前端已经检查过），如果是已经存在的则返回false
     *
     * @param str
     * @param type "username"/"email"/"phone"
     */
    @RequestMapping(value = "/checkValid", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkValid(String str, String type) {
        // todo check valid：非法的字符串抛异常，已经存在则返回false
        return true;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public UserInfoDTO getUserInfo(HttpSession session) {
        UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute(CommonConst.SESSION_KEY_CURRENT_USER);
        if (userInfoDTO == null) {
            throw new AClipException(ResponseCode.NEED_LOGIN.getCode(), "用户未登录");
        }
        return userInfoDTO;
    }

    /**
     * 检查重置问题的答案。如果答案正确则返回token，否则抛出异常
     *
     * @param userName
     * @param answer
     * @return
     */
    @RequestMapping(value = "/checkAnswer", method = RequestMethod.GET)
    @ResponseBody
    public String checkAnswer(String userName, String answer) {
        // todo check answer

        return UUID.randomUUID().toString();
    }


}
