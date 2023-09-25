// dia: 22/09/23 hs: 4:00am
package universidadgrupo33.vistas;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    
    public JIFConsultaAlumnoXMateria() {
        initComponents();
        armarCabecera();
        armarCabecera2();
        // version VIEJA usando COMBOBOX
        //cargarComboBoxMaterias();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTConsultaMaterias = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResultadoSeleccion = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jTFMateriaAbuscar = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Alumnos por Materia");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione una materia:");

        jTConsultaMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jTConsultaMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTConsultaMateriasMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTConsultaMaterias);
        if (jTConsultaMaterias.getColumnModel().getColumnCount() > 0) {
            jTConsultaMaterias.getColumnModel().getColumn(0).setPreferredWidth(4);
            jTConsultaMaterias.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTConsultaMaterias.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

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

        jTFMateriaAbuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTFMateriaAbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFMateriaAbuscarActionPerformed(evt);
            }
        });
        jTFMateriaAbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFMateriaAbuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTFMateriaAbuscar))
                    .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(7, 7, 7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTFMateriaAbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    // VERSION NUEVA BUSCANDO SEGUN LO QUE SE VAYA QUERIENDO BUSCAR EN UNA JTABLE
    private void jTFMateriaAbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMateriaAbuscarKeyReleased
        borrarFilas();
        //      for (Materia mate: deTodoSa.listaProductos)
        for (Materia mate : mat.listarMateriasJTable()) {                    
            //if ((mate.getNombre().toUpperCase()).startsWith((jTFMateriaAbuscar.getText()).toUpperCase())) {
            //if ((mate.getNombre().toUpperCase()).contains((jTFMateriaAbuscar.getText()).toUpperCase())) {
            if ((mate.getNombre()).contains((jTFMateriaAbuscar.getText()))) {
                modelo2.addRow(new Object[]{
                    mate.getIdMateria(),
                    mate.getNombre(),
                    mate.getAño(),
                    mate.isEstado()
                });
            }

        }
        // PARA CONSULTAR SI LA TABLA ESTA VACIA O NO        
        if (jTConsultaMaterias.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "No Existen Datos de Materias", "Advertencia",
            JOptionPane.WARNING_MESSAGE);
        }        
        else
        {        
            int linTabla = jTConsultaMaterias.getSelectedRow()+1;
            int colTabla = jTConsultaMaterias.getSelectedColumn();            
            Object valorTabla = jTConsultaMaterias.getValueAt(linTabla, 0);            
            Materia mat2 = new Materia();            
            mat2.setIdMateria((Integer) jTConsultaMaterias.getValueAt(linTabla, 0));
            mat2.setNombre((String) jTConsultaMaterias.getValueAt(linTabla, 1));
            mat2.setAño((Integer) jTConsultaMaterias.getValueAt(linTabla, 2));
            mat2.setEstado(true);            
            // verifica que la jtable tenga registros para poder trabajar
            if (mat2.getIdMateria() != 0) {
                idMateriaABuscar = mat2.getIdMateria();
                // carga la tabla con los alumnos que cursan esa materia elegida
                cargarTablaAlumnosMateria(idMateriaABuscar);
            } else {
                modelo2.setRowCount(0);
                idMateriaABuscar = 0;
            }            
        }        
    }//GEN-LAST:event_jTFMateriaAbuscarKeyReleased

    private void jTConsultaMateriasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConsultaMateriasMouseReleased
        JTable jTConsultaMaterias = (JTable) evt.getSource();
        int row = jTConsultaMaterias.getSelectedRow();
        int col = jTConsultaMaterias.getSelectedColumn();        
        // obligo a que se tome el nombre de la materia para mostrar 
        Object data2 = (Object) jTConsultaMaterias.getValueAt(row, 1);        
        // y obligo a que se tome el codigo idMateria de la materia para buscar en las inscripciones x materia
        Object data1 = (Object) jTConsultaMaterias.getValueAt(row, 0);
        // asigno ese nombre elegido de la jtable a mi variable jTFMateriaAbuscar (jTextField) para buscar
        jTFMateriaAbuscar.setText(data2.toString());        
        //JOptionPane.showMessageDialog(null, "VVVVVV idMateria capturado desde la tabla es: "+data1);
        //JOptionPane.showMessageDialog(null, "VVVVVV nombre de la materia capturada desde la tabla es: "+data2);
        //JOptionPane.showMessageDialog(null, "VVVVVV nombre del jTFMateriaAbuscar es: "+jTFMateriaAbuscar.getText());        
       
               
    }//GEN-LAST:event_jTConsultaMateriasMouseReleased

    private void jTFMateriaAbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFMateriaAbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFMateriaAbuscarActionPerformed
    
    // VERSION NUEVA BUSCANDO SEGUN LO QUE SE VAYA QUERIENDO BUSCAR EN UNA JTABLE
    /*    
     borrarFilas();
        //      for (Materia mate: deTodoSa.listaProductos)
        for (Materia mate : mat.listarMateriasJTable()) {            
                //System.out.println("A buscar:"+jTFNombreAbuscar.getText());
                //System.out.println(jTFNombreAbuscar.getText().toUpperCase());
                //System.out.println("Leido:"+prod.getDescripcion());
                //System.out.println(prod.getDescripcion().toUpperCase());
                //System.out.println((prod.getDescripcion().toUpperCase()).startsWith((jTFNombreAbuscar.getText()).toUpperCase()));
             
            //if (prod.getDescripcion().startsWith(jTFNombreAbuscar.getText()));
            if ((mate.getNombre().toUpperCase()).startsWith((jTFMateriaAbuscar.getText()).toUpperCase())) {
                modelo2.addRow(new Object[]{
                    mate.getIdMateria(),
                    mate.getNombre(),
                    mate.getAño(),
                    mate.isEstado()
                });
            }

        }
        // PARA CONSULTAR SI LA TABLA ESTA VACIA O NO
        if (jTConsultaMaterias.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "No Existen Datos", "Advertencia",
            JOptionPane.WARNING_MESSAGE);
        }            
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
    */
    
    // VERSION VIEJA BUSCANDO EN UN COMBOBOX
    /*    
    private void jcbSeleccionMateriaActionPerformed(java.awt.event.ActionEvent evt) {                                                    
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
    } 
    */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTConsultaMaterias;
    private javax.swing.JTextField jTFMateriaAbuscar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTable jtResultadoSeleccion;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("Id de Alumno");
        modelo.addColumn("Dni");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        jtResultadoSeleccion.setModel(modelo);
    }
    
    private void armarCabecera2() {
         modelo2.addColumn("Id");
         modelo2.addColumn("Nombre");
         modelo2.addColumn("Año");
         jTConsultaMaterias.setModel(modelo2);
    }

    /*
    // VERSION ANTERIOR CON COMBOBOX
    private void cargarComboBoxMaterias()
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
    */
    
    // VERSION NUEVA CON JTABLE
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
    
    private void borrarFilas()
    {
        int filas = jTConsultaMaterias.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo2.removeRow(i);
        }
    }


}
