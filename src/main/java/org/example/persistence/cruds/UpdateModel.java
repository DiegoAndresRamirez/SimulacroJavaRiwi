package org.example.persistence.cruds;

//generic interface


public interface UpdateModel<Entity> {
    Entity  update(int id, Entity entity);
}
