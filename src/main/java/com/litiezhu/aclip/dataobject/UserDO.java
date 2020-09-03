package com.litiezhu.aclip.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Li Kai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDO extends BaseModelDO {
    private String userName;
    private String passwordEncrypted;
    private String email;
    private String phone;
    private String question;
    private String answer;
    private Integer role;
}
