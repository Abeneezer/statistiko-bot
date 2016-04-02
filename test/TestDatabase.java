package test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDatabase {

    @Test
    public void testServlet() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test", "root", "warcraft");
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE WordStat");
        stmt.close();
        connection.close();
    }
}