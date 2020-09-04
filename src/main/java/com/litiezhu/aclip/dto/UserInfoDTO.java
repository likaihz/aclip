package com.litiezhu.aclip.dto;

import lombok.Data;

/**
 * @author Li Kai
 */
@Data
public class UserInfoDTO {
    private Integer id;

    private String userName;

    private String phone;

    private String email;

    private String question;

    private String answer;

    private Integer role;
}
