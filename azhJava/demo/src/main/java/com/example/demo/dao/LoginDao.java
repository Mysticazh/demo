package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoginDao {
    @Select("select * from user where username=#{username} and password=#{password}")
    User getUserbypwd(String username,String password);
    @Insert("insert into user values (#{username},#{password},#{name})")
    boolean insert(String username,String password,String name);
    @Select("select * from user where username = #{username} ")
    User selectbyid(String username);
    @Select("select * from user where username = #{username} and name = #{name}")
    User selectbyidandname(String username,String name);
    @Update("update user set password= #{password} where username=#{username} ")
    int updatepwdbyid(String password,String username);
}
