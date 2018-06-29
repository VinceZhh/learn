package com.vince.java.learn.netty.test;

import com.vince.java.learn.netty.entity.User;
import com.vince.java.learn.netty.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by zhanghao12@jd.com on 2018/1/31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class DefTest {
    private Logger logger = LoggerFactory.getLogger(DefTest.class);
    @Resource
    Transaction transaction;

    @Test
    public void test() {
        User user = new User();
        String flag = "09";
        user.setName("TestName" + flag);
        user.setAddress("TestAddress" + flag);
        user.setTelephone("170102861"+flag);
        List<User> users = transaction.listUser();
        for(User u:users){
            logger.info("u: {}",u);
        }

        try {
            transaction.transactionProgramTransaction(user);
        }catch (Exception e){
            logger.error("transactionTest has error",e);
        }
        logger.info("user.psw: {}",user.getPsw());

        users = transaction.listUser();
        logger.info("-----------");
        for(User u:users){
            logger.info("u: {}",u);
        }
    }

}
