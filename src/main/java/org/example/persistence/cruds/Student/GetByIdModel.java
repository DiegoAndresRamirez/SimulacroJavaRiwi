package org.example.persistence.cruds.Student;

//generic interface that returns a list with any entity through an id


public interface GetByIdModel <Entity> {
    Entity getById(int id);
}
