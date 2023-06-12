package com.demo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.demo.entity.User;
import com.demo.dao.LoginUseImp;
/**
 * 		登陆界面
 *	1、创建登陆界面，初始化上面的对象
 *	2、美化登陆界面，设置各个对象的大小、位置、字体以
 *	3、给按钮设置监听事件
 *
 */

public class Login {
	//初始化字体
	Font d = new Font("楷体", Font.BOLD, 22);
	Font f = new Font("楷体", Font.BOLD, 15);
	// 初始化对象
	JFrame logingui = new JFrame("");
	JLabel username = new JLabel("用户名：");
	JLabel password = new JLabel("密 码：");
	JTextField name = new JTextField();
	JTextField pwd = new JPasswordField();
	JButton login = new JButton("登录");
	//给User类初始化对象user
	User user = new User();
	public void LoginGui() {
		// 设置对象
		logingui.setBounds(450, 200, 550, 350);
		//设置退出
		logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//取消框架格式
		logingui.setLayout(null);
		//设置位置、大小和字体
		username.setBounds(110, 80, 100, 30);
		username.setFont(f);
		password.setBounds(110, 120, 100, 30);
		password.setFont(f);
		name.setBounds(200, 80, 180, 30);
		name.setFont(f);
		pwd.setBounds(200, 120, 180, 30);
		login.setBounds(200, 200, 80, 30);
		login.setFont(f);
		// 添加对象
		logingui.add(username);
		logingui.add(password);
		logingui.add(name);
		logingui.add(pwd);
		logingui.add(login);
		// 窗体可视化
		logingui.setVisible(true);

		//给登录按钮设置监听事件
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//提取文本框里的用户名和密码
				String name_text = name.getText();
				String pwd_text = pwd.getText();
				//将得到的值存入user对象里面
				user.setusername(name_text);
				user.setuserpwd(pwd_text);
				//给登陆接口实现类初始化对象
				LoginUseImp l = new LoginUseImp();
				String state = user.getFlag();
				if(state != "1" && state != "2") {
					state = "2";
				}
				if(state == "2") {
					try {
						//执行sql语句，进行数据库添加
						boolean flag = l.Query(user, "select * from users where username=? and userpwd=? and flag="+state);
						if(flag) {
							//文本提示框
							JOptionPane.showMessageDialog(null, "登陆成功");
							//界面转换，隐藏原来界面
							logingui.setVisible(false);
							//构造新的界面
							new IndexAdmin(name_text);
						} else {
							//文本提示框
							JOptionPane.showMessageDialog(null, "登陆失败，请检查用户名和密码");
							//设置用户名框和密码框的值为空
							name.setText("");
							pwd.setText("");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		//整个程序执行的入口
	}
	public static void main(String[] args) {
		Login l = new Login();
		l.LoginGui();
	}
}
