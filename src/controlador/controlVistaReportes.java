package controlador;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import modelo.modeloSesionUsuario;
import modeloSQL.conexion;
import modeloSQL.sqlPrincipal;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.vistaReportes;
/**
 * @author Dizan
 */
public class controlVistaReportes {
     Connection con;
    conexion conexion;
    vistaReportes vistaReportes; 
    modeloSesionUsuario modeloUsuario;

    controlVistaReportes(vistaReportes vistaReportes, modeloSesionUsuario modeloUsuario) {
        this.vistaReportes = vistaReportes;
        this.modeloUsuario = modeloUsuario;
        vistaReportes.botonGenerarReporte.addActionListener(this::botonGenerarReporte);
        llenarCiclos();
    }
    
    private void llenarCiclos(){
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <String> ciclosEscolares;
        ciclosEscolares = sqlPrincipal.ciclosEscolares();
        int iteraciones = ciclosEscolares.size();
        for (int i = 0; i < iteraciones; i++) {
            vistaReportes.boxCicloEscolar.addItem(ciclosEscolares.get(i));
        }
    } 
    private void botonGenerarReporte(ActionEvent e){
         String cicloescolar =  String.valueOf(vistaReportes.boxCicloEscolar.getSelectedItem());
         Integer trimestre=  Integer.parseInt(String.valueOf(vistaReportes.boxTrimestre.getSelectedItem()));
        System.out.println("Cicloescolar: "+ cicloescolar);
        System.out.println("Trimestre: "+ trimestre);
       
        conexion = new conexion();
        con = conexion.getConexion(modeloUsuario);
        Map parametros = new HashMap();
        parametros.put("parametroCicloEscolar", cicloescolar);
        parametros.put("parametroTrimestre", trimestre);

        String pathMenu = "/reportes/reporteAlumno.jasper";  
        URL url = this.getClass().getResource(pathMenu);  
        JasperReport jr;
         
        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Reporte", true); 
        viewer.setSize(800,600); 
        viewer.setLocationRelativeTo(null); 
         
         try {
             jr = (JasperReport) JRLoader.loadObject(url);
             JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
             JasperViewer jv = new JasperViewer(jp, true);
             viewer.getContentPane().add(jv.getContentPane()); 
             jv.setTitle("Reporte");
             vistaReportes.dispose();
             viewer.setVisible(true); 
             try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(controlVistaReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         } catch (JRException ex) {
             Logger.getLogger(controlVistaReportes.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
