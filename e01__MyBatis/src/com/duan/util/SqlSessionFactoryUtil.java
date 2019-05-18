package com.duan.util;

import java.io.InputStream;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
	private static SqlSessionFactory sessionFactory;
	static{
		InputStream is =SqlSessionFactoryUtil.class.getResourceAsStream("/mybatis.config.xml");
		sessionFactory=new SqlSessionFactoryBuilder().build(is);
	}
	public static SqlSessionFactory createSessionfactory() {
		return sessionFactory;
		
	}
}
