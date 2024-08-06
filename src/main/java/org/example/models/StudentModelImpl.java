package org.example.models;

import org.example.entities.InscriptionEntity;
import org.example.entities.StudentEntity;
import org.example.persistence.configDB.DBConnection;
import org.example.persistence.imodels.IStudentModel;
import org.example.persistence.utils.enums.StateEnum;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//THIS IS A CLASS WITH THE IMPLEMENTATION OF THE FUNCTIONS

public class StudentModelImpl implements IStudentModel {
    @Override
    public StudentEntity createEntity(StudentEntity studentEntity) {        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "INSERT INTO students (state, email, name, apellido, documento) VALUES (?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentEntity.getState().name());
            preparedStatement.setString(2, studentEntity.getEmail());
            preparedStatement.setString(3, studentEntity.getName());
            preparedStatement.setString(4, studentEntity.getApellido());
            preparedStatement.setString(5, studentEntity.getDocumento());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Student created");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{//HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return studentEntity;
    }

    @Override
    public void delete(int id) {        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "DELETE FROM students WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Student deleted");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{//HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<StudentEntity> readAll() {        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        List<StudentEntity> studentEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT * FROM students;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                StateEnum status = StateEnum.valueOf(resultSet.getString("state"));
                StudentEntity studentEntity  = new StudentEntity(
                        resultSet.getInt("id"),
                        status,
                        resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getString("apellido"),
                        resultSet.getString("documento")
                        );
                studentEntities.add(studentEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{//HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return studentEntities;
    }

    @Override
    public StudentEntity getByEmail(String email) {        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();
        StudentEntity studentEntity = null;

        try{
            String sql = "SELECT * FROM students WHERE email = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                StateEnum status = StateEnum.valueOf(resultSet.getString("state"));
                studentEntity  = new StudentEntity(
                        resultSet.getInt("id"),
                        status,
                        resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getString("apellido"),
                        resultSet.getString("documento")
                );
            }else{
                JOptionPane.showMessageDialog(null, "Student not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{//HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return studentEntity;
    }

    @Override
    public StudentEntity getById(int id) {        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();
        StudentEntity studentEntity = null;

        try{
            String sql = "SELECT * FROM students WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                StateEnum status = StateEnum.valueOf(resultSet.getString("state"));
                studentEntity  = new StudentEntity(
                        resultSet.getInt("id"),
                        status,
                        resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getString("apellido"),
                        resultSet.getString("documento")
                );
            }else{
                JOptionPane.showMessageDialog(null, "Student not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{//HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return studentEntity;
    }

    @Override
    public Integer verifyQuantityStudent(int id) {        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();
        StudentEntity studentEntity = null;
        int count = 0;

        try{
            String sql = "SELECT i.id, s.name, s.apellido FROM inscriptions i" +
                    "INNER JOIN students s ON i.student_id = s.id " +
                    "WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                count++;
            }else{
                JOptionPane.showMessageDialog(null, "Student not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{//HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public Boolean verifyStudentExist(int id) {        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT id, name, apellido FROM students WHERE id = ?;";
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
            try{//HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public StudentEntity update(int id, StudentEntity studentEntity) {        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "UPDATE students SET state = ?, email = ?, name = ?, apellido = ?, documento = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentEntity.getState().name());
            preparedStatement.setString(2, studentEntity.getEmail());
            preparedStatement.setString(3, studentEntity.getName());
            preparedStatement.setString(4, studentEntity.getApellido());
            preparedStatement.setString(5, studentEntity.getDocumento());
            preparedStatement.setInt(6, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Student updated");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{//HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return studentEntity;
    }

    @Override        //OPEN THE CONNECTION IN THE BEGIN OF THE FUNCTION

    public List<StudentEntity> getActiveStudents() {
        List<StudentEntity> studentEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();
        StudentEntity studentEntity = null;


        try{
            String sql = "SELECT * FROM students WHERE state = 'Activo';";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                StateEnum status = StateEnum.valueOf(resultSet.getString("state"));
                 studentEntity = new StudentEntity(
                        resultSet.getInt("id"),
                        status,
                        resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getString("apellido"),
                        resultSet.getString("documento")
                );
                 studentEntities.add(studentEntity);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{//HERE DISABLED THE UTILITIES SUCH AS PREPARETED STATEMENT OR THE DATABASE
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return studentEntities;
    }
}
