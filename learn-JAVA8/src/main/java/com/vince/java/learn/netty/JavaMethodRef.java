package com.vince.java.learn.netty;

import com.alibaba.fastjson.JSONObject;
import com.vince.java.learn.netty.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


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
        users.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
    }

    private void codingInJava8() {
        users.sort(Comparator.comparingLong(User::getId));
        List<String> list = Arrays.asList("A","c","b","f","e");
        list.sort(String::indexOf);
        System.out.println(JSONObject.toJSONString(list));

    }
    public static void main(String[] args){
        JavaMethodRef javaMethodRef = new JavaMethodRef();
        javaMethodRef.codingInJava8();

    }

}
