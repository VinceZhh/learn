package com.vince.java.learn.dao;


import com.vince.java.learn.entity.User;

import java.util.List;

/**
 * @author vince_zh
 */
public interface UserDao {

    /**
     * 获得User数据集合
     * @return User数据集合
     */
    List<User> selectUser();

    /**
     * 获得一个User对象,以参数User对象中不为空的属性作为条件进行查询
     * @param obj user
     * @return user
     */
    User selectUserByObj(User obj);

    /**
     * 通过User的id获得User对象
     * @param id 主键id
     * @return user
     */
    User selectUserById(Long id);

    /**
     * 插入User到数据库,包括null值
     * @param value user
     */
    void insertUser(User value);

    /**
     * 通过User的id删除User
     * @param id 主键id
     * @return 影响行数
     */
    int deleteUserById(Long id);

    /**
     * 通过User的id更新User中的数据 不包括null
     * @param user user
     * @return 影响行数
     */
    int updateUserById(User user);

}