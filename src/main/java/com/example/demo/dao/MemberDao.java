package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.demo.entity.Member;
import org.apache.ibatis.annotations.Select;
public interface MemberDao {
    @Select("select * from eryp_user where user_name = #{name}")
	Member selectMemberByName(@Param("name")String name)throws Exception;
}
