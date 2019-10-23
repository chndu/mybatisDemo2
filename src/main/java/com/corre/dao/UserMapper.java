package com.corre.dao;

import com.corre.domain.Person;
import com.corre.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> findList(Integer id) throws Exception;

    public List<User> findLists(Person person) throws Exception;

    public List<User> getArray(Object [] array) throws Exception;

    public List<User> getList(List<Object> list) throws Exception;

    public List<User> getMap(HashMap <Object, Object> map) throws  Exception;

    public void addUser(User user) throws Exception;

    public void updateUser(User user) throws Exception;

}
