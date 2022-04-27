package com.bridgelabz;

import java.sql.*;

public class SampleClass {
    public static void main(String[] args) {
       String jdbcUrl = "jdbc:mysql://localhost:3306/employee_payroll_service?useSSL=false";
       String userName = "root";
       String password = "9952625052";


        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con= DriverManager.getConnection(jdbcUrl,userName,password);
            Statement statement= con.createStatement();
//            ResultSet resultSet =statement.executeQuery("select * from employee_payroll");
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("name"));
//                System.out.println(resultSet.getInt("Basic_pay"));
            String query = "select * from employee where id=? or name =?";
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setInt(1,6);
            preparedStatement.setString(2,"Terisa");
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
