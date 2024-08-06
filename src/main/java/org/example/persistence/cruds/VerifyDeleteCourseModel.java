package org.example.persistence.cruds;

//only receive an id, you can use it to verify if the course has students

public interface VerifyDeleteCourseModel {
    Boolean verifyDeleteCourse(int id);
}
