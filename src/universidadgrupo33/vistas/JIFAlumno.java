// dia: 22/09/23 hs: 4:00am
package universidadgrupo33.vistas;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo33.accesoADatos.AlumnoData;
import universidadgrupo33.entidades.Alumno;

/**
 *
 * @author Pablo
 */
public class JIFAlumno extends javax.swing.JInternalFrame {
    public String modifica="";    
    public String recuperar="";    
    public int idAlumnoSql=0;

    private DefaultTableModel modelo=new DefaultTableModel()
    {
        @Override
        public boolean isCellEditable(int fila, int columna) {

            // BLOQUEO ESTAS LINEAS PARA QUE LO QUE MUESTRE EN LA TABLE NO PUEDAN SER MODIFICADO
            /*
            if (columna==1 || columna==2)
            {
               return true; // significa que la columna de posicion nro 2 permitira ser 
                            // MODIFICADA dentro de la tabla
            } 
            */
            return false; // significa que todas las filas y columna de la tabla NO permitira ser 
            // modificcas dentro de la tabla               
        }             
    };
    
    // PARA PODER CREAR UN OPCION DE ELEGIR SI DESEA AGREGAR UN ALUMNO NUEVO
    public boolean verSiRegistraAlumnoNuevo(int opcTrabajo, String txtOpcion1, String txtOpcion2, String txtOpcion3)
    {
        String botones[] = {txtOpcion1, txtOpcion2};
        int eleccion = JOptionPane.showOptionDialog(this, txtOpcion3, "Titulo",
                0, 0, null, botones, this);
        // opxTrabajo=0 es para cuando no existe el DNI y ofrese AGREGAR-NUEVO alumno
        // opxTrabajo=1 es para cuando quiere ELIMINAR un alumno, primero pregunta si quiere
        // opxTrabajo=2 es para cuando quiere GRABAR-NUEVO alumno, primero pregunta si quiere
        // opxTrabajo=3 es para cuando quiere MODIFICAR un alumno, primero pregunta si quiere
        // opxTrabajo=4 es para cuando quiere RECUPERAR un alumno eliminado logicamente, primero pregunta si quiere
        if (opcTrabajo==0) {
            if (eleccion == JOptionPane.YES_OPTION) {
                // habilitar los campos para ingresar los datos del alumno nuevo           
                editarObloquearIngresos(false, true, true, true, true);
                jbGuardar.setEnabled(true);
                jrbEstado.setSelected(true);
                jLEstado.setForeground(Color.blue);
                jLEstado.setText("Activo");
                modifica="N";
            } else {
                //    if (eleccion == JOptionPane.NO_OPTION) {
                //       JOptionPane.showMessageDialog(this, "xxxxxxxxxxxxx");
                //    }
                limpiarDatos(0);
                editarObloquearIngresos(true, false, false, false, false);
                modifica = "";
            }
            return true;
        }else {        
            if (eleccion == JOptionPane.YES_OPTION) {
                jbGuardar.setEnabled(false);
                jbEliminar.setEnabled(false);
                jbModificar.setEnabled(false);
                jbRecuperar.setEnabled(false);
                return true; 
                
            } else {
                return false;
            }
        }
    }
    
    public JIFAlumno() {
        initComponents();        
        this.setTitle("UNIVERSIDAD ULP - Gestión de Alumno");
        limpiarDatos(0);
        editarObloquearIngresos(true,false,false,false,false);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
        modifica="";    
        recuperar="";    
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLEstado = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jbModificar = new javax.swing.JButton();
        jbRecuperar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de Alumno");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("DNI:");

        jtfDni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Estado:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento:");

        jLEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLEstado.setText("......");

        jtfApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jtfNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jrbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEstadoActionPerformed(evt);
            }
        });

        jbBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbNuevo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jbModificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbRecuperar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbRecuperar.setText("Recuperar");
        jbRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecuperarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4))
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jrbEstado)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(46, 46, 46))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(52, 52, 52)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(jbModificar))
                                    .addComponent(jbRecuperar))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jrbEstado)
                    .addComponent(jLabel5)
                    .addComponent(jLEstado))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbSalir)
                                .addComponent(jbEliminar)
                                .addComponent(jbRecuperar)))
                        .addComponent(jbNuevo, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbGuardar)
                            .addComponent(jbModificar))
                        .addGap(51, 51, 51)))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoActionPerformed
        if(jrbEstado.isSelected()){           
            jLEstado.setForeground(Color.blue);
            //jLEstado.setBackground(Color.white);
            jLEstado.setText("Activo");
        }else {
            jLEstado.setForeground (Color.red);
            //jLEstado.setBackground(Color.white);
            jLEstado.setText("Baja");
        }        
    }//GEN-LAST:event_jrbEstadoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        //Método buscar Alumno por Dni 
        // va a buscar el DNI ingresadpp en la db sql            
        String esta="N";
        int tipoEstado=0;
        try 
        {            
            AlumnoData alu=new AlumnoData();
//            // verifica si la variable -recuperar="R"- para buscar el DNI que tenga estado=0
//            if (recuperar=="R")
//            {
//                // bucara al DNI que figure con estado=0 en sql (Baja Logica)
//                tipoEstado=0;
//            }else {
//                // bucara al DNI que figure con estado=1 en sql (Activo)
//                tipoEstado=1;
//            }
            Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(Integer.parseInt(jtfDni.getText()),tipoEstado);
            if (alumnoEncontrado!=null){
                // si encontro al alumno actualziar los datos de los textfield            
                // en esta asignacion a la variable -idAlumnoSql- guardo el nro de IdAlumno leido de Sql para usar mas adelante
                idAlumnoSql=alumnoEncontrado.getIdAlumno();               
                //System.out.println("idALumno leido de sql="+idAlumnoSql);
                jtfDni.setText(alumnoEncontrado.getDni()+"");               
                jtfApellido.setText(alumnoEncontrado.getApellido());
                jtfNombre.setText(alumnoEncontrado.getNombre());                
                // de esta manera se puede asignar el radio button prendido(true) o apagado(false)
                //jrbEstado.setSelected(true);
                jrbEstado.setSelected(alumnoEncontrado.isActivo());
                //System.out.println("Estado leido:"+alumnoEncontrado.isActivo());
                //este no: System.out.println("Estado guardado:"+jrbEstado.getHideActionText());
                //este si: System.out.println("Estado guardado:"+jrbEstado.isSelected());
                //este no: if (jrbEstado.getHideActionText()==false)
                if (jrbEstado.isSelected())
                {                    
                    jLEstado.setForeground(Color.blue);
                    //jLEstado.setBackground(Color.white);
                    jLEstado.setText("Activo");
                    jbGuardar.setEnabled(false);
                    jbModificar.setEnabled(true);
                    jbEliminar.setEnabled(true);
                    jbRecuperar.setEnabled(false);
                }else {                    
                    jLEstado.setForeground (Color.red);
                    //jLEstado.setBackground(Color.white);
                    jLEstado.setText("Baja");
                    jbGuardar.setEnabled(false);
                    jbModificar.setEnabled(false);
                    jbEliminar.setEnabled(false);
                    jbRecuperar.setEnabled(true);
                }                                
                // para establecer la fecha localdate de la clase alumno y pasarla a un textfield               
                // este metodo de trasformacion no funciona para el tipo de muestreo de la fecha en jtextfiend
                /*                
                DateTimeFormatter formateo = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                String fechaComoTexto = alumnoEncontrado.getFechaNac().format(formateo);
                jDateChooser1.setDateFormatString(fechaComoTexto);                
                //System.out.println("fecha: "+fechaComoTexto);                
                */                
                // este metodo de trasformacion SI funciona para el tipo de muestreo de la fecha en jtextfiend
                java.sql.Date sqlDate = java.sql.Date.valueOf(alumnoEncontrado.getFechaNac());
                jDateChooser1.setDate(sqlDate);
                esta="S";                            
                editarObloquearIngresos(false,false,false,false,false);
            }        
            if (esta=="N")
            {
                //JOptionPane.showMessageDialog(this, "Error1: NO EXISTE ESTE DNI");
                limpiarDatos(1);                
                editarObloquearIngresos(false,true,true,true,true);
                // envia un 0 cuando es para Agregar un alumno nuevo                
                verSiRegistraAlumnoNuevo(0,"Agregar un Alumno Nuevo", "Cancelar", "ATENCION!!! (Opc.NUEVO)");                
            }            
        }         
        catch (NumberFormatException nfe) 
        {
            JOptionPane.showMessageDialog(this, "Error: Debe ingresar un valor numérico");
        }catch (Exception vma) 
        {
            JOptionPane.showMessageDialog(this, "Error: Algun campo sin Informacion");
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // envia un 1 cuando es para Eliminar un alumno 
        if (verSiRegistraAlumnoNuevo(1, "Eliminar al ALumno", "Cancelar", "ATENCION!!! (Opc.ELIMINAR)")) {
            AlumnoData alu = new AlumnoData();
            Alumno alu1 = new Alumno();
            int resultadoExito = alu.eliminarAlumno(idAlumnoSql);
            if (resultadoExito == 1) {
                alu1.setActivo(false);
                jrbEstado.setSelected(alu1.isActivo());
            }
            if (jrbEstado.isSelected()) {
                jLEstado.setForeground(Color.blue);
                //jLEstado.setBackground(Color.white);
                jLEstado.setText("Activo");
            } else {
                jLEstado.setForeground(Color.red);
                //jLEstado.setBackground(Color.white);
                jLEstado.setText("Baja");
            }
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
    this.dispose(); 
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        limpiarDatos(0); 
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
        editarObloquearIngresos(true,false,false,false,false);
        // informa en esa variable -modifica- con una letra "N" de que se debe realizar un INSERT (ALTA/SQL)
        modifica="N";
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        editarObloquearIngresos(false,true,true,true,true); 
        jbGuardar.setEnabled(true);
        jbEliminar.setEnabled(false);
        jbModificar.setEnabled(false);
        // informa en esa variable -modifica- con una letra "M" de que se debe realizar un UPDATE (MODIFICACION/SQL)
        modifica="M";        
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int resultadoExito=0;
        AlumnoData alu = new AlumnoData();
        Alumno alumno = new Alumno();
        //alumno.setIdAlumno(0);
        alumno.setIdAlumno(idAlumnoSql);
        alumno.setDni(Integer.parseInt(jtfDni.getText()));
        alumno.setApellido(jtfApellido.getText());
        alumno.setNombre(jtfNombre.getText());
        alumno.setActivo(jrbEstado.isSelected());        
        // transformo la fecha del jframe-jDateChooser1 en LocalDate pra asignr eso al atributo de alumno
        LocalDate fechaN = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        alumno.setFechaNac(fechaN);
        // puedo usr esta instrucion para formatear como quiero que se transforme la fecha de jDateChooser
        // por ejemplo en dd-MMM-yyyy, el metodo -format(variable_transformada)- devuelve un String
        //DateTimeFormatter nuevoFormato=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // asigno la fecha ingreasada y convertida en JdateChooser, que estaba en formato americano yyyy-MM-dd
        //variable_LocalDate.setFechaNac(fechaN.format(nuevoFormato));        
        // verifica que valor tiene la variable -modifica-, si es una "N" debe GRABAR-(INSERT/SQL)
        // o si el valor es "M" debe MODIFICAR-(UPDATE/SQL)
        //System.out.println("modifica="+modifica);        
        if (modifica=="N")
        {
            if (verSiRegistraAlumnoNuevo(2, "Guardar al Nuevo Alumno", "Cancelar", "ATENCION!!! (Opc.GUARDAR-NUEVO)")) {
                resultadoExito = alu.guardarAlumno(alumno);
                limpiarDatos(0);
                editarObloquearIngresos(true,false,false,false,false);        
                modifica="";
            }
        }else{
            if (verSiRegistraAlumnoNuevo(3, "Modificar datos del ALumno", "Cancelar", "ATENCION!!! (Opc.MODIFICAR)")) {
                resultadoExito = alu.modificarAlumno(alumno);
                limpiarDatos(0);
                editarObloquearIngresos(true,false,false,false,false);        
                modifica="";
            }
        }                
        if (resultadoExito == 1) {
            // se guardo/modifico con exito
        } else {
            // no se pudo guardar/moficar
        }
        //limpiarDatos(0);
        //editarObloquearIngresos(true,false,false,false,false);        
        //modifica="";
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecuperarActionPerformed
//        if (recuperar == "") {
//            // habilita la variable -recuperar="R"- para que cuando busque un DNI sea a los que figuren de Baja
//            // o sea con estado=0
//            recuperar = "R";
//        } else {
            // envia un 4 cuando es para Recuperar un alumno Eliminado Logicamente
            if (verSiRegistraAlumnoNuevo(4, "Recuperar al ALumno ELiminado", "Cancelar", "ATENCION!!! (Opc.RECUPERAR)")) {
                AlumnoData alu = new AlumnoData();
                Alumno alu1 = new Alumno();
                int resultadoExito = alu.recuperarAlumno(idAlumnoSql);
                if (resultadoExito == 1) {
                    alu1.setActivo(true);
                    jrbEstado.setSelected(alu1.isActivo());
                }
                if (jrbEstado.isSelected()) {
                    jLEstado.setForeground(Color.blue);
                    //jLEstado.setBackground(Color.white);
                    jLEstado.setText("Activo");
                } else {
                    jLEstado.setForeground(Color.red);
                    //jLEstado.setBackground(Color.white);
                    jLEstado.setText("Baja");
                }
                recuperar = "";
            }
        //}
    }//GEN-LAST:event_jbRecuperarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbRecuperar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables


    public void editarObloquearIngresos(boolean txt1,boolean txt2,boolean txt3,boolean txt4,boolean txt5)
    {
        // setEditable() PERMITE HABILITAR O DESAHBILITAR EL INGRESO DE DATOS EN LOS CAMPOS TEXTFIELD 
        // setEnabled() PERMITE HABILITAR O DESAHBILITAR EL INGRESO DE DATOS y  NO PODER SELECCIONAR EN LOS CAMPOS TEXTFIELD         
        if (txt1) {jtfDni.setEditable(true);
                   jtfDni.setEnabled(true);
        }else {jtfDni.setEditable(false);
               jtfDni.setEnabled(false);}
        if (txt2) {jtfApellido.setEditable(true);
                   jtfApellido.setEnabled(true);
        }else {jtfApellido.setEditable(false);
               jtfApellido.setEnabled(false);}
        if (txt3) {jtfNombre.setEditable(true);
                   jtfNombre.setEnabled(true);
        }else {jtfNombre.setEditable(false);
               jtfNombre.setEnabled(false);}
        if (txt4) {jrbEstado.setEnabled(true);
        }else {jrbEstado.setEnabled(false);}
        if (txt5) {jDateChooser1.setEnabled(true);
        }else {jDateChooser1.setEnabled(false);}
               
    }

    private void limpiarDatos(int elijoDni) 
    {
        // LIMPIA LOS CAMPOS        
        if (elijoDni==0)
        {
            jtfDni.setText("");
            idAlumnoSql=0;               
        }        
        jtfApellido.setText("");
        jtfNombre.setText("");                
        jrbEstado.setSelected(false);        
        if(jrbEstado.isSelected()){           
            jLEstado.setForeground(Color.blue);
            //jLEstado.setBackground(Color.white);
            jLEstado.setText("Activo");
        }else {
            jLEstado.setForeground (Color.red);
            //jLEstado.setBackground(Color.white);
            jLEstado.setText("Baja");
        }        
        jDateChooser1.setCalendar(null);                
    }
    
    
}

