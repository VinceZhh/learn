package com.vince.java.learn;

import com.vince.java.learn.dao.UserDao;
import com.vince.java.learn.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by zhanghao12@jd.com on 2018/3/9
 */
@Service
public class Transaction {
    @Resource
    private UserDao userDao;
    @Resource
    private TransactionTemplate transactionTemplate;

    public List<User> listUser(){
        return userDao.selectUser();
    }

    /**
     * 声明式事务
     * @param user
     */
    @Transactional
    public void transactionAnnotationTest(User user){
        user.setPsw("------");
        userDao.insertUser(user);
        int i = 1/0; //引发异常
    }

    /**
     * 编程式事务
     */
    public void transactionProgramTransaction(final User user){
        Object execute = transactionTemplate.execute(new TransactionCallback<Object>() {
            public Integer doInTransaction(TransactionStatus transactionStatus) {
                try {
                    user.setPsw("------");
                    userDao.insertUser(user);
//                    int i = 1 / 0;//引发异常
                    return null;
                }catch (Exception e){
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });

//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                user.setPsw("------");
//                userDao.insertUser(user);
//                int i = 1/0;//引发异常
//            }
//        });
    }

}
