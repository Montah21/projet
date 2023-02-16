import services.applicationDAO;
import Models.application;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        applicationDAO dao = new applicationDAO();

        // Retrieve all applications from the database
        List<application> applications = dao.getAll();
        for (application a : applications) {
            System.out.println(a);
        }

        // Add a new application
        application newApp = new application("A123", "John Doe", 123, "Manager", "path/to/document");
        dao.addApplication(newApp);

        

    }
}