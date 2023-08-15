package com.icss.pojo;

/**
 * @author: Porter
 * @create: 2022/2/9 13:57
 * @Description: 这个类是对emp表进行封装
 * @FileName: Emp
 * @History:
 */
public class Emp {
    private Integer eid;        //员工编号
    private String username;    //员工帐号
    private String ename;       //员工姓名
    private String password;    //员工密码
    private String phone;       //联系电话
    private String email;       //邮箱
    //采用组件bean的形式进行存储
    private Dept dept;          //部门信息
    private String status;      //员工的状态   0表示员工正在审核  1表示审核成功  2表示审核失败

    //字段写完之后  生成有参和无参构造   toString方法  和getter、setter方法
    //快捷键  alt+insert

    public Emp() {
    }

    public Emp(Integer eid, String username, String ename, String password, String phone, String email, Dept dept, String status) {
        this.eid = eid;
        this.username = username;
        this.ename = ename;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.dept = dept;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", username='" + username + '\'' +
                ", ename='" + ename + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
