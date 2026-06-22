import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyBatisTest {
    @Test
    public void testFindUserById() throws Exception {
        // 1.加载核心配置
        String resource = "mybatis-config.xml";
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream(resource));
        // 2.创建会话
        SqlSession session = factory.openSession();
        // 3.执行SQL查询
        User user = session.selectOne("userMapper.findUserById", 1);
        // 4.打印封装后的实体对象
        System.out.println("===== 查询结果 =====");
        System.out.println(user);
        // 5.关闭资源
        session.close();
    }
}