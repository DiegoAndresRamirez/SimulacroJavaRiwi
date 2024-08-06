package org.example.persistence.cruds;

import java.util.List;

//generic interface that returns a list

public interface ReadAllModel <Entity>{
    List<Entity> readAll();
}
