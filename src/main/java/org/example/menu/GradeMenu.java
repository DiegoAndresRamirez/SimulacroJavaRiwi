package org.example.menu;

import org.example.controllers.GradeController;
import org.example.entities.CurseEntity;
import org.example.entities.GradeEntity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GradeMenu {
    private static GradeController gradeController = new GradeController();

    public static void Menu(){
        //repeated variables

        //final variables to instance the only one time
        int id = 0;
        int number_grade = 0;
        int number_gradeOther = 0;
        String description = "";
        int curso_id = 0;
        int curso_idOther = 0;
        int student_id = 0;
        int student_idOther = 0;
        GradeEntity gradeEntity = null;
        List<GradeEntity> gradeEntities;
        int countGrades = 0;



        //test variables to validations
        String idInput;
        String number_gradeInput;
        String descriptionInput;
        String curso_idInput;
        String student_idInput;

        //Booleans to continue the loops

        Boolean booleanLoop = true;
        Boolean booleanLoop2 = true;
        Boolean booleanLoop3 = true;
        Boolean booleanLoop4 = true;
        Boolean booleanLoop5 = true;




        Boolean runningGrade = true;

        while(runningGrade){

            String OptionGrade = JOptionPane.showInputDialog(null, "Enter an option:  \n\n1: Create\n2: Delete By Id\n3: Read All\n4: Update By Id\n5: Read the Number Grades\n6: Exit");

            //simple menu with all funcionalities of the entity

            switch (OptionGrade){
                //FUNCTION TO EXIT TO THE LOOP
                case ("6") ->{
                    //that option close the loop and return to the main menu

                    JOptionPane.showMessageDialog(null, "Go to main menu...");
                    return;
                }

                //FUNCTION TO CREATE A ENTITY
                case ("1") ->{
                    //here the user give the information about the grades

                    while (booleanLoop) {
                        number_gradeInput = JOptionPane.showInputDialog(null, "Enter the grades of the Student:  ");
                        if(number_gradeInput != null){
                            number_gradeOther = Integer.parseInt(number_gradeInput);
                            if(number_gradeOther >= 0 && number_gradeOther <= 100){
                                number_grade = number_gradeOther;
                                booleanLoop = false;
                            }else{
                                JOptionPane.showMessageDialog(null, "The grade could be a number between 0 and 100...");
                                return;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }
                    //all with loops to repeat the process

                    while (booleanLoop2){
                        descriptionInput = JOptionPane.showInputDialog(null, "Enter a description to the grade:  ");
                        if(descriptionInput != null ){
                            description = descriptionInput;
                            booleanLoop2 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop3){
                        curso_idInput = JOptionPane.showInputDialog(null, "Enter the id of the curse:  ");
                        if(curso_idInput != null && !curso_idInput.equalsIgnoreCase("0")){
                            curso_idOther = Integer.parseInt(curso_idInput);
                            Boolean verify = gradeController.verifyCourseId(curso_idOther);
                            if(verify){
                                curso_id = curso_idOther;
                                booleanLoop3 = false;
                            }else{
                                JOptionPane.showMessageDialog(null, "Course not found");
                                return;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop4){
                        student_idInput = JOptionPane.showInputDialog(null, "Enter the id of the student:  ");
                        if(student_idInput != null && !student_idInput.equalsIgnoreCase("0")){
                            student_idOther = Integer.parseInt(student_idInput);
                            Boolean verify = gradeController.verifyStudentId(student_idOther);
                            if(verify) {
                                student_id = student_idOther;
                                booleanLoop2 = false;
                            }else{
                                JOptionPane.showMessageDialog(null, "Student not found");
                                return;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    gradeEntity = new GradeEntity(0, number_grade, description, curso_id, student_id);
                    gradeController.createEntity(gradeEntity);

                }

                //FUNCTION TO DELETE BY ID
                case ("2") ->{

                    booleanLoop = true;


                    while(booleanLoop) {
                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the grade that you wanna delete:  ");
                        if(idInput != null && !idInput.equalsIgnoreCase("0")){
                            id = Integer.parseInt(idInput);
                            booleanLoop = false;
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }
                    gradeController.delete(id);

                }

                //FUNCTION TO READ ALL ENTITIES

                case ("3") ->{

                    gradeEntities = gradeController.readAll();
                    String listString = "";
                    for (GradeEntity ge : gradeEntities){
                        listString += ge.toString();
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

                    while(booleanLoop) {
                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the grade that you wanna update:  ");
                        if(idInput != null && !idInput.equalsIgnoreCase("0")){
                            id = Integer.parseInt(idInput);
                            booleanLoop = false;
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop2) {
                        number_gradeInput = JOptionPane.showInputDialog(null, "Enter the grades of the Student:  ");
                        if(number_gradeInput != null){
                            number_grade = Integer.parseInt(number_gradeInput);
                            booleanLoop2 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop3){
                        descriptionInput = JOptionPane.showInputDialog(null, "Enter a description to the grade:  ");
                        if(descriptionInput != null ){
                            description = descriptionInput;
                            booleanLoop3 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop4){
                        curso_idInput = JOptionPane.showInputDialog(null, "Enter the id of the curse:  ");
                        if(curso_idInput != null && !curso_idInput.equalsIgnoreCase("0")){
                            curso_idOther = Integer.parseInt(curso_idInput);
                            Boolean verify = gradeController.verifyCourseId(curso_idOther);
                            if(verify){
                                curso_id = curso_idOther;
                                booleanLoop3 = false;
                            }else{
                                JOptionPane.showMessageDialog(null, "Course not found");
                                return;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop5){
                        student_idInput = JOptionPane.showInputDialog(null, "Enter the id of the student:  ");
                        if(student_idInput != null && !student_idInput.equalsIgnoreCase("0")){
                            student_idOther = Integer.parseInt(student_idInput);
                            Boolean verify = gradeController.verifyStudentId(student_idOther);
                            if(verify) {
                                student_id = student_idOther;
                                booleanLoop2 = false;
                            }else{
                                JOptionPane.showMessageDialog(null, "Student not found");
                                return;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    gradeEntity = new GradeEntity(0, number_grade, description, curso_id, student_id);

                    gradeController.update(id, gradeEntity);

                }

                //FUNCTION TO SEE THE GRADES OF AN ENTITY
                case ("5") ->{
                    booleanLoop = true;


                    while(booleanLoop) {
                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the grade that you wanna see the numbers grade's:  ");
                        if(idInput != null || !idInput.equalsIgnoreCase("0")){
                            id = Integer.parseInt(idInput);
                            booleanLoop = false;
                        }else if(idInput.equalsIgnoreCase("0")){
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    if(id != 0){
                        countGrades = gradeController.verifyGrade(id);
                        JOptionPane.showMessageDialog(null, "The numbers grade's are: " + countGrades + " ...");
                    }else{
                        JOptionPane.showMessageDialog(null, "Try Again...");
                        return;

                    }

                }
            }

        }

    }
}
