package com.vince.java.learn;

import com.vince.java.learn.entity.User;

import java.util.*;


/**
 * @author vince_zh  2018/5/30
 */
public class JavaMethodRef {
    private List<User> users;

    {
        users = new ArrayList<>();
        User user1 = new User();
        user1.setId(5L);
        User user2 = new User();
        user2.setId(2L);
        User user3 = new User();
        user3.setId(1L);
        User user4 = new User();
        user4.setId(3L);
        User user5 = new User();
        user5.setId(4L);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    private void codingInJava7() {
        Collections.sort(users, (o1, o2) -> Long.compare(o1.getId(),o2.getId()));
    }

    private void codingInJava8() {
        users.sort(Comparator.comparingLong(User::getId));
    }

}
