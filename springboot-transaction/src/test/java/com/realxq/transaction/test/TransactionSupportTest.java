package com.realxq.transaction.test;

import com.realxq.transaction.Application;
import com.realxq.transaction.service.TestTransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TransactionSupportTest {


    @Autowired
    private TestTransactionService testTransactionService;

    /**
     * 调用方法(addMember) 不开启事务
     * 被调用方法 A 不开启事务 BC SUPPORTS事务
     *
     * 调用结果：ABC不发生回滚，SUPPORTS事务是否开启与调用者的事务相关
     */
    @Test
    public void test1(){
        testTransactionService.addMemberSupport1();
    }


    /**
     * 调用方法(addMember) 开启事务
     * 被调用方法 A 不开启事务 BC SUPPORTS事务
     *
     * 调用结果：
     */
    @Test
    public void test2(){
        testTransactionService.addMemberSupport2();
    }

}
