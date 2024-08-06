package org.example.entities;

import org.example.persistence.utils.enums.StateEnum;

public class StudentEntity {

    //Atributtes

    private int id;
    private StateEnum state;
    private String email;
    private String name;
    private String apellido;
    private String documento;

    //constructors

    public StudentEntity() {
    }

    public StudentEntity(int id, StateEnum state, String email , String name, String apellido, String documento) {
        this.id = id;
        this.state = state;
        this.email = email;
        this.name = name;
        this.apellido = apellido;
        this.documento = documento;
    }

    //getters and setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StateEnum getState() {
        return this.state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", state=" + state +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                "}\n";
    }
}
