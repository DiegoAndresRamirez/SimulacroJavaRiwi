package org.example.persistence.cruds.Student;

//this interface you can use it to verify if exist a student in the database


public interface VerifyStudentExistModel{
    Boolean verifyStudentExist(int id);
}
