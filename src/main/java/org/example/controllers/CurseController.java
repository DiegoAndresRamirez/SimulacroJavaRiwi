package org.example.controllers;

import org.example.entities.CurseEntity;
import org.example.models.CurseModelImpl;
import org.example.persistence.imodels.ICurseModel;

import java.util.List;

//that is a class that join all funcionalities and instance them

public class CurseController {
    ICurseModel curseModel = new CurseModelImpl();

    public CurseEntity createEntity(CurseEntity curseEntity) {
        return this.curseModel.createEntity(curseEntity);
    }

    public void delete(int id) {
        this.curseModel.delete(id);
    }

    public List<CurseEntity> readAll() {
        return this.curseModel.readAll();
    }

    public CurseEntity update(int id, CurseEntity curseEntity) {
        return this.curseModel.update(id, curseEntity);
    }

    public Boolean verifyDeleteCourse(int id) {
        return this.curseModel.verifyDeleteCourse(id);
    }

    public Boolean verifyStudentId(int id) {
        return this.curseModel.verifyStudentId(id);
    }



    }
