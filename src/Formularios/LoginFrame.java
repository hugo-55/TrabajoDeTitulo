package Formularios;

import com.mysql.jdbc.Connection;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;


public class LoginFrame extends javax.swing.JFrame {
    Conexion conex = new Conexion();
    Connection conn = (Connection) conex.realizarConexion();
   
  
    public LoginFrame() {
        initComponents();
        if(conn != null){
            JOptionPane.showMessageDialog(null, "conectado");
        }else{
            JOptionPane.showMessageDialog(null, "error conexion");
        }
    }
    
    public void ingresar(){
        Connection con1 = null;
        PreparedStatement pst = null;
        String User  = txt_usuario.getText();
        String Pass = txt_pass.getText();
        if (User.equals("") || Pass.equals("")){
            JOptionPane.showMessageDialog(this,"uno o mas campos estan vacios , favor de rellenarlos " );
        } else{
            try{
                con1 =  (Connection) conex.realizarConexion();
                pst = con1.prepareStatement("select user_name , clave, tipo_usuario  from usuario where user_name ='" + User +
                        "' and clave ='"+ Pass +"'");
                ResultSet rs = pst.executeQuery();
                if (rs.next() && rs.getString("tipo_usuario").equals("gestor")){
                    this.dispose();
                    new GestorFrame().setVisible(true);
                } else{
                    if ( rs.getString("tipo_usuario").equals("admin")){
                        this.dispose();
                        new AdminFrame().setVisible(true);
                    } else{
                        JOptionPane.showMessageDialog(this, "Credenciales incorrectas. vuelve a intentar de nuevo."); 
                                } 
                        }
            }catch(SQLException e){
                System.err.print(e.toString());
                JOptionPane.showMessageDialog(this, "ocurrio un error inesperado.\nFavor comunicarse con el administrador");
            }
                    
        }
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_ingresar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        txt_pass = new javax.swing.JPasswordField();
        txt_usuario = new javax.swing.JTextField();
        lbl_usuario = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        btn_ingresar.setText("Ingresar ");
        btn_ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ingresarMouseClicked(evt);
            }
        });
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ingresar);
        btn_ingresar.setBounds(51, 323, 100, 29);

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salir);
        btn_salir.setBounds(290, 320, 100, 29);

        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pass);
        txt_pass.setBounds(160, 161, 225, 26);
        jPanel1.add(txt_usuario);
        txt_usuario.setBounds(160, 117, 225, 26);

        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Usuario       : ");
        jPanel1.add(lbl_usuario);
        lbl_usuario.setBounds(51, 120, 100, 20);

        lbl_pass.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pass.setText("Contraseña  : ");
        jPanel1.add(lbl_pass);
        lbl_pass.setBounds(51, 164, 100, 20);

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setText("Sistema de estadistica de matriculas y asistencias ");
        jPanel1.add(lbl_titulo);
        lbl_titulo.setBounds(30, 30, 380, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hugo\\Desktop\\fondo1.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 440, 440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
                   // TODO add your handling code here:
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void btn_ingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMouseClicked
        // TODO add your handling code here:
        if(MouseEvent.BUTTON1 == evt.getButton()){
            ingresar();
        }
    }//GEN-LAST:event_btn_ingresarMouseClicked

    
    
    
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
