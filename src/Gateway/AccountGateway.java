package Gateway;

import model.Account;

import javax.swing.*;
import java.sql.*;

/**
 * Created by Raluca on 24.03.2017.
 */
public class AccountGateway {

    public void createAccount(Connection conn, Account a) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("insert into account(type,amount,date,client_id) values ('"+a.getType()+"',"+a.getAmount()+",'"+a.getDate()+"','"+a.getClientId()+"')");
    }

    public void updateAccount(Connection conn, String type,Float amount, int id) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("update account set type='"+type+"',amount="+amount+" where id = "+id+";");
    }

    public void deleteAccount(Connection conn, int id) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("delete from account where id = "+id+";");
    }

    public void viewAccount(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from account where id = "+id+";");
        Account a = new Account();
        while(rs.next()) {
            String type = rs.getString(2);
            float amount = rs.getFloat(3);
            String date = rs.getString(4);
            int clientId = rs.getInt(5);
            a.setId(id);
            a.setType(type);
            a.setAmount(amount);
            a.setDate(date);
            a.setClientId(clientId);
        }
        JOptionPane.showMessageDialog(null,
                a.toString(),
                "Client info",
                JOptionPane.PLAIN_MESSAGE);
        System.out.println(a.toString());
        System.out.println(a.toString());
    }

    public void transferMoney(Connection conn,int sourceId,int destinationId,float amount) throws SQLException {
        Statement stmt = conn.createStatement();
        float newAmountInSource = -1;
        ResultSet rs = stmt.executeQuery("select amount from account where id = "+sourceId+";");
        while(rs.next()){
            newAmountInSource = rs.getFloat(1)-amount;
            if(!(newAmountInSource<0)) {
                Statement stmt1 = conn.createStatement();
                stmt1.executeUpdate("update account set amount = " + newAmountInSource + " where id = " + sourceId + ";");
            }
            else JOptionPane.showMessageDialog(null,
                    "Insufficient funds",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
        if(!(newAmountInSource<0)) {
            ResultSet rs1 = stmt.executeQuery("select amount from account where id = " + destinationId + ";");
            while (rs1.next()) {
                float newAmountInDestination = rs1.getFloat(1) + amount;
                Statement stmt2 = conn.createStatement();
                stmt2.executeUpdate("update account set amount = " + newAmountInDestination + " where id = " + destinationId + ";");
            }
        }
    }

    public void processBill(Connection conn,int clientId,int accountId,float sum)throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select client_id, amount from account where id = "+accountId+";");
        while(rs.next()){
            if(rs.getInt(1) == clientId){
                float newAmount = rs.getFloat(2) - sum;
                if(!(newAmount<0)) {
                    Statement stmt1 = conn.createStatement();
                    stmt1.executeUpdate("update account set amount = " + newAmount + " where id = " + accountId + ";");
                    System.out.println("Successfully processed bill.");
                }
                else JOptionPane.showMessageDialog(null,
                        "Insufficient funds",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null,
                    "Wrong client-account matching.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,
                "Bill processed. Removed $"+sum+" from account "+accountId+".",
                "",
                JOptionPane.PLAIN_MESSAGE);
    }

    public boolean exists(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from account where id = "+id+";");
        if(!rs.next()) return false;
        else return true;
    }

}
