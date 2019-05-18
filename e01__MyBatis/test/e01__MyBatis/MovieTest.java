package e01__MyBatis;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import com.duan.pojo.Movie;
import com.duan.pojo.Type;
import com.duan.util.SqlSessionFactoryUtil;

public class MovieTest {
	private SqlSessionFactory sessionFactory=null;

	@Before
	public void setUp() throws Exception {
		this.sessionFactory=SqlSessionFactoryUtil.createSessionfactory();
		
	}

	@Test
	public void selectOneMovie(){
		//建议SessionFactory用单例模式
		//建议Session用局部变量形式，不要写到类成员变量或者类变量中。
		SqlSession session = this.sessionFactory.openSession();
		
		Movie movie = session.selectOne("com.duan.mapper.MovieMapper.selectMovieWithTypeById", 1);
		session.close();
		System.out.println("-------------");
		System.out.println(movie);
	}
	
	@Test
	public void selectTypeWithMoviesById(){
		//建议SessionFactory用单例模式
		//建议Session用局部变量形式，不要写到类成员变量或者类变量中。
		SqlSession session = this.sessionFactory.openSession();
		
		Type type = session.selectOne("com.duan.mapper.TypeMapper.selectTypeWithMoviesById", 1);
		session.close();
		System.out.println("-------------");
		System.out.println(type);
	}

}
