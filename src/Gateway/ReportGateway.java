package Gateway;

import model.Report;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Raluca on 25.03.2017.
 */
public class ReportGateway {

    public void addAction(Connection conn, String date, String description, int employeeId) throws SQLException{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("insert into report(date,description,employee_id) values ('"+date+"','"+description+"',"+employeeId+");");
    }

    public void viewReport(Connection conn, int employeeId, String startDate, String endDate)throws SQLException{
        Statement stmt = conn.createStatement();
        Date sd = stringToDate(startDate);
        Date ed = stringToDate(endDate);
        ResultSet rs = stmt.executeQuery("select * from report where employee_id = "+employeeId+";");
        int dim = rs.getFetchSize();
        String[][] data = new String[100][3];
        int row = 0;
        while(rs.next()) {
            Date actionDate = stringToDate(rs.getString(2));
            if (sd.before(actionDate) && ed.after(actionDate)) {
                row++;
                data[row][0] = rs.getString(1);
                data[row][1] = rs.getString(2);
                data[row][2] = rs.getString(3);
            }
        }
        createTable(data);
    }

    public Date stringToDate(String s){
        try {
            DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
            Date date = format.parse(s);
            return date;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void createTable(String[][] data){
        String[] columnNames = {"Id","Date","Description"};
        Report report = new Report();
        DefaultTableModel model=new DefaultTableModel(data,columnNames);
        JTable t=new JTable(model);
        t.setEnabled(false);

        JDialog dialog=new JDialog();
        //dialog.setBounds(0,0,400,400);
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("Report");

        JScrollPane scrollPane3 = new JScrollPane(t);
        scrollPane3.setBounds(10, 50, 950, 120);
        scrollPane3.setEnabled(false);

        dialog.add(scrollPane3);
        dialog.pack();
        dialog.setVisible(true);
    }
}
