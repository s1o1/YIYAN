package com.gzj.dao.mapper;

import com.gzj.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    /**
     *               通过用户名查询用户
     * @param name   用户名
     * @return       用户
     */
    @Select("select username,pwd from users where username = #{name}")
    User queryUserByName(String name);
}
