package org.example.persistence.cruds.Student;

import java.util.List;

//generic interface that returns a list with any entity through an email


public interface GetByEmailModel <Entity>{
    Entity getByEmail(String email);
}
