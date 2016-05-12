package jdbc;

import java.sql.*;

public class Sample4 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:H:\\temp\\db/TEST", "sa", "");

        Statement stat = conn.createStatement();
        stat.executeUpdate("CREATE TABLE TEMP (id INT, NAME VARCHAR (20))");

        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO TEMP VALUES (?, ?)");
        //preparedStatement.set...
        //preparedStatement.set...
        preparedStatement.executeUpdate();

        preparedStatement.close();

        preparedStatement = conn.prepareStatement("SELECT id, name FROM TEMP WHERE id > ?");
        //preparedStatement.set...
        ResultSet res = preparedStatement.executeQuery();

        while (res.next()) {
            System.out.print(res.getString(1));
            System.out.print(" | ");
            System.out.println(res.getString(2));
        }
        res.close();
        preparedStatement.close();
        stat.executeUpdate("DROP TABLE TEMP");
        stat.close();
        if (conn != null) {
            conn.close();
        }
    }
}
