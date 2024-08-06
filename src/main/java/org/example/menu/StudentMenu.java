package org.example.menu;

import org.example.controllers.StudentController;
import org.example.entities.InscriptionEntity;
import org.example.entities.StudentEntity;
import org.example.persistence.utils.enums.StateEnum;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentMenu {
    private static StudentController studentController = new StudentController();

    public static void Menu(){
        //repeated variables

        //final variables to instance the only one time
        int id = 0;
        StateEnum state = StateEnum.Activo;
        String email = "";
        String name = "";
        String apellido = "";
        String documento = "";
        StudentEntity studentEntity = null;
        List<StudentEntity> studentEntities = new ArrayList<>();
        int countGrades = 0;

        //test variables to validations
        String idInput;
        String stateInput;
        String emailInput;
        String curse_idInput;
        String nameInput;
        String apellidoInput;
        String documentoInput;

        //Booleans to continue the loops
        Boolean booleanLoop = true;
        Boolean booleanLoop2 = true;
        Boolean booleanLoop3 = true;
        Boolean booleanLoop4 = true;
        Boolean booleanLoop5 = true;
        Boolean booleanLoop6 = true;




        Boolean runningStudent = true;

        while(runningStudent){

            String OptionStudent = JOptionPane.showInputDialog(null, "Enter an option:  \n\n1: Create\n2: Delete By Id\n3: Read All\n4: Update By Id\n5: Read by Id\n6: Read by Email\n7: Read Inscriptions by Student\n8: Verify if a Student exists\n9 Read Active Students\n10: Exit");

            //simple menu with all funcionalities of the entity

            //FUNCTION TO EXIT TO THE LOOP
            switch (OptionStudent){
                case ("10") ->{
                    //that option close the loop and return to the main menu

                    JOptionPane.showMessageDialog(null, "Go to main menu...");
                    return;
                }

                //FUNCTION TO CREATE AN ENTITY
                case ("1") ->{

                    //here the user give the information about the student

                    while (booleanLoop){
                        stateInput = JOptionPane.showInputDialog(null, "Enter the state of the Student: (Activo / Inactivo) ");
                        if(stateInput != null && stateInput.equalsIgnoreCase("Activo") || stateInput != null &&  stateInput.equalsIgnoreCase("Inactivo")){
                            try{
                                state = StateEnum.valueOf(stateInput);
                                booleanLoop = false;
                            }catch (IllegalArgumentException i){
                                i.printStackTrace();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }
                    //all with loops to repeat the process

                    while (booleanLoop2){
                        emailInput = JOptionPane.showInputDialog(null, "Enter a email to the Student:  ");
                        if(emailInput != null ){
                            email = emailInput;
                            booleanLoop2 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }


                    while (booleanLoop3){
                        nameInput = JOptionPane.showInputDialog(null, "Enter a name to the Student:  ");
                        if(nameInput != null ){
                            name = nameInput;
                            booleanLoop3 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop4){
                        apellidoInput = JOptionPane.showInputDialog(null, "Enter a lastname to the Student:  ");
                        if(apellidoInput != null ){
                            apellido = apellidoInput;
                            booleanLoop4 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop5){
                        documentoInput = JOptionPane.showInputDialog(null, "Enter a document to the Student:  ");
                        if(documentoInput != null ){
                            documento = documentoInput;
                            booleanLoop5 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }


                    studentEntity = new StudentEntity(0, state, email, name, apellido, documento);
                    studentController.createEntity(studentEntity);

                }

                //FUNCTION TO DELETE AN ENTITY BY ID
                case ("2") ->{

                    booleanLoop = true;


                    while(booleanLoop) {
                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the inscription that you wanna delete:  ");
                        if(idInput != null && !idInput.equalsIgnoreCase("0")){
                            id = Integer.parseInt(idInput);
                            booleanLoop = false;
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }
                    studentController.delete(id);

                }

                //FUNCTION TO READ ALL ENTITIES
                case ("3") ->{

                    studentEntities = studentController.readAll();
                    String listString = "";
                    for (StudentEntity se : studentEntities){
                        listString += se.toString();
                    }
                    JOptionPane.showMessageDialog(null, listString);
                }

                //FUNCTION TO UPDATE AN ENTITY
                case ("4") ->{

                    booleanLoop = true;
                    booleanLoop2 = true;
                    booleanLoop3 = true;
                    booleanLoop4 = true;
                    booleanLoop5 = true;
                    booleanLoop6 = true;

                    while(booleanLoop) {
                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the student that you wanna update:  ");
                        if(idInput != null && !idInput.equalsIgnoreCase("0")){
                            id = Integer.parseInt(idInput);
                            booleanLoop = false;
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop2){
                        stateInput = JOptionPane.showInputDialog(null, "Enter the state of the Student:  (Activo, Inactivo)");
                        if(stateInput != null && stateInput.equalsIgnoreCase("Activo") && stateInput.equalsIgnoreCase("Inactivo")){
                            try{
                                state = StateEnum.valueOf(stateInput);
                                booleanLoop2 = false;
                            }catch (IllegalArgumentException i){
                                i.printStackTrace();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop3){
                        emailInput = JOptionPane.showInputDialog(null, "Enter a email to the Student:  ");
                        if(emailInput != null ){
                            email = emailInput;
                            booleanLoop3 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop4){
                        nameInput = JOptionPane.showInputDialog(null, "Enter a name to the Student:  ");
                        if(nameInput != null ){
                            name = nameInput;
                            booleanLoop4 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop5){
                        emailInput = JOptionPane.showInputDialog(null, "Enter a email to the Student:  ");
                        if(emailInput != null ){
                            email = emailInput;
                            booleanLoop5 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop6){
                        documentoInput = JOptionPane.showInputDialog(null, "Enter a document to the Student:  ");
                        if(documentoInput != null ){
                            documento = documentoInput;
                            booleanLoop6 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    studentEntity = new StudentEntity(0, state, email, name, apellido, documento);

                    studentController.update(id, studentEntity);
                }

                //FUNCTION TO READ AN ENTITY BY ID
                case ("5") ->{

                    booleanLoop = true;


                    while(booleanLoop) {
                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the student that you wanna see:  ");
                        if(idInput != null && !idInput.equalsIgnoreCase("0")){
                            id = Integer.parseInt(idInput);
                            booleanLoop = false;
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }
                    studentEntity = studentController.getById(id);
                    JOptionPane.showMessageDialog(null, studentEntity);

                }

                //FUNCTION TO READ AN ENTITY BY EMAIL

                case ("6") ->{

                    booleanLoop = true;


                    while(booleanLoop) {
                        emailInput = JOptionPane.showInputDialog(null, "Enter the email of the student that you wanna see:  ");
                        if(emailInput != null){
                            email = emailInput;
                            booleanLoop = false;
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }
                    studentEntity = studentController.getByEmail(email);
                    JOptionPane.showMessageDialog(null, studentEntity.toString());

                }

                //FUNCTION TO VERIFY HOW MUCH INSCRIPTIONS HAS AN STUDENT

                case ("7") ->{

                    booleanLoop = true;


                    while(booleanLoop) {
                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the student that you wanna see his inscriptions:  ");
                        if(idInput != null && !idInput.equalsIgnoreCase("0")){
                            id = Integer.parseInt(idInput);
                            booleanLoop = false;
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }
                    int Quantity = studentController.verifyQuantityStudent(id);
                    JOptionPane.showMessageDialog(null, "The times are : " + Quantity + " ...");

                }

                //FUNCTION TO KNOW IF AN ENTITY EXIST IN THE DATABASE

                case ("8") ->{

                    booleanLoop = true;


                    while(booleanLoop) {
                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the student that you wanna know that exist:  ");
                        if(idInput != null && !idInput.equalsIgnoreCase("0")){
                            id = Integer.parseInt(idInput);
                            booleanLoop = false;
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }
                    Boolean exist = studentController.verifyStudentExist(id);
                    if(exist){
                        JOptionPane.showMessageDialog(null, "The student exists!");
                    }else{
                        JOptionPane.showMessageDialog(null, "The student not exists");
                        return;
                    }
                }

                //FUNCTION TO READ A LIST WITH ALL STUDENT WITH THE STATUS "ACTIVE";

                case ("9") ->{
                    studentEntities = studentController.getActiveStudents();
                    String listStudents = "";
                    for (StudentEntity se : studentEntities){
                        listStudents += se;
                    }
                    JOptionPane.showMessageDialog(null, listStudents.toString());
                }
            }
        }
    }
}
