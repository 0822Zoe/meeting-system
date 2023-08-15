package com.icss.pojo;

/**
 * @author: Porter
 * @create: 2022/2/9 14:01
 * @Description: 对表dept进行封装
 * @FileName: Dept
 * @History:
 */
public class Dept {
    private Integer did;    //部门编号
    private String dname;   //部门名称

    //字段写完之后  生成有参和无参构造   toString方法  和getter、setter方法
    //快捷键  alt+insert


    public Dept() {
    }

    public Dept(Integer did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
