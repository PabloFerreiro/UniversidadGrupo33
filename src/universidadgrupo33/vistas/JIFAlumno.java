/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo33.vistas;

import java.awt.Color;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    public String modifica="N";    
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
    public void verSiRegistraAlumnoNuevo()
    {
        String botones[] = {"Registrar un Nuevo ALumnos", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "No Existe el DNI buscado", "Titulo",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
           // habilitar los campos para ingresar los datos del alumno nuevo           
           editarObloquearIngresos(true,true,true,true,true);
        } 
        //else {
        //    if (eleccion == JOptionPane.NO_OPTION) {
        //       JOptionPane.showMessageDialog(this, "xxxxxxxxxxxxx");
        //    }
       // }
    }
    
    public JIFAlumno() {
        initComponents();        
        this.setTitle("UNIVERSIDAD ULP - Gestión de Alumno");
        
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

        jbModificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jrbEstado)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(52, 52, 52)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbModificar)
                                .addGap(4, 4, 4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
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
                .addGap(18, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbNuevo)
                            .addComponent(jbSalir)
                            .addComponent(jbEliminar)
                            .addComponent(jbGuardar)
                            .addComponent(jbModificar)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        modifica="N";
        try 
        {            
            AlumnoData alu=new AlumnoData();
            Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(Integer.parseInt(jtfDni.getText()));
            if (alumnoEncontrado!=null){
                // si encontro al alumno actualziar los datos de los textfield            
                // en esta asignacion a la variable -idAlumnoSql- guardo el nro de IdAlumno leido de Sql para usar mas adelante
                idAlumnoSql=alumnoEncontrado.getIdAlumno();               
                jtfDni.setText(alumnoEncontrado.getDni()+"");               
                jtfApellido.setText(alumnoEncontrado.getApellido());
                jtfNombre.setText(alumnoEncontrado.getNombre());                
                // de esta manera se puede asignar el radio button prendido(true) o apagado(false)
                //jrbEstado.setSelected(true);
                jrbEstado.setSelected(alumnoEncontrado.isActivo());
                System.out.println("Estado leido:"+alumnoEncontrado.isActivo());
                //System.out.println("Estado guardado:"+jrbEstado.getHideActionText());
                System.out.println("Estado guardado:"+jrbEstado.isSelected());
                //if (jrbEstado.getHideActionText()==false)
                if (jrbEstado.isSelected())
                {                    
                    jLEstado.setForeground(Color.blue);
                    //jLEstado.setBackground(Color.white);
                    jLEstado.setText("Activo");
                }else {                    
                    jLEstado.setForeground (Color.red);
                    //jLEstado.setBackground(Color.white);
                    jLEstado.setText("Baja");
                }                                
                // para establecer la fecha localdate de la clase alumno y pasarla a un textfield               
                // este metodo de trasformacion no funciona para el tipo de muestreo de la fecha en jtextfiend
                /*                
                DateTimeFormatter formateo = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                String fechaComoTexto = alumnoEncontrado.getFechaNac().format(formateo);
                jDateChooser1.setDateFormatString(fechaComoTexto);                
                System.out.println("fecha: "+fechaComoTexto);                
                */                
                // este metodo de trasformacion SI funciona para el tipo de muestreo de la fecha en jtextfiend
                java.sql.Date sqlDate = java.sql.Date.valueOf(alumnoEncontrado.getFechaNac());
                jDateChooser1.setDate(sqlDate);
                esta="S";            
                modifica="S";
                editarObloquearIngresos(false,false,false,false,false);
            }        
            if (esta=="N")
            {
                //JOptionPane.showMessageDialog(this, "Error1: NO EXISTE ESTE DNI");
                limpiarDatos(1);                
                editarObloquearIngresos(false,true,true,true,true);
                verSiRegistraAlumnoNuevo();                
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
    this.dispose(); 
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        limpiarDatos(0);
        editarObloquearIngresos(true,false,false,false,false);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        editarObloquearIngresos(false,true,true,true,true);
    }//GEN-LAST:event_jbModificarActionPerformed


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
        idAlumnoSql=0;               
        if (elijoDni==0)
        {
            jtfDni.setText("");
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

