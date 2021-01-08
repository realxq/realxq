package com.realxq.transaction.service.impl;

import com.realxq.transaction.service.MemberService;
import com.realxq.transaction.service.TestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TestTransactionServiceImpl implements TestTransactionService {

    @Resource(name="memberByRequiredService")
    private MemberService requiredService;

    @Resource(name="memberBySupportService")
    private MemberService supportService;

    @Override
    public void test() {
        System.out.println("ttttt");
    }

    @Override
    public void addMember() {
        requiredService.addMemberATransaction();
        requiredService.addMemberBCTransaction();
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addMemberRequired() {
        requiredService.addMemberA();
        requiredService.addMemberBCTransaction();
    }

    @Override
    public void addMember2() {
        requiredService.addMemberA();
        requiredService.addMemberBCTransaction();
    }

    @Override
    public void addMemberSupport1() {
        supportService.addMemberA();
        supportService.addMemberBCTransaction();
    }

    @Override
    @Transactional
    public void addMemberSupport2() {
        supportService.addMemberA();
        supportService.addMemberBCTransaction();
    }
}
