package services;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
import Models.application;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class applicationDAO {
    private Connection connection;
     private static String url="jdbc:mysql://localhost:3306/khademni";
    private static String login="root";
    private static String pwd="";
    private static Statement ste;


    public applicationDAO() {

        try {
            connection = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<application> getAll() {
    List<application> applications = new ArrayList<>();
    String query = "SELECT * FROM application";

    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            int num = resultSet.getInt("num");
            String role = resultSet.getString("role");
            String document = resultSet.getString("document");

            application application1 = new application(id , name, num, role, document);
            applications.add(application1);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return applications;
}

    public application getById(int id) {
        String query = "SELECT * FROM application WHERE id = ?";

        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        
                        String name = resultSet.getString("name");
                        int num = resultSet.getInt("num");
                        String role = resultSet.getString("role");
                        String document = resultSet.getString("document");
                        application application2;
                        application2 = new application(id,name,num,role,document);
                        return application2;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addApplication(application application) {
        String query = "INSERT INTO application (id,name,num,role,document) VALUES (?,?,?,?,?)";

        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, application.getId());
                preparedStatement.setString(2, application.getName());
                preparedStatement.setInt(3, application.getNum());
                preparedStatement.setString(4, application.getRole());
                preparedStatement.setString(5, application.getDocument());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateApplication(application application) {
        String query = "UPDATE application SET name = ?, num = ? , role = ?, document = ? WHERE id = ?";

       try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, application.getId());
                preparedStatement.setString(2, application.getName());
                preparedStatement.setInt(3, application.getNum());
                preparedStatement.setString(4, application.getRole());
                preparedStatement.setString(5, application.getDocument());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void deleteApplication(int id) {
    String query = "DELETE FROM application WHERE id = ?";

    try {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}