/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo33.vistas;

import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    
    // PARA PODER CREAR UN OPCION DE ELEGIR SI DESEA SALIR O NO CUANDO PRESIONA -SALIR o X-
    void Cerrar(int tipo)
    {
        String botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea cerrar la Aplicación?", "Titulo",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            // SE USA PARA CERRAR TOTO EL PROGRAMA
            // System.exit(0);
            // SE USA PARA CERRAR LA VENTANA ACTUAL PERO NO CERRAR EL PROGRAMA
            if (tipo == 0) {
                this.dispose();
            } else {
                System.exit(0);
            }
           
        } else {
            if (eleccion == JOptionPane.NO_OPTION) {
               JOptionPane.showMessageDialog(this, "Cierre cancelado...");
            }
        }
    }
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("UNIVERSIDAD ULP");
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAlumno = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmMateria = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jmAdministracion = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmConsultas = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdpEscritorioLayout = new javax.swing.GroupLayout(jdpEscritorio);
        jdpEscritorio.setLayout(jdpEscritorioLayout);
        jdpEscritorioLayout.setHorizontalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1186, Short.MAX_VALUE)
        );
        jdpEscritorioLayout.setVerticalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );

        jmAlumno.setText("Alumno");
        jmAlumno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem1.setText("Gestión de Alumno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmAlumno.add(jMenuItem1);

        jMenuBar1.add(jmAlumno);

        jmMateria.setText("Materia");
        jmMateria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem2.setText("Gestión de Materia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmMateria.add(jMenuItem2);

        jMenuBar1.add(jmMateria);

        jmAdministracion.setText("Administración");
        jmAdministracion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem3.setText("Manejo de Inscripciones");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmAdministracion.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem4.setText("Manipulación de Notas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmAdministracion.add(jMenuItem4);

        jMenuBar1.add(jmAdministracion);

        jmConsultas.setText("Consultas");
        jmConsultas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem5.setText("Alumnos por Materia");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jmConsultas.add(jMenuItem5);

        jMenuBar1.add(jmConsultas);

        jmSalir.setText("Salir");
        jmSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        JIFAlumno jifalumno = new JIFAlumno();
        jifalumno.setVisible(true);
        jdpEscritorio.add(jifalumno);
        jdpEscritorio.moveToFront(jifalumno);

        // Lineas para centrar el jInternalFrame dentro del desktopPane
        Dimension desktopSize = jdpEscritorio.getSize();
        Dimension jInternalFrameSize = jifalumno.getSize();
        jifalumno.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
        (desktopSize.height - jInternalFrameSize.height) / 2);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        JIFInscripciones jifinscripciones = new JIFInscripciones();
        jifinscripciones.setVisible(true);
        jdpEscritorio.add(jifinscripciones);
        jdpEscritorio.moveToFront(jifinscripciones);

        // Lineas para centrar el jInternalFrame dentro del desktopPane
        Dimension desktopSize = jdpEscritorio.getSize();
        Dimension jInternalFrameSize = jifinscripciones.getSize();
        jifinscripciones.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
        (desktopSize.height - jInternalFrameSize.height) / 2);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        JIFMateria jifmateria = new JIFMateria();
        jifmateria.setVisible(true);
        jdpEscritorio.add(jifmateria);
        jdpEscritorio.moveToFront(jifmateria);

        // Lineas para centrar el jInternalFrame dentro del desktopPane
        Dimension desktopSize = jdpEscritorio.getSize();
        Dimension jInternalFrameSize = jifmateria.getSize();
        jifmateria.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
        (desktopSize.height - jInternalFrameSize.height) / 2);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        JIFNotas jifnotas = new JIFNotas();
        jifnotas.setVisible(true);
        jdpEscritorio.add(jifnotas);
        jdpEscritorio.moveToFront(jifnotas);

        // Lineas para centrar el jInternalFrame dentro del desktopPane
        Dimension desktopSize = jdpEscritorio.getSize();
        Dimension jInternalFrameSize = jifnotas.getSize();
        jifnotas.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
        (desktopSize.height - jInternalFrameSize.height) / 2);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        JIFConsultaAlumnoXMateria jifalumnoxmateria = new JIFConsultaAlumnoXMateria();
        jifalumnoxmateria.setVisible(true);
        jdpEscritorio.add(jifalumnoxmateria);
        jdpEscritorio.moveToFront(jifalumnoxmateria);

        // Lineas para centrar el jInternalFrame dentro del desktopPane
        Dimension desktopSize = jdpEscritorio.getSize();
        Dimension jInternalFrameSize = jifalumnoxmateria.getSize();
        jifalumnoxmateria.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
        (desktopSize.height - jInternalFrameSize.height) / 2);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jmSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSalirMouseClicked
    Cerrar(1);
    }//GEN-LAST:event_jmSalirMouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JDesktopPane jdpEscritorio;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmAlumno;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenu jmMateria;
    private javax.swing.JMenu jmSalir;
    // End of variables declaration//GEN-END:variables
}
