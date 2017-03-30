package model;

import service.AdminService;
import service.EmployeeService;
import service.ReportService;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Raluca on 22.03.2017.
 */
public class Admin extends User {

    public AdminService adminGateway;
    public EmployeeService employeeGateway;
    public ReportService reportGateway;

    public Admin(){
        adminGateway = new AdminService();
        employeeGateway = new EmployeeService();
        reportGateway = new ReportService();
    }

    public void addEmployee(Connection conn, Employee a) throws SQLException {
        employeeGateway.addEmployee(conn,a);
    }

    public void updateEmployee(Connection conn, Employee a, int id) throws SQLException {
        employeeGateway.updateEmployee(conn,a,id);
    }

    public void deleteEmployee(Connection conn, int id) throws SQLException {
        employeeGateway.deleteEmployee(conn,id);
    }

    public void viewEmployee(Connection conn,int id) throws SQLException {
        employeeGateway.viewEmployee(conn,id);
    }

    public void viewReport(Connection conn, int employeeId, String startDate, String endDate)throws SQLException {
        if(employeeGateway.exists(conn,employeeId))
            reportGateway.viewReport(conn,employeeId,startDate,endDate);
    }

    public boolean isValid(Connection conn) throws SQLException {
        if(adminGateway.isValid(conn,this.getUsername(),this.getPassword())) return true;
        else return false;
    }

    public int getAdminId(Connection conn,String u,String p) throws SQLException{
        return adminGateway.getAdminId(conn,u,p);
    }
}
