package com.corre;

import com.corre.dao.UserMapper;
import com.corre.domain.Person;
import com.corre.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test {

    private InputStream inputStream;
    private SqlSessionFactory sessionFactory;
    private SqlSession openSession;

    @Before
    public void setUp() throws Exception{
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        openSession = sessionFactory.openSession();
    }

    @After
    public void tearDown() throws IOException {
        openSession.commit();
        openSession.close();
        inputStream.close();
    }

    @Test
    public void testFindlist() throws Exception{

        UserMapper mapper = openSession.getMapper(UserMapper.class);


        List <User> list = mapper.findList(1);

        for (User user:list){
            System.out.println(user);
        }
    }

    @Test
    public void testFindlists() throws Exception{

        UserMapper mapper = openSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        Person person = new Person();
        person.setUser(user);
        List <User> list = mapper.findLists(person);
        System.out.println(list);

    }

    @Test
    public void testGetArray() throws Exception{
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        Object [] obj = new Object[]{"id",5};
        List<User> array = mapper.getArray(obj);
        System.out.println(array);

    }


    @Test
    public void testGetList() throws Exception{
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        ArrayList<Object> arrayList = new ArrayList <>();
        arrayList.add(1);
        List<User> array = mapper.getList(arrayList);
        System.out.println(array);

    }

    @Test
    public void testGetMap() throws Exception{
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        HashMap <Object, Object> hashMap = new HashMap <>();

        hashMap.put("namekey","小米");
        hashMap.put("nameValues","name");

        List <User> map = mapper.getMap(hashMap);

        System.out.println(map);
    }


    @Test
    public void testAddUser() throws Exception{
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("红梅");
        user.setPassword("123456");
        user.setSex("2");
        user.setCity("海南");
        mapper.addUser(user);

        System.out.println(user.getId());
    }


    @Test
    public void testUpdateUser() throws Exception{
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("刘海");
        user.setId(9);
        mapper.updateUser(user);
        System.out.println(user.getName());
    }
}
