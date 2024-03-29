/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;

/**
 *
 * @author Dizan
 */
public class vistaReportes extends javax.swing.JDialog {

    /**
     * Creates new form vistaReinscripcion
     */
    public vistaReportes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        labelTipoReporte = new javax.swing.JLabel();
        labelCicloEscolar = new javax.swing.JLabel();
        labelTrimestre = new javax.swing.JLabel();
        labelRegion = new javax.swing.JLabel();
        boxTipoReporte = new javax.swing.JComboBox<>();
        boxCicloEscolar = new javax.swing.JComboBox<>();
        boxTrimestre = new javax.swing.JComboBox<>();
        boxRegion = new javax.swing.JComboBox<>();
        panelBotones = new javax.swing.JPanel();
        botonGenerarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(438, 324));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        panelPrincipal.setBackground(new java.awt.Color(8, 38, 67));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        panelTitulo.setBackground(new java.awt.Color(8, 38, 67));
        panelTitulo.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        panelTitulo.setLayout(new java.awt.GridBagLayout());

        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Generar reportes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelTitulo.add(labelTitulo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelPrincipal.add(panelTitulo, gridBagConstraints);

        panelOpciones.setBackground(new java.awt.Color(8, 38, 67));
        panelOpciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelOpciones.setLayout(new java.awt.GridBagLayout());

        labelTipoReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTipoReporte.setForeground(new java.awt.Color(255, 255, 255));
        labelTipoReporte.setText("Tipo de reporte");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelOpciones.add(labelTipoReporte, gridBagConstraints);

        labelCicloEscolar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCicloEscolar.setForeground(new java.awt.Color(255, 255, 255));
        labelCicloEscolar.setText("Ciclo escolar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelOpciones.add(labelCicloEscolar, gridBagConstraints);

        labelTrimestre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelTrimestre.setForeground(new java.awt.Color(255, 255, 255));
        labelTrimestre.setText("Trimestre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelOpciones.add(labelTrimestre, gridBagConstraints);

        labelRegion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelRegion.setForeground(new java.awt.Color(255, 255, 255));
        labelRegion.setText("Región");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelOpciones.add(labelRegion, gridBagConstraints);

        boxTipoReporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxTipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Tipo de reporte - ", "Resumen general de alumnos y etapas", "Concentrado de alumnos y etapas" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelOpciones.add(boxTipoReporte, gridBagConstraints);

        boxCicloEscolar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxCicloEscolar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Ciclo escolar -" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelOpciones.add(boxCicloEscolar, gridBagConstraints);

        boxTrimestre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxTrimestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Trimestre -", "1", "2", "3" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelOpciones.add(boxTrimestre, gridBagConstraints);

        boxRegion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Region -" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelOpciones.add(boxRegion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelPrincipal.add(panelOpciones, gridBagConstraints);

        panelBotones.setBackground(new java.awt.Color(8, 38, 67));
        panelBotones.setLayout(new java.awt.GridBagLayout());

        botonGenerarReporte.setBackground(new java.awt.Color(8, 38, 67));
        botonGenerarReporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        botonGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/report.png"))); // NOI18N
        botonGenerarReporte.setText("Generar");
        botonGenerarReporte.setBorder(null);
        botonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarReporteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 50);
        panelBotones.add(botonGenerarReporte, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        panelPrincipal.add(panelBotones, gridBagConstraints);

        getContentPane().add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGenerarReporteActionPerformed

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
            java.util.logging.Logger.getLogger(vistaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vistaReportes dialog = new vistaReportes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonGenerarReporte;
    public javax.swing.JComboBox<String> boxCicloEscolar;
    public javax.swing.JComboBox<String> boxRegion;
    public javax.swing.JComboBox<String> boxTipoReporte;
    public javax.swing.JComboBox<String> boxTrimestre;
    private javax.swing.JLabel labelCicloEscolar;
    private javax.swing.JLabel labelRegion;
    private javax.swing.JLabel labelTipoReporte;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTrimestre;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
