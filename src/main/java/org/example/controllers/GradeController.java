package org.example.controllers;

import org.example.entities.GradeEntity;
import org.example.models.GradeModelImpl;
import org.example.persistence.imodels.IGradeModel;

import java.util.List;


//that is a class that join all funcionalities and instance them

public class GradeController {
    IGradeModel gradeModel = new GradeModelImpl();

    public GradeEntity createEntity(GradeEntity gradeEntity) {
        return this.gradeModel.createEntity(gradeEntity);
    }

    public void delete(int id) {
        this.gradeModel.delete(id);
    }

    public Integer verifyGrade(int id) {
        return this.gradeModel.verifyGrade(id);
    }

    public List<GradeEntity> readAll() {
        return this.gradeModel.readAll();
    }

    public GradeEntity update(int id, GradeEntity gradeEntity) {
        return this.gradeModel.update(id, gradeEntity);
    }

    public Boolean verifyCourseId(int id) {
        return this.gradeModel.verifyCourseId(id);
    }

    public Boolean verifyStudentId(int id) {
        return this.gradeModel.verifyStudentId(id);
    }







    }
