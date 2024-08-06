package org.example.entities;


public class CurseEntity {

    //Atributtes

    private int id;
    private String name;
    private int student_id;

    //constructors

    public CurseEntity() {
    }

    public CurseEntity(int id, String name, int student_id) {
        this.id = id;
        this.name = name;
        this.student_id = student_id;
    }

    //getters and setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "CurseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student_id=" + student_id +
                "}\n";
    }
}
