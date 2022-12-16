/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hugo
 */
public class Establecimiento_Agregar extends javax.swing.JFrame {
/**
     * Creates new form Establecimiento_Agregar
     */
    Conexion conex = new Conexion();
    Connection conn = (Connection) conex.realizarConexion();
    
    public Establecimiento_Agregar() {
        initComponents();
        llenarTabla("");
    }
    public void llenarTabla(String sql){
       DefaultTableModel modelo = (DefaultTableModel) tbl_establecimiento.getModel();
        modelo.setRowCount(0);
       tbl_establecimiento.setModel(modelo);
       try{
            String cons = "";
            if(sql.equals("")){
                cons = "SELECT * FROM establecimiento, usuario WHERE establecimiento.id_usuario = usuario.id_usuario";
            }else{
                cons = sql;
            }
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                modelo.addRow( new Object[]{
                    rs.getString("id_establecimiento"), rs.getString("nombre"), rs.getString("tipo_educacion"), rs.getString("nombre_usuario"), rs.getString("rut_admin")
                });
            }

            tbl_establecimiento.setModel(modelo);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Cargar la Lista "+ex, "Error de Carga", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmb_tipo_admin = new javax.swing.JComboBox<>();
        btn_agregar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        cmb_tipo_educacion = new javax.swing.JComboBox<>();
        txt_nom_admin = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_codigo_establecimiento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_rut = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_establecimiento = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setText("AGREGAR ESTABLECIMIENTO");

        jLabel2.setText("Nombre del establecimiento:");

        jLabel5.setText("Tipo de Educacion       :");

        jLabel3.setText("Nombre administrador :");

        jLabel4.setText("Contraseña :");

        jLabel6.setText("Tipo de administrador :");

        cmb_tipo_admin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UTP", "ADMIN" }));

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_atras.setText("Atras");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        cmb_tipo_educacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basica", "Media", "Ambas" }));

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jLabel8.setText("Codigo del Establecimiento:");

        jLabel10.setText("Rut :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btn_agregar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_modificar)
                                .addGap(31, 31, 31)
                                .addComponent(btn_eliminar)
                                .addGap(33, 33, 33)
                                .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_tipo_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_tipo_educacion, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_nom_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txt_codigo_establecimiento)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_password)
                                    .addComponent(txt_rut))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_codigo_establecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_tipo_educacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nom_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmb_tipo_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_atras)
                    .addComponent(btn_modificar)
                    .addComponent(btn_eliminar))
                .addGap(55, 55, 55))
        );

        tbl_establecimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Tipo Educacion", "Administrador", "Rut Admin"
            }
        ));
        tbl_establecimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_establecimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_establecimientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_establecimiento);

        jLabel7.setText("Busqueda:");

        txt_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busquedaActionPerformed(evt);
            }
        });

        jLabel9.setText("ESTABLECIMIENTOS");

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        insertarDatos();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void txt_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busquedaActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        eliminarDatos();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void tbl_establecimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_establecimientoMouseClicked
        if(tbl_establecimiento.getSelectedRow()>=0){
            try{
                DefaultTableModel tm = (DefaultTableModel)tbl_establecimiento.getModel();
                String codigo = String.valueOf(tm.getValueAt(tbl_establecimiento.getSelectedRow(),0));
                String nombre = String.valueOf(tm.getValueAt(tbl_establecimiento.getSelectedRow(),1));
                String tipo_educacion = String.valueOf(tm.getValueAt(tbl_establecimiento.getSelectedRow(),2));
                String admin = String.valueOf(tm.getValueAt(tbl_establecimiento.getSelectedRow(),3));
                String rut_admin = String.valueOf(tm.getValueAt(tbl_establecimiento.getSelectedRow(), 4));
                txt_codigo_establecimiento.setText(codigo);
                txt_nombre.setText(nombre);
                txt_nom_admin.setText(admin);
                cmb_tipo_educacion.setSelectedItem(tipo_educacion);
                txt_rut.setText(rut_admin);
          
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"NO CONTIENE UN  ESTABLECIMIENTO ");
            }
         
        }else{
            JOptionPane.showMessageDialog(this,"DEBE SELECCIONAR UN ESTABLECIMIENTO","SISTEMA",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_tbl_establecimientoMouseClicked

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        
        if(txt_codigo_establecimiento.getText().equals("") ||
        txt_nombre.getText().equals("") ||
        txt_nom_admin.getText().equals("") ||
        String.valueOf(txt_password.getPassword()).equals("") ||
        txt_rut.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Los campos no deben estar Vacios", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
        return;
    }
        
    String id_establecimiento = txt_codigo_establecimiento.getText().trim();
    String rut_admin = txt_rut.getText().trim();
    
    String sql = "UPDATE establecimiento SET nombre = '"+txt_nombre.getText().trim()+"', tipo_educacion = '"+cmb_tipo_educacion.getItemAt(cmb_tipo_educacion.getSelectedIndex())+"' WHERE id_establecimiento = '"+id_establecimiento+"'";
    String sql2 = "UPDATE usuario SET nombre_usuario = '"+txt_nom_admin.getText().trim()+"', tipo_usuario = '"+cmb_tipo_admin.getItemAt(cmb_tipo_admin.getSelectedIndex())+"', clave = '"+String.valueOf(txt_password.getPassword())+"' WHERE rut_admin = '"+rut_admin+"'";
    try{
        Statement stm = conn.createStatement();
        Statement stm2 = conn.createStatement();
        
        stm.executeUpdate(sql);
        stm.executeUpdate(sql2);
        
        JOptionPane.showMessageDialog(null, "Modificacion Exitosa", "Modificado", JOptionPane.INFORMATION_MESSAGE);
        
        
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al Modificar "+ex.getMessage(), "Error de modificacion", JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String busqueda = txt_busqueda.getText().trim();
        
        String sql = "SELECT * FROM establecimiento, usuario WHERE establecimiento.id_usuario = usuario.id_usuario AND establecimiento.nombre LIKE '%"+busqueda+"%'";
        
        llenarTabla(sql);
        
    }//GEN-LAST:event_btn_buscarActionPerformed

    /**
     * @param args the command line arguments
     */
public void insertarDatos(){
    
    String rut_admin = txt_rut.getText().trim();
    String sql = "Select count(rut_admin) as cantidad from usuario where rut_admin = '"+rut_admin+"'";
    try{
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if (rs.next()){
            if(rs.getInt("cantidad") > 0){
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con este rut.", "Usuario Existente", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Hubo un Error en la Peticion", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        return;
    }
        Validacion_RUT Validacion;
        Validacion = new Validacion_RUT(rut_admin);

        if(Validacion.Validacion_Concreta() == true){

            JOptionPane.showMessageDialog(null, "El rut es valido");

        }else{

            JOptionPane.showMessageDialog(null, "El rut es Invalido");
            return;
        }
    
    if(txt_codigo_establecimiento.getText().equals("") ||
       txt_nombre.getText().equals("") ||
       txt_nom_admin.getText().equals("") ||
       String.valueOf(txt_password.getPassword()).equals("") ||
       txt_rut.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Los campos no deben estar Vacios", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    
    try {
        String SQL= "insert into establecimiento(nombre,tipo_educacion,id_establecimiento,id_usuario) values (?,?,?,?) ";
        PreparedStatement pst =  conn.prepareStatement(SQL);
        pst.setString(1 , txt_nombre.getText());
        int seleccionado =cmb_tipo_educacion.getSelectedIndex();
        pst.setString(2 , cmb_tipo_educacion.getItemAt(seleccionado));
        pst.setString(3 , txt_codigo_establecimiento.getText());
        
        
        String SQL2= "insert into usuario(nombre_usuario,tipo_usuario,clave,rut_admin) values (?,?,?,?) ";
        PreparedStatement pst2 =  conn.prepareStatement(SQL2);
        pst2.setString(1 , txt_nom_admin.getText());
        int seleccionado2 =cmb_tipo_admin.getSelectedIndex();
        pst2.setString(2 , cmb_tipo_admin.getItemAt(seleccionado2));
        pst2.setString(3 , txt_password.getText());
        pst2.setString(4 , txt_rut.getText());
        
        pst2.execute();
        String ultimo_usuario = "select max(id_usuario) as id from usuario";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(ultimo_usuario);
        
        if (rs.next()){
            int id_usuario = rs.getInt("id");
             System.out.println(id_usuario);
            pst.setInt(4 , id_usuario);
            pst.execute();
         } 
        llenarTabla("");
        JOptionPane.showMessageDialog(null,"Registro exitoso");
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"error de registro" +e.getMessage());
}

}
public void eliminarDatos(){
    if(tbl_establecimiento.getSelectedRow() == -1){
        JOptionPane.showMessageDialog(null, "No has seleccionado una fila", "Seleccione una fila", JOptionPane.WARNING_MESSAGE);
        return;
    }
    DefaultTableModel mdl = (DefaultTableModel) tbl_establecimiento.getModel();
    String codigo = String.valueOf(mdl.getValueAt(tbl_establecimiento.getSelectedRow(), 0));
    String rut_admin = String.valueOf(mdl.getValueAt(tbl_establecimiento.getSelectedRow(), 4));
    int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Eliminar este esblecimiento ?", "Eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
   
    switch(opcion){
        case 0: 
            String cons = "DELETE FROM establecimiento WHERE id_establecimiento ='"+codigo+ "'";
            String cons1 = "DELETE FROM usuario WHERE rut_admin = '"+rut_admin+"'";
            try {
                Statement stm = conn.createStatement();
                Statement stm1 = conn.createStatement();
                stm.executeUpdate(cons);
                stm.executeUpdate(cons1);
                JOptionPane.showMessageDialog(null, "Se ha eliminado Correctamente","Eliminacion Concretada", JOptionPane.INFORMATION_MESSAGE);
                llenarTabla("");
            } catch (SQLException e) {                
                JOptionPane.showMessageDialog(null, "No se Pudo Eliminar", "Eliminacion Fallida", JOptionPane.ERROR_MESSAGE);
            }
            break;
        case 2: 
            JOptionPane.showMessageDialog(null, "Eliminacion Cancelada", "Eliminacion Cancelada",JOptionPane.INFORMATION_MESSAGE);
            break;
        default:
            System.out.println("Opcion no valida");
    }
}
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
            java.util.logging.Logger.getLogger(Establecimiento_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Establecimiento_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Establecimiento_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Establecimiento_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Establecimiento_Agregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cmb_tipo_admin;
    private javax.swing.JComboBox<String> cmb_tipo_educacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_establecimiento;
    private javax.swing.JTextField txt_busqueda;
    private javax.swing.JTextField txt_codigo_establecimiento;
    private javax.swing.JTextField txt_nom_admin;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_rut;
    // End of variables declaration//GEN-END:variables
}
