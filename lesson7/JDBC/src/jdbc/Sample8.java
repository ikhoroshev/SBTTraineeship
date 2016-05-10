package jdbc;

import java.sql.*;
import java.util.Random;

public class Sample8 {

    /*
    CREATE PROCEDURE new_rec(OUT newid INT, IN name VARCHAR(32))
      MODIFIES SQL DATA
      BEGIN ATOMIC
        INSERT INTO table1 VALUES (DEFAULT, name);
        SET newid = IDENTITY();
      END
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:H:\\temp\\db/TEST", "sa", "");

        CallableStatement callableStatement = conn.prepareCall("{call new_rec (?, ?)}");
        Random r = new Random();
        callableStatement.setString(2, "aaa" + r.nextInt());
        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.executeUpdate();

        int newId = callableStatement.getInt(1);
        System.out.println("New id is " + newId);

        Statement stat = conn.createStatement();
        ResultSet res = stat.executeQuery("SELECT id, name FROM TABLE1");
        while (res.next()) {
            System.out.print(res.getString(1));
            System.out.print(" | ");
            System.out.println(res.getString(2));
        }
        res.close();
        stat.close();
        if (conn != null) {
            conn.close();
        }
    }
}
