package org.example.persistence.imodels;

import org.example.entities.InscriptionEntity;
import org.example.persistence.cruds.CreateModel;
import org.example.persistence.cruds.DeleteByIdModel;
import org.example.persistence.cruds.Inscription.VerifyStudentInCourseModel;
import org.example.persistence.cruds.ReadAllModel;
import org.example.persistence.cruds.Student.VerifyQuantityStudentsModel;
import org.example.persistence.cruds.UpdateModel;
import org.example.persistence.cruds.verifyIDs.VerifyCourseIdModel;
import org.example.persistence.cruds.verifyIDs.VerifyStudentIdModel;

//that is an interface that join various necesary interfaces with funcionalities in only one


public interface IInscriptionModel extends CreateModel<InscriptionEntity>, DeleteByIdModel, UpdateModel<InscriptionEntity>, ReadAllModel<InscriptionEntity> , VerifyStudentInCourseModel , VerifyCourseIdModel, VerifyStudentIdModel, VerifyQuantityStudentsModel {
}
