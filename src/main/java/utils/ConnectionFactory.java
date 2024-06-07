package utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ConnectionFactory {
	private static SqlSessionFactory factory;
	static String path="mybatis-config.xml";

	static {
		Reader reader = null;
		//SqlMapClient sqlMapClient;
		try { 
			 reader = Resources.getResourceAsReader(path);
	        //sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}

	public static UserMapper1 getCustomerMapper() {
		return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(UserMapper1.class);
	}

	public static UserPreferenceMapper1 getUserPreferenceMapperMapper() {
		return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(UserPreferenceMapper1.class);
	}
}