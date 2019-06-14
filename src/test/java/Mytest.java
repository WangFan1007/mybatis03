import com.wang.dao.ICountry;
import com.wang.domain.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Mytest {

    private ICountry mapper;
    private SqlSession session;

    @Before
    public void initEnv(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
            mapper = session.getMapper(ICountry.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testgetOne(){
        Country counrey = mapper.getCounreyByID(1);
        System.out.println(counrey.toString());
    }


    @Test
    public void testgetAll(){
        List<Country> all = mapper.getAll();
        System.out.println(all);
    }

    @After
    public void testAfter(){
        session.commit();
    }
}
