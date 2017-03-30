package service;

import model.Client;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Raluca on 24.03.2017.
 */
public class ClientService {

    public void addClient(Connection conn, Client c) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("insert into client(name,idCardNumber,PNC,address) values ('"+c.getName()+"','"+c.getIdCardNumber()+"','"+c.getPNC()+"','"+c.getAddress()+"')");
    }

    public void updateClient(Connection conn, Client c, int id) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("update client set name='"+c.getName()+"',address='"+c.getAddress()+"' where id = "+id+";");
    }

    public void viewClient(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from client where id = "+id+";");
        Client c = new Client();
        while(rs.next()) {
            String name = rs.getString(2);
            String idCardNumber = rs.getString(3);
            String PNC = rs.getString(4);
            String address = rs.getString(5);
            c.setId(id);
            c.setName(name);
            c.setIdCardNumber(idCardNumber);
            c.setPNC(PNC);
            c.setAddress(address);
        }
        JOptionPane.showMessageDialog(null,
                c.toString(),
                "Client info",
                JOptionPane.PLAIN_MESSAGE);
        System.out.println(c.toString());
    }

    public boolean exists(Connection conn,String name) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from client where name = '"+name+"';");
        if(!rs.next()) return false;
        else return true;
    }

    public boolean exists(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from client where id = '"+id+"';");
        if(!rs.next()) return false;
        else return true;
    }

}
