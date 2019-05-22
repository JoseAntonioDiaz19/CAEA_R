package controlador;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloSesionUsuario;
import modeloSQL.sqlSesionUsuario;
import vista.vistaPrincipal;
import vista.vistaSesionUsuario;
/**
 * @author Dizan
 */
public class controlVistaSesionUsuario {
    modeloSesionUsuario modeloUsuario;
    vistaSesionUsuario sesionVista;
     sqlSesionUsuario sqlSesionUsuario;
    
    public controlVistaSesionUsuario(vistaSesionUsuario sesionVista, modeloSesionUsuario modeloUsuario) {
        this.sesionVista = sesionVista;
        this.modeloUsuario = modeloUsuario;
        init();
    }

    private void init() {
        sqlSesionUsuario = new sqlSesionUsuario(sesionVista);
        sesionVista.setVisible(true);
        sesionVista.setLocationRelativeTo(null);
        sesionVista.botonEntrar.addActionListener(this::botonEntrar);     
        
        sesionVista.contraseña.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String valorPass = new String(sesionVista.contraseña.getPassword());
                    String usuario = sesionVista.fieldUsuario.getText();
                    modeloUsuario.setUsuario(usuario);
                    System.out.println("usuario = " + usuario);
                    modeloUsuario.setPassword(valorPass);
                    System.out.println("Contraseña = " + valorPass);

                    try {
                        if (sqlSesionUsuario.buscar_usuario(modeloUsuario)) {
                            abrirVistaPrincipal();
                            sesionVista.setVisible(false);
                        }

                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                        JOptionPane.showMessageDialog(sesionVista, "Datos incorrectos");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
    }

    public void botonEntrar(ActionEvent e) {
        System.out.println("Metodo iniciar_sesion clase controlVistaSesionUsuario");
        sqlSesionUsuario = new sqlSesionUsuario(sesionVista);
        String valorPass = new String(sesionVista.contraseña.getPassword());
        String usuario = sesionVista.fieldUsuario.getText();
        modeloUsuario.setUsuario(usuario);
        modeloUsuario.setPassword(valorPass);

        try {
            if (sqlSesionUsuario.buscar_usuario(modeloUsuario)) {
                abrirVistaPrincipal();
                sesionVista.setVisible(false);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(sesionVista, "Datos incorrectos");
        }
    }

    public void abrirVistaPrincipal() {
        System.out.println("Vista principal creada");
        vistaPrincipal ventanaPrincipal = new vistaPrincipal();
 
        sqlSesionUsuario = new sqlSesionUsuario(sesionVista);       
         //Cargar datos de usuario en la interfaz
        try {
            modeloUsuario = sqlSesionUsuario.datosUsuarioActual(modeloUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaSesionUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ventanaPrincipal.fieldNombreUsuario.setText(modeloUsuario.getApe_paterno()+" "
                                                  + modeloUsuario.getApe_materno()+" "
                                                  + modeloUsuario.getNombre());
        
        controlVistaPrincipal ctrlPrincipalVista = new controlVistaPrincipal(ventanaPrincipal, modeloUsuario);
        ventanaPrincipal.setVisible(true);
    }
}
