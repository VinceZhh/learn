package com.vince.java.learn.dao;

import com.vince.java.learn.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 获得User数据集合
     */
    List<User> selectUser();

    /**
     * 获得一个User对象,以参数User对象中不为空的属性作为条件进行查询
     */
    User selectUserByObj(User obj);

    /**
     * 通过User的id获得User对象
     */
    User selectUserById(Long id);

    /**
     * 插入User到数据库,包括null值
     */
    int insertUser(User value);

    /**
     * 通过User的id删除User
     */
    int deleteUserById(Long id);

    /**
     * 通过User的id更新User中的数据 不包括null
     */
    int updateUserById(User user);

}