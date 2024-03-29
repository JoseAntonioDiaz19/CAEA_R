package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
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
        vistaReportes.boxTipoReporte.addItemListener(this::boxTipoReporte);
        llenarCiclos();
        llenarRegiones();
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
    
     private void llenarRegiones(){
       sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
       ArrayList <String> regiones;
       regiones = sqlPrincipal.regiones();
       int iteraciones = regiones.size();
       for (int i = 0; i < iteraciones; i++) {
           vistaReportes.boxRegion.addItem(regiones.get(i));
       }
   }
    private void botonGenerarReporte(ActionEvent e){
        String tipoReporte =  String.valueOf(vistaReportes.boxTipoReporte.getSelectedItem());
        if ("Resumen general de alumnos y etapas".equals(tipoReporte)) {        
            reporteResumenGeneral();
        }
 
        if ("Concentrado de alumnos y etapas".equals(tipoReporte)) {
            reporteConcentradoAlumnos();
        }
    }
    
    private void reporteResumenGeneral(){
        String cicloescolar =  String.valueOf(vistaReportes.boxCicloEscolar.getSelectedItem());
        Integer trimestre=  Integer.parseInt(String.valueOf(vistaReportes.boxTrimestre.getSelectedItem()));
        System.out.println("Cicloescolar: "+ cicloescolar);
        System.out.println("Trimestre: "+ trimestre);
       
        conexion = new conexion();
        con = conexion.getConexion(modeloUsuario);
        Map parametros = new HashMap();
        parametros.put("parametroCicloEscolar", cicloescolar);
        parametros.put("parametroTrimestre", trimestre);

        String pathMenu = "/reportes/reporteResumenAlumnosEtapas.jasper";  
        URL url = this.getClass().getResource(pathMenu);  
        JasperReport jr;
         
        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Resumen general de alumnos y etapas", true); 
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
    
    private void reporteConcentradoAlumnos(){
        String cicloescolar =  String.valueOf(vistaReportes.boxCicloEscolar.getSelectedItem());
        String region = (String.valueOf(vistaReportes.boxRegion.getSelectedItem()));
        System.out.println("Cicloescolar: "+ cicloescolar);
        System.out.println("Trimestre: "+ region);
       
        conexion = new conexion();
        con = conexion.getConexion(modeloUsuario);
        Map parametros = new HashMap();
        parametros.put("parametroCicloEscolar", cicloescolar);
        parametros.put("parametroRegion", region);

        String pathMenu = "/reportes/reporteConcentradoAlumnosEtapas.jasper";  
        URL url = this.getClass().getResource(pathMenu);  
        JasperReport jr;
         
        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Concentrado de alumnos y etapas", true); 
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
    
    private void boxTipoReporte(ItemEvent eventItem){
        String tipoReporte =  String.valueOf(vistaReportes.boxTipoReporte.getSelectedItem());
        
        if ("Resumen general de alumnos y etapas".equals(tipoReporte)) {        
            vistaReportes.boxCicloEscolar.setEnabled(true);
            vistaReportes.boxTrimestre.setEnabled(true);
            vistaReportes.boxRegion.setEnabled(false);  
        }
 
        if ("Concentrado de alumnos y etapas".equals(tipoReporte)) {
           vistaReportes.boxCicloEscolar.setEnabled(true);
           vistaReportes.boxTrimestre.setEnabled(false);
           vistaReportes.boxRegion.setEnabled(true); 
        }
    }
}
