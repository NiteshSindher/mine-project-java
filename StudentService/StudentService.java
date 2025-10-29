package com.example.studentmgmt.service;

import com.example.studentmgmt.dao.StudentDAO;
import com.example.studentmgmt.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.annotation.Resource;

@Service
public class StudentService {

    @Resource
    private StudentDAO dao;
    @Resource
    private TransactionService txService;

    @Transactional
    public void payFees(int studentId, double amount) {
        Student s = dao.find(studentId);
        s.setFees(s.getFees() + amount);
        dao.update(s);
        txService.recordTransaction("PAYMENT", amount);
    }

    @Transactional
    public void refundFees(int studentId, double amount) {
        Student s = dao.find(studentId);
        s.setFees(s.getFees() - amount);
        dao.update(s);
        txService.recordTransaction("REFUND", amount);
    }
}
