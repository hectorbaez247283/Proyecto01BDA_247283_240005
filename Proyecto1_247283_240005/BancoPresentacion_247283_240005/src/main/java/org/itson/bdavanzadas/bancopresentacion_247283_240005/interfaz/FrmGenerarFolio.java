/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.bdavanzadas.bancopresentacion_247283_240005.interfaz;

import javax.swing.JOptionPane;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.Conexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.conexion.IConexion;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.daos.RetiroSinCuentaDAO;
import org.itson.bdavanzadas.bancopersistencia_247283_240005.persistenciaException.PersistenciaException;

/**
 *
 * @author Chris
 */
public class FrmGenerarFolio extends javax.swing.JFrame {

    String cadenaConexion = "jdbc:mysql://localhost:3306/banco_247283_240005", usuario = "root", contra = "Avenged21@";
    IConexion c = new Conexion(cadenaConexion, usuario, contra);
    RetiroSinCuentaDAO rDAO = new RetiroSinCuentaDAO(c);

    /**
     * Creates new form FrmGenerarFolio
     */
    public FrmGenerarFolio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumeroCuenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNumeroCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCuentaActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero cuenta:");

        bGenerar.setText("Generar");
        bGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(bGenerar)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bGenerar)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarActionPerformed
        // TODO add your handling code here:
        try {
            // Obtén el número de cuenta desde tu interfaz de usuario (puedes usar un JTextField, por ejemplo)
            int numeroCuenta = Integer.parseInt(txtNumeroCuenta.getText()); // Reemplaza txtNumeroCuenta con el componente real

            // Llama al método para generar el folio
            rDAO.generarFolio(numeroCuenta);

            // Puedes agregar lógica adicional después de generar el folio, si es necesario
            // Mensaje de éxito (puedes mostrarlo en un JOptionPane u otro componente)
            JOptionPane.showMessageDialog(null, "Folio generado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            // Maneja la excepción si el número de cuenta no es válido
            JOptionPane.showMessageDialog(null, "Ingrese un número de cuenta válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (PersistenciaException ex) {
            // Maneja la excepción de persistencia
            JOptionPane.showMessageDialog(null, "Error al generar el folio: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_bGenerarActionPerformed

    private void txtNumeroCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCuentaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGenerarFolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarFolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarFolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarFolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGenerarFolio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNumeroCuenta;
    // End of variables declaration//GEN-END:variables
}
