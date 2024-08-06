package org.example.models;

import org.example.entities.CurseEntity;
import org.example.entities.GradeEntity;
import org.example.persistence.configDB.DBConnection;
import org.example.persistence.imodels.IGradeModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//THIS IS A CLASS WITH THE IMPLEMENTATION OF THE FUNCTIONS

public class GradeModelImpl implements IGradeModel {
    @Override
    public GradeEntity createEntity(GradeEntity gradeEntity) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "INSERT INTO grades (number_grade, description, curse_id, student_id) VALUES (?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, gradeEntity.getNumber_grade());
            preparedStatement.setString(2, gradeEntity.getDescription());
            preparedStatement.setInt(3, gradeEntity.getCurse_id());
            preparedStatement.setInt(4, gradeEntity.getStudent_id());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Grade created");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

            try{
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return gradeEntity;
    }

    @Override
    public void delete(int id) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "DELETE FROM grades WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Grade deleted");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

            try{
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Integer verifyGrade(int id) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        ResultSet resultSet = null;
        int containerNumber = 0;

        try{
            String sql = "SELECT number_grade FROM grades WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                containerNumber = resultSet.getInt("number_grade");
            }else{
                JOptionPane.showMessageDialog(null, "Grade not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

            try{
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return containerNumber;
    }

    @Override
    public List<GradeEntity> readAll() {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        List<GradeEntity> gradeEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT * FROM grades;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                GradeEntity gradeEntity = new GradeEntity(
                        resultSet.getInt("id"),
                        resultSet.getInt("number_grade"),
                        resultSet.getString("description"),
                        resultSet.getInt("curse_id"),
                        resultSet.getInt("student_id")
                        );
                gradeEntities.add(gradeEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

            try{
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return gradeEntities;
    }

    @Override
    public GradeEntity update(int id, GradeEntity gradeEntity) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "UPDATE curses SET number_grade = ?,  description = ?, curse_id = ?, student_id = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, gradeEntity.getNumber_grade());
            preparedStatement.setString(2, gradeEntity.getDescription());
            preparedStatement.setInt(3, gradeEntity.getCurse_id());
            preparedStatement.setInt(4, gradeEntity.getStudent_id());
            preparedStatement.setInt(5, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Grade Updated");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

            try{
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return gradeEntity;
    }

    @Override
    public Boolean verifyCourseId(int id) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT id FROM curses WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

            try{
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Boolean verifyStudentId(int id) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT id FROM students WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

            try{
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
