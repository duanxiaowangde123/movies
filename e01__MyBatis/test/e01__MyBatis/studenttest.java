package e01__MyBatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.duan.mapper.StudentMapper;
import com.duan.mapper.TeacherMapper;
import com.duan.pojo.Student;
import com.duan.pojo.Teacher;
import com.duan.util.SqlSessionFactoryUtil;

public class studenttest {
	private SqlSessionFactory sessionFactory=null;
	@Before
	public void setUp() throws Exception {
		this.sessionFactory=SqlSessionFactoryUtil.createSessionfactory();
	}

	
	
	@Test
	public void selectStudentByIdOrByNameAndPwd(){
		SqlSession session = this.sessionFactory.openSession();
		StudentMapper studentMapper=session.getMapper(StudentMapper.class);
		Student student=new Student();
		student.setId(1);
		List<Student> students= studentMapper.selectStudentByIdOrByNameAndPwd(student);
		
		System.out.println(students);
		session.close();
	}
	
	@Test
	public void selectStudentByWhere(){
		SqlSession session = this.sessionFactory.openSession();
		StudentMapper studentMapper=session.getMapper(StudentMapper.class);
		Student student=new Student();
		//student.setId(1);
		List<Student> students= studentMapper.selectStudentByWhere(student);
		
		System.out.println(students);
		session.close();
	}
	
	@Test
	public void updateStudentByDynamicSQL(){
		SqlSession session = this.sessionFactory.openSession();
		StudentMapper studentMapper=session.getMapper(StudentMapper.class);
		Student student=new Student();
		student.setId(2);
		student.setName("赵云");
		studentMapper.updateStudentByDynamicSQL(student);
		 
		session.commit();
		session.close();
	}
	
	@Test
	public void selectStudentsByInClause(){
		SqlSession session = this.sessionFactory.openSession();
		StudentMapper studentMapper=session.getMapper(StudentMapper.class);
		List<Integer>list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		 List<Student> students=studentMapper.selectStudentsByInClause(list);
		 System.out.println(students);
		session.commit();
		session.close();
	}
	
	@Test
	public void selectStudentsByPattern(){
		SqlSession session = this.sessionFactory.openSession();
		StudentMapper studentMapper=session.getMapper(StudentMapper.class);
		
		 List<Student> students=studentMapper.selectStudentsByPattern("1");
		 System.out.println(students);
		session.commit();
		session.close();
	}
}
