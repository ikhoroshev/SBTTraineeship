package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sample1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("...");
        Connection conn = DriverManager.getConnection("...", "sa", "");
        conn.close();
    }
}
