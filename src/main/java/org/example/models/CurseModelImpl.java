package org.example.models;

import org.example.entities.CurseEntity;
import org.example.persistence.configDB.DBConnection;
import org.example.persistence.imodels.ICurseModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//THIS IS A CLASS WITH THE IMPLEMENTATION OF THE FUNCTIONS


public class CurseModelImpl implements ICurseModel {
    @Override

    //FUNCTION WITH THE IMPLEMENTATION
    public CurseEntity createEntity(CurseEntity curseEntity) {
        PreparedStatement preparedStatement = null;
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "INSERT INTO curses (name, student_id) VALUES (?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, curseEntity.getName());
            preparedStatement.setInt(2, curseEntity.getStudent_id());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Curse created");
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
        return curseEntity;
    }

    @Override

    //FUNCTION WITH THE IMPLEMENTATION

    public void delete(int id) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "DELETE FROM curses WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Curse deleted");
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

    //FUNCTION WITH THE IMPLEMENTATION

    @Override
    public List<CurseEntity> readAll() {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        List<CurseEntity> curseEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT * FROM curses;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                CurseEntity curseEntity = new CurseEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("student_id")
                        );
                curseEntities.add(curseEntity);
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
        return curseEntities;
    }

    //FUNCTION WITH THE IMPLEMENTATION

    @Override
    public CurseEntity update(int id, CurseEntity curseEntity) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "UPDATE curses SET name = ?, student_id = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, curseEntity.getName());
            preparedStatement.setInt(2, curseEntity.getStudent_id());
            preparedStatement.setInt(3, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Curse Updated");
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
        return curseEntity;
    }
    //FUNCTION WITH THE IMPLEMENTATION


    @Override
    public Boolean verifyDeleteCourse(int id) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT student_id FROM curses WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return false;
            }else{
                return true;
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

    //FUNCTION WITH THE IMPLEMENTATION

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
