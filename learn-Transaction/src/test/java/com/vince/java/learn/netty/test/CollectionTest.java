package com.vince.java.learn.netty.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by zhanghao12@jd.com on 2018/4/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class CollectionTest {
    private Logger logger = LoggerFactory.getLogger(CollectionTest.class);

    @Test
    public void delInCenter() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        logger.info(JSONObject.toJSONString(list));
        list.subList(4, 8).clear();
        logger.info(JSONObject.toJSONString(list));
    }

    @Test
    public void stringsToList() {
        String param = "10086,10010";
        List<String> list = Arrays.asList(param.split(","));
        List<Long> longs = new ArrayList<Long>(list.size());
        for (String s : list) {
            longs.add(new Long(s));
        }
        logger.info(JSONObject.toJSONString(longs));
    }
}
