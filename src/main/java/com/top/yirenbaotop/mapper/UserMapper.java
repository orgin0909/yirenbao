package com.top.yirenbaotop.mapper;

import com.top.yirenbaotop.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("insert into u_user (uid,account,pwd,phone,status) values(null,#{account},#{pwd},#{phone},1)")
    public int register (User user);

    @Select("select * from u_user where account=#{account}")
    public User loadByAccount(String account);

    @Select("select * from u_user where account=#{account} and pwd=#{pwd} and status=1")
    public User login(User user);
}
