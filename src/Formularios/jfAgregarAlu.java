/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import java.sql.*;
import javax.swing.JOptionPane;
import Formularios.Validacion_RUT;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Hugo
 */
public class jfAgregarAlu extends javax.swing.JFrame {
    Connection conex=null;
    Statement stm=null;
    
   // Conexion conex = new Conexion();
    
    
    /**
     * Creates new form jfMatricular
     */
    public jfAgregarAlu() {
        conectar();
        initComponents();
        jDateChooser1.setMaxSelectableDate(new Date());
    }
    public void conectar(){
        String url="jdbc:mysql://localhost:3306/bd_tt";
        String usuario="root";
        String pass="";
        try{
            conex=DriverManager.getConnection(url,usuario,pass);
            //JOptionPane.showMessageDialog(null,"conectado","coneccion",1);
        }catch(Exception ex){
            System.out.println("ERROR de Conexion");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRutAlu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomAlu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmdAgregarAlu = new javax.swing.JButton();
        cmdAtras = new javax.swing.JButton();
        rbMasc = new javax.swing.JRadioButton();
        rbFem = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtApeAlu = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(543, 371));

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Alumno");

        jLabel2.setText("Rut:");

        txtRutAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutAluActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre:");

        jLabel5.setText("Fecha Nacimiento:");

        jLabel6.setText("Sexo:");

        cmdAgregarAlu.setText("Agregar");
        cmdAgregarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarAluActionPerformed(evt);
            }
        });

        cmdAtras.setText("Atras");
        cmdAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAtrasActionPerformed(evt);
            }
        });

        btnGroupSexo.add(rbMasc);
        rbMasc.setText("Masculino");

        btnGroupSexo.add(rbFem);
        rbFem.setText("Femenino");

        jLabel4.setText("Apellido:");

        txtApeAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeAluActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApeAlu, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(txtNomAlu, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(txtRutAlu, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmdAgregarAlu)
                                .addGap(28, 28, 28)
                                .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbMasc)
                                .addGap(18, 18, 18)
                                .addComponent(rbFem)))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApeAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbMasc)
                            .addComponent(rbFem))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdAgregarAlu)
                            .addComponent(cmdAtras))))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApeAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeAluActionPerformed

    private void cmdAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_cmdAtrasActionPerformed

    private void cmdAgregarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarAluActionPerformed

        String rut=txtRutAlu.getText();
        Validacion_RUT Validacion;
        Validacion = new Validacion_RUT(rut);
        

        //Textos para Alumnos.
        String nom=txtNomAlu.getText(),ape=txtApeAlu.getText(),sexo="",curso="";
        //-------------Numeros para Alumnos------------------------------------
        //Integer edad=Integer.parseInt(txtEdad.getText());
        //String fecha=txtFechaNac.getText();
        //java.util.Date utilPackageDate = new java.util.Date();
        //java.sql.Date sqlPackageDate = new java.sql.Date(jDateChooser1.getDate());
        //Date fecha = jDateChooser1.getDate();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String fecha =  format1.format(jDateChooser1.getDate());
        //Date fecha_nacimiento = format1.parse(fecha);
        //Numeros para Matricula
        //Integer añoM=Integer.parseInt(txtAñoMatricula.getText());
        //Integer vtc=Integer.parseInt(txtVTC.getText());
        //Integer matricula=Integer.parseInt(txtMatricula.getText());
        if(rbFem.isSelected()){
            //sexo=rbFem.getText();
            sexo="F";
        }else{
            //sexo=rbMasc.getText();
            sexo="M";
        }
        
        //curso=String.valueOf(cmbCurso.getSelectedItem());
        //Ultima Verificacion que no funciona xd
        /*if (Digito.equals(rutSep[1])){
            System.out.println(Digito +"1era parte");
        }else{
            System.out.println(Digito + "2da parte");
            //JOptionPane.showMessageDialog(null, "Rut Incorrecto","Incorrecto",1);
        }*/
        if(Validacion.Validacion_Concreta() == true){

            //JOptionPane.showMessageDialog(null, "El rut es valido");
            try{
                String sql = "SELECT rut_estudiante FROM estudiante WHERE rut_estudiante = '"+rut+"'";
                stm=conex.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if(rs.toString().equals(rut)){
                    JOptionPane.showMessageDialog(null, "Ya se encuentra registrado este rut", "Agregado Fallido", JOptionPane.ERROR_MESSAGE);
                }else{
                    String inser="INSERT INTO estudiante(rut_estudiante,nombres,apellidos,fecha_nacimiento,sexo) VALUES ('"+ rut +"','"+ nom +"','"+ape+"','"+ fecha +"','"+ sexo+"')";
                    try{
                        stm=conex.createStatement();
                        stm.executeUpdate(inser);
                        JOptionPane.showMessageDialog(null, "Datos Ingresados","Ingreso",1);
                    }catch(SQLException ei){
                        JOptionPane.showMessageDialog(null, "Error en ingreso"+ei,"Insert",3);
                    } 
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al compara rut", "Verificacion Fallida", JOptionPane.ERROR_MESSAGE);
            }

        }else{

            JOptionPane.showMessageDialog(null, "El rut es Invalido");

        }
        /*String inser="INSERT INTO estudiante(rut_estudiante,nombres,apellidos,fecha_nacimiento,sexo) VALUES ('"+ rut +"','"+ nom +"','"+ape+"','"+ fecha +"','"+ sexo+"')";
        try{
            stm=conex.createStatement();
            stm.executeUpdate(inser);
            JOptionPane.showMessageDialog(null, "Datos Ingresados","Ingreso",1);
        }catch(SQLException ei){
            JOptionPane.showMessageDialog(null, "Error en ingreso"+ei,"Insert",3);
        }*/
        //Ingreso Datos Matricula
        /*String insert="INSERT INTO matricula(id_matricula,cod_curso,rut_estudiante,año,vtc) VALUES ('"+matricula+"','"+curso+"','"+ rut +"','" +añoM+"','"+vtc+")";
        try{
            stm=conex.createStatement();
            stm.executeUpdate(insert);
            JOptionPane.showMessageDialog(null, "Datos Ingresados","Ingreso",1);
        }catch(SQLException ei){
            JOptionPane.showMessageDialog(null, "Error en ingreso"+ei,"Insert",3);
        }*/
    }//GEN-LAST:event_cmdAgregarAluActionPerformed

    private void txtRutAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutAluActionPerformed
    //Dando Vuelta el Rut para verificarlo
    public static Object[] invertir(Object[] array) {
        Object[] invertir_int = new Object[array.length];
        int maximo = array.length;

        for (int i = 0; i < array.length; i++) {
            Object j = array[maximo - 1];
            invertir_int[maximo - 1] = array[i];
            maximo--;
            }
        return invertir_int;
    }    

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
            java.util.logging.Logger.getLogger(jfAgregarAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfAgregarAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfAgregarAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfAgregarAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfAgregarAlu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupSexo;
    private javax.swing.JButton cmdAgregarAlu;
    private javax.swing.JButton cmdAtras;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbFem;
    private javax.swing.JRadioButton rbMasc;
    private javax.swing.JTextField txtApeAlu;
    private javax.swing.JTextField txtNomAlu;
    private javax.swing.JTextField txtRutAlu;
    // End of variables declaration//GEN-END:variables
}
