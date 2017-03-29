package Gateway;

import model.Employee;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by Raluca on 24.03.2017.
 */
public class EmployeeGateway {

    public static void addEmployee(Connection conn, Employee a) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("insert into employee(name,username,password) values ('"+a.getName()+"','"+a.getUsername()+"','"+a.getPassword()+"')");
    }

    public void updateEmployee(Connection conn, Employee a, int id) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("update employee set name='"+a.getName()+"',username='"+a.getUsername()+"',password='"+a.getPassword()+"' where id = "+id+";");
    }

    public void deleteEmployee(Connection conn, int id) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("delete from report where employee_id = "+id+";");
        stmt.executeUpdate("delete from employee where id = "+id+";");
    }

    public void viewEmployee(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee where id = "+id+";");
        Employee e = new Employee();
        while(rs.next()) {
            String name = rs.getString(2);
            String username = rs.getString(3);
            String password = rs.getString(4);
            e.setId(id);
            e.setName(name);
            e.setUsername(username);
            e.setPassword(password);
        }
        JOptionPane.showMessageDialog(null,
                e.toString(),
                "Employee info",
                JOptionPane.PLAIN_MESSAGE);
        System.out.println(e.toString());
    }


    public boolean exists(Connection conn,String name) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee where name = '"+name+"';");
        if(!rs.next()) return false;
        else return true;
    }

    public boolean exists(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee where id = " + id + ";");
        if (!rs.next()) return false;
        else return true;
    }

    public boolean isValid(Connection conn,String u,String p) throws SQLException{
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from employee where username = '" + u + "'and password = '"+ p+ "';");
        if (!rs.next()) return false;
        else return true;
    }

    public int getEmployeeId(Connection conn,String u,String p) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id from employee where username = '" + u + "'and password = '"+ p+ "';");
        if (rs.next()) return rs.getInt(1);
        else return -1;
    }

}
