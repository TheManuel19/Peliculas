package com.edu.mx.pelicula.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    public Connection createConnection() throws SQLException {
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }catch (Exception e){
            System.out.println(e);
        }
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netflix?user=root&password=1234&useSSL=false");
        return  con;
    }

    public static void main(String[] args) {
        try {
            Connection c = new Conexion().createConnection();
            System.out.println("conexion ->" + c);
            c.close();
        }catch (Exception e){
            System.out.println("Algo salió mal");
        }
    }
}
