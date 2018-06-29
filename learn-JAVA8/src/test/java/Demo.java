import com.vince.java.learn.netty.dao.UserDao;
import com.vince.java.learn.netty.entity.User;
import com.vince.java.learn.netty.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by zhanghao12@jd.com on 2018/6/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Demo {
    private Logger logger = LoggerFactory.getLogger(Demo.class);
    @Resource
    private UserDao userDao;

    @Test
    public void java8() {
        List<User> users = userDao.selectUser();
        List<UserVO> userVOS = users.stream().map(this::packageUserVO).collect(Collectors.toList());
        System.out.println(userVOS);
    }

    private UserVO packageUserVO(User user) {
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }
}
