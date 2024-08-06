package org.example.menu;

import org.example.controllers.CurseController;
import org.example.entities.CurseEntity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CurseMenu {
    private static CurseController curseController = new CurseController();

    public static void Menu(){
        //repeated variables

        //final variables to instance the only one time
        int id = 0;
        int idOther = 0;
        String name = "";
        int student_id = 0;
        int student_idOther = 0;
        CurseEntity curseEntity = null;
        List<CurseEntity> curseEntities = new ArrayList<>();


        //test variables to validations
        String idInput;
        String nameInput;
        String student_idInput;

        //Booleans to continue the loops
        Boolean booleanLoop = true;
        Boolean booleanLoop2 = true;
        Boolean booleanLoop3 = true;




        Boolean runningCurse = true;

        while(runningCurse){

            String OptionCurse = JOptionPane.showInputDialog(null, "Enter an option:  \n\n1: Create\n2: Delete By Id\n3: Read All\n4: Update By Id\n5: Exit");

            //simple menu with all funcionalities of the entity

            switch (OptionCurse){

                //FUNCTION TO EXIT TO THE LOOP
                case ("5") ->{
                    //that option close the loop and return to the main menu
                    JOptionPane.showMessageDialog(null, "Go to main menu...");
                    return;
                }

                //FUNCTION TO CREATE
                case ("1") ->{

                    //here the user give the information about the course
                    while (booleanLoop) {
                        nameInput = JOptionPane.showInputDialog(null, "Enter the name of the curse:  ");
                        if (nameInput != null){
                            name = nameInput;
                            booleanLoop = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    //all with loops to repeat the process
                    while (booleanLoop2){

                        //this is a validation to verify the id that enter the user;
                        student_idInput = JOptionPane.showInputDialog(null, "Enter the id of the student:  ");
                        if(student_idInput != null && !student_idInput.equalsIgnoreCase("0")){
                            student_idOther = Integer.parseInt(student_idInput);
                            Boolean verify = curseController.verifyStudentId(student_idOther);
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

                    curseEntity = new CurseEntity(0 , name, student_id);
                    curseController.createEntity(curseEntity);

                }

                //FUNCTION TO DELETE BY ID
                case ("2") ->{
                    booleanLoop = true;


                    while(booleanLoop) {
                        //this is a validation to verify the id that enter the user;

                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the curse that you wanna delete:  ");
                        if(idInput != null && !idInput.equalsIgnoreCase("0")){
                            idOther = Integer.parseInt(idInput);
                            Boolean verify = curseController.verifyDeleteCourse(idOther);
                            if(verify){
                                id = idOther;
                                booleanLoop = false;
                            }else{
                                JOptionPane.showMessageDialog(null, "You can't delete this course, because it has students");
                                return;
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                        }
                    }
                    curseController.delete(id);

                }

                //FUNCTION TO READ ALL ENTITIES
                case ("3") ->{
                    curseEntities = curseController.readAll();
                    String listString = "";
                    for (CurseEntity cs : curseEntities){
                        listString += cs.toString();
                    }
                    JOptionPane.showMessageDialog(null, listString);
                }

                //FUNCTION TO UPDATE A ENTITY
                case ("4") ->{
                    booleanLoop = true;
                    booleanLoop2 = true;
                    booleanLoop3 = true;


                    while(booleanLoop) {
                        //this is a validation to verify the id that enter the user;

                        idInput = JOptionPane.showInputDialog(null, "Enter the id of the curse that you wanna update:  ");
                        if(idInput != null && !idInput.equalsIgnoreCase("0")){
                            id = Integer.parseInt(idInput);
                            booleanLoop = false;
                        }else {
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop2) {
                        nameInput = JOptionPane.showInputDialog(null, "Enter the name of the curse:  ");
                        if (nameInput != null){
                            name = nameInput;
                            booleanLoop2 = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Try Again...");
                            return;
                        }
                    }

                    while (booleanLoop3){
                        //this is a validation to verify the id that enter the user;

                        student_idInput = JOptionPane.showInputDialog(null, "Enter the id of the student:  ");
                        if(student_idInput != null && !student_idInput.equalsIgnoreCase("0")){
                            student_idOther = Integer.parseInt(student_idInput);
                            Boolean verify = curseController.verifyStudentId(student_idOther);
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

                    curseEntity = new CurseEntity(0 , name, student_id);
                    curseController.update(id, curseEntity);
                }
            }

        }

    }
}
