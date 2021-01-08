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
public class TransactionTest {

    @Autowired
    private TestTransactionService testTransactionService;

    @Test
    public void myTest(){
        testTransactionService.addMemberRequired();
    }

}
