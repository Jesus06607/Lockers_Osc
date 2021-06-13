/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author martin
 */
public class Controllers {
     private static Conexion conn = new Conexion();
    private static Connection conection = (Connection) conn.conexion();
    
    
     public static boolean addData(String table, String campos, String valores){
        String sql = "INSERT INTO "+table+" ("+campos+") values ("+valores+")";
        try{
            Statement st1 = (Statement) conection.createStatement();
            int rs1 = st1.executeUpdate(sql);
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    
        public static boolean updateData(String table,  String camb, String lck ){
        String sql = " UPDATE "+table+" SET "+ camb+" WHERE "+ lck;
            System.out.println(sql);
        try{
            Statement st1 = (Statement) conection.createStatement();
            int rs1 = st1.executeUpdate(sql);
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
        
     public static ResultSet mostrardatos(String table, String valores, String where){
     
         String sql= " SELECT " + valores +" FROM " + table + " WHERE " + where;
         try{
             Statement dlock = (Statement) conection.createStatement();
             ResultSet rs1 = dlock.executeQuery(sql);
             return rs1;
             
         }catch(Exception e){
             return null;
         }
     
 
     }
    
}
