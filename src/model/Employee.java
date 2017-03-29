package model;

import Gateway.AccountGateway;
import Gateway.ClientGateway;
import Gateway.EmployeeGateway;
import Gateway.ReportGateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 * Created by Raluca on 22.03.2017.
 */
public class Employee extends User {

    private String name;
    public ClientGateway clientGateway;
    public AccountGateway accountGateway;
    public EmployeeGateway employeeGateway;
    public ReportGateway reportGateway;

    public Employee()
    {
        clientGateway = new ClientGateway();
        accountGateway = new AccountGateway();
        employeeGateway = new EmployeeGateway();
        reportGateway = new ReportGateway();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addClient(Connection conn, Client c) throws SQLException {
        if(!clientGateway.exists(conn,c.getName())) {
            clientGateway.addClient(conn, c);
            reportGateway.addAction(conn, LocalDate.now().toString(),"Added client.",this.getId());
        }
        else System.out.println("Client already exists");

    }

    public void updateClient(Connection conn, Client c, int id) throws SQLException {
        if(clientGateway.exists(conn,id)) {
            clientGateway.updateClient(conn, c, id);
            reportGateway.addAction(conn, LocalDate.now().toString(), "Updated client information.", this.getId());
        }
        else System.out.println("Client does not exist");
    }

    public void viewClient(Connection conn,int id) throws SQLException {
        if(clientGateway.exists(conn,id))
            clientGateway.viewClient(conn,id);
        else System.out.println("Client does not exist");
    }

    public void createAccount(Connection conn, Account a) throws SQLException {
        if(!accountGateway.exists(conn,a.getId())) {
            accountGateway.createAccount(conn, a);
            reportGateway.addAction(conn, LocalDate.now().toString(),"Created new account.",this.getId());
        }
        else System.out.println("Account already exists");
    }

    public void updateAccount(Connection conn, String type,Float amount, int id) throws SQLException {
        if(accountGateway.exists(conn,id)) {
            accountGateway.updateAccount(conn, type,amount, id);
            reportGateway.addAction(conn, LocalDate.now().toString(), "Updated account information.", this.getId());
        }
        else System.out.println("Account does not exist");
    }

    public void deleteAccount(Connection conn, int id) throws SQLException {
        if(accountGateway.exists(conn,id)) {
            accountGateway.deleteAccount(conn, id);
            reportGateway.addAction(conn, LocalDate.now().toString(), "Deleted account.", this.getId());
        }
        else System.out.println("Account does not exist");
    }

    public void viewAccount(Connection conn,int id) throws SQLException {
        if(accountGateway.exists(conn,id)) {
            accountGateway.viewAccount(conn, id);
        }
        else System.out.println("Account does not exist");
    }

    public void transferMoney(Connection conn,int sourceId,int destinationId,float amount) throws SQLException {
        if(accountGateway.exists(conn,sourceId)) {
            if (accountGateway.exists(conn, destinationId)) {
                accountGateway.transferMoney(conn,sourceId,destinationId,amount);
                reportGateway.addAction(conn, LocalDate.now().toString(),"Transfered money from account "+sourceId+" to account "+destinationId+".",this.getId());
            }
            else System.out.println("Destination account does not exist.");
        }
        else System.out.println("Source account does not exist.");
    }

    public void processBill(Connection conn,int clientId,int accountId,float sum)throws SQLException {
        if (accountGateway.exists(conn, accountId)) {
            accountGateway.processBill(conn,clientId,accountId,sum);
            reportGateway.addAction(conn, LocalDate.now().toString(),"Processed utilities bill for client "+clientId+" from account "+accountId+", amount of "+sum+".",this.getId());
        }
        else System.out.println("Account does not exist.");
    }

    public boolean isValid(Connection conn) throws SQLException {
        if(employeeGateway.isValid(conn,this.getUsername(),this.getPassword())) return true;
        else return false;
    }

    public int getEmployeeId(Connection conn,String u,String p) throws SQLException{
        return employeeGateway.getEmployeeId(conn,u,p);
    }

    public String toString() {
        return "Employee [id=" + super.getId() + ", name=" + name + ", username=" + super.getUsername()
                + ", password=" + super.getPassword() + "]";
    }
}
