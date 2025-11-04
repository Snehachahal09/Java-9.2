package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentMain {

    public static void main(String[] args) {

        // CREATE
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student s1 = new Student(101, "Sneha", "Computer Science");
        session.save(s1);
        tx.commit();
        System.out.println("Student Inserted!");

        // READ
        Student student = session.get(Student.class, 101);
        System.out.println("Student: " + student.getName());

        // UPDATE
        tx = session.beginTransaction();
        student.setCourse("AI & ML");
        session.update(student);
        tx.commit();
        System.out.println("Student Updated!");

        // DELETE
        tx = session.beginTransaction();
        session.delete(student);
        tx.commit();
        System.out.println("Student Deleted!");

        session.close();
    }
}
