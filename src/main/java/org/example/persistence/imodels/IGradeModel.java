package org.example.persistence.imodels;

import org.example.entities.GradeEntity;
import org.example.persistence.cruds.CreateModel;
import org.example.persistence.cruds.DeleteByIdModel;
import org.example.persistence.cruds.Grade.VerifyGradeModel;
import org.example.persistence.cruds.ReadAllModel;
import org.example.persistence.cruds.UpdateModel;
import org.example.persistence.cruds.verifyIDs.VerifyCourseIdModel;
import org.example.persistence.cruds.verifyIDs.VerifyStudentIdModel;

//that is an interface that join various necesary interfaces with funcionalities in only one


public interface IGradeModel extends CreateModel<GradeEntity>, DeleteByIdModel, UpdateModel<GradeEntity>, ReadAllModel<GradeEntity>, VerifyGradeModel , VerifyStudentIdModel, VerifyCourseIdModel {
}
