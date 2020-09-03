package com.litiezhu.aclip.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Li Kai
 */
@Mapper
public interface UserMapper {
    int selectLogin(@Param("username") String username, @Param("password") String password);
}
