package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Raluca on 26.03.2017.
 */
public class AdminService {

    public boolean isValid(Connection conn, String u, String p) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from admin where username = '" + u + "'and password = '"+ p+ "';");
        if (!rs.next()) return false;
        else return true;
    }

    public int getAdminId(Connection conn,String u,String p) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id from admin where username = '" + u + "'and password = '"+ p+ "';");
        if (rs.next()) return rs.getInt(1);
        else return -1;
    }

}
