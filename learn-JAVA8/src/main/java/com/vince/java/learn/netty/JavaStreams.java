package com.vince.java.learn.netty;

import com.alibaba.fastjson.JSONObject;
import com.vince.java.learn.netty.entity.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author vince_zh  2018/5/30
 */
public class JavaStreams {
    private List<User> users;

    {
        users = new ArrayList<>();
        User user1 = new User();
        user1.setId(5L);
        user1.setName("vince carter");
        User user2 = new User();
        user2.setId(2L);
        user2.setName("kobe");
        User user3 = new User();
        user3.setId(1L);
        user3.setName("lebron james");
        User user4 = new User();
        user4.setId(3L);
        user4.setName("james hadon");
        User user5 = new User();
        user5.setId(4L);
        user5.setName("keven durant");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    private void codingInJava7() {
        List<User> userJames = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains("james")) {
                userJames.add(user);
            }
        }
        Collections.sort(userJames, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return (int) (o1.getId() - o2.getId());
            }
        });
        List<Long> userJamesId = new ArrayList<>();
        for (User user : userJames) {
            userJamesId.add(user.getId());
        }
        System.out.println(JSONObject.toJSONString(userJamesId));
    }

    private void codingInJava8() {

        List<User> userJamesId =
                users.parallelStream()
                        .filter(this::bj)
                        .filter(user -> user.getName().contains("james"))
                        .sorted(Comparator.comparingLong(User::getId))
                        .collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(userJamesId));


        Map<Long, User> map = users.stream().collect(Collectors.toMap(User::getId, u -> u));


        for (User user : users) {
            map.put(user.getId(), user);
        }
        System.out.println("map: " + JSONObject.toJSONString(map));
    }

    private boolean bj(User u) {
        return u == null;
    }
    public static void main(String[] args){
        JavaStreams javaStreams = new JavaStreams();
        javaStreams.codingInJava7();
        System.out.println("-----------");
        javaStreams.codingInJava8();
    }
}
