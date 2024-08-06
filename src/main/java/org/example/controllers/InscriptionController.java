package org.example.controllers;

import org.example.entities.InscriptionEntity;
import org.example.models.InscriptionModelImpl;
import org.example.persistence.imodels.IInscriptionModel;

import java.util.List;


//that is a class that join all funcionalities and instance them

public class InscriptionController {
    IInscriptionModel inscriptionModel = new InscriptionModelImpl();

    public InscriptionEntity createEntity(InscriptionEntity inscriptionEntity) {
        return this.inscriptionModel.createEntity(inscriptionEntity);
    }

    public void delete(int id) {
        this.inscriptionModel.delete(id);
    }

    public List<InscriptionEntity> readAll() {
        return this.inscriptionModel.readAll();
    }

    public InscriptionEntity update(int id, InscriptionEntity inscriptionEntity) {
        return this.inscriptionModel.update(id, inscriptionEntity);

    }

    public Boolean verifyStudentInCourse(int id) {
        return this.inscriptionModel.verifyStudentInCourse(id);
    }

    public Boolean verifyCourseId(int id) {
        return this.inscriptionModel.verifyCourseId(id);
    }

    public Boolean verifyStudentId(int id) {
        return this.inscriptionModel.verifyStudentId(id);
    }

    public Integer verifyQuantityStudent(int id) {
        return this.inscriptionModel.verifyQuantityStudent(id);
    }





    }
