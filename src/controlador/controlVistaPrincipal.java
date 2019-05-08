package controlador;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.modeloSesionUsuario;
import vista.vistaAltaAlumno;
import vista.vistaAltaUsuario;
import vista.vistaAvances;
import vista.vistaPrincipal;
import vista.vistaReportes;
import vista.vistaSesionUsuario;
/**
 *
 * @author Dizan
 */
public class controlVistaPrincipal {

    vistaPrincipal ventanaPrincipal;
    vistaSesionUsuario vistaSesion;
    vistaReportes vistaReportes;
    vistaAltaUsuario vistaAltaUsuario;
    vistaAvances  vistaAvances ;
    vistaAltaAlumno vistaAltaAlumno;
   
    controlVistaPrincipal(vistaPrincipal ventanaPrincipal) {
       this.ventanaPrincipal = ventanaPrincipal;

       ventanaPrincipal.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
       eventos();   
    }
    
    private void eventos(){
        ventanaPrincipal.botonCerrarSesion.addActionListener(this::botonCerrarSesion);   
        ventanaPrincipal.botonReportes.addActionListener(this::botonReportes);
        ventanaPrincipal.botonSalir.addActionListener(this::botonSalir);
        ventanaPrincipal.botonUsuarios.addActionListener(this::botonUsuarios);
        ventanaPrincipal.botonAvances.addActionListener(this::botonAvances);
        ventanaPrincipal.botonRegistrar.addActionListener(this::botonRegistrar);
    }
    
    private void close(){ 
        vistaSesion = new vistaSesionUsuario();
        modeloSesionUsuario modeloSesionUsuario = new modeloSesionUsuario();
        vistaSesion.setVisible(true);
        controlVistaSesionUsuario controlVistaSesionUsuario = new controlVistaSesionUsuario(vistaSesion, modeloSesionUsuario);
        System.out.println("Nueva ventana de inicio de sesion");
    } 

    public void botonCerrarSesion(ActionEvent e){
       System.out.println("Cerrar sesion boton");
       ventanaPrincipal.dispose();
       close();
    }
    
    public void botonReportes(ActionEvent e){
        vistaReportes = new vistaReportes(ventanaPrincipal, true);
        vistaReportes.setVisible(true);   
    }
    
    public void botonSalir(ActionEvent e){
        int respuesta = JOptionPane.showConfirmDialog(null,"¿Realmente desea salir?");
        
        if (respuesta == JOptionPane.YES_OPTION) {
            ventanaPrincipal.dispose();
            close();
        }else{
            JOptionPane.showMessageDialog(vistaSesion, "Te salvaste!!!");
        }
    }
    
    public void botonUsuarios(ActionEvent e){
        vistaAltaUsuario = new vistaAltaUsuario(ventanaPrincipal, true);
        vistaAltaUsuario.setVisible(true);
    }
    
    public void botonAvances(ActionEvent e){
        vistaAvances = new vistaAvances(ventanaPrincipal, true);
        vistaAvances.setVisible(true);
    }
    
    public void botonRegistrar (ActionEvent e){
        vistaAltaAlumno = new vistaAltaAlumno(ventanaPrincipal, true);
        vistaAltaAlumno.setVisible(true);
    }
}
