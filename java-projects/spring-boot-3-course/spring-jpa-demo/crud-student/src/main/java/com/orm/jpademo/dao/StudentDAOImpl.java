package com.orm.jpademo.dao;

import com.orm.jpademo.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements IStudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findStudentById(int studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> query1 = entityManager
                .createQuery("FROM Student", Student.class);
        return query1.getResultList();
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName) {
        TypedQuery<Student> query2 = entityManager
                .createQuery("FROM Student WHERE lastName=:name", Student.class);
        query2.setParameter("name",lastName);
        return query2.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
        entityManager.remove(entityManager.find(Student.class, studentId));
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
