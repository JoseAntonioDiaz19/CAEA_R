/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author AxiosGaming
 */
public class vistaPrincipal extends javax.swing.JFrame {
 
    public DefaultTableModel modeloTabla;
    /**
     * Creates new form interfaz_Principal
     */
    
    //cambios realizados
  int xx,xy;
    public vistaPrincipal() {
        initComponents();
        modeloTabla = (DefaultTableModel) tablaPrincipal.getModel() ;
        personalizarComponentes();
    }
    
    private void personalizarComponentes(){
        scrollTablaPrincipal.getViewport().setBackground(new Color(8,38,67));
        
        //Iconos del panel menu
        
        String pathMenu = "/img/menu.png";  
        URL urlMenu = this.getClass().getResource(pathMenu);  
        ImageIcon imgMenu = new ImageIcon(urlMenu);  
        botonExpandir.setIcon(imgMenu);
        
        String pathAvances = "/img/avances32x32.png";  
        URL urlAvances = this.getClass().getResource(pathAvances);  
        ImageIcon imgAvances = new ImageIcon(urlAvances);  
        botonAvances.setIcon(imgAvances); 
        
        String pathReportes = "/img/informe32x32.png";  
        URL urlReportes = this.getClass().getResource(pathReportes);  
        ImageIcon imgReportes = new ImageIcon(urlReportes);  
        botonReportes.setIcon(imgReportes); 
        
        String pathUsuario = "/img/usuarios32x32.png";  
        URL urlUsuario = this.getClass().getResource(pathUsuario);  
        ImageIcon imgUsuario = new ImageIcon(urlUsuario);  
        botonUsuarios.setIcon(imgUsuario);
        
        String pathSalir = "/img/salir32x32.png";  
        URL urlSalir = this.getClass().getResource(pathSalir);  
        ImageIcon imgSalir= new ImageIcon(urlSalir);  
        botonSalir.setIcon(imgSalir);
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
        panelSesionUsuario = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        fieldNombreUsuario = new javax.swing.JTextField();
        botonCerrarSesion = new javax.swing.JButton();
        panelCampos = new javax.swing.JPanel();
        boxCicloEscolar = new javax.swing.JComboBox<>();
        boxRegion = new javax.swing.JComboBox<>();
        boxGrado = new javax.swing.JComboBox<>();
        fieldNumerocontrol = new javax.swing.JTextField();
        panelNombre = new javax.swing.JPanel();
        fieldApePaterno = new javax.swing.JTextField();
        fieldApeMaterno = new javax.swing.JTextField();
        fieldNombre = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        botonBuscar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();
        scrollTablaPrincipal = new javax.swing.JScrollPane();
        tablaPrincipal = new javax.swing.JTable();
        panelMenu = new javax.swing.JPanel();
        botonExpandir = new javax.swing.JButton();
        botonAvances = new javax.swing.JButton();
        botonReportes = new javax.swing.JButton();
        botonUsuarios = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        panelInferiorVacio = new javax.swing.JPanel();

        setExtendedState(MAXIMIZED_BOTH);
        setPreferredSize(new java.awt.Dimension(1300, 720));
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        panelPrincipal.setBackground(new java.awt.Color(8, 38, 67));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        panelSesionUsuario.setBackground(new java.awt.Color(8, 38, 67));
        panelSesionUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSesionUsuario.setLayout(new java.awt.GridBagLayout());

        labelUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUsuario.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelSesionUsuario.add(labelUsuario, gridBagConstraints);

        fieldNombreUsuario.setEditable(false);
        fieldNombreUsuario.setBackground(new java.awt.Color(8, 38, 67));
        fieldNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        fieldNombreUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldNombreUsuario.setText("Nombre de usuario");
        fieldNombreUsuario.setMargin(new java.awt.Insets(2, 5, 2, 2));
        fieldNombreUsuario.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelSesionUsuario.add(fieldNombreUsuario, gridBagConstraints);

        botonCerrarSesion.setBackground(new java.awt.Color(8, 38, 67));
        botonCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        botonCerrarSesion.setText("Cerrar sesión");
        botonCerrarSesion.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelSesionUsuario.add(botonCerrarSesion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 10);
        panelPrincipal.add(panelSesionUsuario, gridBagConstraints);

        panelCampos.setBackground(new java.awt.Color(8, 38, 67));
        panelCampos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelCampos.setLayout(new java.awt.GridBagLayout());

        boxCicloEscolar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxCicloEscolar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccione ciclo escolar -" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCampos.add(boxCicloEscolar, gridBagConstraints);

        boxRegion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Region -" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCampos.add(boxRegion, gridBagConstraints);

        boxGrado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Grado -" }));
        boxGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGradoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCampos.add(boxGrado, gridBagConstraints);

        fieldNumerocontrol.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldNumerocontrol.setForeground(new java.awt.Color(153, 153, 153));
        fieldNumerocontrol.setText("Numero de control");
        fieldNumerocontrol.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNumerocontrolFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNumerocontrolFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCampos.add(fieldNumerocontrol, gridBagConstraints);

        panelNombre.setBackground(new java.awt.Color(8, 38, 67));
        panelNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 89, 124), null));
        panelNombre.setForeground(new java.awt.Color(0, 102, 102));
        panelNombre.setLayout(new java.awt.GridBagLayout());

        fieldApePaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldApePaterno.setForeground(new java.awt.Color(153, 153, 153));
        fieldApePaterno.setText("Apellido Paterno");
        fieldApePaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldApePaternoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldApePaternoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelNombre.add(fieldApePaterno, gridBagConstraints);

        fieldApeMaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldApeMaterno.setForeground(new java.awt.Color(153, 153, 153));
        fieldApeMaterno.setText("Apellido Materno");
        fieldApeMaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldApeMaternoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldApeMaternoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelNombre.add(fieldApeMaterno, gridBagConstraints);

        fieldNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldNombre.setForeground(new java.awt.Color(153, 153, 153));
        fieldNombre.setText("Nombre");
        fieldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNombreFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelNombre.add(fieldNombre, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCampos.add(panelNombre, gridBagConstraints);

        panelBotones.setBackground(new java.awt.Color(8, 38, 67));
        panelBotones.setLayout(new java.awt.GridBagLayout());

        botonBuscar.setBackground(new java.awt.Color(153, 0, 51));
        botonBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("Buscar");
        botonBuscar.setAlignmentX(0.5F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 20);
        panelBotones.add(botonBuscar, gridBagConstraints);

        botonRegistrar.setBackground(new java.awt.Color(153, 0, 51));
        botonRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrar.setText("Registrar");
        botonRegistrar.setAlignmentX(0.5F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 0);
        panelBotones.add(botonRegistrar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelCampos.add(panelBotones, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        panelPrincipal.add(panelCampos, gridBagConstraints);

        panelTabla.setBackground(new java.awt.Color(8, 38, 67));
        panelTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTabla.setLayout(new java.awt.GridLayout(1, 0));

        scrollTablaPrincipal.setBackground(new java.awt.Color(0, 51, 102));
        scrollTablaPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        scrollTablaPrincipal.setOpaque(false);

        tablaPrincipal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Control", "A. Paterno", "A. Materno", "Nombre", "Grado", "Región", "Ciclo escolar", "Situación", "Estado", "Estado Actual/Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaPrincipal.setGridColor(new java.awt.Color(153, 204, 255));
        tablaPrincipal.setSelectionBackground(new java.awt.Color(204, 204, 255));
        scrollTablaPrincipal.setViewportView(tablaPrincipal);
        tablaPrincipal.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaPrincipal.getColumnModel().getColumnCount() > 0) {
            tablaPrincipal.getColumnModel().getColumn(0).setMinWidth(100);
            tablaPrincipal.getColumnModel().getColumn(0).setPreferredWidth(100);
            tablaPrincipal.getColumnModel().getColumn(0).setMaxWidth(150);
            tablaPrincipal.getColumnModel().getColumn(1).setMinWidth(150);
            tablaPrincipal.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablaPrincipal.getColumnModel().getColumn(1).setMaxWidth(200);
            tablaPrincipal.getColumnModel().getColumn(2).setMinWidth(150);
            tablaPrincipal.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablaPrincipal.getColumnModel().getColumn(2).setMaxWidth(200);
            tablaPrincipal.getColumnModel().getColumn(3).setMinWidth(150);
            tablaPrincipal.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablaPrincipal.getColumnModel().getColumn(3).setMaxWidth(200);
            tablaPrincipal.getColumnModel().getColumn(4).setMinWidth(50);
            tablaPrincipal.getColumnModel().getColumn(4).setPreferredWidth(50);
            tablaPrincipal.getColumnModel().getColumn(4).setMaxWidth(50);
            tablaPrincipal.getColumnModel().getColumn(5).setMinWidth(100);
            tablaPrincipal.getColumnModel().getColumn(5).setPreferredWidth(100);
            tablaPrincipal.getColumnModel().getColumn(5).setMaxWidth(150);
            tablaPrincipal.getColumnModel().getColumn(6).setMinWidth(100);
            tablaPrincipal.getColumnModel().getColumn(6).setPreferredWidth(100);
            tablaPrincipal.getColumnModel().getColumn(6).setMaxWidth(150);
            tablaPrincipal.getColumnModel().getColumn(7).setMinWidth(100);
            tablaPrincipal.getColumnModel().getColumn(7).setPreferredWidth(100);
            tablaPrincipal.getColumnModel().getColumn(7).setMaxWidth(150);
            tablaPrincipal.getColumnModel().getColumn(8).setMinWidth(100);
            tablaPrincipal.getColumnModel().getColumn(8).setPreferredWidth(50);
            tablaPrincipal.getColumnModel().getColumn(8).setMaxWidth(120);
            tablaPrincipal.getColumnModel().getColumn(9).setMinWidth(110);
            tablaPrincipal.getColumnModel().getColumn(9).setPreferredWidth(110);
            tablaPrincipal.getColumnModel().getColumn(9).setMaxWidth(120);
        }

        panelTabla.add(scrollTablaPrincipal);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelPrincipal.add(panelTabla, gridBagConstraints);

        panelMenu.setBackground(new java.awt.Color(0, 87, 126));
        panelMenu.setMaximumSize(new java.awt.Dimension(70, 0));
        panelMenu.setMinimumSize(new java.awt.Dimension(10, 500));
        panelMenu.setPreferredSize(new java.awt.Dimension(0, 0));
        panelMenu.setLayout(new java.awt.GridBagLayout());

        botonExpandir.setBackground(new java.awt.Color(0, 87, 126));
        botonExpandir.setToolTipText("");
        botonExpandir.setBorder(null);
        botonExpandir.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 15;
        panelMenu.add(botonExpandir, gridBagConstraints);

        botonAvances.setBackground(new java.awt.Color(0, 87, 126));
        botonAvances.setBorder(null);
        botonAvances.setFocusPainted(false);
        botonAvances.setMaximumSize(new java.awt.Dimension(74, 22));
        botonAvances.setMinimumSize(new java.awt.Dimension(74, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 10, 2);
        panelMenu.add(botonAvances, gridBagConstraints);

        botonReportes.setBackground(new java.awt.Color(0, 87, 126));
        botonReportes.setBorder(null);
        botonReportes.setFocusPainted(false);
        botonReportes.setMaximumSize(new java.awt.Dimension(74, 22));
        botonReportes.setMinimumSize(new java.awt.Dimension(74, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 10, 2);
        panelMenu.add(botonReportes, gridBagConstraints);

        botonUsuarios.setBackground(new java.awt.Color(0, 87, 126));
        botonUsuarios.setBorder(null);
        botonUsuarios.setFocusPainted(false);
        botonUsuarios.setMaximumSize(new java.awt.Dimension(74, 22));
        botonUsuarios.setMinimumSize(new java.awt.Dimension(74, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 10, 0);
        panelMenu.add(botonUsuarios, gridBagConstraints);

        botonSalir.setBackground(new java.awt.Color(0, 87, 126));
        botonSalir.setBorder(null);
        botonSalir.setFocusPainted(false);
        botonSalir.setMaximumSize(new java.awt.Dimension(74, 22));
        botonSalir.setMinimumSize(new java.awt.Dimension(74, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        panelMenu.add(botonSalir, gridBagConstraints);

        panelInferiorVacio.setBackground(new java.awt.Color(0, 87, 126));
        panelInferiorVacio.setMinimumSize(new java.awt.Dimension(10, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelMenu.add(panelInferiorVacio, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelPrincipal.add(panelMenu, gridBagConstraints);

        getContentPane().add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boxGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxGradoActionPerformed

    private void fieldNumerocontrolFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNumerocontrolFocusGained
        if ("Numero de control".equals(fieldNumerocontrol.getText())) {
            fieldNumerocontrol.setText("");
            fieldNumerocontrol.setForeground(Color.BLACK);   
        }
    }//GEN-LAST:event_fieldNumerocontrolFocusGained

    private void fieldNumerocontrolFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNumerocontrolFocusLost
       if (fieldNumerocontrol.getText().isEmpty()) {
            fieldNumerocontrol.setText("Numero de control");
             fieldNumerocontrol.setForeground(new Color(153, 153,153));
        }
    }//GEN-LAST:event_fieldNumerocontrolFocusLost

    private void fieldApePaternoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldApePaternoFocusGained
            fieldApePaterno.setText("");
            fieldApePaterno.setForeground(Color.BLACK);  
    }//GEN-LAST:event_fieldApePaternoFocusGained

    private void fieldApeMaternoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldApeMaternoFocusGained
            fieldApeMaterno.setText("");
            fieldApeMaterno.setForeground(Color.BLACK);  
    }//GEN-LAST:event_fieldApeMaternoFocusGained

    private void fieldNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNombreFocusGained
            fieldNombre.setText("");
            fieldNombre.setForeground(Color.BLACK);  
    }//GEN-LAST:event_fieldNombreFocusGained

    private void fieldApePaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldApePaternoFocusLost
        if (fieldApePaterno.getText().isEmpty()) {
            fieldApePaterno.setText("Apellido Paterno");
            fieldApePaterno.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_fieldApePaternoFocusLost

    private void fieldApeMaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldApeMaternoFocusLost
        if (fieldApeMaterno.getText().isEmpty()) {
            fieldApeMaterno.setText("Apellido Materno");
            fieldApeMaterno.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_fieldApeMaternoFocusLost

    private void fieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNombreFocusLost
        if (fieldNombre.getText().isEmpty()) {
            fieldNombre.setText("Nombre");
            fieldNombre.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_fieldNombreFocusLost

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
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonAvances;
    public javax.swing.JButton botonBuscar;
    public javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonExpandir;
    public javax.swing.JButton botonRegistrar;
    public javax.swing.JButton botonReportes;
    public javax.swing.JButton botonSalir;
    public javax.swing.JButton botonUsuarios;
    public javax.swing.JComboBox<String> boxCicloEscolar;
    public javax.swing.JComboBox<String> boxGrado;
    public javax.swing.JComboBox<String> boxRegion;
    private javax.swing.JTextField fieldApeMaterno;
    private javax.swing.JTextField fieldApePaterno;
    private javax.swing.JTextField fieldNombre;
    public javax.swing.JTextField fieldNombreUsuario;
    public javax.swing.JTextField fieldNumerocontrol;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelInferiorVacio;
    public javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSesionUsuario;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JScrollPane scrollTablaPrincipal;
    private javax.swing.JTable tablaPrincipal;
    // End of variables declaration//GEN-END:variables
}
