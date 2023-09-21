
package universidadgrupo33.vistas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
        cargarComboBoxALumnos();
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
        jcbSeleccionAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResultadoSeleccionAlumno = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jcbSeleccionAlumno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jcbSeleccionAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionAlumnoActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbSeleccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbSeleccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbSeleccionAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSeleccionAlumnoActionPerformed
        alu2  = (Alumno) jcbSeleccionAlumno.getSelectedItem();                
        // verifica que no elija la primer linea del combobox que es solo titulo
        if (alu2.getIdAlumno() != 0) {
            idAlumnoABuscar = alu2.getIdAlumno();    
            MateriasInscriptas();
        }else{
            modelo.setRowCount(0);        
            idAlumnoABuscar =0;
            jbGuardar.setEnabled(false);            
        }

    }//GEN-LAST:event_jcbSeleccionAlumnoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        System.out.println("idAlumno: "+idAlumnoABuscar);
    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbSeleccionAlumno;
    private javax.swing.JTable jtResultadoSeleccionAlumno;
    // End of variables declaration//GEN-END:variables
private void armarCabecera() {
        modelo.addColumn("Código de Materia");
        modelo.addColumn("Nombre de materia");
        modelo.addColumn("Nota");
        jtResultadoSeleccionAlumno.setModel(modelo);

    }

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
     
     public void MateriasInscriptas() {        
        jbGuardar.setEnabled(true);        
        modelo.setRowCount(0);        
        String hayMaterias="N";        
        for(Materia mater:ins.obtenerMateriasCursadas(idAlumnoABuscar)){      
           modelo.addRow(new Object []{mater.getIdMateria(),
                   mater.getNombre(),
                   mater.getAño()});                               
           hayMaterias="S";
        }
        if (hayMaterias=="N")
        {
            jbGuardar.setEnabled(false);        
        }
    }  

}
