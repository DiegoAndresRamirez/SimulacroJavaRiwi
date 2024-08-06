package org.example.persistence.cruds;

//generic interface

public interface CreateModel <Entity>{
    Entity createEntity(Entity entity);
}
