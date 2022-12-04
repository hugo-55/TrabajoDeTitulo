package Formularios;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
import Formularios.Validacion_RUT;



public class LoginFrame extends javax.swing.JFrame {
    Conexion conex = new Conexion();
    Connection conn = (Connection) conex.realizarConexion();
   
    Validacion_RUT validacion;
  
    public LoginFrame() {
        initComponents();
    }
    
    public void ingresar(){
        Connection con1 = null;
        PreparedStatement pst = null;
        String User  = txt_usuario.getText();
        String Pass = String.valueOf(txt_pass.getPassword());
        
        validacion = new Validacion_RUT(User);
        boolean valid = validacion.Validacion_Concreta();
        
        if(!valid){
            JOptionPane.showMessageDialog(null, "El rut no es Correcto","Rut Incorrecto",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (User.equals("") || Pass.equals("")){
            JOptionPane.showMessageDialog(this,"uno o mas campos estan vacios , favor de rellenarlos " );
        } else{
            try{
                con1 =  (Connection) conex.realizarConexion();
                pst = conn.prepareStatement("SELECT * FROM usuario WHERE rut_admin ='" + User +
                        "' and clave ='"+ Pass +"'");
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                    if(rs.getString("tipo_usuario").equals("UTP")){
                        this.dispose();
                        new GestorFrame().setVisible(true);
                    }else if(rs.getString("tipo_usuario").equals("ADMIN")){
                        this.dispose();
                        new AdminFrame().setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Credenciales incorrectas. vuelve a intentar de nuevo.");
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

        jPanel1.setBackground(new java.awt.Color(102, 0, 153));
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
        btn_ingresar.setBounds(51, 323, 100, 30);

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salir);
        btn_salir.setBounds(250, 323, 100, 30);

        txt_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 255)));
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pass);
        txt_pass.setBounds(200, 210, 170, 20);

        txt_usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 255)));
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyTyped(evt);
            }
        });
        jPanel1.add(txt_usuario);
        txt_usuario.setBounds(200, 150, 170, 20);

        lbl_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Usuario       : ");
        jPanel1.add(lbl_usuario);
        lbl_usuario.setBounds(40, 150, 80, 20);

        lbl_pass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_pass.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pass.setText("Contraseña  : ");
        jPanel1.add(lbl_pass);
        lbl_pass.setBounds(40, 210, 80, 20);

        lbl_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("<html><body><p>Sistema de estadistica de matriculas <br> y asistencias</p></body></html>");
        lbl_titulo.setToolTipText("");
        jPanel1.add(lbl_titulo);
        lbl_titulo.setBounds(40, 20, 360, 70);

        jLabel1.setBackground(new java.awt.Color(153, 0, 153));
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
        ingresar();
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void btn_ingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMouseClicked
        // TODO add your handling code here:
        /*if(MouseEvent.BUTTON1 == evt.getButton()){
            ingresar();
        }*/
    }//GEN-LAST:event_btn_ingresarMouseClicked

    private void txt_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = (key >= 48 && key <= 57) || key == 45;

        if (!numeros)
        {
            evt.consume();
        }

        if (txt_usuario.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_usuarioKeyTyped

    
    
    
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
