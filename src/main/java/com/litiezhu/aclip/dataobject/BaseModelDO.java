package com.litiezhu.aclip.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author Li Kai
 */
@Data
public class BaseModelDO {
    private int id;
    private Date createTime;
    private Date updateTime;
    private String isDeleted;
}
