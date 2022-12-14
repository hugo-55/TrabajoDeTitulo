/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hugo
 */
public class jfAlumnos extends javax.swing.JFrame {
    //Connection conex=null;
    Statement stm=null;
    Conexion conex = new Conexion();
    Connection conn = (Connection) conex.realizarConexion();

    /**
     * Creates new form jfAlumnos
     */
    public jfAlumnos() {
        //conectar();
        initComponents();
        llenarTabla("");
        /*-------------------- Definicion de tabla ----------------------*/
        /*try{
            stm = conn.createStatement();
            ResultSet result  = stm.executeQuery(sql);
            
            while (result.next()){
                System.out.println(result.getString(0));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos", "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }*/
    }
    public void llenarTabla(String sql){
        DefaultTableModel model = new DefaultTableModel();
        
        jTableAlu.setModel(model);
        
        model.addColumn("Rut");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Fecha Nacimiento");
        model.addColumn("Genero");
        
        
        try{
            String cons = "";
            if(sql.equals("")){
                cons = "SELECT * FROM estudiante";
            }else{
                cons = sql;
            }
            //String sql = "SELECT * FROM estudiante";
            String[] datos = new String[4];
            stm = conn.createStatement();
            ResultSet res = stm.executeQuery(cons);
            while(res.next()){
                model.addRow( new Object[]{
                    res.getString("rut_estudiante"), res.getString("nombres"), res.getString("apellidos"), res.getString("fecha_nacimiento"), res.getString("sexo")
                });
            }
            jTableAlu.setModel(model);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Cargar la Lista "+ex, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
    }
    /*public void conectar(){
        String url="jdbc:mysql://localhost:3306/bd_tt";
        String usuario="root";
        String pass="";
        try{
            conex=DriverManager.getConnection(url,usuario,pass);
            JOptionPane.showMessageDialog(null,"conectado","coneccion",1);
        }catch(Exception ex){
            System.out.println("ERROR de Conexion");
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jProgressBar1 = new javax.swing.JProgressBar();
        btnGroupSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmdModificarAlu = new javax.swing.JButton();
        cmdEliminarAlu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlu = new javax.swing.JTable();
        cmdModificarAlu1 = new javax.swing.JButton();
        cmdAtras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtRutAlu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomAlu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApeAlu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        rbMasc = new javax.swing.JRadioButton();
        rbFem = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(543, 371));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Alumnos");

        cmdModificarAlu.setText("Modificar");
        cmdModificarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModificarAluActionPerformed(evt);
            }
        });

        cmdEliminarAlu.setText("Eliminar");
        cmdEliminarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarAluActionPerformed(evt);
            }
        });

        jTableAlu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAluMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAlu);

        cmdModificarAlu1.setText("Agregar");
        cmdModificarAlu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModificarAlu1ActionPerformed(evt);
            }
        });

        cmdAtras.setText("Atras");
        cmdAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAtrasActionPerformed(evt);
            }
        });

        jLabel2.setText("Rut:");

        txtRutAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutAluActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        txtApeAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeAluActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha Nacimiento:");

        jDateChooser1.setDateFormatString("dd-MM-yyyy");

        jLabel6.setText("Sexo:");

        btnGroupSexo.add(rbMasc);
        rbMasc.setText("Masculino");

        btnGroupSexo.add(rbFem);
        rbFem.setText("Femenino");

        jLabel7.setText("Busqueda:");

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });

        btnBusqueda.setText("Buscar");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmdModificarAlu1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdEliminarAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApeAlu)
                            .addComponent(txtNomAlu)
                            .addComponent(txtRutAlu)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmdModificarAlu)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(75, 75, 75)
                                .addComponent(rbMasc)))
                        .addGap(18, 18, 18)
                        .addComponent(rbFem)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbMasc)
                                .addComponent(rbFem)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdModificarAlu)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdAtras)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdEliminarAlu)
                        .addComponent(cmdModificarAlu1)))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdModificarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModificarAluActionPerformed
        
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        
        if(txtRutAlu.getText().trim().isEmpty()||
           txtNomAlu.getText().trim().isEmpty()||
           txtApeAlu.getText().trim().isEmpty()/*||
           jDateChooser1.getDate().equals("")||
           btnGroupSexo.getSelectedValue().equals("")*/){
           JOptionPane.showMessageDialog(null, "Los campos no deben estar Vacios", "Campos Vacios", JOptionPane.WARNING_MESSAGE); 
           return;
        }
        
        String rut = txtRutAlu.getText().trim();
        String nombre = txtNomAlu.getText().trim();
        String apellido = txtApeAlu.getText().trim();
        String fecha = format1.format(jDateChooser1.getDate());
        String sexo="";
        if(rbFem.isSelected()){
            //sexo=rbFem.getText();
            sexo="F";
        }else{
            //sexo=rbMasc.getText();
            sexo="M";
        }
        
        String sql = "UPDATE estudiante SET nombres ='"+nombre+"',apellidos = '"+apellido+"',fecha_nacimiento = '"+fecha+"',sexo = '"+sexo+"'WHERE rut_estudiante = '"+rut+"'";
        
        try{
            Statement stm = conn.createStatement();
            
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa", "Modificado", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Modificar "+ex.getMessage(), "Error de modificacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdModificarAluActionPerformed

    private void cmdModificarAlu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModificarAlu1ActionPerformed
        jfAgregarAlu fra = new jfAgregarAlu();
        fra.setVisible(true);
    }//GEN-LAST:event_cmdModificarAlu1ActionPerformed

    private void cmdAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_cmdAtrasActionPerformed

    private void txtRutAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutAluActionPerformed

    private void txtApeAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeAluActionPerformed

    private void jTableAluMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAluMouseClicked
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        
        //Seleccionado de datos para pasarlos a Modificar
        if (jTableAlu.getSelectedRow()>=0){
            try{
                DefaultTableModel tm = (DefaultTableModel)jTableAlu.getModel();
                String rut = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),0));
                String nombre = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),1));
                String apellido = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),2));
                String fecha = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),3));
                String sexo = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),4));
                txtRutAlu.setText(rut);
                txtNomAlu.setText(nombre);
                txtApeAlu.setText(apellido);
                //Date fechaSeleccionada = format1.parse(fecha);
                //jDateChooser1.setSelectedDate(fechaSeleccionada);
                
                Date fechaSeleccionada;
                try {
                    fechaSeleccionada = format1.parse(fecha);
                } catch (ParseException e) {
                    fechaSeleccionada = new Date();
                    JOptionPane.showMessageDialog(this, "La fecha seleccionada no es válida. Por favor ingresela otra vez", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (sexo.equals("M")) {
                    rbMasc.setSelected(true);
                } else {
                    rbFem.setSelected(true);
                }       
                //btnGroupSexo.setText(sexo);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"");
            }
        }else{
            JOptionPane.showMessageDialog(this,"DEBE SELECCIONAR UN ESTABLECIMIENTO","SISTEMA",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTableAluMouseClicked

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        String busqueda = txtBusqueda.getText().trim();
        
        String sql = "SELECT * FROM estudiante WHERE estudiante.nombres LIKE '%"+busqueda+"%'";
        
        llenarTabla(sql);
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void cmdEliminarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarAluActionPerformed
        
        if(jTableAlu.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "No has seleccionado una fila", "Seleccione una fila", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel tm = (DefaultTableModel)jTableAlu.getModel();
        String rut = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(), 0));
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Eliminar este estudiante ?", "Eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        switch(opcion){
            case 0:
                String cons = "DELETE FROM estudiante WHERE rut_estudiante = '"+rut+"'";
                
                try{
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(cons);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado Correctamente","Eliminacion Concretada", JOptionPane.INFORMATION_MESSAGE);
                    llenarTabla("");
                }catch(SQLException e) {
                    JOptionPane.showMessageDialog(null, "No se Pudo Eliminar", "Eliminacion Fallida", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Eliminacion Cancelada", "Eliminacion Cancelada",JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }//GEN-LAST:event_cmdEliminarAluActionPerformed

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
            java.util.logging.Logger.getLogger(jfAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda;
    private javax.swing.ButtonGroup btnGroupSexo;
    private javax.swing.JButton cmdAtras;
    private javax.swing.JButton cmdEliminarAlu;
    private javax.swing.JButton cmdModificarAlu;
    private javax.swing.JButton cmdModificarAlu1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAlu;
    private javax.swing.JRadioButton rbFem;
    private javax.swing.JRadioButton rbMasc;
    private javax.swing.JTextField txtApeAlu;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtNomAlu;
    private javax.swing.JTextField txtRutAlu;
    // End of variables declaration//GEN-END:variables
}
