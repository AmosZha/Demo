package com.zhao.springboot.mapper;

import com.zhao.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {

	@Select("select id, name, phone, sex from User where id = #{id}")
	public User getUserById(@Param("id")String id);

	public User getUserByName(@Param("name")String name);

	User getUserByConditions(Map<String, Object> condition);
}