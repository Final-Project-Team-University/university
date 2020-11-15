package Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBRepo implements IDBRepo{
    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_register?serverTimezone=Europe/Moscow","root","1234");
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}


