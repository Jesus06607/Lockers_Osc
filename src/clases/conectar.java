/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author martin
 */
public class conectar {
    private static Connection conn;
    private static final String driver ="com.mysql.cj.jdbc.Driver";
    private static final String user = "Admin";
    private static final String password = "Guitar_Mar23";
    private static final String url = "jdbc:mysql://localhost:3306/Lockers";

    public conectar() {
        
        conn = null;
        
        try{
            Class.forName(driver);   
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                
                System.out.println("Conexion Establecida....");
            }
        }catch(ClassNotFoundException | SQLException e){
                System.out.println("Conexion rechazada....");

        }
        
    };
    public Connection getConnection(){
        return conn;
        }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
