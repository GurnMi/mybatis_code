package kr.or.dgit.mybatis_code;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_code.dto.Student;
import kr.or.dgit.mybatis_code.util.MyBatisSqlSessionFactory;

public class MybatisSqlSessionTest {
	private static SqlSessionFactory factory;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
		factory = MyBatisSqlSessionFactory.getSqlsessionfactory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");
		factory = null;
	}

	@Test
	public void testSqlSessionFactory() {
		Assert.assertNotNull(factory);
	}
	
/*	@Test
	public void testSqlSession() {
		SqlSession ss = factory.openSession();
		List<Student> list = ss.selectList("select * from students");
		Assert.assertNotNull(list);
	}*/

}
