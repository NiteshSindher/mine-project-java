package com.example.studentmgmt.service;

import com.example.studentmgmt.entity.*;
import org.hibernate.*;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public void recordTransaction(String type, double amount) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(new TransactionRecord(type, amount));
    }
}
