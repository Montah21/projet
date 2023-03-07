package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mariem
 */
public class MyConnection {
   
//DB Credentials
     String USERNAME = "root";
     String PASSWORD = "";
     String URL = "jdbc:mysql://127.0.0.1:3306/khademni";
//var
    Connection cnx;
    
    //2 créer une instance static de MyConnection
    static MyConnection instance;
    
    //1 privatisation du constructeur :
    //constructeur
    private MyConnection() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection etablie avec succes !!!");
        } catch (Exception e) {
        }

    }
    
    //3 getter static
    public static MyConnection getInstance() {
        if(instance == null){
            instance = new MyConnection();
        }
        return instance;
    }

    public static void setInstance(MyConnection instance) {
        MyConnection.instance = instance;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

}

    
