package jdbc;

import java.sql.*;

public class Sample2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:H:\\temp\\db/TEST", "sa", "");

        Statement stat = conn.createStatement();
        stat.executeUpdate("CREATE TABLE ....");
        stat.executeUpdate("INSERT ....");
        stat.executeUpdate("INSERT ....");
        stat.executeUpdate("INSERT ....");

        ResultSet res = stat.executeQuery("SELECT ...");
        while (res.next()) {
            //System.out.println(res.getLong(1));
            //System.out.println(res.getString(2));
        }
        res.close();
        stat.executeUpdate("DROP ....");
        stat.close();
        if (conn != null) {
            conn.close();
        }
    }
}
