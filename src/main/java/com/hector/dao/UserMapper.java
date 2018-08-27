package com.hector.dao;

import com.hector.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
//   @Select("SELECT * FROM users where id=#{id}")
   User find(int id);

//   @Select("SELECT * FROM users")
   List<User> all();
}
