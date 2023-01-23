
package Formularios;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class jfMatricularAlu extends javax.swing.JFrame {
    Statement stm=null;
    String rut_admin;
    Conexion conex = new Conexion();
    Connection conn = (Connection) conex.realizarConexion();

    String tipo_educacion, id_establecimiento;
    
    public jfMatricularAlu() {
        initComponents();
        llenarComboBox();
        llenarTablaAlumnos("");
        llenarTablaMatriculas("");
    }
    
    public jfMatricularAlu(String rut_admin){
        this.rut_admin = rut_admin;
        initComponents();
        obtenerData();
        llenarComboBox();
        llenarTablaAlumnos("");
        llenarTablaMatriculas("");
    }
    
    private void llenarComboBox(){
        String sql = "Select cod_curso from cursos where id_establecimiento = '"+id_establecimiento+"'";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                cbCurso.addItem(rs.getString("cod_curso"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Cargar el combobox "+ex, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    private void obtenerData(){
        String sql = "select usuario.id_usuario, establecimiento.id_establecimiento ,establecimiento.tipo_educacion from usuario, establecimiento " +
       "WHERE usuario.id_usuario = establecimiento.id_usuario AND " +
       "usuario.rut_admin = '"+rut_admin+"'";
        
        try{
           Statement stm = conn.createStatement();
           ResultSet rs = stm.executeQuery(sql);
           
           if(rs.next()){
               //tipo_educacion = rs.getString("tipo_educacion");
               this.tipo_educacion = rs.getString("tipo_educacion");
               this.id_establecimiento = rs.getString("id_establecimiento");
           }
           
           
           
        }catch(SQLException ex){
            System.out.println("Error sql " +ex);
        }
        
        System.out.println(tipo_educacion);
        System.out.println(id_establecimiento);
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlu = new javax.swing.JTable();
        cmdAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbCurso = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMatriculados = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cmdMatricular = new javax.swing.JButton();
        cmdManejoAlu = new javax.swing.JButton();
        cmdEliminarAlu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

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

        jTableAlu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableAlu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAluMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAlu);

        cmdAtras.setText("Atras");
        cmdAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAtrasActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Matricular Alumnos Año:");

        cbCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCursoMouseClicked(evt);
            }
        });
        cbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCursoActionPerformed(evt);
            }
        });

        jLabel2.setText("Curso");

        jYearChooser1.setMaximum(2023);
        jYearChooser1.setMinimum(1980);

        jTableMatriculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMatriculados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMatriculadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMatriculados);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Alumnos:");

        cmdMatricular.setText("Matricular");
        cmdMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMatricularActionPerformed(evt);
            }
        });

        cmdManejoAlu.setText("Manejo Alumnos");
        cmdManejoAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdManejoAluActionPerformed(evt);
            }
        });

        cmdEliminarAlu.setText("Eliminar Matricula");
        cmdEliminarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarAluActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(256, 256, 256)
                                .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmdManejoAlu, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                                .addComponent(cmdMatricular)
                                                .addGap(37, 37, 37))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel2)
                                                .addGap(23, 23, 23)
                                                .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmdEliminarAlu)))))
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAtras))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusqueda))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(86, 86, 86)
                        .addComponent(cmdMatricular)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdManejoAlu)
                    .addComponent(cmdEliminarAlu))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        String busqueda = txtBusqueda.getText().trim();

        String sql = "SELECT * FROM estudiante WHERE estudiante.rut_estudiante LIKE '%"+busqueda+"%'";

        llenarTablaAlumnos(sql);
        
    }//GEN-LAST:event_btnBusquedaActionPerformed
    public void llenarTablaAlumnos(String sql){
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
    
    private void llenarTablaMatriculas(String sql){
        
        DefaultTableModel model = new DefaultTableModel();
        
        jTableMatriculados.setModel(model);
        
        model.addColumn("N° Matricula");
        model.addColumn("Rut");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Curso");
        
        try{
            String cons = "";
            if(sql.equals("")){
                cons = "SELECT * FROM matriculas, estudiante, cursos WHERE matriculas.rut_estudiante = estudiante.rut_estudiante AND matriculas.cod_curso = cursos.cod_curso AND matriculas.id_establecimiento = '"+id_establecimiento+"' GROUP by estudiante.rut_estudiante";
            }else{
                cons = sql;
            }
            //String sql = "SELECT * FROM matriculas, estudiante, curso WHERE matriculas.rut_estudiante = estudiante.rut_estudiante AND matriculas.cod_curso = cursos.cod_curso";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            
            while(rs.next()){
                model.addRow( new Object[]{
                    rs.getString("id_matricula"), rs.getString("rut_estudiante"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("cod_curso")
                });
            }
            jTableMatriculados.setModel(model);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Cargar la Lista "+ex, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void jTableAluMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAluMouseClicked
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");

        //Seleccionado de datos para pasarlos a Modificar
        if (jTableAlu.getSelectedRow()>=0){
            try{
                DefaultTableModel tm = (DefaultTableModel)jTableAlu.getModel();
                String rut = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),0));

            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"");
            }
        }else{
            JOptionPane.showMessageDialog(this,"DEBE SELECCIONAR UN ESTUDIANTE","SISTEMA",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTableAluMouseClicked

    private void cmdAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAtrasActionPerformed
        dispose();
        new GestorFrame(rut_admin).setVisible(true);
    }//GEN-LAST:event_cmdAtrasActionPerformed

    private void cbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCursoActionPerformed

    private void jTableMatriculadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMatriculadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMatriculadosMouseClicked

    private void cmdManejoAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdManejoAluActionPerformed
        new jfAlumnos(rut_admin).setVisible(true);
    }//GEN-LAST:event_cmdManejoAluActionPerformed

    private void cmdMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMatricularActionPerformed

        if(jTableAlu.getSelectedRow() == -1){
            return;
        }
        
        DefaultTableModel tm = (DefaultTableModel)jTableAlu.getModel();
        String rut = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),0));
        String nombre = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),1));
        String apellido = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),2));
        String curso = (String)cbCurso.getSelectedItem();
        
        Calendar c1 = new GregorianCalendar();
        String annio = Integer.toString(c1.get(Calendar.YEAR));
        
        
        String sql_comprobar = "select count(*) as cantidad from matriculas where rut_estudiante = '"+rut+"' and id_establecimiento='"+id_establecimiento+"' and cod_curso = '"+curso+"' and anno = "+annio;
        JOptionPane.showMessageDialog(this, sql_comprobar);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql_comprobar);
            
            if(rs.next()){
                int cantidad = rs.getInt("cantidad");
                
                if(cantidad > 0){
                    JOptionPane.showMessageDialog(this,"Este Alumno ya esta matriculado en este establecimiento este a\u00f1o ","No se pudo Matricular",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Error en la consulta "+ex,"error al consultar",JOptionPane.ERROR_MESSAGE);
        }
        
        String sql = "INSERT INTO matriculas (cod_curso, id_establecimiento, rut_estudiante, anno, vtc, estado) "
                + "VALUES('"+curso+"','"+id_establecimiento+"','"+rut+"',"+annio+",0,'Matriculado')";
        String sql1 = "SELECT matriculas.rut_estudiante, matriculas.anno FROM matriculas";
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            Statement stm1 = conn.createStatement();
            stm1.executeQuery(sql1);
            if(rut.equals("matriculas.rut_estudiante") && annio.equals("matriculas.anno")){
                try{
                    //Statement stm1 = conn.createStatement();
                    stm.executeQuery(sql1);
                    JOptionPane.showMessageDialog(this,"Alumno ya se encuentra matriculado","Alumno ya matriculado este año",JOptionPane.ERROR_MESSAGE);
                    //llenarTablaMatriculas("");
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, "Error al matricular alumno","Error al matricular",JOptionPane.ERROR_MESSAGE);
                }    
            }
            JOptionPane.showMessageDialog(this,"Alumno Matriculado Exitosamente!","Matricula Exitosa",JOptionPane.INFORMATION_MESSAGE);
            llenarTablaMatriculas("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Alumno ya se encuentra matriculado para este año","Alumno ya matriculado",JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_cmdMatricularActionPerformed

    private void cbCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCursoMouseClicked
        //System.out.println("Clickeado");
        String curso = (String)cbCurso.getSelectedItem();
        llenarTablaMatriculasFiltrado(curso);
    }//GEN-LAST:event_cbCursoMouseClicked

    private void cmdEliminarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarAluActionPerformed

        if(jTableMatriculados.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "No has seleccionado una fila", "Seleccione una fila", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel tm = (DefaultTableModel)jTableMatriculados.getModel();
        System.out.println("Definicion Modelo tabla");
        //Obtencion de Numero de Matricula
        String numMatricula = String.valueOf(tm.getValueAt(jTableMatriculados.getSelectedRow(),0));
        Integer matricula = Integer.parseInt(numMatricula);
        System.out.println("Obtencion de Numero Matricula");
        //--------------------------------
        //Obtencion de Ruta Alumno
        String rut = String.valueOf(tm.getValueAt(jTableMatriculados.getSelectedRow(), 1));
        System.out.println("Obtencion de rut");
        //------------------------
        //Obtencion Codigo Curso
        /*String curso = (String)cbCurso.getSelectedItem();
        Integer cursoDB = Integer.valueOf(obtenerCodigoCurso(curso));*/
        String curso = String.valueOf(tm.getValueAt(jTableMatriculados.getSelectedRow(),4));
        System.out.println("Obtencion del codigo de curso: "+curso);
        //----------------------
        //Obtencion Id establecimiento
        Integer establecimientoDB = Integer.valueOf(obtenerIDEstablecimiento(curso));
        System.out.println("Obtencion de id establecimiento");
        //----------------------------
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Eliminar esta Matricula?", "Eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        
        switch(opcion){
            case 0:
            String cons = "DELETE FROM matriculas WHERE id_matricula = '"+matricula+"'AND cod_curso = '"+curso+"'AND id_establecimiento = '"+establecimientoDB+"'AND rut_estudiante= '"+rut+"'";

            try{
                Statement stm = conn.createStatement();
                stm.executeUpdate(cons);
                JOptionPane.showMessageDialog(null, "Se ha eliminado Correctamente","Eliminacion Concretada", JOptionPane.INFORMATION_MESSAGE);
                llenarTablaMatriculas("");
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
        //llenarTablaMatriculas("");
    }//GEN-LAST:event_cmdEliminarAluActionPerformed
    public void llenarTablaMatriculasFiltrado(String curso){
        //Integer cursoDB = Integer.valueOf(obtenerCodigoCurso(curso));
        //"SELECT * FROM matriculas, estudiante, cursos WHERE matriculas.rut_estudiante = estudiante.rut_estudiante AND matriculas.cod_curso = cursos.cod_curso";
        String sql = "SELECT * FROM matriculas,estudiante,cursos WHERE matriculas.cod_curso LIKE '%"+curso+"%' AND matriculas.rut_estudiante = estudiante.rut_estudiante AND matriculas.cod_curso = cursos.cod_curso AND matriculas.id_establecimiento = '"+id_establecimiento+"' GROUP by estudiante.rut_estudiante";

        llenarTablaMatriculas(sql);
    }
    
    public String obtenerCodigoCurso(String curso){
        String codcurso = "";
        try{
            String sql = "SELECT cod_curso FROM cursos WHERE cursos.nombre= '"+curso+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            if (rs.next()){
                codcurso = rs.getString("cod_curso");
            }else{
                codcurso = "";
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,"ERROR AL SELECCIONAR EL CURSO","SISTEMA",JOptionPane.WARNING_MESSAGE);
        }
        return codcurso;
    }
    public String obtenerIDEstablecimiento(String curso){
        String idesta="";
        try{
            String sql = "SELECT id_establecimiento FROM cursos WHERE cursos.cod_curso = '"+curso+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            if (rs.next()){
                idesta= rs.getString("id_establecimiento");
            }else{
                idesta = "";
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,"ERROR AL SELECCIONAR EL ESTABLECIMIENTO","SISTEMA",JOptionPane.WARNING_MESSAGE);
        }
        return idesta;
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
            java.util.logging.Logger.getLogger(jfMatricularAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfMatricularAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfMatricularAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfMatricularAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfMatricularAlu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JButton cmdAtras;
    private javax.swing.JButton cmdEliminarAlu;
    private javax.swing.JButton cmdManejoAlu;
    private javax.swing.JButton cmdMatricular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlu;
    private javax.swing.JTable jTableMatriculados;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
