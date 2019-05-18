package e01__MyBatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.duan.pojo.Course;
import com.duan.pojo.Student;
import com.duan.util.SqlSessionFactoryUtil;

public class ManyToManyTestCase {

	private SqlSessionFactory sessionFactory = null;
	@Before
	public void setUp() throws Exception {
		this.sessionFactory = SqlSessionFactoryUtil.createSessionfactory();
	}

	@Test
	public void testSelectOneStudent(){
		SqlSession session = this.sessionFactory.openSession();
		Student student = session.selectOne("com.duan.mapper.StudentMapper.selectStudentWithCoursesById", 1);
		
		System.out.println("-----------------");
		System.out.println(student);
		session.close();
	}
	@Test
	public void testSelectOneType(){
		SqlSession session = this.sessionFactory.openSession();
		Course course = session.selectOne("com.duan.mapper.CourseMapper.selectCourseWithStudentById", 1);
		
		System.out.println("-----------------");
		System.out.println(course);
		session.close();
	}
	
}
