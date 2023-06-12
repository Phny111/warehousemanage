package com.demo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class IndexAdmin {
	//声明对象
	public  JFrame index;
	private JMenuBar management;
	private JMenu user;
	private JMenu goods;
	private JMenu storage;
	private JMenu about;
	private JMenuItem exit;
	private JMenuItem useradd;
	private JMenuItem userdelete;
	private JMenuItem userupdate;
	private JMenuItem userselect;
	private JMenuItem goodsadd;
	private JMenuItem goodsdelete;
	private JMenuItem goodsupdate;
	private JMenuItem storageadd;

	private JMenuItem storagedelete;
	private JMenuItem storageupdate;
	private JMenuItem aboutus;
	Font f = new Font("楷体", Font.BOLD, 15);

	//构造函数
	public IndexAdmin(String name) {
		indexadmin();
		//菜单的添加
		//给用户菜单添加条目
		user.add(useradd);
		user.add(userselect);
		user.add(userdelete);
		user.add(userupdate);
		user.add(exit);
		//给商品菜单添加条目

		//给仓库菜单添加条目
		storage.add(storageadd);
		storage.add(storagedelete);
		storage.add(storageupdate);
		//给关于我们添加条目
		about.add(aboutus);
		//将菜单添加到菜单栏里
		management.add(user);
		management.add(storage);
		management.add(about);
		init(name);
		action(name);
	}

	private void init(String name) {
		//初始化框架
		index = new JFrame("");
		//设置框架大小及位置
		index.setBounds(500, 100, 600, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//将菜单栏设置进框架
		index.setJMenuBar(management);
		//清空框架格式
		index.setLayout(null);
		//将框架转换为容器
		((JComponent) index.getContentPane()).setOpaque(false);
		//设置可视化
		index.setVisible(true);
	}

	public void indexadmin() {
		//对象初始化以及设置字体
		management = new JMenuBar();
		//菜单初始化
		user = new JMenu(" 用户管理");
		user.setFont(f);
		storage = new JMenu(" 仓库管理");
		storage.setFont(f);
		about = new JMenu(" 关于我们");
		about.setFont(f);
		//菜单条目初始化
		exit = new JMenuItem("更换用户");
		exit.setFont(f);
		useradd = new JMenuItem("添加用户");
		useradd.setFont(f);
		userdelete = new JMenuItem("删除用户");
		userdelete.setFont(f);
		userupdate = new JMenuItem("密码修改");
		userupdate.setFont(f);
		userselect = new JMenuItem("查询用户");
		userselect.setFont(f);
		goodsadd = new JMenuItem("商品添加");
		goodsadd.setFont(f);
		goodsdelete = new JMenuItem("商品删除");
		goodsdelete.setFont(f);
		goodsupdate = new JMenuItem("商品更新");
		goodsupdate.setFont(f);
		storageadd = new JMenuItem("仓库添加");
		storageadd.setFont(f);
		storagedelete = new JMenuItem("仓库删除");
		storagedelete.setFont(f);
		storageupdate = new JMenuItem("仓库更新");
		storageupdate.setFont(f);
		aboutus = new JMenuItem("关于我们");
	}

	//给所有的菜单条目设置监听事件
	private void action(final String name) {
		aboutus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String info = "仓库管理系统\n\n";
				String[] buttons = {"了解"};
				JOptionPane.showOptionDialog(null, info, "关于", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(IndexAdmin.class.getResource("/images/logo.png")), buttons, null);
			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				//将原来页面设置为不可见
				index.setVisible(false);
				//调用函数转到登陆页面
				Login.main(null);
			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				//将原来页面设置为不可见
				index.setVisible(false);
				//调用函数转到登陆页面
				Login.main(null);
			}
		});
		useradd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				//将原来页面设置为不可见
				index.setVisible(false);
				//用构造函数获取新页面
				new Useradd(name);
			}
		});
		userselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Userselect(name);
			}
		});
		userdelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Userdelete(name);
			}
		});
		userupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Adminupdate(name);
			}
		});
		goodsadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
			}
		});
		goodsdelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
			}
		});
		goodsupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
			}
		});
		storageadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Storageadd(name);
			}
		});
		storagedelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Storagedelete(name);
			}
		});
		storageupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Storageupdate(name);
			}
		});
	}
}