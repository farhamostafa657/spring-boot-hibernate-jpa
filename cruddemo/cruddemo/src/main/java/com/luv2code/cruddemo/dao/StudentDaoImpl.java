package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//define field for entitymaneger

@Repository
public class StudentDaoImpl implements StudentDao{
    //define field entitymaneger

    private EntityManager entityManager;

    //inject intitymamneger using constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student>theQuery=entityManager.createQuery("from Student",Student.class);
        //return query list
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student>theQuery=entityManager.createQuery(
                "from Student where lastName=:theData",Student.class);
        //set query parametere
        theQuery.setParameter("theData",lastName);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void Delete(Integer id) {
        //retrieve the student
        Student theStudet=entityManager.find(Student.class,id);
        //delete the student
        entityManager.remove(theStudet);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleted=entityManager.createQuery("delete from Student").executeUpdate();
        return rowsDeleted;
    }


}
