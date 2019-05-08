/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Dizan
 */
public class vistaDatosAlumno extends javax.swing.JDialog {
    /**
     * Creates new form vistaAltaAlumno
     */
    public vistaDatosAlumno(java.awt.Frame parent, boolean modal) {
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
        panelDatosAlumno = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApe_paterno = new javax.swing.JLabel();
        labelApe_materno = new javax.swing.JLabel();
        labelSexo = new javax.swing.JLabel();
        labelFechaNacimiento = new javax.swing.JLabel();
        labelNumeroControl = new javax.swing.JLabel();
        labelCicloEscolar = new javax.swing.JLabel();
        labelRegion = new javax.swing.JLabel();
        labelGrado = new javax.swing.JLabel();
        labelSituacion = new javax.swing.JLabel();
        labelSituacionFinal = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldApe_paterno = new javax.swing.JTextField();
        fieldApe_materno = new javax.swing.JTextField();
        fieldNumeroControl = new javax.swing.JTextField();
        boxSexo = new javax.swing.JComboBox<>();
        boxAño = new javax.swing.JComboBox<>();
        boxMes = new javax.swing.JComboBox<>();
        boxDia = new javax.swing.JComboBox<>();
        boxCicloEscolar = new javax.swing.JComboBox<>();
        boxRegion = new javax.swing.JComboBox<>();
        boxGrado = new javax.swing.JComboBox<>();
        boxSituacion = new javax.swing.JComboBox<>();
        checkSituacionFinal = new javax.swing.JCheckBox();
        panelBotones = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 592));
        setSize(new java.awt.Dimension(500, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        panelPrincipal.setBackground(new java.awt.Color(8, 38, 67));
        panelPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        panelTitulo.setBackground(new java.awt.Color(8, 38, 67));
        panelTitulo.setLayout(new java.awt.GridLayout(1, 1));

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(153, 204, 255));
        labelTitulo.setText("Editar datos de alumno");
        panelTitulo.add(labelTitulo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        panelPrincipal.add(panelTitulo, gridBagConstraints);

        panelDatosAlumno.setBackground(new java.awt.Color(8, 38, 67));
        panelDatosAlumno.setLayout(new java.awt.GridBagLayout());

        labelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(153, 204, 255));
        labelNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        panelDatosAlumno.add(labelNombre, gridBagConstraints);

        labelApe_paterno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelApe_paterno.setForeground(new java.awt.Color(153, 204, 255));
        labelApe_paterno.setText("Apellido paterno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelApe_paterno, gridBagConstraints);

        labelApe_materno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelApe_materno.setForeground(new java.awt.Color(153, 204, 255));
        labelApe_materno.setText("Apellido materno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelApe_materno, gridBagConstraints);

        labelSexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSexo.setForeground(new java.awt.Color(153, 204, 255));
        labelSexo.setText("Sexo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelSexo, gridBagConstraints);

        labelFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFechaNacimiento.setForeground(new java.awt.Color(153, 204, 255));
        labelFechaNacimiento.setText("Fecha de nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelFechaNacimiento, gridBagConstraints);

        labelNumeroControl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumeroControl.setForeground(new java.awt.Color(153, 204, 255));
        labelNumeroControl.setText("Número de control");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelNumeroControl, gridBagConstraints);

        labelCicloEscolar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCicloEscolar.setForeground(new java.awt.Color(153, 204, 255));
        labelCicloEscolar.setText("Ciclo escolar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelCicloEscolar, gridBagConstraints);

        labelRegion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRegion.setForeground(new java.awt.Color(153, 204, 255));
        labelRegion.setText("Región");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelRegion, gridBagConstraints);

        labelGrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelGrado.setForeground(new java.awt.Color(153, 204, 255));
        labelGrado.setText("Grado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelGrado, gridBagConstraints);

        labelSituacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSituacion.setForeground(new java.awt.Color(153, 204, 255));
        labelSituacion.setText("Situación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelSituacion, gridBagConstraints);

        labelSituacionFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSituacionFinal.setForeground(new java.awt.Color(153, 204, 255));
        labelSituacionFinal.setText("Situación Final");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panelDatosAlumno.add(labelSituacionFinal, gridBagConstraints);

        fieldNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 20);
        panelDatosAlumno.add(fieldNombre, gridBagConstraints);

        fieldApe_paterno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 20);
        panelDatosAlumno.add(fieldApe_paterno, gridBagConstraints);

        fieldApe_materno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 20);
        panelDatosAlumno.add(fieldApe_materno, gridBagConstraints);

        fieldNumeroControl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 20);
        panelDatosAlumno.add(fieldNumeroControl, gridBagConstraints);

        boxSexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexo" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 20);
        panelDatosAlumno.add(boxSexo, gridBagConstraints);

        boxAño.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 10);
        panelDatosAlumno.add(boxAño, gridBagConstraints);

        boxMes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelDatosAlumno.add(boxMes, gridBagConstraints);

        boxDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 20);
        panelDatosAlumno.add(boxDia, gridBagConstraints);

        boxCicloEscolar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxCicloEscolar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ciclo escolar" }));
        boxCicloEscolar.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 20);
        panelDatosAlumno.add(boxCicloEscolar, gridBagConstraints);

        boxRegion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Region" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 20);
        panelDatosAlumno.add(boxRegion, gridBagConstraints);

        boxGrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grado" }));
        boxGrado.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 20);
        panelDatosAlumno.add(boxGrado, gridBagConstraints);

        boxSituacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxSituacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Situación" }));
        boxSituacion.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 20);
        panelDatosAlumno.add(boxSituacion, gridBagConstraints);

        checkSituacionFinal.setBackground(new java.awt.Color(8, 38, 67));
        checkSituacionFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkSituacionFinal.setForeground(new java.awt.Color(255, 255, 255));
        checkSituacionFinal.setText("Todos los grados acreditados");
        checkSituacionFinal.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 20);
        panelDatosAlumno.add(checkSituacionFinal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelPrincipal.add(panelDatosAlumno, gridBagConstraints);

        panelBotones.setBackground(new java.awt.Color(8, 38, 67));
        panelBotones.setToolTipText("");
        panelBotones.setLayout(new java.awt.GridBagLayout());

        botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonGuardar.setText("Guardar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelBotones.add(botonGuardar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        panelPrincipal.add(panelBotones, gridBagConstraints);

        getContentPane().add(panelPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(vistaDatosAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaDatosAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaDatosAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaDatosAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vistaDatosAlumno dialog = new vistaDatosAlumno(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonGuardar;
    private javax.swing.JComboBox<String> boxAño;
    private javax.swing.JComboBox<String> boxCicloEscolar;
    private javax.swing.JComboBox<String> boxDia;
    private javax.swing.JComboBox<String> boxGrado;
    private javax.swing.JComboBox<String> boxMes;
    private javax.swing.JComboBox<String> boxRegion;
    private javax.swing.JComboBox<String> boxSexo;
    private javax.swing.JComboBox<String> boxSituacion;
    private javax.swing.JCheckBox checkSituacionFinal;
    private javax.swing.JTextField fieldApe_materno;
    private javax.swing.JTextField fieldApe_paterno;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldNumeroControl;
    private javax.swing.JLabel labelApe_materno;
    private javax.swing.JLabel labelApe_paterno;
    private javax.swing.JLabel labelCicloEscolar;
    private javax.swing.JLabel labelFechaNacimiento;
    private javax.swing.JLabel labelGrado;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumeroControl;
    private javax.swing.JLabel labelRegion;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel labelSituacion;
    private javax.swing.JLabel labelSituacionFinal;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatosAlumno;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}