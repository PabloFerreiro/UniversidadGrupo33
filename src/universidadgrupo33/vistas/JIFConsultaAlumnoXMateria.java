// dia: 22/09/23 hs: 4:00am
package universidadgrupo33.vistas;
import javax.swing.table.DefaultTableModel;
import universidadgrupo33.accesoADatos.AlumnoData;
import universidadgrupo33.accesoADatos.InscripcionData;
import universidadgrupo33.accesoADatos.MateriaData;
import universidadgrupo33.entidades.Alumno;
import universidadgrupo33.entidades.Inscripcion;
import universidadgrupo33.entidades.Materia;

/**
 *
 * @author Pablo
 */
public class JIFConsultaAlumnoXMateria extends javax.swing.JInternalFrame {

   private DefaultTableModel modelo = new DefaultTableModel(){
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
    
    public JIFConsultaAlumnoXMateria() {
        initComponents();
        armarCabecera();
        cargarComboBoxALumnos();
        this.setTitle("UNIVERSIDAD ULP - Listado de Alumnos por Materia");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbSeleccionMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResultadoSeleccion = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Alumnos por Materia");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione una materia:");

        jcbSeleccionMateria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jcbSeleccionMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionMateriaActionPerformed(evt);
            }
        });

        jtResultadoSeleccion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtResultadoSeleccion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtResultadoSeleccion);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jcbSeleccionMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbSeleccionMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbSeleccionMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSeleccionMateriaActionPerformed
        mat2  = (Materia) jcbSeleccionMateria.getSelectedItem();                
        // verifica que no elija la primer linea del combobox que es solo titulo
        if (mat2.getIdMateria() != 0) {
            idMateriaABuscar = mat2.getIdMateria();            
            // carga la tabla con los alumnos que cursan esa materia elegida
            cargarTablaAlumnosMateria(idMateriaABuscar);
        }else{
            modelo.setRowCount(0);        
            idMateriaABuscar =0;            
        }
        //System.out.println("x idMateria a usar par buscar en Materias: "+idMateriaABuscar);                 
    }//GEN-LAST:event_jcbSeleccionMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Materia> jcbSeleccionMateria;
    private javax.swing.JTable jtResultadoSeleccion;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("Id de Alumno");
        modelo.addColumn("Dni");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        jtResultadoSeleccion.setModel(modelo);
    }

    private void cargarComboBoxALumnos()
    {           
        //System.out.println("Entro a llenar el combobox");
        // Vaciar el JComboBox
        jcbSeleccionMateria.removeAllItems();
        // agrega una linea que diga -ELIJA UNA MATERIA DE LA LISTA-        
        Materia matTitulo = new Materia(0,"-ELIJA UNA MATERIA DE LA LISTA-",0,false);        
        jcbSeleccionMateria.addItem(matTitulo); 
        // ahora agrega en el combobox los datos de alumnos recuperados desde sql        
        for(Materia mate:mat.listarMaterias()){      
            jcbSeleccionMateria.addItem(mate); 
        }        
    }
    
    public void cargarTablaAlumnosMateria(int idMateriaBuscar) {                
        modelo.setRowCount(0);                
        for(Alumno alumn:ins.obtenerAlumnosXMateria(idMateriaABuscar)){      
           modelo.addRow(new Object []{
                   alumn.getIdAlumno(),
                   alumn.getDni(),
                   alumn.getApellido(),
                   alumn.getNombre(),
           });                    
        }        
    }  
    


}
