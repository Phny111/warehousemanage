package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private String Driver_name="jdbc:mysql://localhost:3306/db_warehouse_manager?useUnicode=true&characterEncoding=utf8";
	private String USER="root"; // 用户名
	private String PASS="123456"; // 密码

	// 驱动名称
	private String jdbcName="com.mysql.jdbc.Driver";


	//数据库连接
	public static Connection con;
	//构造方法
	public DB(){
		try {
			//加载驱动
			Class.forName(jdbcName);
			//获取连接
			con =
					DriverManager.getConnection(
							Driver_name, USER, PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConnection(){
		if(con == null){
			new DB();
		}
		return con;
	}

	public static void main(String[] args) throws Exception {
		//运行后直接结束则代表连接成功
		DB dbUtil=new DB();
		dbUtil.getConnection();
	}
}
