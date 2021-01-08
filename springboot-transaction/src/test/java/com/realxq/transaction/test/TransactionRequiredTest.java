package com.realxq.transaction.test;

import com.realxq.transaction.Application;
import com.realxq.transaction.service.TestTransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 事务的传播方式：REQUIRED（默认）
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TransactionRequiredTest {

    @Autowired
    private TestTransactionService testTransactionService;

    /**
     * 调用方法(addMemberRequired) 开启事务(required)
     * 被调用方法: addMemberA 开启事务；addMemberBC开启事务
     * 调用结果：在 addMemberBC中发生了异常，三个方法都发生了回滚（成为了一个事务）
     */
    @Test
    public void testRequired(){
        testTransactionService.addMemberRequired();
    }


    /**
     * 调用方法(addMember) 不开启事务
     * 被调用方法: addMemberA 开启事务；addMemberBC开启事务
     * 异常条件： addMemberA中无异常，addMemberBC中有异常
     *
     * 调用结果：ABC都发生了回滚
     */
    @Test
    public void testRequired2(){
        testTransactionService.addMember();
    }

    /**
     * 调用方法(addMember) 不开启事务
     * 被调用方法 A 不开启事务；BC 开启事务，存在异常
     *
     * 调用结果: A 成功入库，BC 发生回滚
     */
    @Test
    public void testRequired3(){
        testTransactionService.addMember2();
    }
}
