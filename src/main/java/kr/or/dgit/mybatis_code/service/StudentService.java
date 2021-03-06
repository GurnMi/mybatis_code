package kr.or.dgit.mybatis_code.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_code.dao.StudentDao;
import kr.or.dgit.mybatis_code.dto.Student;
import kr.or.dgit.mybatis_code.util.MyBatisSqlSessionFactory;

public class StudentService {
	
	public List<Student> selectAllStudent(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			StudentDao dao = sqlSession.getMapper(StudentDao.class);
			return dao.findAllStudents();	
		}
	}
	
	public int createStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			StudentDao dao = sqlSession.getMapper(StudentDao.class);
			int res = dao.insertStudent(student);
			sqlSession.commit();
			return res;
		}
	}
	
	
	public void deleteStudent(int studId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			StudentDao dao = sqlSession.getMapper(StudentDao.class);
			dao.deleteStudent(studId);
			sqlSession.commit();
		}
	}
	
	
	
	public Student SelectStudentByNo(int studId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne("kr.or.dgit.mybatis_code.dao.StudentDao.findStudentById", studId);	
		}
	}
}
