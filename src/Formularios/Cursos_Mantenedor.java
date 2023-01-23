
package Formularios;

import java.sql.*;
import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cursos_Mantenedor extends javax.swing.JFrame {

    private String rut_admin;
    Conexion conex = new Conexion();
    Connection conn = (Connection) conex.realizarConexion();
    String tipo_educacion;
    String id_establecimiento;
    
    public Cursos_Mantenedor() {
        initComponents();
    }
    
    public Cursos_Mantenedor(String rut_admin){
        this.rut_admin = rut_admin;
        Calendar c1 = new GregorianCalendar();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        String mes = Integer.toString(c1.get(Calendar.MONTH));
        String annio = Integer.toString(c1.get(Calendar.YEAR));
        obtenerData();
        initComponents();
        restringirNiveles();
        txt_annio.setText(annio);
        llenarComboBox();
        llenarTabla("");
        
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
        
        
    }
    
    private void restringirNiveles(){
       if(tipo_educacion != null){
           switch(tipo_educacion){
               case "Basica":
                   cmb_nivel.removeAllItems();
                   cmb_nivel.addItem("Basica");
                   cmb_nivel.setEnabled(false);
                   break;
               case "Media":
                   cmb_nivel.removeAllItems();
                   cmb_nivel.addItem("Media");
                   cmb_nivel.setEnabled(false);
                   break;
               case "Ambas":
                   cmb_nivel.removeAllItems();
                   cmb_nombre_curso.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           int curso_numero =  Integer.parseInt(cmb_nombre_curso.getItemAt(cmb_nombre_curso.getSelectedIndex()).split(" ")[0]);
                           String curso_nombre = cmb_nombre_curso.getItemAt(cmb_nombre_curso.getSelectedIndex()).split(" ")[1];
                           
                           if(curso_numero > 0 && curso_numero < 5){
                               cmb_nivel.removeAllItems();
                               cmb_nivel.addItem("Basica");
                               cmb_nivel.addItem("Media");
                               cmb_nivel.setEnabled(true);
                           }else{
                               cmb_nivel.removeAllItems();
                               cmb_nivel.addItem("Basica");
                               cmb_nivel.setEnabled(false);
                           }
                           
                           
                       }
                    });
                   break;
               default:
                   System.out.println("Opcion no Encontrada");
                   break;
           }
       }
    }
    
    
    private void llenarComboBox(){
       String[] basica = {"1 Primero", "2 Segundo", "3 Tercero", "4 Cuarto", "5 Quinto", "6 Sexto", "7 Septimo", "8 Octavo"};
       String[] media = {"1 Primero", "2 Segundo", "3 Tercero", "4 Cuarto"};

       
       if(tipo_educacion != null){
           switch(tipo_educacion){
                case "Basica":
                    for(String e: basica){
                       
                       cmb_nombre_curso.addItem(e);
                    }
                    break;
                case "Media":
                    for(String e: media){
                       cmb_nombre_curso.addItem(e);
                    }
                    break;
                case "Ambas":
                    for(String e: basica){
                       cmb_nombre_curso.addItem(e);
                    }
                    break;
                default:
                   System.out.println("Opcion no Encontrada");
                   break;
            }
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
                   rs.getString("nombre"), rs.getString("nivel"), rs.getString("letra")
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
        btn_atras = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_nivel = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_annio = new javax.swing.JLabel();
        cmb_nombre_curso = new javax.swing.JComboBox<>();
        cmb_letra = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_curso = new javax.swing.JTable();
        btn_buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(153, 204, 255));

        btn_atras.setText("Atras");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre del Curso :");

        jLabel2.setText("Letra :");

        jLabel3.setText("Nivel : ");

        cmb_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basica", "Media" }));

        jLabel5.setText("Año :");

        txt_annio.setText("2023");

        cmb_letra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Mantenedor de Cursos");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_atras))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_nombre_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmb_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(cmb_letra, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_eliminar)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_annio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_nombre_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_letra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmb_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txt_annio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_atras)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_agregar))
                .addGap(54, 54, 54))
        );

        tbl_curso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Nivel", "Letra"
            }
        ));
        jScrollPane1.setViewportView(tbl_curso);

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String nombre_curso = ((String) cmb_nombre_curso.getSelectedItem()).split(" ")[1].trim();
        String letra_curso = ((String) cmb_letra.getSelectedItem()).trim();
        String nivel_curso = ((String) cmb_nivel.getSelectedItem()).trim();
        
        
        if(tipo_educacion != null && id_establecimiento != null){
            switch(tipo_educacion){
               case "Basica":
                   String sql = "SELECT count(*) as cantidad FROM cursos WHERE nombre = '"+nombre_curso+"' AND letra = '"+letra_curso+"' AND id_establecimiento = '"+id_establecimiento+"'";
                   
                   try{
                       Statement stm = conn.createStatement();
                       ResultSet rs = stm.executeQuery(sql);
                       
                       if(rs.next()){
                           int cantidad = rs.getInt("cantidad");
                           if(cantidad == 0){
                               agregar(nombre_curso, "Basica", tipo_educacion);
                           }else{
                               JOptionPane.showMessageDialog(null, "Ya existe un Curso con Este nombre y Letra", "No se pudo agregar", JOptionPane.WARNING_MESSAGE);
                           }
                       }
                   }catch(SQLException ex){
                       JOptionPane.showMessageDialog(null, "Error al consultar a la BD", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
                   }
                   
                   
                   
                   break;
               case "Media":
                   String sql2 = "SELECT count(*) as cantidad FROM cursos WHERE nombre = '"+nombre_curso+"' AND letra = '"+letra_curso+"' AND id_establecimiento = '"+id_establecimiento+"'";
                   try{
                       Statement stm = conn.createStatement();
                       ResultSet rs = stm.executeQuery(sql2);
                       
                       if(rs.next()){
                           int cantidad = rs.getInt("cantidad");
                           if(cantidad == 0){
                               agregar(nombre_curso, "Media", tipo_educacion);
                           }else{
                               JOptionPane.showMessageDialog(null, "Ya existe un Curso con Este nombre y Letra", "No se pudo agregar", JOptionPane.WARNING_MESSAGE);
                           }
                       }
                   }catch(SQLException ex){
                       JOptionPane.showMessageDialog(null, "Error al consultar a la BD", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
                   }
                   
                   
                   break;
               case "Ambas":
                   System.out.println("XXXXXX");
                   String sql3 = "SELECT count(*) as cantidad FROM cursos WHERE nombre = '"+nombre_curso+"' AND letra = '"+letra_curso+"' AND nivel = '"+nivel_curso+"' AND id_establecimiento = '"+id_establecimiento+"'";
                   try{
                       Statement stm = conn.createStatement();
                       ResultSet rs = stm.executeQuery(sql3);
                       
                       if(rs.next()){
                           int cantidad = rs.getInt("cantidad");
                           if(cantidad == 0){
                               agregar(nombre_curso, letra_curso, nivel_curso);
                           }else{
                               JOptionPane.showMessageDialog(null, "Ya existe un Curso en este nivel con nombre y letra", "No se pudo agregar", JOptionPane.WARNING_MESSAGE);
                           }
                       }
                   }catch(SQLException ex){
                       JOptionPane.showMessageDialog(null, "Error al consultar a la BD " + ex.getMessage(), "Error de Consulta", JOptionPane.ERROR_MESSAGE);
                   }
                   
                   
                   
                   
                   break;
               default:
                   System.out.println("Opcion no Encontrada");
                   break;
           }
        }
        
        
        
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void agregar(String nombre_curso, String letra_curso, String nivel_curso){
        
        int num_curso = Integer.parseInt(((String) cmb_nombre_curso.getSelectedItem()).split(" ")[0].trim()); //bien
        char letra_nivel = nivel_curso.charAt(0);
        String letra_curso_x = ((String) cmb_letra.getSelectedItem()).trim();
        String cod_curso = String.valueOf(num_curso) + letra_nivel + letra_curso_x;
        
        System.out.println("COD CURSO: " + cod_curso);
        System.out.println("ID ESTAB: " + id_establecimiento);
        System.out.println("NOM CURSO: " + nombre_curso);
        System.out.println("NIV CURSO: " + nivel_curso);
        System.out.println("LETRA CURSO: " + letra_curso_x);
        
        
        
        
        String sql = "INSERT INTO cursos(cod_curso, id_establecimiento, nombre,nivel,letra)"
                + " values ('"+cod_curso+"', '"+id_establecimiento+"', '"+nombre_curso+"', '"+nivel_curso+"', '"+letra_curso_x+"')";
        
        
        try{
           Statement stm = conn.createStatement();
           stm.executeUpdate(sql);
            llenarTabla("");
           JOptionPane.showMessageDialog(null, "Curso Agregado Exitosamente!!", "Insercion Hecha", JOptionPane.INFORMATION_MESSAGE);
           
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "No se pudo Agregar el Curso", "Error de Insercion", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    
    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        dispose();
        new GestorFrame(rut_admin).setVisible(true);
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String buscar = txt_buscar.getText().trim();
        
        
        String sql = "SELECT * FROM cursos WHERE nombre LIKE '%"+buscar+"%' and id_establecimiento = '"+id_establecimiento+"'";
        
        llenarTabla(sql);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if(tbl_curso.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila", "Seleccione una fila", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String curso = (String) tbl_curso.getModel().getValueAt(tbl_curso.getSelectedRow(), 0);
        String nivel = (String) tbl_curso.getModel().getValueAt(tbl_curso.getSelectedRow(), 1);
        String letra_curso_x = (String) tbl_curso.getModel().getValueAt(tbl_curso.getSelectedRow(), 2);
        int num_curso;
        
        switch(curso){
            case "Primero":
                num_curso = 1;
                break;
            case "Segundo":
                num_curso = 2;
                break;
            case "Tercero":
                num_curso = 3;
                break;
            case "Cuarto":
                num_curso = 4;
                break;
            case "Quinto":
                num_curso = 5;
                break;
            case "Sexto":
                num_curso = 6;
                break;
            case "Septimo":
                num_curso = 7;
                break;
            case "Octavo":
                num_curso = 8;
                break;
            default:
                num_curso = 0;
                break;
                
        };

        char letra_nivel = nivel.charAt(0);
        
        String cod_curso = String.valueOf(num_curso) + letra_nivel + letra_curso_x;
        
        String sql = "DELETE FROM cursos WHERE cod_curso = '"+cod_curso+"'";
        
        try{
            Statement stm = conn.createStatement();
            
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar el curso con id: "+cod_curso+"?", "Eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
            switch(opcion){
                case 0:
                    stm.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Curso Eliminado", "Eliminacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    llenarTabla("");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Eliminacion Cancelada", "Eliminacion Cancelada",JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Curso", "Error de Eliminacion", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

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
    private javax.swing.JComboBox<String> cmb_letra;
    private javax.swing.JComboBox<String> cmb_nivel;
    private javax.swing.JComboBox<String> cmb_nombre_curso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tbl_curso;
    private javax.swing.JLabel txt_annio;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
