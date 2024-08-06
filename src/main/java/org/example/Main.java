package org.example;

import org.example.controllers.InscriptionController;
import org.example.menu.CurseMenu;
import org.example.menu.GradeMenu;
import org.example.menu.InscriptionMenu;
import org.example.menu.StudentMenu;
import org.example.persistence.configDB.DBConnection;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //flag to the loop
        Boolean running = true;

        while (running){

            //open connection
            DBConnection.getConnection();

            String Option = JOptionPane.showInputDialog(null, "Enter an option:  \n\n1: Curse\n2: Grade\n3: Inscription\n4: Student\n5: Exit");

            //simple menu with instances of menus outside
            switch (Option){
                case ("5") ->{
                    JOptionPane.showMessageDialog(null, "GoodBye...");
                    return;
                }
                case ("1") ->{
                    CurseMenu.Menu();
                }
                case ("2") ->{
                    GradeMenu.Menu();
                }
                case ("3") ->{
                    InscriptionMenu.Menu();
                }
                case ("4") ->{
                    StudentMenu.Menu();
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Enter a valid option...");
                    DBConnection.closeConnection();
                }
            }
        }
    }
}