package com.icss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static String url="jdbc:mysql://localhost:3306/meeting?useUnicode=true&characterEncoding=utf8";
    private static String username="root";
    private static String password="123456";

    //加载驱动
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //创建连接
    public static Connection getCon(){
        Connection con=null;
        try {
            con= DriverManager.getConnection(url,username,password);
            System.out.println("数据库连接成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
