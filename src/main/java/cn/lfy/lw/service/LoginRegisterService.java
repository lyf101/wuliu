package cn.lfy.lw.service;

import cn.lfy.lw.domain.Staff;
import cn.lfy.lw.mapper.LoginRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LoginRegisterService {

    @Autowired
    private LoginRegisterMapper loginRegisterMapper;

    //根据用户名查询用户名是否存在
    public boolean isExistStaffByUsername(String username) {
        List<Staff> staff = loginRegisterMapper.findStaffByUsername(username);
        if (staff.size() == 0) {
            return false;
        } else return true;
    }


    //根据用户名和密码验证用户密码是否正确
    public boolean isExisStaffByUsernamePassword(String username, String password) {
        List<Staff> staffByUsernamePassword = loginRegisterMapper.findStaffByUsernamePassword(username, password);
        if (staffByUsernamePassword.size() == 0) {
            return false;
        } else return true;
    }

    //根据用户名查找用户
    public Staff findStaffByUsername(String username) {
        List<Staff> staffByUsername = loginRegisterMapper.findStaffByUsername(username);
        Staff staff = staffByUsername.get(0);
        return staff;
    }

    //修改用户
    public boolean changeStaff(String username,String password){
        int i = loginRegisterMapper.changeStaffPassword(username,password);
        if(i>0){
            return true;
        }else return false;
    }


    //注册用户
    public int addStaff(String username, String password, String realName, String idCard, int classify) {
        Staff staff = new Staff();
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = f.format(date);
        staff.setStaffId(UUID.randomUUID().toString());
        staff.setStaffUsername(username);
        staff.setStaffPassword(password);
        staff.setStaffRealName(realName);
        staff.setStaffIdCard(idCard);
        staff.setStaffRegisterTime(nowDate);
        staff.setStaffLastTime(nowDate);
        staff.setStaffClassify(classify);
        staff.setStaffWorkingYears(0);
        staff.setStaffFree(1);

        return loginRegisterMapper.addStaff(staff);
    }


}
