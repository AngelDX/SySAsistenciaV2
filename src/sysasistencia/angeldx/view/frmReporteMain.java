/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysasistencia.angeldx.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import sysasistencia.angeldx.manager.EventoManager;
import sysasistencia.angeldx.reportes.ReporteAsistentes;
import sysasistencia.angeldx.to.EventoTO;

/**
 *
 * @author AngelDX
 */
public class frmReporteMain extends javax.swing.JFrame {
EventoManager evento=new EventoManager();
EventoTO data=new EventoTO();
    /**
     * Creates new form frmReporteMain
     */
    public frmReporteMain() {
        initComponents();
        cargarEventos();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cboEvento = new javax.swing.JComboBox();
        btnVerReporte1 = new javax.swing.JButton();
        cboCarrera = new javax.swing.JComboBox();
        optEntrada = new javax.swing.JRadioButton();
        optSalida = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Por Eventos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 3, 14))); // NOI18N

        cboEvento.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnVerReporte1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnVerReporte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysasistencia/icons/PNG-48/Print.png"))); // NOI18N
        btnVerReporte1.setText("Ver");
        btnVerReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReporte1ActionPerformed(evt);
            }
        });

        cboCarrera.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cboCarrera.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contabilidad y Gestion Tributaria", "Administracion y Negocios Internacionales", "Asistencia Gerencial" }));

        buttonGroup1.add(optEntrada);
        optEntrada.setSelected(true);
        optEntrada.setText("Entrada");

        buttonGroup1.add(optSalida);
        optSalida.setText("Salida");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCarrera, 0, 396, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optEntrada)
                    .addComponent(optSalida))
                .addGap(47, 47, 47)
                .addComponent(btnVerReporte1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVerReporte1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(optEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(optSalida)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReporte1ActionPerformed
        // TODO add your handling code here:
       String ca=String.valueOf(cboCarrera.getSelectedItem());
       String tipo="";
       if(ca.equals("Contabilidad y Gestion Tributaria")){
           ca="Co";
       }else if(ca.equals("Administracion y Negocios Internacionales")){
           ca="Ad";
       }else if(ca.equals("Asistencia Gerencial")){
           ca="AG";
       }
       if(optEntrada.isSelected()){
           tipo="ENTRADA";
       }
       if(optSalida.isSelected()){
           tipo="SALIDA";
       }
       new ReporteAsistentes().reporteEventos(String.valueOf(cboEvento.getSelectedItem()),ca,tipo);
    }//GEN-LAST:event_btnVerReporte1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmReporteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReporteMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerReporte1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboCarrera;
    private javax.swing.JComboBox cboEvento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton optEntrada;
    private javax.swing.JRadioButton optSalida;
    // End of variables declaration//GEN-END:variables
    void cargarEventos(){
        try {
            ArrayList<EventoTO> d=new ArrayList();
            d=evento.listar();
            for(EventoTO x:d){
                cboEvento.addItem(x.getDescripcion());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }


}
