package services;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */

import Models.admission;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class admissionDAO {
    private Connection connection;

    public admissionDAO() {
        String url = "jdbc:mysql://localhost:3306/khademni";
        String user = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<admission> getAll() {
    List<admission> admissions = new ArrayList<>();
    String query = "SELECT * FROM application";

    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            int num = resultSet.getInt("num");
            String role = resultSet.getString("role");
            String result = resultSet.getString("result");

            admission admission1 = new admission( id, name, num ,role ,result);
            admissions.add(admission1);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return admissions;
}

    public admission getById(int id) {
        String query = "SELECT * FROM application WHERE id = ?";

        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        
                        String name = resultSet.getString("name");
                        int num = resultSet.getInt("num");
                        String role = resultSet.getString("role");
                        String result = resultSet.getString("result");
                        admission admission2;
                        admission2 = new admission(id , name, num, role, result);
                        return admission2;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addAdmission(admission admission) {
        String query = "INSERT INTO admission (id,name,num,role,result) VALUES (?,?,?,?,?)";

        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, admission.getId());
                preparedStatement.setString(2, admission.getName());
                preparedStatement.setInt(3, admission.getNum());
                preparedStatement.setString(4, admission.getRole());
                preparedStatement.setString(5, admission.getResult());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdmission(admission admission) {
        String query = "UPDATE admission SET name = ?, num = ? , role = ?, result = ? WHERE id = ?";

       try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, admission.getId());
                preparedStatement.setString(2, admission.getName());
                preparedStatement.setInt(3, admission.getNum());
                preparedStatement.setString(4, admission.getRole());
                preparedStatement.setString(5, admission.getResult());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void deleteAdmission(int id) {
    String query = "DELETE FROM admission WHERE id = ?";

    try {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}