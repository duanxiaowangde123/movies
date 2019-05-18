package e01__MyBatis;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.duan.mapper.TeacherMapper;
import com.duan.pojo.Teacher;
import com.duan.util.SqlSessionFactoryUtil;

public class test1 {
	private SqlSessionFactory sessionFactory=null;
	@Before
	public void setUp() throws Exception {
		this.sessionFactory=SqlSessionFactoryUtil.createSessionfactory();
	}

	@Test
	public void testTeacherInsertrOne1() {
		InputStream is =this.getClass().getResourceAsStream("/mybatis.config.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=sessionFactory.openSession();
		Teacher teacher =new Teacher();
		teacher.setName("222222");
		teacher.setGender("男");
		teacher.setBirthDate(new java.sql.Date(new java.util.Date().getTime()));
		session.insert("com.duan.mapper.TeacherMapper.insertOneTeacher", teacher);
		session.commit();
		session.close();
	}
	
	@Test
	public void insertOneTeacherStatic() {
		InputStream is =this.getClass().getResourceAsStream("/mybatis.config.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=sessionFactory.openSession();
		session.insert("com.duan.mapper.TeacherMapper.insertOneTeacherStatic");
		session.commit();
		session.close();
	}
	
	@Test
	public void testTeacherSelectOne(){
		//建议SessionFactory用单例模式
		//建议Session用局部变量形式，不要写到类成员变量或者类变量中。
		SqlSession session = this.sessionFactory.openSession();
		
		Teacher teacher = session.selectOne("com.duan.mapper.TeacherMapper.selectOneTeacher", 1);
		System.out.println(teacher);
		session.close();
	}
	
	@Test
	public void testTeacherSelectList(){
		
		SqlSession session = this.sessionFactory.openSession();
		/*List<Teacher> teachers = session.selectList("com.duan.mapper.TeacherMapper.selectTeacherList");
		*/
		RowBounds rowBounds=new RowBounds(0, 1);
		List<Teacher> teachers = session.selectList("com.duan.mapper.TeacherMapper.selectTeacherList",rowBounds);
		
		System.out.println(teachers);
		session.close();
	}
	
	@Test
	public void testTeacherDeleteOne(){
		
		SqlSession session = this.sessionFactory.openSession();
		session.delete("com.duan.mapper.TeacherMapper.deleteOneTeacher",2);
		session.commit();
		session.close();
	}
	
	@Test
	public void updataOneTeacher(){
		
		SqlSession session = this.sessionFactory.openSession();

		Teacher teacher =new Teacher();
		teacher.setId(2);
		teacher.setName("6666");
		teacher.setGender("女");
		teacher.setBirthDate(new java.sql.Date(new java.util.Date().getTime()));
		
		session.update("com.duan.mapper.TeacherMapper.updataOneTeacher",teacher);
		session.commit();
		session.close();
	}
	
	@Test
	public void testTeacherInsertStatic(){
		SqlSession session = this.sessionFactory.openSession();
		session.insert("com.duan.mapper.TeacherMapper.insertOneTeacherStatic");
		session.commit();
		session.close();
		
	}
	
	@Test
	public void selectTeacherListByCondition(){
		
		SqlSession session = this.sessionFactory.openSession();
		HashMap<String, Object> params=new HashMap<String,Object>();
		params.put("min", 1);
		params.put("max", 3);
		List<Teacher> teachers = session.selectList("com.duan.mapper.TeacherMapper.selectTeacherListByCondition",params);
		System.out.println(teachers);
		session.close();
	}
	
	@Test
	public void selectTeacherMap(){
		
		SqlSession session = this.sessionFactory.openSession();
		Map<String,Object> teachers = session.selectMap("com.duan.mapper.TeacherMapper.selectTeacherList","name");
		System.out.println(teachers);
		session.close();
	}
	
	@Test
	public void selectTeacherMap2(){
		
		SqlSession session = this.sessionFactory.openSession();
		List<Map<String,Object>> teachers = session.selectList("com.duan.mapper.TeacherMapper.selectTeacherList2");
		System.out.println(teachers);
		session.close();
	}
	
	@Test
	public void testTeacherMapper(){
		SqlSession session = this.sessionFactory.openSession();
		TeacherMapper techerMapper=session.getMapper(TeacherMapper.class);
		//techerMapper.insertOneTeacherStatic();
		/*Teacher teacher = new Teacher();
		teacher.setName("掏粪");
		teacher.setGender("男");
		techerMapper.insertOneTeacher(teacher);*/
		//删除
		techerMapper.deleteOneTeacher(8);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testTeacherDynamicSQL(){
		SqlSession session = this.sessionFactory.openSession();
		TeacherMapper techerMapper=session.getMapper(TeacherMapper.class);
		Map<String, Object> params=new HashMap<>();
		params.put("id", 1);
		
		List<Teacher> teachers=techerMapper.selectTeachersByCondition(params);
		
		System.out.println(teachers);
		session.commit();
		session.close();
	}
	
	
}
