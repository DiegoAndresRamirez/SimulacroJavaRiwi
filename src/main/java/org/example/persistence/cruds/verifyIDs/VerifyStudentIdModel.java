package org.example.persistence.cruds.verifyIDs;

//this interface receive an id, and you can use it to verify if exist an id in the database

public interface VerifyStudentIdModel {
    Boolean verifyStudentId(int id);
}
