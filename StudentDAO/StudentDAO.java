package com.example.studentmgmt.dao;

import com.example.studentmgmt.entity.Student;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Student s) { getSession().persist(s); }
    public void update(Student s) { getSession().merge(s); }
    public void delete(int id) {
        Student s = getSession().get(Student.class, id);
        if (s != null) getSession().remove(s);
    }
    public Student find(int id) { return getSession().get(Student.class, id); }
    public List<Student> listAll() {
        return getSession().createQuery("from Student", Student.class).list();
    }
}
