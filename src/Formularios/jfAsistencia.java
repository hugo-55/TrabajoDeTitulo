/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

/**
 *
 * @author lmart
 */
public class jfAsistencia extends javax.swing.JFrame {
    Statement stm=null;
    Conexion conex = new Conexion();
    Connection conn = (Connection) conex.realizarConexion();
    String rut_admin, id_establecimiento;

    /**
     * Creates new form jfAsistencia
     */
    public jfAsistencia() {
        initComponents();
        llenarTabla("");
        llenarTablaAsistenciaPasada("");
        filtrarxCurso();
        JOptionPane.showMessageDialog(null, "No olvide seleccionar el curso para la asistencia", "Asistencia", JOptionPane.INFORMATION_MESSAGE);
           
    }
    public jfAsistencia(String rut_admin){
        this.rut_admin = rut_admin;
        initComponents();
        llenarTabla("");
        llenarTablaAsistenciaPasada("");
        jDateChooser1.setMaxSelectableDate(new Date());
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        jDateChooser1.setDate(new Date());
        filtrarxCurso();
        /*try{
            Date fechaSeleccionada = format1.parse("2000-01-01");
            jDateChooser1.setDate(fechaSeleccionada);
        }catch(ParseException ex){
            System.out.println("Error de Parseo");
        }*/
        JOptionPane.showMessageDialog(null, "No olvide seleccionar el curso para la asistencia", "Asistencia", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void filtrarxCurso(){
        cbCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String curso = (String)cbCurso.getSelectedItem();
                llenarTablaAsistenciaFiltrado(curso);
                llenarTablaAsistenciaPasadaFiltrado(curso);
                //System.out.println(curso);
            }
        });

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
               //this.tipo_educacion = rs.getString("tipo_educacion");
               this.id_establecimiento = rs.getString("id_establecimiento");
           }
           
           
           
        }catch(SQLException ex){
            System.out.println("Error sql " +ex);
        }
        
        //System.out.println(tipo_educacion);
        System.out.println(id_establecimiento);
    }
    
    public void obtenerEstablecimiento(){
        String sql = "SELECT establecimiento.id_establecimiento FROM usuario, establecimiento WHERE  usuario.id_usuario = establecimiento.id_usuario AND rut_admin = '"+rut_admin+"'";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()){
                this.id_establecimiento = rs.getString("id_establecimiento");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Obtener ID establecimiento "+ex, "Error de obtencion", JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
    
    public void llenarTabla(String sql){
        DefaultTableModel model = new DefaultTableModel();
        jTableAsistencia.setModel(model);
        
        
        
        model.addColumn("Rut");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Asistencia");
        addCheckedBox(3,jTableAsistencia);
        try{
            String cons = "";
            if (sql.equals("")){
               //Tiene que filtrar x alumnos del establecimiento en el que se encuentre
               cons = "SELECT * FROM estudiante, cursos, matriculas WHERE matriculas.cod_curso = cursos.cod_curso AND matriculas.rut_estudiante = estudiante.rut_estudiante"; 
               //cons = "SELECT * FROM matriculas, estudiante, cursos WHERE matriculas.rut_estudiante = estudiante.rut_estudiante AND matriculas.cod_curso = cursos.cod_curso AND matriculas.id_establecimiento = '"+id_establecimiento;
               //cons = "SELECT estudiante.rut_estudiante, estudiante.nombres, estudiante.apellidos FROM estudiante, cursos, matriculas WHERE matriculas.cod_curso = cursos.cod_curso AND matriculas.rut_estudiante = estudiante.rut_estudiante AND matriculas.id_establecimiento = '"+ id_establecimiento+"' GROUP BY estudiante.rut_estudiante";
               //cons = "SELECT estudiante.rut_estudiante, estudiante.nombres, estudiante.apellidos, estudiante.fecha_nacimiento, estudiante.sexo FROM estudiante, matriculas where estudiante.rut_estudiante = matriculas.rut_estudiante and matriculas.id_establecimiento = '"+id_establecimiento+"'"; 
            }else{
                cons = sql;
            }
            //String sql = "SELECT * FROM estudiante, cursos, matriculas WHERE matriculas.cod_curso = cursos.cod_curso AND matriculas.rut_estudiante = estudiante.rut_estudiante";
            String[] datos = new String[3];
            stm = conn.createStatement();
            ResultSet res = stm.executeQuery(cons);
            while(res.next()){
                model.addRow(new Object []{
                    res.getString("rut_estudiante"),res.getString("nombres"),res.getString("apellidos")
                });
            }
            jTableAsistencia.setModel(model);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Cargar la Lista "+ex, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
        try{
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            String sql2 = "SELECT cod_curso FROM cursos";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql2);
            while (rs.next()) {
                modelo.addElement(rs.getString("cod_curso"));
                cbCurso.setModel(modelo);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Cargar los Cursos "+ex, "Error de Carga", JOptionPane.ERROR_MESSAGE);
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
        cmdAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAsistencia = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        cmdAsistencia = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbTipoDia = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAsistenciaPasada = new javax.swing.JTable();
        cbCurso = new javax.swing.JComboBox<>();
        btn_generar_reporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1039, 417));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Asistencia");

        cmdAtras.setText("Atras");
        cmdAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAtrasActionPerformed(evt);
            }
        });

        jTableAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableAsistencia);

        jLabel2.setText("Curso");

        jLabel3.setText("Fecha:");

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

        cmdAsistencia.setText("Pasar Asistencia");
        cmdAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsistenciaActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo Dia:");

        cbTipoDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habil", "No habil" }));

        jTableAsistenciaPasada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableAsistenciaPasada);

        cbCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        btn_generar_reporte.setText("Generar Reporte");
        btn_generar_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generar_reporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbTipoDia, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmdAsistencia)
                                            .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_generar_reporte)
                                .addGap(55, 55, 55))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusqueda))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbTipoDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(cmdAsistencia))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cmdAtras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_generar_reporte)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void llenarTablaAsistenciaPasada(String sql){
        DefaultTableModel model = new DefaultTableModel();
        jTableAsistenciaPasada.setModel(model);
        
        
        model.addColumn("Rut");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Fecha");
        model.addColumn("Asistencia");
        //model.addColumn("");
        //addCheckedBox(5,jTableAsistenciaPasada);
        //Checkbox checkbox1 = new Checkbox();
        
        try{
            String cons = "";
            if (sql.equals("")){
                cons = "SELECT * FROM estudiante, asistencia WHERE estudiante.rut_estudiante = asistencia.rut_estudiante"; 
            }else{
                cons = sql;
            }
            stm = conn.createStatement();
            ResultSet res = stm.executeQuery(cons);
            while(res.next()){
                model.addRow(new Object []{
                    res.getString("rut_estudiante"),res.getString("nombres"),res.getString("apellidos"),res.getDate("fecha"),res.getString("estado"),
                    
                });
            }
            jTableAsistenciaPasada.setModel(model);
        }catch(SQLException ex){
            
        }
        
    }
    //Funcion para crear un checkbox en cualquier lado pero no funcion elsetSelected
    //public Checkbox chekbox1 = new Checkbox().setSelected(true);
    
    public void addCheckedBox(int column, JTable table){
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }
    private void cmdAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAtrasActionPerformed
        dispose();
        new GestorFrame(rut_admin).setVisible(true);
    }//GEN-LAST:event_cmdAtrasActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        String busqueda = txtBusqueda.getText().trim();
        
        String sql = "SELECT * FROM estudiante, matriculas, cursos WHERE matriculas.cod_curso = cursos.cod_curso AND estudiante.rut_estudiante = matriculas.rut_estudiante AND estudiante.rut_estudiante LIKE '%"+busqueda+"%'";
        
        llenarTabla(sql);
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void cmdAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsistenciaActionPerformed
        
        for (int i = 0; i<jTableAsistencia.getRowCount();i++){
            //Trozo de codigo sacado del if de abajo jTableAsistencia.getSelectedRow()>=0 && 
            System.out.println(isSelected(i,3,jTableAsistencia));
            if(isSelected(i,3,jTableAsistencia)){
                //try{
                    //Obtencion de los datos (INICIO)
                    DefaultTableModel tm = (DefaultTableModel)jTableAsistencia.getModel();
                    String estado = "";
                
                    String rut = String.valueOf(tm.getValueAt(i,0));
                    String nombre = String.valueOf(tm.getValueAt(i,1));
                    String apellido = String.valueOf(tm.getValueAt(i,2));
                    //Date fecha = jDateChooser1;
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha =  format1.format(jDateChooser1.getDate());
                    String tipo_dia = (String)cbTipoDia.getSelectedItem();
                    //Obtencion de datos (FINAL)
                    estado = "Presente";
                    //Insertado de datos (INICIO)
                    try{
                        String inser = "INSERT INTO asistencia(fecha,rut_estudiante,estado,tipo_dia) VALUES ('"+fecha+"','"+rut+"','"+estado+"','"+tipo_dia+"')";
                        Statement stm = conn.createStatement();
                        stm.executeUpdate(inser);
                        JOptionPane.showMessageDialog(null, "Asistencia Pasada","Ingreso",1);
                    }catch(SQLException ei){
                        JOptionPane.showMessageDialog(null, "Error al pasar asistencia"+ei,"Insert",3);
                    }
                    //Insertado de datos (FINAL)
                    //System.out.println("Salida de try presente");
            }else{
                //try{
                    //System.out.println("Ingreso al try de ausente");
                    //Obtencion de los datos (INICIO)
                    DefaultTableModel tm = (DefaultTableModel)jTableAsistencia.getModel();
                    String estado = "";
                
                    String rut = String.valueOf(tm.getValueAt(i,0));
                    String nombre = String.valueOf(tm.getValueAt(i,1));
                    String apellido = String.valueOf(tm.getValueAt(i,2));
                    //Date fecha = jDateChooser1;
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha =  format1.format(jDateChooser1.getDate());
                    
                    String tipo_dia = (String)cbTipoDia.getSelectedItem();
                    //Obtencion de datos (FINAL)
                    
                    estado = "Ausente";
                    //Insertado de datos (INICIO)
                    try{
                        String inser = "INSERT INTO asistencia(fecha,rut_estudiante,estado,tipo_dia) VALUES ('"+fecha+"','"+rut+"','"+estado+"','"+tipo_dia+"')";
                        Statement stm = conn.createStatement();
                        stm.executeUpdate(inser);
                        JOptionPane.showMessageDialog(null, "Asistencia Pasada","Ingreso",1);
                    }catch(SQLException ei){
                        JOptionPane.showMessageDialog(null, "Error al pasar asistencia"+ei,"Insert",3);
                    }
                    //Insertado de datos (FINAL)
                /*}catch(Exception ei){
                    JOptionPane.showMessageDialog(null, "Error al procesar asistencia"+ei,"Insert",3);
                }*/
            }
        }
        llenarTablaAsistenciaPasada("");
    }//GEN-LAST:event_cmdAsistenciaActionPerformed

    
    private void cbCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCursoMouseClicked
        //System.out.println("Clickeado");
        /*String curso = (String)cbCurso.getSelectedItem();
        System.out.println(curso);
        llenarTablaAsistenciaFiltrado(curso);*/
        //llenarTablaAsistenciaPasadaFiltrado(curso);
    }//GEN-LAST:event_cbCursoMouseClicked
    
    private void cbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCursoActionPerformed

    private void btn_generar_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_reporteActionPerformed
       String dateTime = DateTimeFormatter.ofPattern("YYYY-MM").format(LocalDateTime.now()); //Devuelve Fecha formato 2022-08
        
        File fichero = new File("src/principal/rutaReportes.txt"); //buscamos la ruta donde guardar reportes
        if(!fichero.exists()) {
            JOptionPane.showMessageDialog(null, "No hay una ruta especificada para la creacion de los reportes, por favor configurela en ADMINISTRACION", "Configure la ruta para reportes", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        FileReader fr;
        String ruta = ""; //obtenemos la ruta
        try {
            fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            ruta = br.readLine();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Ruta no Encontrada","Error de ruta",JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IOException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo","Error de lectura",JOptionPane.ERROR_MESSAGE);
            return;
        }
        //aca creamos ruta para el guardado de carpetas mensuales // c:/user/juan/documents/prueba/{{2022-08}}
        File fichero2 = new File(ruta+"/"+dateTime);
        
        if(!fichero2.exists()){ // si el fichero no existe, se procede a crearlo
            if(!fichero2.mkdir()){
                JOptionPane.showMessageDialog(null, "No se pudo crear el fichero especificado","Error al crear fichero",JOptionPane.ERROR_MESSAGE);
            }
        }else{ //si el fichero existe se guardan los archivos diarios en el
            String dateTime2 = DateTimeFormatter.ofPattern("MM-dd").format(LocalDateTime.now());
            File fichero3 = new File(ruta + "/" + dateTime + "/" + dateTime2+".pdf");
            
            Document documento = new Document() {
                @Override
                public int getLength() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void addDocumentListener(DocumentListener listener) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void removeDocumentListener(DocumentListener listener) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void addUndoableEditListener(UndoableEditListener listener) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void removeUndoableEditListener(UndoableEditListener listener) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object getProperty(Object key) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void putProperty(Object key, Object value) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void remove(int offs, int len) throws BadLocationException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public String getText(int offset, int length) throws BadLocationException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void getText(int offset, int length, Segment txt) throws BadLocationException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Position getStartPosition() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Position getEndPosition() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Position createPosition(int offs) throws BadLocationException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Element[] getRootElements() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Element getDefaultRootElement() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void render(Runnable r) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            try{
                PdfWriter.getInstance(documento, new FileOutputStream(fichero3));
                
                documento.open();
                PdfPTable tabla = new PdfPTable(5);
                tabla.addCell("ID");
                tabla.addCell("Fecha");
                tabla.addCell("Tipo Pago");
                tabla.addCell("Total");
                tabla.addCell("Vendedor");
                
                String cons = "Select id_venta, fecha_hora, tipo_pago, total_pago, nombre_completo from ventas, empleadott where estado_venta = 'A' and ventas.rut_empleado = empleadott.rut_empleado and fecha_hora  >= trunc(sysdate) and fecha_hora < trunc(sysdate + 1)";
                String total;
                int totalTotal = 0;
                try{
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(cons);
                    
                    while(rs.next()){
                        totalTotal += rs.getInt("total_pago");
                        total = formato.format(rs.getInt("total_pago"));
                        tabla.addCell(String.valueOf(rs.getInt("id_venta")));
                        tabla.addCell(rs.getString("fecha_hora"));
                        if(rs.getString("tipo_pago").equalsIgnoreCase("E")){
                            tabla.addCell("Efectivo");
                        }else{
                            tabla.addCell("Debito");
                        }
                        tabla.addCell(total);
                        tabla.addCell(rs.getString("nombre_completo"));
                        
                        
                    }
                    tabla.addCell("");
                    tabla.addCell("");
                    tabla.addCell("");
                    tabla.addCell("Ganancia: ");
                    tabla.addCell(formato.format(totalTotal));
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al obtener los datos de las ventas", "Error de Obtencion", JOptionPane.ERROR_MESSAGE);
                }
                documento.add(tabla);
                
            }catch(DocumentException | FileNotFoundException ex){
                System.out.println(ex);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado y Caja Cerrada Exitosamente!", "Caja Cerrada",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_generar_reporteActionPerformed
    
    public boolean isSelected(int row, int column, JTable table){
        return table.getValueAt(row,column) != null;
    }
    
    public void llenarTablaAsistenciaFiltrado(String curso){
        //System.out.println("Impresion en tabla filtrada");
        //("SELECT * FROM estudiante, cursos, matriculas WHERE matriculas.cod_curso = cursos.cod_curso AND matriculas.rut_estudiante = estudiante.rut_estudiante"; 
        String sql = "SELECT * FROM matriculas,estudiante,cursos WHERE matriculas.cod_curso = '"+curso+"' AND matriculas.rut_estudiante = estudiante.rut_estudiante GROUP by estudiante.rut_estudiante";
        System.out.println(sql);
        llenarTabla(sql);
    }
    public void llenarTablaAsistenciaPasadaFiltrado(String curso){
        
        String sql = "SELECT * FROM estudiante, asistencia, matriculas  WHERE matriculas.cod_curso = '"+curso+"' AND estudiante.rut_estudiante = matriculas.rut_estudiante GROUP by estudiante.rut_estudiante"; 
        
        llenarTablaAsistenciaPasada(sql);
    }
    public String obtenerCodigoCurso(String curso){
        String codcurso = "";
        try{
            String sql = "SELECT cod_curso FROM cursos WHERE cursos.nombre = '"+curso+"'";
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
            java.util.logging.Logger.getLogger(jfAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfAsistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btn_generar_reporte;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JComboBox<String> cbTipoDia;
    private javax.swing.JButton cmdAsistencia;
    private javax.swing.JButton cmdAtras;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAsistencia;
    private javax.swing.JTable jTableAsistenciaPasada;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
