package ru.geekbrains.hw5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class StudentDao {
    private SessionFactory factory;

    public StudentDao(SessionFactory factory) {
        this.factory = factory;
    }

    public Student findByID(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    public List<Student> findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> list = session.createQuery("from Student ").list();
            session.getTransaction().commit();
            return list;
        }
    }

    public void create(String name, int mark) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = new Student(name, mark);
            session.save(student);
            session.getTransaction().commit();
        }
    }

    public void update(Long id, String name, int mark) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            student.setName(name);
            student.setMark(mark);
            session.getTransaction().commit();
        }
    }

    public void delete(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }
    }
}
