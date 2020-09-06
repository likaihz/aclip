package com.litiezhu.aclip.mapper;

import com.litiezhu.aclip.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Li Kai
 */
@Mapper
public interface UserMapper {
    UserDO selectLogin(@Param("username") String username, @Param("password") String password);

    int countUserName(String userName);

    int countEmail(String email);

    int countPhone(String phone);

    int insert(UserDO userDO);
}
