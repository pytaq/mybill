package cn.gwj.util;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.util
    User:1093499975@qq.com
    Date:2019/7/6 0006
    Time:16:56
*/

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory factory;

    static{//在静态代码块下，factory只会被创建一次
        System.out.println("static factory===============");
        try {
            //加载mybatis的配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //通过sqlSession工厂创建者build出一个数据库会话工程
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static SqlSession createSqlSession(){
        //打开一个数据库会话
        return factory.openSession(false);//true 为自动提交事务
    }

    public static void closeSqlSession(SqlSession sqlSession){
        if(null != sqlSession)
            sqlSession.close();
    }
}

