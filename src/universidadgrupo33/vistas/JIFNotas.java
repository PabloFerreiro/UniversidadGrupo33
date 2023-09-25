// dia: 22/09/23 hs: 4:00am
package universidadgrupo33.vistas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import universidadgrupo33.accesoADatos.AlumnoData;
import universidadgrupo33.accesoADatos.InscripcionData;
import universidadgrupo33.accesoADatos.MateriaData;
import universidadgrupo33.entidades.Alumno;
import universidadgrupo33.entidades.Inscripcion;
import universidadgrupo33.entidades.Materia;


public class JIFNotas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            if (c!=2)
            { 
               return false;
            }
            return true;
        }
    };
    
    private DefaultTableModel modelo2 = new DefaultTableModel(){
    public boolean isCellEditable (int f, int c){               
        return false;
    }
    };

    AlumnoData alu = new AlumnoData();
    MateriaData mat = new MateriaData();
    InscripcionData ins = new InscripcionData();
    Alumno alu2 = new Alumno();
    Materia mat2 = new Materia();
    Inscripcion ins2 = new Inscripcion();

    int idAlumnoABuscar = 0;
    int idMateriaABuscar = 0;

    public JIFNotas() {
        initComponents();
        armarCabecera();
        armarCabecera2();
        // version VIEJA usando COMBOBOX
        //cargarComboBoxALumnos();
        this.setTitle("UNIVERSIDAD ULP - Carga de Notas");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTConsultaAlumno = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResultadoSeleccionAlumno = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jcbSeleccionAlumno = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jTConsultaAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jTConsultaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTConsultaAlumnoMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTConsultaAlumno);

        jtResultadoSeleccionAlumno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtResultadoSeleccionAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtResultadoSeleccionAlumno);

        jbGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jcbSeleccionAlumno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbSeleccionAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionAlumnoActionPerformed(evt);
            }
        });
        jcbSeleccionAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbSeleccionAlumnoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(409, 409, 409)
                            .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcbSeleccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcbSeleccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    // version ANTERIOR con COMBOBOX
    /*
    private void jcbSeleccionAlumnoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        alu2  = (Alumno) jcbSeleccionAlumno.getSelectedItem();                
        // verifica que no elija la primer linea del combobox que es solo titulo
        if (alu2.getIdAlumno() != 0) {
            idAlumnoABuscar = alu2.getIdAlumno();    
//            System.out.println("Paso0 " + idAlumnoABuscar);
            cargarMateriasInscriptas();
        }else{
            modelo.setRowCount(0);        
            idAlumnoABuscar =0;
            jbGuardar.setEnabled(false);            
        }
    } 
    */
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        //System.out.println("idAlumno: "+idAlumnoABuscar);
        int linea=jtResultadoSeleccionAlumno.getSelectedRow();
        int colum=jtResultadoSeleccionAlumno.getSelectedColumn();        
        idMateriaABuscar=(Integer) jtResultadoSeleccionAlumno.getValueAt(linea, 0);        
//        System.out.println("lINEA posicion en la tabla: "+linea);
//        System.out.println("COLUMNA posicion en la tabla: "+colum);
//        System.out.println("idAlumnoABuscar: "+idAlumnoABuscar);
//        System.out.println("idMateriaABuscar: "+idMateriaABuscar);        
        //double laNota=(Double) jtResultadoSeleccionAlumno.getValueAt(linea, 2);        
        double laNota = Double.parseDouble(String.valueOf(jtResultadoSeleccionAlumno.getValueAt(linea, 2)));
//        System.out.println("nota: "+laNota);        
        ins.actualizarNota(idAlumnoABuscar, idMateriaABuscar, laNota);
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jcbSeleccionAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSeleccionAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSeleccionAlumnoActionPerformed

    private void jcbSeleccionAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbSeleccionAlumnoKeyReleased
        borrarFilas();
        //      for (Materia mate: deTodoSa.listaProductos)
        for (Alumno alum : alu.listarAlumnosJTable(1)) {  
            
            if ((alum.getApellido()).contains((jcbSeleccionAlumno.getText())) ||
                     (alum.getNombre()).contains((jcbSeleccionAlumno.getText())) ||
                     (String.valueOf (alum.getDni())).contains((jcbSeleccionAlumno.getText()))) {
                modelo2.addRow(new Object[]{
                    alum.getIdAlumno(),
                    alum.getApellido(),
                    alum.getNombre(),
                    alum.getDni(),
                    alum.isActivo()
                });
            }

        }
        // PARA CONSULTAR SI LA TABLA ESTA VACIA O NO        
        if (jTConsultaAlumno.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "No Existen Datos de Alumnos", "Advertencia",
            JOptionPane.WARNING_MESSAGE);
        }        
        else
        {        
            int linTabla = jTConsultaAlumno.getSelectedRow()+1;
            int colTabla = jTConsultaAlumno.getSelectedColumn();            
            Object valorTabla = jTConsultaAlumno.getValueAt(linTabla, 0);            
            Alumno alu2 = new Alumno();            
            alu2.setIdAlumno((Integer) jTConsultaAlumno.getValueAt(linTabla, 0));
            alu2.setApellido((String) jTConsultaAlumno.getValueAt(linTabla, 1));
            alu2.setNombre((String) jTConsultaAlumno.getValueAt(linTabla, 2));
            alu2.setDni((Integer) jTConsultaAlumno.getValueAt(linTabla, 3));
            alu2.setActivo(true);
            // verifica que la jtable tenga registros para poder trabajar
            if (alu2.getIdAlumno()!= 0) {
                idAlumnoABuscar = alu2.getIdAlumno();
                // carga la tabla con lo materias que cursa el alumnos elegido
                //cargarTablaAlumnosMateria(idAlumnoABuscar);
                cargarMateriasInscriptas();
            } else {
                modelo2.setRowCount(0);
                idMateriaABuscar = 0;
                jbGuardar.setEnabled(false);
            }            
        }   
        
    }//GEN-LAST:event_jcbSeleccionAlumnoKeyReleased

    private void jTConsultaAlumnoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConsultaAlumnoMouseReleased
        JTable jTConsultaAlumno = (JTable) evt.getSource();
        int row = jTConsultaAlumno.getSelectedRow();
        int col = jTConsultaAlumno.getSelectedColumn();        
        // obligo a que se tome el nombre del Alumno para mostrar 
        Object data2 = (Object) jTConsultaAlumno.getValueAt(row, 1);        
        // y obligo a que se tome el codigo idMateria de la materia para buscar en las inscripciones x materia
        Object data1 = (Object) jTConsultaAlumno.getValueAt(row, 0);
        // asigno ese nombre elegido de la jtable a mi variable jTFMateriaAbuscar (jTextField) para buscar
        jcbSeleccionAlumno.setText(data2.toString());        
        //JOptionPane.showMessageDialog(null, "VVVVVV idMateria capturado desde la tabla es: "+data1);
        //JOptionPane.showMessageDialog(null, "VVVVVV nombre de la materia capturada desde la tabla es: "+data2);
        //JOptionPane.showMessageDialog(null, "VVVVVV nombre del jTFMateriaAbuscar es: "+jTFMateriaAbuscar.getText());        
    }//GEN-LAST:event_jTConsultaAlumnoMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTConsultaAlumno;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTextField jcbSeleccionAlumno;
    private javax.swing.JTable jtResultadoSeleccionAlumno;
    // End of variables declaration//GEN-END:variables
    
    private void armarCabecera() {
        modelo.addColumn("Código de Materia");
        modelo.addColumn("Nombre de materia");
        modelo.addColumn("Nota");
        jtResultadoSeleccionAlumno.setModel(modelo);

    }

    private void armarCabecera2() {
        modelo2.addColumn("Id de Alumno");        
        modelo2.addColumn("Apellido");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Dni");
        jTConsultaAlumno.setModel(modelo2);
    }

    /*
    // VERSION ANTERIOR CON COMBOBOX
    private void cargarComboBoxALumnos()
    {           
        //System.out.println("Entro a llenar el combobox");
        // Vaciar el JComboBox
        jcbSeleccionAlumno.removeAllItems();
        // agrega una linea que diga -ELIJA UN ALUMNO DE LA LISTA-
        String fechaFalsa="21/09/2023";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaFalsaAPasar = LocalDate.parse(fechaFalsa, formato);
        Alumno aluTitulo = new Alumno(0,0,"-ELIJA UN ALUMNO DE LA LISTA-","",fechaFalsaAPasar,true);
        jcbSeleccionAlumno.addItem(aluTitulo); 
        // ahora agrega en el combobox los datos de alumnos recuperados desde sql        
        for(Alumno alum:alu.listarAlumnos(1)){      
            jcbSeleccionAlumno.addItem(alum); 
        }        
    }
    */
    
    // VERSION NUEVA CON JTABLE
    public void cargarTablaAlumnosMateria(int idAlumnoBuscar) {                
        modelo.setRowCount(0);                
        for(Alumno alumn:alu.listarAlumnos(1)){      
           modelo.addRow(new Object []{
                   alumn.getIdAlumno(),
                   alumn.getDni(),
                   alumn.getApellido(),
                   alumn.getNombre(),
           });                    
        }        
    }  
     
     public void cargarMateriasInscriptas() {        
        jbGuardar.setEnabled(true);        
        modelo.setRowCount(0);        
        String hayMaterias="N"; 
        //System.out.println("Entramos a MateriasInscriptas antes del for");        
        for(Inscripcion inscrip2:ins.obtenerInscripcionesPorAlumno(idAlumnoABuscar)){      
            /*
           System.out.println("Ingreso a armar la Jtabla con los datos traidos");
           System.out.println("idMAteria: "+inscrip2.getMateria().getIdMateria());
           System.out.println("Nombre: "+inscrip2.getMateria().getNombre());
           System.out.println("Nota: "+inscrip2.getNota());
*/
           modelo.addRow(new Object []{               
                   inscrip2.getMateria().getIdMateria(),
                   inscrip2.getMateria().getNombre(),
                   inscrip2.getNota()         
           });            
           hayMaterias="S";
        }
        //System.out.println("Traspasamos el for");
        if (hayMaterias=="N")
        {
            jbGuardar.setEnabled(false);        
        }
    }  
             
    private void borrarFilas()
    {
        int filas = jTConsultaAlumno.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo2.removeRow(i);
        }
    }
     
     

}
