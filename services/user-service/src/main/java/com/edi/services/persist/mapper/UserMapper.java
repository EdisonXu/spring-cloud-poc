package com.edi.services.persist.mapper;

import com.edi.common.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Edison Xu on 2016/12/27.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User findUserById(@Param("id") long id);

    /*
    This is not working?! Editing xml in java class is insane!!
     */
    @Insert({"<script>" ,
            "insert into user (" ,
            "<trim prefixOverride=','>" ,
            "<if test='id!=null'>id</if>" ,
            "<if test='name!=null'>name</if>" ,
            "<if test='password!=null'>password</if>" ,
            "</trim>)values(" ,
            "<trim prefixOverrides=','>" ,
            "<if test='id!=null'>#{id}</if>" ,
            "<if test='name!=null'>#{name}</if>" ,
            "<if test='password!=null'>#{password}</if>" ,
            "</trim>)</script>"})
    void insertUser(@Param("user") User user);
}
