package model;

import GUI.Controller;
import GUI.View;
import JDBC.JDBC;

import java.sql.SQLException;


/**
 * Created by Raluca on 22.03.2017.
 */
public class Main {

    public static void main(String[] args) {
//        JDBC jdbc = new JDBC();
//        Admin admin = new Admin();
//
//        Client client = new Client();
//        client.setName("Raluca");
//
//        Account account = new Account();
//        account.setType("abcdefg");
//        account.setDate("2015-03-09");
//        account.setClientId(1);
//
//        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setName("employeeee");
//        employee.setUsername("mee");
//        employee.setPassword("boss");

        View view = new View();
        Controller controller = new Controller(view);

//
//        try {
//            if(employee.isValid(jdbc.conn))
//                System.out.println("yes");
//            //admin.viewReport(jdbc.conn,1,"2017-03-22","2017-03-27");
//            //System.out.println(LocalDate.now().toString());
//            //employee.processBill(jdbc.conn,1,1,200);
//            //employee.transferMoney(jdbc.conn,3,2,2000);
//            //employee.addClient(jdbc.conn, client);
//            //updateClient(jdbc.conn,client,4);
//            //viewClient(jdbc.conn,1);
//            //deleteAccount(jdbc.conn,7);
//            //employee.createAccount(jdbc.conn,account);
//            //updateAccount(jdbc.conn,account,3);
//            //viewAccount(jdbc.conn,2);
//            //admin.addEmployee(jdbc.conn,employee);
//            //admin.updateEmployee(jdbc.conn,employee,2);
//            //admin.employeeGateway.viewEmployee(jdbc.conn,2);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (jdbc.conn != null) {
//                try {
//                    if (!jdbc.conn.isClosed()) {
//                        jdbc.conn.close();
//                    }
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
    }
}
