package com.realxq.transaction.service.impl;

import com.realxq.transaction.mapper.MemberMapper;
import com.realxq.transaction.pojo.Member;
import com.realxq.transaction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void addMemberA() {
        Member m = new Member();
        m.setName("A");
        m.setAge(10);
        memberMapper.insert(m);
    }

    @Override
    public void addMemberATransaction() {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addMemberBC() {
        Member b = new Member();
        b.setName("B");
        b.setAge(15);
        memberMapper.insert(b);

        int a = 10/0;

        Member c = new Member();
        c.setName("C");
        c.setAge(20);
        memberMapper.insert(c);
    }

    @Override
    public void addMemberBCTransaction() {

    }
}
