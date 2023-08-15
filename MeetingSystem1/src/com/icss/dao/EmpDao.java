package com.icss.dao;

import com.icss.pojo.Emp;
import com.icss.util.BaseDao;

import java.util.List;


public class EmpDao {
    /**
     * 通过账户检测表中的数据信息
     *
     * @param username
     * @return
     */
    public Emp checkEmpLoginDao(String username) {
        //1、编写sql语句   ?表示占位符  为了让sql语句能够正常编译
        String sql = "select password,status from emp where username = ?";
        //2、执行sql语句，并获取查询出的数据   调用BaseDao中的静态方法exeDQL来执行查询
        List<List> ll = BaseDao.exeDQL(sql, username);
        //实例化一个emp对象用来存储数据
        Emp emp = new Emp();
        //验证ll是否为空
        if (ll.size() != 0) {
            //通过坐标获取二维集合中的所有数据
            emp.setPassword(ll.get(0).get(0).toString());
            emp.setStatus(ll.get(0).get(0).toString());
        }
        return emp;
    }
}