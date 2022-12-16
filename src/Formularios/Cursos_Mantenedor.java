
package Formularios;

import java.sql.*;
import com.mysql.jdbc.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cursos_Mantenedor extends javax.swing.JFrame {

    private String rut_admin;
    Conexion conex = new Conexion();
    Connection conn = (Connection) conex.realizarConexion();
    
    public Cursos_Mantenedor() {
        initComponents();
    }
    
    public Cursos_Mantenedor(String rut_admin){
        this.rut_admin = rut_admin;
        Calendar c1 = new GregorianCalendar();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        String mes = Integer.toString(c1.get(Calendar.MONTH));
        String annio = Integer.toString(c1.get(Calendar.YEAR));
        
        initComponents();
         txt_annio.setText(annio);
        llenarTabla("");
    }
    public void insertarDatos(){
    //Validacion de que hay un solo curso con es nombre
  /* String rut_admin = txt_rut.getText().trim();
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
    }*/
    
    
    Calendar c1 = new GregorianCalendar();
     String dia = Integer.toString(c1.get(Calendar.DATE));
     String mes = Integer.toString(c1.get(Calendar.MONTH));
     String annio = Integer.toString(c1.get(Calendar.YEAR));
    if(txt_nombre_curso.getText().equals("") ||
       txt_letra.getText().equals("") ){
        JOptionPane.showMessageDialog(null, "Los campos no deben estar Vacios", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    
    try {
        String SQL= "insert into cursos(nombre,nivel,letra,anno) values (?,?,?,?) ";
        PreparedStatement pst =  conn.prepareStatement(SQL);
        pst.setString(1 , txt_nombre_curso.getText());
        int seleccionado =cmb_nivel.getSelectedIndex();
        pst.setString(2 , cmb_nivel.getItemAt(seleccionado));
        pst.setString(3 , txt_letra.getText());
        pst.setString(4 ,  annio);
        
       
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

    public void llenarTabla(String sql){
       DefaultTableModel modelo = (DefaultTableModel) tbl_curso.getModel();
        modelo.setRowCount(0);
       tbl_curso.setModel(modelo);
       try{
            String cons = "";
            if(sql.equals("")){
                cons =  "SELECT usuario.id_usuario, establecimiento.id_establecimiento, cursos.* FROM usuario, establecimiento, cursos WHERE usuario.id_usuario = establecimiento.id_usuario AND cursos.id_establecimiento = establecimiento.id_establecimiento AND rut_admin = '"+rut_admin+"'";
            }else{
                cons = sql;
            }
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                modelo.addRow( new Object[]{
                   rs.getString("nombre"), rs.getString("nivel"), rs.getString("letra"), rs.getString("anno")
                });
            }

            tbl_curso.setModel(modelo);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Cargar la Lista "+ex, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
    }


    private String[] obtenerListadosCursos(){
        System.out.println(rut_admin);
        String sql = "SELECT usuario.id_usuario, establecimiento.id_establecimiento, cursos.* FROM usuario, establecimiento, cursos WHERE usuario.id_usuario = establecimiento.id_usuario AND cursos.id_establecimiento = establecimiento.id_establecimiento AND rut_admin = '"+rut_admin+"'";
        
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getInt("cod_curso"));
            }
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al obtener cursos", "Error de obtencion",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        String[] aa = new String[5];
        return aa;
    }    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        btn_modificar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre_curso = new javax.swing.JTextField();
        txt_letra = new javax.swing.JTextField();
        cmb_nivel = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_annio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_curso = new javax.swing.JTable();
        btn_buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(153, 204, 255));

        btn_modificar.setText("Modificar");

        btn_atras.setText("Atras");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre del Curso :");

        jLabel2.setText("Letra :");

        jLabel3.setText("Nivel : ");

        txt_nombre_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_cursoActionPerformed(evt);
            }
        });

        cmb_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basica", "Media", "Ambas" }));

        jLabel5.setText("Año :");

        txt_annio.setText("jLabel7");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_agregar)
                        .addGap(19, 19, 19)
                        .addComponent(btn_modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btn_eliminar)
                        .addGap(33, 33, 33)
                        .addComponent(btn_atras))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombre_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_nivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_letra)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_annio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombre_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_letra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmb_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txt_annio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_atras)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_modificar)
                    .addComponent(btn_agregar))
                .addGap(54, 54, 54))
        );

        tbl_curso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Nivel", "Letra", "Año"
            }
        ));
        jScrollPane1.setViewportView(tbl_curso);

        btn_buscar.setText("Buscar");

        jLabel4.setText("Busqueda :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombre_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_cursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_cursoActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_atrasActionPerformed

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
            java.util.logging.Logger.getLogger(Cursos_Mantenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cursos_Mantenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cursos_Mantenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cursos_Mantenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cursos_Mantenedor().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cmb_nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tbl_curso;
    private javax.swing.JLabel txt_annio;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_letra;
    private javax.swing.JTextField txt_nombre_curso;
    // End of variables declaration//GEN-END:variables
}
