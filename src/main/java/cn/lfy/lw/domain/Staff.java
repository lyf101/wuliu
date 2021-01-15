package cn.lfy.lw.domain;


import lombok.Data;

import java.util.Date;

@Data
public class Staff {

    private String staffId;
    private String staffUsername;
    private String staffPassword;
    private String staffRealName;
    private String staffIdCard;
    private String staffRegisterTime;
    private String staffLastTime;
    private int staffClassify;
    private int staffWorkingYears;
    private int staffFree;

}
