package cn.lfy.lw.mapper;

import cn.lfy.lw.domain.Staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface LoginRegisterMapper {

    //根据用户名查找用户是否存在
    @Select("select * from staff where staff_username = #{username}")
    public Staff findStaffByUsername(String username);

    //根据用户名和密码验证用户密码正确
    @Select("select * from staff where staff_username = #{username},staff_password = #{password}")
    public Staff findStaffByUsernamePassword(@Param("username") String username, @Param("password") String password);

    //添加用户
    @Insert("insert into staff values(#{staffId},#{staffUsername},#{staffPassword},#{staffRealName},#{staffIdCard}," +
            "#{staffRegisterTime},#{staffLastTime},#{staffClassify},#{staffWorkingYears},#{staffFree})")
    public int addStaff(Staff staff);

}
