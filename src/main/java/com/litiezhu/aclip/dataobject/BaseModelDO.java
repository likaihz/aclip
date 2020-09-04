package com.litiezhu.aclip.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author Li Kai
 */
@Data
public class BaseModelDO {
    private Integer id;
    private Date createTime;
    private Date updateTime;
    private String isDeleted;
}
