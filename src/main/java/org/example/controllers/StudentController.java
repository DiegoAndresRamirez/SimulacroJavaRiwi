package org.example.controllers;

import org.example.entities.StudentEntity;
import org.example.models.StudentModelImpl;
import org.example.persistence.imodels.IStudentModel;

import java.util.List;


//that is a class that join all funcionalities and instance them

public class StudentController {
    IStudentModel studentModel = new StudentModelImpl();

    public StudentEntity createEntity(StudentEntity studentEntity) {
        return this.studentModel.createEntity(studentEntity);
    }

    public void delete(int id) {
        this.studentModel.delete(id);
    }

    public List<StudentEntity> readAll() {
        return this.studentModel.readAll();
    }

    public StudentEntity getByEmail(String email) {
        return this.studentModel.getByEmail(email);
    }

    public StudentEntity getById(int id) {
        return this.studentModel.getById(id);
    }

    public Integer verifyQuantityStudent(int id) {
        return this.studentModel.verifyQuantityStudent(id);
    }

    public Boolean verifyStudentExist(int id) {
        return this.studentModel.verifyStudentExist(id);
    }

    public StudentEntity update(int id, StudentEntity studentEntity) {
        return this.studentModel.update(id, studentEntity);
    }

    public List<StudentEntity> getActiveStudents() {
        return this.studentModel.getActiveStudents();
    }









    }
