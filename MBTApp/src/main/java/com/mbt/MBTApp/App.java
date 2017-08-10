package com.mbt.MBTApp;

import java.io.InputStream;
import java.util.List;

import com.mbt.MBTApp.Entity.Info;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 //mybatis的配置文件
        String resource = "com/mbt/MBTApp/Entity/config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.mbt.MBTApp.Entity.infoMapper.getInfo";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        Info info = session.selectOne(statement, 1);
        System.out.println(info.getId()+":"+info.getName()+":"+info.getIntro());
        
        statement = "com.mbt.MBTApp.Entity.infoMapper.insertInfo";
        Info ninfo = new Info();
        ninfo.setName("Mybatis");
        ninfo.setIntro("new info");
        session.insert(statement, ninfo);
        session.commit();
        statement = "com.mbt.MBTApp.Entity.infoMapper.updateInfo";
        info.setIntro("world");
        session.update(statement, info);
        session.commit();
        String allst = "com.mbt.MBTApp.Entity.infoMapper.getAllInfo";
        List<Info> list = session.selectList(allst);
        for(Info inf:list) {
        	System.out.println(inf.getId()+":"+inf.getName()+":"+inf.getIntro());
        }
        
        //statement = "com.mbt.MBTApp.Entity.infoMapper.deleteInfo";
        //session.delete(statement, 12);
        //session.commit();
        
        session.close();
    }
}
