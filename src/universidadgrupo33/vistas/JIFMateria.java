// dia: 22/09/23 hs: 4:00am
package universidadgrupo33.vistas;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import universidadgrupo33.accesoADatos.MateriaData;
import universidadgrupo33.entidades.Materia;

/**
 *
 * @author Pablo
 */
public class JIFMateria extends javax.swing.JInternalFrame {
    public String modifica="";    
    public String recuperar="";    
    public int idMateriaSql=0;    

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
    public boolean verSiRegistraMateriaNueva(int opcTrabajo, String txtOpcion1, String txtOpcion2, String txtOpcion3)
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
                editarObloquearIngresos(false, true, true, true);
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
                editarObloquearIngresos(true, false, false, false);
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
    
    public JIFMateria() {
        initComponents();        
        this.setTitle("UNIVERSIDAD ULP - Gestión de Materia");
        limpiarDatos(0);
        editarObloquearIngresos(true,false,false,false);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
        modifica="";    
        recuperar="";    
        jLProximoIdMAteria.setText("");        
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfIdMateria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLEstado = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbRecuperar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtfAño = new javax.swing.JTextField();
        jLProximoIdMAteria = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de Materia");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Codigo:");

        jtfIdMateria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Estado:");

        jLEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLEstado.setText("......");

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

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Año;");

        jtfAño.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtfAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAñoActionPerformed(evt);
            }
        });

        jLProximoIdMAteria.setBackground(new java.awt.Color(255, 255, 255));
        jLProximoIdMAteria.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLProximoIdMAteria.setForeground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
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
                                .addGap(38, 38, 38)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 429, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLProximoIdMAteria, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jtfIdMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(77, 77, 77))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtfAño, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jrbEstado)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jLEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))))
                                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLProximoIdMAteria, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfIdMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jrbEstado)
                    .addComponent(jLabel5)
                    .addComponent(jLEstado))
                .addGap(30, 30, 30)
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
                .addGap(29, 29, 29))
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
            MateriaData mat=new MateriaData();
            // verifica si la variable -recuperar="R"- para buscar el DNI que tenga estado=0
            if (recuperar=="R")
            {
                // bucara al DNI que figure con estado=0 en sql (Baja Logica)
                tipoEstado=0;
            }else {
                // bucara al DNI que figure con estado=1 en sql (Activo)
                tipoEstado=1;
            }
            Materia materiaEncontrada=mat.buscarMateria(Integer.parseInt(jtfIdMateria.getText()),tipoEstado);
            if (materiaEncontrada!=null){
                // si encontro al alumno actualziar los datos de los textfield            
                // en esta asignacion a la variable -idAlumnoSql- guardo el nro de IdAlumno leido de Sql para usar mas adelante
                idMateriaSql=materiaEncontrada.getIdMateria();                                               
                jtfNombre.setText(materiaEncontrada.getNombre());                
                jtfAño.setText(materiaEncontrada.getAño()+"");                
                // de esta manera se puede asignar el radio button prendido(true) o apagado(false)
                //jrbEstado.setSelected(true);
                jrbEstado.setSelected(materiaEncontrada.isEstado());
                //System.out.println("Estado leido:"+alumnoEncontrado.isActivo());
                //este no: System.out.println("Estado guardado:"+jrbEstado.getHideActionText());
                //este si: System.out.println("Estado guardado:"+jrbEstado.isSelected());
                //este no: if (jrbEstado.getHideActionText()==false)
                if (jrbEstado.isSelected())
                {                    
                    jLEstado.setForeground(Color.blue);
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
                esta="S";                            
                editarObloquearIngresos(false,false,false,false);                
            }        
            if (esta=="N")
            {
                //JOptionPane.showMessageDialog(this, "Error1: NO EXISTE ESTE DNI");
                limpiarDatos(1);                
                editarObloquearIngresos(false,true,true,true);
                // envia un 0 cuando es para Agregar una materia nueva
                verSiRegistraMateriaNueva(0,"Agregar una Materia Nueva", "Cancelar", "ATENCION!!! (Opc.NUEVO)");                
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
        if (verSiRegistraMateriaNueva(1, "Eliminar a la Materia", "Cancelar", "ATENCION!!! (Opc.ELIMINAR)")) {
            MateriaData mat = new MateriaData();
            Materia mat1 = new Materia();
            int resultadoExito = mat.eliminarMateria(idMateriaSql);
            if (resultadoExito == 1) {
                mat1.setEstado(false);
                jrbEstado.setSelected(mat1.isEstado());
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
        
        //ESTA LINEA ES PARA TRABAJARLA, PARA QUE MUESTRE CUAL ES EL SIGUIENTE CODIGO DISPONIBLE
        //DE MATERIA
        //SELECT idMateria FROM materia ORDER BY idMateria DESC LIMIT 1;
        
        limpiarDatos(0);
        editarObloquearIngresos(true,false,false,false);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
        
        // informa en esa variable -modifica- con una letra "N" de que se debe realizar un INSERT (ALTA/SQL)
        modifica="N";
        
        // busca el ultimo idMateria en sql para sumarle 1 y mostrar cual seria el proximo codigo
        // a agregar si fuera necesario
        MateriaData mat = new MateriaData();
        Materia mat1 = new Materia();
        int ProximoIdMate=mat.proximoIdMateria().getIdMateria()+1;
        // Activa el cartel bliqueador con la informacion del proximo IdMateria a crear
        jLProximoIdMAteria.setText("Proximo Codigo--> "+ProximoIdMate);        
        jtfIdMateria.setText(ProximoIdMate+"");                
        //cartelBlinqueador("Proximo Codigo--> "+ProximoIdMate);        
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        editarObloquearIngresos(false,true,true,true); 
        jbGuardar.setEnabled(true);
        jbEliminar.setEnabled(false);
        jbModificar.setEnabled(false);
        // informa en esa variable -modifica- con una letra "M" de que se debe realizar un UPDATE (MODIFICACION/SQL)
        modifica="M";                
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int resultadoExito=0;
        MateriaData mat = new MateriaData();
        Materia materia = new Materia();        
        //materia.setIdMateria(idMateriaSql);
        materia.setIdMateria(Integer.parseInt(jtfIdMateria.getText()));
        materia.setNombre(jtfNombre.getText());
        materia.setAño(Integer.parseInt(jtfAño.getText()));
        materia.setEstado(jrbEstado.isSelected());                
        // verifica que valor tiene la variable -modifica-, si es una "N" debe GRABAR-(INSERT/SQL)
        // o si el valor es "M" debe MODIFICAR-(UPDATE/SQL)
        //System.out.println("modifica="+modifica);        
        if (modifica=="N")
        {
            if (verSiRegistraMateriaNueva(2, "Guardar a la Nueva Materia", "Cancelar", "ATENCION!!! (Opc.GUARDAR-NUEVO)")) {
                resultadoExito = mat.guardarMateria(materia);
                limpiarDatos(0);
                editarObloquearIngresos(true,false,false,false);        
                modifica="";
            }
        }else{
            if (verSiRegistraMateriaNueva(3, "Modificar datos de la Materia", "Cancelar", "ATENCION!!! (Opc.MODIFICAR)")) {
                resultadoExito = mat.modificarMateria(materia);
                limpiarDatos(0);
                editarObloquearIngresos(true,false,false,false);        
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
        // Apaga el cartel bliqueador con la informacion del proximo IdMateria a crear
        jLProximoIdMAteria.setText("");        
        //apagarCartelBlinqueador();
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecuperarActionPerformed
//        if (recuperar == "") {
//            // habilita la variable -recuperar="R"- para que cuando busque un DNI sea a los que figuren de Baja
//            // o sea con estado=0
//            recuperar = "R";
//        } else {
            // envia un 4 cuando es para Recuperar un alumno Eliminado Logicamente
            if (verSiRegistraMateriaNueva(4, "Recuperar la Materia ELiminada", "Cancelar", "ATENCION!!! (Opc.RECUPERAR)")) {
                MateriaData mat = new MateriaData();
                Materia mat1 = new Materia();
                int resultadoExito = mat.recuperarMateria(idMateriaSql);
                if (resultadoExito == 1) {
                    mat1.setEstado(true);
                    jrbEstado.setSelected(mat1.isEstado());
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
//        }
    }//GEN-LAST:event_jbRecuperarActionPerformed

    private void jtfAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAñoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLProximoIdMAteria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField jtfAño;
    private javax.swing.JTextField jtfIdMateria;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables


    public void editarObloquearIngresos(boolean txt1,boolean txt2,boolean txt3,boolean txt4)
    {
        // setEditable() PERMITE HABILITAR O DESAHBILITAR EL INGRESO DE DATOS EN LOS CAMPOS TEXTFIELD 
        // setEnabled() PERMITE HABILITAR O DESAHBILITAR EL INGRESO DE DATOS y  NO PODER SELECCIONAR EN LOS CAMPOS TEXTFIELD         
        if (txt1) {jtfIdMateria.setEditable(true);
                   jtfIdMateria.setEnabled(true);
        }else {jtfIdMateria.setEditable(false);
               jtfIdMateria.setEnabled(false);}        
        if (txt2) {jtfNombre.setEditable(true);
                   jtfNombre.setEnabled(true);
        }else {jtfNombre.setEditable(false);
               jtfNombre.setEnabled(false);}
        if (txt3) {jtfAño.setEnabled(true);
        }else {jtfAño.setEnabled(false);}        
        if (txt4) {jrbEstado.setEnabled(true);
        }else {jrbEstado.setEnabled(false);}        
               
    }

    private void limpiarDatos(int elijoCodigo) 
    {
        // LIMPIA LOS CAMPOS        
        if (elijoCodigo==0)
        {
            jtfIdMateria.setText("");
            idMateriaSql=0;               
        }                
        jtfNombre.setText("");                
        jtfAño.setText("");                
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
    }
    
    public void cartelBlinqueador(String cartel)
    {
        // PARA UN JFrame
        JFrame frame = new JFrame();
        JLabel label = new JLabel(cartel);
        frame.add(label);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);                
        frame.setSize(150, 100);                
        frame.setVisible(true);        
        
        /* PARA UN JinternalFrame
        JInternalFrame internalFrame = new JInternalFrame();
        JLabel label = new JLabel(cartel);        
        internalFrame.add(label);
        //internalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        internalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        //internalFrame.setClosable(true);        
        //internalFrame.setLocation(100,100);
        //internalFrame.setBounds(0, 0, 150, 100);
        internalFrame.setSize(150, 100);                
        internalFrame.setVisible(true);
        */
        
        Timer timer = new Timer(500, new ActionListener() {
            private boolean isForeground = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isForeground) {
                    label.setForeground(Color.BLUE);
                } else {
                    label.setForeground(Color.BLACK);
                }
                isForeground = !isForeground;
            }
        });
        timer.start();        
    }
    
    public void apagarCartelBlinqueador()
    {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("");
        frame.add(label);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(false);        
    }
    
    
}

