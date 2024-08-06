package org.example.persistence.imodels;

import org.example.entities.CurseEntity;
import org.example.persistence.cruds.*;
import org.example.persistence.cruds.verifyIDs.VerifyStudentIdModel;

//that is an interface that join various necesary interfaces with funcionalities in only one

public interface ICurseModel extends CreateModel<CurseEntity>, DeleteByIdModel, UpdateModel<CurseEntity>, ReadAllModel<CurseEntity>, VerifyDeleteCourseModel, VerifyStudentIdModel {
}
