package org.example.persistence.imodels;

import org.example.entities.StudentEntity;
import org.example.persistence.cruds.CreateModel;
import org.example.persistence.cruds.DeleteByIdModel;
import org.example.persistence.cruds.ReadAllModel;
import org.example.persistence.cruds.Student.*;
import org.example.persistence.cruds.UpdateModel;

//that is an interface that join various necesary interfaces with funcionalities in only one


public interface IStudentModel extends CreateModel<StudentEntity>, DeleteByIdModel, ReadAllModel<StudentEntity>, UpdateModel<StudentEntity>, GetByIdModel<StudentEntity>, GetByEmailModel<StudentEntity>, VerifyQuantityStudentsModel, VerifyStudentExistModel, GetActiveStudentsModel<StudentEntity> {
}
