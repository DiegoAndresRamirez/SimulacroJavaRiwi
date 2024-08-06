package org.example.menu;

import org.example.controllers.InscriptionController;
import org.example.entities.GradeEntity;
import org.example.entities.InscriptionEntity;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InscriptionMenu {
    private static InscriptionController inscriptionController = new InscriptionController();

    public static void Menu(){
        //repeated variables

        //final variables to instance the only one time
        int id = 0;
        int curse_id = 0;
        int curse_idOther = 0;
        int student_id = 0;
        int student_idOther = 0;
        int student_Inscription = 0;
        Date date_inscription = null;
        InscriptionEntity inscriptionEntity = null;
        List<InscriptionEntity> inscriptionEntities = new ArrayList<>();
        int countGrades = 0;

        //test variables to validations
        String idInput;
        String curse_idInput;
        String student_idInput;
        String date_inscriptionInput;

        //Booleans to continue the loops

        Boolean booleanLoop = true;
        Boolean booleanLoop2 = true;
        Boolean booleanLoop3 = true;
        Boolean booleanLoop4 = true;
        Boolean booleanLoop5 = true;


        Boolean runningInscription = true;

        while(runningInscription){

            String OptionInscription = JOptionPane.showInputDialog(null, "Enter an option:  \n\n1: Create\n2: Delete By Id\n3: Read All\n4: Update By Id\n5: Exit");

            //simple menu with all funcionalities of the entity

            switch (OptionInscription){

                //FUNCTION TO EXIT TO THE LOOP
                case ("5") ->{
                    //that option close the loop and return to the main menu

                    JOptionPane.showMessageDialog(null, "Go to main menu...");
                    return;
                }

                //FUNCTION TO CREATE AN INSCRIPTION
                case ("1") ->{

                    //here the user give the information about the inscription

                    while (booleanLoop){
                        curse_idInput = JOptionPane.showInputDialog(null, "Enter the id of the curse:  ");
                        if(curse_idInput != null && !curse_idInput.equalsIgnoreCase("0")){
                            curse_idOther = Integer.parseInt(curse_idInput);
                            Boolean verify = inscriptionController.verifyCourseId(curse_idOther);
                            if(verify){
                                curse_id = curse_idOther;
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
                    //all with loops to repeat the process

                    while (booleanLoop2){
                        student_idInput = JOptionPane.showInputDialog(null, "Enter the id of the student:  ");
                        if(student_idInput != null && !student_idInput.equalsIgnoreCase("0")){
                            student_idOther = Integer.parseInt(student_idInput);
                            Boolean verify = inscriptionController.verifyStudentInCourse(student_idOther);
                            if(verify){
                                student_Inscription = student_idOther;
                                int counter = inscriptionController.verifyQuantityStudent(student_Inscription);
                                if(counter > 3){
                                    JOptionPane.showMessageDialog(null, "The student exceded the limit od inscriptions...");
                                    return;
                                }else{
                                    student_id = student_Inscription;
                                    booleanLoop2 = false;
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "The student already is in the Course...");
                                return;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop3){
                        date_inscriptionInput = JOptionPane.showInputDialog(null, "Enter the date that you applied:  (YYYY-MM-DD)");
                        try{
                            date_inscription = Date.valueOf(date_inscriptionInput);
                            booleanLoop3 = false;
                        }catch (IllegalArgumentException i){
                            i.printStackTrace();
                        }
                    }

                    inscriptionEntity = new InscriptionEntity(0, curse_id, student_id, date_inscription);
                    inscriptionController.createEntity(inscriptionEntity);

                }

                //FUNCTION TO DELETE AN INSCRIPTION BY ID
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
                    inscriptionController.delete(id);

                }

                //FUNCTION TO READ ALL INSCRIPTION
                case ("3") ->{

                    inscriptionEntities = inscriptionController.readAll();
                    String listString = "";
                    for (InscriptionEntity ie : inscriptionEntities){
                        listString += ie.toString();
                    }
                    JOptionPane.showMessageDialog(null, listString);
                }

                //FUNCTION TO UPDATE AN INSCRIPTION
                case ("4") ->{

                    booleanLoop = true;
                    booleanLoop2 = true;
                    booleanLoop3 = true;
                    booleanLoop4 = true;


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

                    while (booleanLoop2){
                        curse_idInput = JOptionPane.showInputDialog(null, "Enter the id of the curse:  ");
                        if(curse_idInput != null && !curse_idInput.equalsIgnoreCase("0")){
                            curse_idOther = Integer.parseInt(curse_idInput);
                            Boolean verify = inscriptionController.verifyCourseId(curse_idOther);
                            if(verify){
                                curse_id = curse_idOther;
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

                    while (booleanLoop3){
                        student_idInput = JOptionPane.showInputDialog(null, "Enter the id of the student:  ");
                        if(student_idInput != null && !student_idInput.equalsIgnoreCase("0")){
                            student_idOther = Integer.parseInt(student_idInput);
                            Boolean verify = inscriptionController.verifyStudentInCourse(student_idOther);
                            if(verify){
                                student_id = student_idOther;
                                booleanLoop2 = false;
                            }else{
                                JOptionPane.showMessageDialog(null, "The student already is in the Course...");
                                return;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop4){
                        date_inscriptionInput = JOptionPane.showInputDialog(null, "Enter the date that you applied:  (YYYY-MM-DD)");
                        try{
                            date_inscription = Date.valueOf(date_inscriptionInput);
                            booleanLoop4 = false;
                        }catch (IllegalArgumentException i){
                            i.printStackTrace();
                        }
                    }

                    inscriptionEntity = new InscriptionEntity(0, curse_id, student_id, date_inscription);

                    inscriptionController.update(id, inscriptionEntity);

                }
            }
        }
    }
}
