package org.example.entities;

public class GradeEntity {

    //Atributtes

    private int id;
    private int number_grade;
    private String description;
    private int curse_id;
    private int student_id;

    //constructors


    public GradeEntity() {
    }

    public GradeEntity(int id, int number_grade, String description, int curse_id, int student_id) {
        this.id = id;
        this.number_grade = number_grade;
        this.description = description;
        this.curse_id = curse_id;
        this.student_id = student_id;
    }

    //getters and setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_grade() {
        return this.number_grade;
    }

    public void setNumber_grade(int number_grade) {
        this.number_grade = number_grade;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurse_id() {
        return this.curse_id;
    }

    public void setCurse_id(int curse_id) {
        this.curse_id = curse_id;
    }

    public int getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "GradeEntity{" +
                "id=" + id +
                ", number_grade=" + number_grade +
                ", description='" + description + '\'' +
                ", curse_id=" + curse_id +
                ", student_id=" + student_id +
                "}\n";
    }
}
