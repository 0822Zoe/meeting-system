package com.icss.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    //增删改DML方法
    //当形参为Object[]数组时，调用该方法必须传入一个数组
    public static int exeDML(String sql,Object ... params){
        //获取数据库连接对象
        Connection con=DBConn.getCon();
        PreparedStatement ps=null;
        //定义多少数据被修改
        int res=0;
        //获取PreparedStatement对象
        try {
            ps=con.prepareStatement(sql);
            //获取参数的元数据对象
            ParameterMetaData pmd=ps.getParameterMetaData();
            //获取占位符？个数
            int count=pmd.getParameterCount();
            if (count>0){
                if (params.length!=count){
                    throw new RuntimeException("传递的参数个数和占位符中参数个数不一致！！！");
                }
                //将参数遍历到SQL的占位符中
                for (int i=0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            //执行SQL语句
            res=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //设置不自动提交
            try {
                con.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //关闭资源  关闭时会将所有操作保存到数据库
            try {
                ps.close();
                con.close();
                System.out.println("数据库连接关闭成功！");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
    //查询
    public static List<List> exeDQL(String sql,Object ... params){
        Connection con=DBConn.getCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<List> al=new ArrayList<>();
        try {
            ps=con.prepareStatement(sql);
            //获取参数的元数据对象
            ParameterMetaData pmd=ps.getParameterMetaData();
            //获取占位符？个数
            int count=pmd.getParameterCount();
            if (count>0){
                if (params.length!=count){
                    throw new RuntimeException("传递的参数个数和占位符中参数个数不一致！！！");
                }
                //将参数遍历到SQL的占位符中
                for (int i=0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            //执行SQL语句
            rs=ps.executeQuery();
            //获取每条数据有多少字段
            int num=rs.getMetaData().getColumnCount();
            while(rs.next()){
                ArrayList a=new ArrayList();
                for (int i=1;i<=num;i++){
                    a.add(rs.getObject(i));
                }
                al.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
}
