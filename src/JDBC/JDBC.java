package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {

        public static String url = "jdbc:mysql://localhost/bank";
        public static Connection conn;

        public JDBC() {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(url, "root", "root");
                System.out.println("Successfully connected to database");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }