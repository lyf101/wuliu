package cn.lfy.lw.mapper;

import cn.lfy.lw.domain.Staff;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface LoginRegisterMapper {

    //根据用户名查找用户
    @Select("select * from staff where staff_username = #{username}")
    public List<Staff> findStaffByUsername(String username);


    //根据用户名和密码查找用户
    @Select("select * from staff where staff_username = #{username} and staff_password = #{password}")
    public List<Staff> findStaffByUsernamePassword(@Param("username") String username, @Param("password") String password);

    //添加用户
    @Insert("insert into staff values(#{staffId},#{staffUsername},#{staffPassword},#{staffRealName},#{staffIdCard}," +
            "#{staffRegisterTime},#{staffLastTime},#{staffClassify},#{staffWorkingYears},#{staffFree})")
    public int addStaff(Staff staff);

    //修改密码
    @Update("update staff set staff_password = #{password} where staff_username = #{username}")
    public int changeStaffPassword(@Param("username")String username,@Param("password")String password);

}
