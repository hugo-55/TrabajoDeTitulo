
package Formularios;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class jfAlumnos extends javax.swing.JFrame {
    //Connection conex=null;
    Statement stm=null;
    Conexion conex = new Conexion();
    Connection conn = (Connection) conex.realizarConexion();
    String rut_admin, id_establecimiento;

    
    public jfAlumnos() {
        initComponents();
        llenarTabla("");
        jdFechaNacimiento.setMaxSelectableDate(new Date());
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date fechaSeleccionada = format1.parse("2000-01-01");
            jdFechaNacimiento.setDate(fechaSeleccionada);
        }catch(ParseException ex){
            System.out.println("Error de Parseo");
        }
    }
    
    public jfAlumnos(String rut_admin){
        this.rut_admin = rut_admin;
        obtenerEstablecimiento();
        initComponents();
        llenarTabla("");
        jdFechaNacimiento.setMaxSelectableDate(new Date());
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date fechaSeleccionada = format1.parse("2000-01-01");
            jdFechaNacimiento.setDate(fechaSeleccionada);
        }catch(ParseException ex){
            System.out.println("Error de Parseo");
        }
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
        
        jTableAlu.setModel(model);
        
        model.addColumn("Rut");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Fecha Nacimiento");
        model.addColumn("Genero");
        
        
        try{
            String cons = "";
            if(sql.equals("")){
                cons = "SELECT estudiante.rut_estudiante, estudiante.nombres, estudiante.apellidos, estudiante.fecha_nacimiento, estudiante.sexo FROM estudiante, matriculas where estudiante.rut_estudiante = matriculas.rut_estudiante and matriculas.id_establecimiento = '"+id_establecimiento+"'";
                System.out.println(cons);
            }else{
                cons = sql;
            }
            //String sql = "SELECT * FROM estudiante";
            String[] datos = new String[4];
            stm = conn.createStatement();
            ResultSet res = stm.executeQuery(cons);
            int cont = 0;
            while(res.next()){
                model.addRow( new Object[]{
                    res.getString("rut_estudiante"), res.getString("nombres"), res.getString("apellidos"), res.getString("fecha_nacimiento"), res.getString("sexo")
                });
                cont++;
            }
            jTableAlu.setModel(model);
            if(cont == 0){
                JOptionPane.showMessageDialog(null, "No se han Encontrado Resultados para la Busqueda", "Busqueda sin Resultados", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Cargar la Lista "+ex, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jProgressBar1 = new javax.swing.JProgressBar();
        btnGroupSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlu = new javax.swing.JTable();
        cmdAtras = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbTipoEducacion = new javax.swing.JComboBox<>();
        btnFiltrarCurso = new javax.swing.JButton();
        panel_alumno = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtRutAlu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApeAlu = new javax.swing.JTextField();
        txtNomAlu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jdFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        rbMasc = new javax.swing.JRadioButton();
        rbFem = new javax.swing.JRadioButton();
        cmdAgregarAlu = new javax.swing.JButton();
        cmdModificarAlu = new javax.swing.JButton();
        cmdEliminarAlu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(543, 371));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mantenedor de Alumnos");

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

        jLabel7.setText("Busqueda por Rut:");

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

        jLabel8.setText("Filtrar pot Curso:");

        cmbTipoEducacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo" }));

        btnFiltrarCurso.setText("Filtrar");

        panel_alumno.setBackground(new java.awt.Color(51, 51, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rut:");

        txtRutAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutAluActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido:");

        txtApeAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeAluActionPerformed(evt);
            }
        });
        txtApeAlu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApeAluKeyTyped(evt);
            }
        });

        txtNomAlu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomAluKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Nacimiento:");

        jdFechaNacimiento.setDateFormatString("dd-MM-yyyy");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sexo:");

        rbMasc.setBackground(new java.awt.Color(51, 51, 255));
        btnGroupSexo.add(rbMasc);
        rbMasc.setForeground(new java.awt.Color(255, 255, 255));
        rbMasc.setSelected(true);
        rbMasc.setText("Masculino");

        rbFem.setBackground(new java.awt.Color(51, 51, 255));
        btnGroupSexo.add(rbFem);
        rbFem.setForeground(new java.awt.Color(255, 255, 255));
        rbFem.setText("Femenino");

        cmdAgregarAlu.setBackground(new java.awt.Color(153, 51, 255));
        cmdAgregarAlu.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmdAgregarAlu.setForeground(new java.awt.Color(255, 255, 255));
        cmdAgregarAlu.setText("Agregar");
        cmdAgregarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarAluActionPerformed(evt);
            }
        });

        cmdModificarAlu.setBackground(new java.awt.Color(153, 51, 255));
        cmdModificarAlu.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmdModificarAlu.setForeground(new java.awt.Color(255, 255, 255));
        cmdModificarAlu.setText("Modificar");
        cmdModificarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModificarAluActionPerformed(evt);
            }
        });

        cmdEliminarAlu.setBackground(new java.awt.Color(153, 51, 255));
        cmdEliminarAlu.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmdEliminarAlu.setForeground(new java.awt.Color(255, 255, 255));
        cmdEliminarAlu.setText("Eliminar");
        cmdEliminarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarAluActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_alumnoLayout = new javax.swing.GroupLayout(panel_alumno);
        panel_alumno.setLayout(panel_alumnoLayout);
        panel_alumnoLayout.setHorizontalGroup(
            panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_alumnoLayout.createSequentialGroup()
                .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_alumnoLayout.createSequentialGroup()
                        .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_alumnoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel_alumnoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(panel_alumnoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jdFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomAlu)
                                .addComponent(txtRutAlu)
                                .addComponent(txtApeAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_alumnoLayout.createSequentialGroup()
                                .addComponent(rbMasc)
                                .addGap(18, 18, 18)
                                .addComponent(rbFem))))
                    .addGroup(panel_alumnoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdAgregarAlu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(cmdModificarAlu)
                        .addGap(28, 28, 28)
                        .addComponent(cmdEliminarAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_alumnoLayout.setVerticalGroup(
            panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_alumnoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_alumnoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(txtRutAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_alumnoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(txtNomAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApeAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jdFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbMasc)
                        .addComponent(rbFem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(panel_alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAgregarAlu)
                    .addComponent(cmdEliminarAlu)
                    .addComponent(cmdModificarAlu))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbTipoEducacion, 0, 189, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBusqueda)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(btnFiltrarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(panel_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBusqueda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbTipoEducacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrarCurso))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(panel_alumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(cmdAtras)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdModificarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModificarAluActionPerformed
        
        //obtener datos
        
        String rut = txtRutAlu.getText().trim();
        String nombres = txtNomAlu.getText().trim();
        String apellidos = txtApeAlu.getText().trim();
        JDateChooser fechaNacimiento_alumno = jdFechaNacimiento;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_alumno_nacimiento =  format1.format(fechaNacimiento_alumno.getDate());
        
        char sexo = 'I';
        
        if(rbMasc.isSelected()) sexo = 'M';
        if(rbFem.isSelected()) sexo = 'F';
        
        //validar
        
        if(rut.equals("") || nombres.equals("") || apellidos.equals("") || fecha_alumno_nacimiento.equals("")){
            JOptionPane.showMessageDialog(null, "Hay campos sin Rellenar", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        //modificar
        String sql = "UPDATE estudiante SET nombres = '"+nombres+"', apellidos = '"+apellidos+"', fecha_nacimiento = '"+fecha_alumno_nacimiento+"', sexo = '"+sexo+"' WHERE rut_estudiante = '"+rut+"'";
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Alumno Modificado Exitosamente!", "Modificacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            llenarTabla("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar el Alumno", "Error de Modificacion", JOptionPane.ERROR_MESSAGE);
        }   
        
    }//GEN-LAST:event_cmdModificarAluActionPerformed

    private void cmdAgregarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarAluActionPerformed
        //obtener datos
        String rut_alumno = txtRutAlu.getText().trim();
        String nombre_alumno = txtNomAlu.getText().trim();
        String apellido_alumno = txtApeAlu.getText().trim();
        JDateChooser fechaNacimiento_alumno = jdFechaNacimiento;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_alumno_nacimiento =  format1.format(fechaNacimiento_alumno.getDate());
        char sexo = 'I';
        if(rbMasc.isSelected()) sexo = 'M';
        if(rbFem.isSelected()) sexo = 'F';
        
        
        Validacion_RUT validacion = new Validacion_RUT(rut_alumno);
        
        if(!validacion.Validacion_Concreta()){
            JOptionPane.showMessageDialog(null, "El Rut no es Correcto", "Rut Incorrecto", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sql = "SELECT count(*) as cantidad FROM estudiante WHERE rut_estudiante = '"+rut_alumno+"'";
        
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()){
                int cantidad = rs.getInt("cantidad");
                if(cantidad > 0){
                    JOptionPane.showMessageDialog(null, "Ya existe un estudiante con este rut.");
                    txtRutAlu.selectAll();
                    txtRutAlu.requestFocus();
                    return;
                }else{
                    agregarEstudiante(rut_alumno, nombre_alumno, apellido_alumno, fecha_alumno_nacimiento, sexo);
                }
            }
            
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al buscar estudiante", "Error de consulta", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
    }//GEN-LAST:event_cmdAgregarAluActionPerformed

    private void agregarEstudiante(String rut_estudiante, String nombres, String apellidos, String fecha_nacimiento, char sexo){
        
        String sql = "INSERT INTO estudiante (rut_estudiante, nombres, apellidos, fecha_nacimiento, sexo) "
                + "VALUES ('"+rut_estudiante+"','"+nombres+"','"+apellidos+"','"+fecha_nacimiento+"','"+sexo+"')";
        
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Estudiante Ingresado Correctamente", "Insercion Exitosa!", JOptionPane.INFORMATION_MESSAGE);
            
            //borrarCampos
            txtRutAlu.setText("");
            txtNomAlu.setText("");
            txtApeAlu.setText("");
            rbMasc.setSelected(true);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date fechaSeleccionada = format1.parse("2000-01-01");
                jdFechaNacimiento.setDate(fechaSeleccionada);
            }catch(ParseException ex){
                System.out.println("Error de Parseo");
            }
            //llenar Tabla
            llenarTabla("");
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Ingresar el Estudiante", "Error de Insercion", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
    
    
    private void cmdAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAtrasActionPerformed
        dispose();
        new GestorFrame(rut_admin).setVisible(true);
    }//GEN-LAST:event_cmdAtrasActionPerformed

    private void txtRutAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutAluActionPerformed

    private void txtApeAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeAluActionPerformed

    private void jTableAluMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAluMouseClicked
        
        if(jTableAlu.getSelectedRow() >= 0){
            DefaultTableModel tm = (DefaultTableModel)jTableAlu.getModel();
            String rut = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),0));
            String nombre = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),1));
            String apellido = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),2));
            String fecha = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),3));
            String sexo = String.valueOf(tm.getValueAt(jTableAlu.getSelectedRow(),4));
            
            txtRutAlu.setText(rut);
            txtNomAlu.setText(nombre);
            txtApeAlu.setText(apellido);
            if(sexo.equalsIgnoreCase("M")){
                rbMasc.setSelected(true);
            }
            if(sexo.equalsIgnoreCase("F")){
                rbFem.setSelected(true);
            }
            
            //cambiar fecha
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fechaSeleccionada = format1.parse(fecha);
                jdFechaNacimiento.setDate(fechaSeleccionada);
                
            } catch (ParseException ex) {
                System.out.println("parse error");
            }
             
            
        }
        
    }//GEN-LAST:event_jTableAluMouseClicked

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        String busqueda = txtBusqueda.getText().trim();
        
        String sql = "SELECT * FROM estudiante, matriculas WHERE estudiante.rut_estudiante = matriculas.rut_estudiante AND estudiante.rut_estudiante LIKE '%"+busqueda+"%' AND matriculas.id_establecimiento = '"+id_establecimiento+"'";
        
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
                
                String cons = "SELECT count(*) as cantidad FROM matriculas WHERE rut_estudiante = '"+rut+"'";
                
                try {
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(cons);
                    
                    if(rs.next()){
                        int cantidad = rs.getInt("cantidad");
                        if(cantidad > 0){
                            JOptionPane.showMessageDialog(null,"No se puede eliminar este alumno ya que estuvo/esta matriculado","no se pudo eliminar",JOptionPane.WARNING_MESSAGE);
                        }else{
                            eliminarEstudiante(rut);
                        }
                    }
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"No se pudo consultar en Matriculas","no se pudo consultar",JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Eliminacion Cancelada", "Eliminacion Cancelada",JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }//GEN-LAST:event_cmdEliminarAluActionPerformed

    private void eliminarEstudiante(String rut){
        String cons = "DELETE FROM estudiante WHERE rut_estudiante = '"+rut+"'";
                
        try{
            Statement stm = conn.createStatement();
            stm.executeUpdate(cons);
            JOptionPane.showMessageDialog(null, "Se ha eliminado Correctamente","Eliminacion Concretada", JOptionPane.INFORMATION_MESSAGE);
            llenarTabla("");
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"No se puede eliminar el alumno","no se pudo eliminar",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void txtNomAluKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomAluKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNomAluKeyTyped

    private void txtApeAluKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeAluKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtApeAluKeyTyped

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
    private javax.swing.JButton btnFiltrarCurso;
    private javax.swing.ButtonGroup btnGroupSexo;
    private javax.swing.JComboBox<String> cmbTipoEducacion;
    private javax.swing.JButton cmdAgregarAlu;
    private javax.swing.JButton cmdAtras;
    private javax.swing.JButton cmdEliminarAlu;
    private javax.swing.JButton cmdModificarAlu;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAlu;
    private com.toedter.calendar.JDateChooser jdFechaNacimiento;
    private javax.swing.JPanel panel_alumno;
    private javax.swing.JRadioButton rbFem;
    private javax.swing.JRadioButton rbMasc;
    private javax.swing.JTextField txtApeAlu;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtNomAlu;
    private javax.swing.JTextField txtRutAlu;
    // End of variables declaration//GEN-END:variables
}
