package com.vince.java.learn;

import com.vince.java.learn.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author vince_zh  2018/5/30
 */
public class JavaOptional {
    private List<User> users;

    {
        users = new ArrayList<>();
        User user1 = new User();
        user1.setId(5L);
        user1.setName("vince carter");
        user1.setTelephone("17010286194");
        User user2 = new User();
        user2.setId(2L);
        user2.setName("kobe");
        user2.setTelephone("27010286194");
        User user3 = new User();
        user3.setId(1L);
        user3.setName("lebron james");
        user3.setTelephone("37010286194");
        User user4 = new User();
        user4.setId(3L);
        user4.setName("james hadon");
        user4.setTelephone("47010286194");
        User user5 = new User();
        user5.setId(4L);
        user5.setName("keven durant");


        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(null);
    }

    private String codingInJava7(int index) {
        User user = users.get(index);
        if (user != null) {
            String userTel = user.getTelephone();
            if (userTel != null) {
                return userTel.substring(0,4) + "****" + userTel.substring(8);
            }
        }
        return "user info unComplete";
    }


    private String codingInJava8(int index) {
        User u = users.get(index);
        return Optional.ofNullable(u)
                .map(User::getTelephone)
                .map(tel -> tel.substring(0,4) + "****" + tel.substring(8))
                .orElse("user info unComplete");
    }

    public static void main(String[] args) {
        JavaOptional javaOptional = new JavaOptional();
        System.out.println(javaOptional.codingInJava7(3));
        System.out.println(javaOptional.codingInJava8(3));
        System.out.println(javaOptional.codingInJava7(4));
        System.out.println(javaOptional.codingInJava8(4));
        System.out.println(javaOptional.codingInJava7(5));
        System.out.println(javaOptional.codingInJava8(5));
    }
}
