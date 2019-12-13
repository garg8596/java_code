package utils;

import java.sql.*;

public class DBUtils {
    public static Connection fetchConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, "root", "root");
    }
}
