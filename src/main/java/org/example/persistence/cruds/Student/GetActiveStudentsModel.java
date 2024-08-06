package org.example.persistence.cruds.Student;

import java.util.List;

//generic interface that returns a list with the students that are in status Active

public interface GetActiveStudentsModel <Entity>{
    List<Entity> getActiveStudents();
}
