package jdbc;

import java.sql.*;

public class Sample3a {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:H:\\temp\\db/TEST", "sa", "");

        Statement stat = conn.createStatement();
        stat.executeUpdate("CREATE TABLE TEMP (id INT, NAME VARCHAR (20))");
        stat.executeUpdate("INSERT INTO TEMP VALUES (1, 'aaar')");
        stat.executeUpdate("INSERT INTO TEMP VALUES (2, 'abbb')");
        stat.executeUpdate("INSERT INTO TEMP VALUES (3, 'cccz')");

        int c = stat.executeUpdate("UPDATE TEMP SET name = 'azzz' WHERE id = 3");
        System.out.println("Updated records: " + c);

        ResultSet res = stat.executeQuery("SELECT id, name FROM TEMP WHERE name like 'a%' ORDER BY name DESC");
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
