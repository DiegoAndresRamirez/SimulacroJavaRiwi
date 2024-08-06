package org.example.models;

import org.example.entities.GradeEntity;
import org.example.entities.InscriptionEntity;
import org.example.persistence.configDB.DBConnection;
import org.example.persistence.imodels.IInscriptionModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//THIS IS A CLASS WITH THE IMPLEMENTATION OF THE FUNCTIONS

public class InscriptionModelImpl implements IInscriptionModel {
    @Override
    public InscriptionEntity createEntity(InscriptionEntity inscriptionEntity) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "INSERT INTO inscriptions (curse_id, student_id , date_inscription) VALUES (?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, inscriptionEntity.getCurse_id());
            preparedStatement.setInt(2, inscriptionEntity.getStudent_id());
            preparedStatement.setDate(3, inscriptionEntity.getDate_inscription());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Inscription created");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return inscriptionEntity;
    }

    @Override
    public void delete(int id) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "DELETE FROM inscriptions WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Inscription deleted");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<InscriptionEntity> readAll() {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        List<InscriptionEntity> inscriptionEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT * FROM inscriptions;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                InscriptionEntity inscriptionEntity  = new InscriptionEntity(
                        resultSet.getInt("id"),
                        resultSet.getInt("curse_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getDate("date_inscription")
                );
                inscriptionEntities.add(inscriptionEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return inscriptionEntities;
    }

    @Override
    public InscriptionEntity update(int id, InscriptionEntity inscriptionEntity) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "UPDATE inscriptions SET curse_id = ?,  student_id = ?, date_inscription ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, inscriptionEntity.getCurse_id());
            preparedStatement.setInt(2, inscriptionEntity.getStudent_id());
            preparedStatement.setDate(3, inscriptionEntity.getDate_inscription());
            preparedStatement.setInt(4, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Inscription Updated");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return inscriptionEntity;
    }

    @Override
    public Boolean verifyStudentInCourse(int id) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        ResultSet resultSet = null;

        try{
            String sql = "SELECT students_id FROM curses WHERE id = ?;";
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
            try{            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

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
            try{            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

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
            try{            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

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
    public Integer verifyQuantityStudent(int id) {
        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();
        int counter = 0;

        try{
            String sql = "SELECT student_id FROM inscriptions WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{            //HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE

                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return counter;
    }
}