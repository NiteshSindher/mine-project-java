package com.example.studentmgmt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.studentmgmt.config.AppConfig;
import com.example.studentmgmt.entity.Student;
import com.example.studentmgmt.dao.StudentDAO;
import com.example.studentmgmt.service.StudentService;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentDAO dao = ctx.getBean(StudentDAO.class);
        StudentService service = ctx.getBean(StudentService.class);

        // Add student
        Student s = new Student();
        s.setName("Alice");
        s.setCourse("B.Tech");
        s.setFees(0);
        dao.save(s);
        System.out.println("Student Added: " + s);

        // Fee payment transaction
        service.payFees(s.getId(), 5000);
        System.out.println("Fee paid. Updated: " + dao.find(s.getId()));

        // Refund
        service.refundFees(s.getId(), 1000);
        System.out.println("Refunded. Updated: " + dao.find(s.getId()));

        ctx.close();
    }
}
