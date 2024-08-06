package org.example.entities;

import java.sql.Date;

public class InscriptionEntity {

    //Atributtes

    private int id;
    private int curse_id;
    private int student_id;
    private Date date_inscription;


    //constructors

    public InscriptionEntity() {
    }

    public InscriptionEntity(int id, int curse_id, int student_id, Date date_inscription) {
        this.id = id;
        this.curse_id = curse_id;
        this.student_id = student_id;
        this.date_inscription = date_inscription;
    }

    //getters and setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate_inscription() {
        return this.date_inscription;
    }

    public void setDate_inscription(Date date_inscription) {
        this.date_inscription = date_inscription;
    }

    @Override
    public String toString() {
        return "InscriptionEntity{" +
                "id=" + id +
                ", curse_id=" + curse_id +
                ", student_id=" + student_id +
                ", date_inscription=" + date_inscription +
                "}\n";
    }
}
