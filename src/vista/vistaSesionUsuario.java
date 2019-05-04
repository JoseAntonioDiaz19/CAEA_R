package vista;
import recursos.JPanelFondo;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import recursos.Hint;
import recursos.JPanelTransparente;
/**
 * @JOSE ANTONIO DIAZ
 * VERSION 1.0
 */
public class vistaSesionUsuario extends JFrame{

    GridBagConstraints constraints = new GridBagConstraints();
    JPanelFondo contentPane = new JPanelFondo("/img/paisaje1.jpg");
    JPanelTransparente panelTitulo = new JPanelTransparente();
    JPanelFondo panelSesion = new JPanelFondo("/img/SESION.png");
    
    JLabel inicioSesion = new JLabel("Inicio de sesión");
    public JTextField fieldUsuario = new Hint("Usuario");
    public JPasswordField contraseña = new JPasswordField();
    public JButton botonEntrar = new JButton("Entrar");
    

    public vistaSesionUsuario() {
        super("Inicio de sesion");
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(0, 0, 20, 0));//(arriba,izquierda,abajo, derecha)
        contentPane.setBackground(new Color(180, 215,238));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        titulo();
        panelSesion();
        componentes();
        add(contentPane);
        setSize(950,525); 
        setLocationRelativeTo(null);
        
    } 
    
    private void titulo(){
        JLabel titulo1 = new JLabel("Control de avances de escritura ");
        JLabel titulo2 = new JLabel("de alumnos");
        JLabel titulo3 = new JLabel("Zona 06 Tapachula");
        
        panelTitulo.setLayout(new GridBagLayout());
        GridBagConstraints constraintsPanel= new GridBagConstraints();
        
         //titulo1
        titulo1.setFont(new java.awt.Font("Arial", 1,22));
        titulo1.setForeground(Color.white);
        constraintsPanel.gridx = 0;
        constraintsPanel.gridy = 0;
        constraintsPanel.gridwidth = 1;
        constraintsPanel.gridheight = 1;
        constraintsPanel.weightx = 1.0;
        constraintsPanel.anchor = GridBagConstraints.NORTH; 
        panelTitulo.add (titulo1, constraintsPanel);

        //Titulo2
        titulo2.setFont(new java.awt.Font("Arial", 1,22));
        titulo2.setForeground(Color.white);
        constraintsPanel.gridx = 0;
        constraintsPanel.gridy = 1;
        constraintsPanel.gridwidth = 1;
        constraintsPanel.gridheight = 1;
        constraintsPanel.weightx = 1.0;
        constraintsPanel.anchor = GridBagConstraints.CENTER; 
        panelTitulo.add (titulo2, constraintsPanel);

        //Titulo 3
        titulo3.setFont(new java.awt.Font("Arial", 1,22));
        titulo3.setForeground(Color.white);
        constraintsPanel.gridx = 0;
        constraintsPanel.gridy = 2;
        constraintsPanel.gridwidth = 1;
        constraintsPanel.gridheight = 1;
        constraintsPanel.weightx = 1.0;
        constraintsPanel.anchor = GridBagConstraints.SOUTH; 
        panelTitulo.add (titulo3, constraintsPanel);
        
    }
    
    private void componentes(){
        
        JLabel imgSecretaria = new JLabel();
        String path = "/img/SEP.png";  
        URL url1 = this.getClass().getResource(path);  
        ImageIcon img1 = new ImageIcon(url1);  
        imgSecretaria.setIcon(img1); 

        JLabel imgConafe = new JLabel();
        String path2 = "/img/CONAFE.png";  
        URL url2 = this.getClass().getResource(path2);  
        ImageIcon img2 = new ImageIcon(url2);  
        imgConafe.setIcon(img2);
        
        //imgSecreateria
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty =1.0;
        constraints.anchor = GridBagConstraints.WEST; 
        contentPane.add (imgSecretaria, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.CENTER; 
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 100;
        contentPane.add (panelTitulo, constraints);
        constraints.gridy = 0;
       
        //imgConafe
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty =1.0;
        constraints.anchor = GridBagConstraints.WEST; 
        contentPane.add (imgConafe, constraints);
        constraints.weighty =0.0;
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.ipadx = 100;
        constraints.ipady = 150;
        constraints.insets = new Insets(50, 0, 50, 0);//(arriba,izquierda,abajo, derecha)
        constraints.fill = GridBagConstraints.BOTH; 
        contentPane.add (panelSesion, constraints);  
    }
    
    
    private void panelSesion (){
             
        panelSesion.setLayout(new GridBagLayout());
        GridBagConstraints constraintsPanelSesion = new GridBagConstraints();
        
        inicioSesion.setFont(new java.awt.Font("Arial", 1,20));
        inicioSesion.setForeground(Color.white);
        constraintsPanelSesion.gridx = 0;
        constraintsPanelSesion.gridy = 0;
        constraintsPanelSesion.gridwidth = 1;
        constraintsPanelSesion.gridheight = 1;
        constraintsPanelSesion.weightx = 1.0;
        constraintsPanelSesion.weighty = 1.0;
        constraintsPanelSesion.anchor = GridBagConstraints.CENTER; 
        panelSesion.add (inicioSesion, constraintsPanelSesion);
        
        fieldUsuario.setFont(new java.awt.Font("Arial", 0,16));
        constraintsPanelSesion.gridx = 0;
        constraintsPanelSesion.gridy = 1;
        constraintsPanelSesion.gridwidth = 1;
        constraintsPanelSesion.gridheight = 1;
        constraintsPanelSesion.weightx = 1.0;
        constraintsPanelSesion.insets = new Insets(0, 50, 0, 50);//(arriba,izquierda,abajo, derecha)
        constraintsPanelSesion.fill = GridBagConstraints.HORIZONTAL;
        panelSesion.add (fieldUsuario, constraintsPanelSesion);
        fieldUsuario.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                borrarTexto(evt, fieldUsuario);
            }
        });
        
        contraseña.setFont(new java.awt.Font("Arial", 0,16));
        constraintsPanelSesion.gridx = 0;
        constraintsPanelSesion.gridy = 2;
        constraintsPanelSesion.gridwidth = 1;
        constraintsPanelSesion.gridheight = 1;
        constraintsPanelSesion.weightx = 1.0;
        panelSesion.add (contraseña, constraintsPanelSesion);
        constraintsPanelSesion.fill = GridBagConstraints.NONE;
        
        botonEntrar.setFont(new java.awt.Font("Arial", 0,16));
        constraintsPanelSesion.gridx = 0;
        constraintsPanelSesion.gridy = 3;
        constraintsPanelSesion.gridwidth = 1;
        constraintsPanelSesion.gridheight = 1;
        constraintsPanelSesion.ipadx=50;
        panelSesion.add (botonEntrar, constraintsPanelSesion);
    }
    
    public void borrarTexto(MouseEvent evt, JTextField e)
    {
        e.setText("");
    }
    
    public static void main(String[] args) {
       vistaSesionUsuario prueba =new  vistaSesionUsuario();
    }
}
