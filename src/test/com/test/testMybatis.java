package com.test;

import com.dao.MedicalcardDao;
import com.entity.Medicalcard;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class testMybatis {

    @Test
    public void testMybatis() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MedicalcardDao medicalcardDao = sqlSession.getMapper(MedicalcardDao.class);

        List<Medicalcard> medicalcards = medicalcardDao.queryList();
        for (Medicalcard medicalcard : medicalcards) {
            System.out.println(medicalcard);
        }
        System.out.println("chaxunchenggong");

    }
}
