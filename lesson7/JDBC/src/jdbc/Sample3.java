package jdbc;

import java.sql.*;

public class Sample3 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:H:\\temp\\db/TEST", "sa", "");

        Statement stat = conn.createStatement();
        stat.executeUpdate("CREATE TABLE TEMP (id INT, NAME VARCHAR (20))");
        stat.executeUpdate("INSERT INTO TEMP VALUES (1, 'aaar')");
        stat.executeUpdate("INSERT INTO TEMP VALUES (2, 'abbb')");
        stat.executeUpdate("INSERT INTO TEMP VALUES (3, 'cccz')");

        int c = stat.executeUpdate("UPDATE TEMP ...");
        System.out.println("Some number: " + c);

        ResultSet res = stat.executeQuery("SELECT id, name FROM TEMP WHERE ... ORDER BY ...");
        while (res.next()) {
            System.out.print(res.getString(1));
            System.out.print(" | ");
            System.out.println(res.getString(2));
        }
        res.close();
        stat.executeUpdate("DROP TABLE TEMP");
        stat.close();
        if (conn != null) {
            conn.close();
        }
    }
}
