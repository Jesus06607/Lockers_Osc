/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martin
 */
public class Lokers extends javax.swing.JFrame {
    
    Connection conn = null;
    Statement stmt = null;
    
    public Lokers() {
        initComponents();
        this.setTitle("Registro de lockers");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_fadquisicion = new javax.swing.JTextField();
        txt_clave = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_capacidad = new javax.swing.JTextField();
        txt_color = new javax.swing.JTextField();
        txt_estatus = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        jLabel1.setText("             Ingrese la informacion");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 30, 260, 50);

        jLabel2.setText("CLAVE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 120, 31, 14);

        jLabel3.setText("NOMBRE");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 170, 42, 14);

        jLabel4.setText("PRECIO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 220, 38, 14);

        jLabel5.setText("CAPACIDAD");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 270, 59, 14);

        jLabel6.setText("COLOR");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(140, 320, 35, 14);

        jLabel7.setText("FECHA DE AQUISICION");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 420, 114, 14);

        jLabel8.setText("ESTATUS");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 370, 44, 14);
        getContentPane().add(txt_fadquisicion);
        txt_fadquisicion.setBounds(220, 410, 300, 20);
        getContentPane().add(txt_clave);
        txt_clave.setBounds(220, 110, 300, 20);

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre);
        txt_nombre.setBounds(220, 160, 300, 20);

        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precioKeyTyped(evt);
            }
        });
        getContentPane().add(txt_precio);
        txt_precio.setBounds(220, 210, 300, 20);
        getContentPane().add(txt_capacidad);
        txt_capacidad.setBounds(220, 260, 300, 20);

        txt_color.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_colorKeyTyped(evt);
            }
        });
        getContentPane().add(txt_color);
        txt_color.setBounds(220, 310, 300, 20);

        txt_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estatusActionPerformed(evt);
            }
        });
        txt_estatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_estatusKeyTyped(evt);
            }
        });
        getContentPane().add(txt_estatus);
        txt_estatus.setBounds(220, 360, 300, 20);

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar);
        btn_guardar.setBounds(560, 100, 80, 40);

        jButton2.setText("Ir al menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(560, 160, 100, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String cadena1, cadena2, cadena3, cadena4, cadena5, cadena6, cadena7;
        
        cadena1 = txt_clave.getText();
        cadena2 = txt_nombre.getText();
        cadena3 = txt_precio.getText();
        cadena4 = txt_capacidad.getText();
        cadena5 = txt_color.getText();
        cadena6 = txt_estatus.getText();
        cadena7 = txt_fadquisicion.getText();
        
        
           if (txt_clave.getText().equals("") || 
              (txt_nombre.getText().equals("") || 
              (txt_precio.getText().equals("")) || 
              (txt_capacidad.getText().equals("")) || 
              (txt_color.getText().equals(""))|| 
              (txt_estatus.getText().equals("")) || 
              (txt_fadquisicion.getText().equals("")))) 
             {
                javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar todos los campos \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txt_nombre.requestFocus();
             }
        
              else {
                try {
           
            String url = "jdbc:mysql://localhost:3306/Lockers";
            String usuario = "root";
            String contrase??a = "";
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); 
             conn = DriverManager.getConnection(url,usuario,contrase??a); 
             if ( conn != null ) 
                    System.out.println("Se ha establecido una conexi??n a la base de datos " +  
                                       "\n " + url ); 
  
                  stmt = conn.createStatement(); 
                  stmt.executeUpdate("INSERT INTO lockers VALUES('"+cadena1+"','"+cadena2+"','"+cadena3+"','"+cadena4+"','"+cadena5+"','"+cadena6+"','"+cadena7+"')");
                  System.out.println("Los valores han sido agregados a la base de datos ");
                   
       } catch (InstantiationException ex) {
           Logger.getLogger(Lokers.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(Lokers.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Lokers.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(Lokers.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        finally {
            if (conn != null) {
                try {
                    conn.close();
                    stmt.close();
                } catch ( Exception e ) { 
                         System.out.println( e.getMessage());
                }
            }
        }
         javax.swing.JOptionPane.showMessageDialog(this,"Registro exitoso! \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        this.txt_clave.setText("");
        this.txt_nombre.setText("");
        this.txt_precio.setText("");
        this.txt_capacidad.setText("");
        this.txt_color.setText("");
        this.txt_estatus.setText("");
        this.txt_fadquisicion.setText("");
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
       
        
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioKeyTyped
        char c = evt.getKeyChar();
        if(c<'0'|| c>'9')evt.consume();
    }//GEN-LAST:event_txt_precioKeyTyped

    private void txt_colorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_colorKeyTyped
  
    }//GEN-LAST:event_txt_colorKeyTyped

    private void txt_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estatusActionPerformed

    private void txt_estatusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estatusKeyTyped

    }//GEN-LAST:event_txt_estatusKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lokers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lokers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lokers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lokers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lokers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txt_capacidad;
    private javax.swing.JTextField txt_clave;
    private javax.swing.JTextField txt_color;
    private javax.swing.JTextField txt_estatus;
    private javax.swing.JTextField txt_fadquisicion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
