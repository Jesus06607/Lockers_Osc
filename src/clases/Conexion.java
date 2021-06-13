/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author martin
 */
public class Conexion {
    
     private Connection conect = null;
     
    public Connection conexion(){
        try{//se intenta la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/Lockers", "Admin", "Guitar_Mar23");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return conect;//REGRESAR LA CONEXIÓN CUANDO ÉSTA SEA ESTABLE
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
