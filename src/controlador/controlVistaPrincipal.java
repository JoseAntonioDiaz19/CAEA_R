package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.modeloSesionUsuario;
import modelo.modeloTablaPrincipal;
import modeloSQL.sqlPrincipal;
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
    vistaSesionUsuario vistaSesionUsuario;
    vistaReportes vistaReportes;
    vistaAltaUsuario vistaAltaUsuario;
    vistaAvances  vistaAvances ;
    vistaAltaAlumno vistaAltaAlumno;
    controlVistaAltaAlumno controlVistaAltaAlumno;
    modeloSesionUsuario modeloUsuario;
    modeloTablaPrincipal modeloTablaPrincipal;

   
    controlVistaPrincipal(vistaPrincipal ventanaPrincipal, modeloSesionUsuario modeloUsuario) {
       this.ventanaPrincipal = ventanaPrincipal;
       this.modeloUsuario = modeloUsuario;

       ventanaPrincipal.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
       eventos();  
       
       llenarCiclosEscolares();
       llenarRegiones();
       llenarGrados();
    }
    
    private void eventos(){
        ventanaPrincipal.botonCerrarSesion.addActionListener(this::botonCerrarSesion);   
        ventanaPrincipal.botonReportes.addActionListener(this::botonReportes);
        ventanaPrincipal.botonSalir.addActionListener(this::botonSalir);
        ventanaPrincipal.botonUsuarios.addActionListener(this::botonUsuarios);
        ventanaPrincipal.botonAvances.addActionListener(this::botonAvances);
        ventanaPrincipal.botonRegistrar.addActionListener(this::botonRegistrar);
        ventanaPrincipal.botonBuscar.addActionListener(this::botonBuscar);
        ventanaPrincipal.boxCicloEscolar.addItemListener(this::boxCicloEscolar);
        ventanaPrincipal.boxRegion.addItemListener(this::boxRegion);
        ventanaPrincipal.boxGrado.addItemListener(this::boxGrado);
        
    }
    
    private void close(){ 
        vistaSesionUsuario = new vistaSesionUsuario();
        modeloSesionUsuario modeloSesionUsuario = new modeloSesionUsuario();
        vistaSesionUsuario.setVisible(true);
        controlVistaSesionUsuario controlVistaSesionUsuario = new controlVistaSesionUsuario(vistaSesionUsuario, modeloSesionUsuario);
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
            JOptionPane.showMessageDialog(vistaSesionUsuario, "Te salvaste!!!");
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
        controlVistaAltaAlumno = new controlVistaAltaAlumno(vistaAltaAlumno, modeloUsuario );
        vistaAltaAlumno.setVisible(true); 
    }
    
    private void llenarCiclosEscolares(){
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <String> ciclosEscolares;
        ciclosEscolares = sqlPrincipal.ciclosEscolares();
        int iteraciones = ciclosEscolares.size();
        for (int i = 0; i < iteraciones; i++) {
            ventanaPrincipal.boxCicloEscolar.addItem(ciclosEscolares.get(i));
        } 
    }
    
   private void llenarRegiones(){
       sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
       ArrayList <String> regiones;
       regiones = sqlPrincipal.regiones();
       int iteraciones = regiones.size();
       for (int i = 0; i < iteraciones; i++) {
           ventanaPrincipal.boxRegion.addItem(regiones.get(i));
       }
   }
   
   private void llenarGrados(){
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <String>  grados;
        grados = sqlPrincipal.grados();
        int iteraciones = grados.size();
        for (int i = 0; i < iteraciones; i++) {
           ventanaPrincipal.boxGrado.addItem(grados.get(i));
       }
   }
   
   private void botonBuscar(ActionEvent e){
        buscarPorNocontrol();
   }
   
   private void buscarPorNocontrol(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <modeloTablaPrincipal>  busquedaNocontrol;
        String nocontrol = ventanaPrincipal.fieldNumerocontrol.getText();
        busquedaNocontrol = sqlPrincipal.buscarPorNocontrol(nocontrol);
       
        int iteraciones =  busquedaNocontrol.size();
       
        System.out.println("iteraciones = " + iteraciones);
        for (int i = 0; i < iteraciones; i++) {
                ventanaPrincipal.modeloTabla.addRow(new Object[]{
                                    busquedaNocontrol.get(i).getNocontrol(),
                                    busquedaNocontrol.get(i).getApe_paterno(),
                                    busquedaNocontrol.get(i).getApe_materno(),
                                    busquedaNocontrol.get(i).getNombre(),
                                    busquedaNocontrol.get(i).getGrado(),
                                    busquedaNocontrol.get(i).getRegion(),
                                    busquedaNocontrol.get(i).getCicloescolar(),
                                    busquedaNocontrol.get(i).getSituacion(),
                                    busquedaNocontrol.get(i).getEstado(),
                                    busquedaNocontrol.get(i).getEstado_actual_final()  
            });
           
       }  
    }
   
    private void boxCicloEscolar(ItemEvent eventItem){
        String itemCiclo = (String) ventanaPrincipal.boxCicloEscolar.getSelectedItem();
        String itemRegion = (String) ventanaPrincipal.boxRegion.getSelectedItem();
        String itemGrado = (String) ventanaPrincipal.boxGrado.getSelectedItem();
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -")) {
            buscarPorCicloEscolar();
        }
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarCicloRegion(); 
        }
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloGrado();
        }
    }
    
    private void boxRegion(ItemEvent eventItem){
        String itemCiclo = (String) ventanaPrincipal.boxCicloEscolar.getSelectedItem();
        String itemRegion = (String) ventanaPrincipal.boxRegion.getSelectedItem();
        String itemGrado = (String) ventanaPrincipal.boxGrado.getSelectedItem();
        
        if (!itemRegion.equals("- Seleccione Region -")) {
            buscarPorRegion();
        }
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarCicloRegion(); 
        }
        
        if (!itemGrado.equals("- Seleccione Grado -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarRegionGrado();
        }  
    }
    
    private void boxGrado(ItemEvent eventItem){
        String itemGrado = (String) ventanaPrincipal.boxGrado.getSelectedItem();
        String itemCiclo = (String) ventanaPrincipal.boxCicloEscolar.getSelectedItem();
        String itemRegion = (String) ventanaPrincipal.boxRegion.getSelectedItem();
        
        if (!itemGrado.equals("- Seleccione Grado -")) {
             buscarPorGrado();
        }
        
        if (!itemGrado.equals("- Seleccione Grado -") && !itemCiclo.equals("- Seleccione Ciclo Escolar -") ) {
            buscarCicloGrado();
        }
        
        if (!itemGrado.equals("- Seleccione Grado -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarRegionGrado();
        } 
    }
   
    private void buscarPorCicloEscolar(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        String cicloSeleccionado = (String) ventanaPrincipal.boxCicloEscolar.getSelectedItem();
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        
        ArrayList <modeloTablaPrincipal>  busqueda;
        busqueda = sqlPrincipal.buscarPorCicloEscolar(cicloSeleccionado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                ventanaPrincipal.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getGrado(),
                                    busqueda.get(i).getRegion(),
                                    busqueda.get(i).getCicloescolar(),
                                    busqueda.get(i).getSituacion(),
                                    busqueda.get(i).getEstado(),
                                    busqueda.get(i).getEstado_actual_final()  
            });
       }    
    }
    
    private void buscarPorRegion(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        String region = (String) ventanaPrincipal.boxRegion.getSelectedItem();
        region = region.substring(1,region.length());
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        
        ArrayList <modeloTablaPrincipal>  busqueda;
        busqueda = sqlPrincipal.buscarPorRegion(region);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                ventanaPrincipal.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getGrado(),
                                    busqueda.get(i).getRegion(),
                                    busqueda.get(i).getCicloescolar(),
                                    busqueda.get(i).getSituacion(),
                                    busqueda.get(i).getEstado(),
                                    busqueda.get(i).getEstado_actual_final()  
            });
       }    
    }
    
    private void buscarPorGrado(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        int itemSeleccionado = Integer.parseInt((String) ventanaPrincipal.boxGrado.getSelectedItem());
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        
        ArrayList <modeloTablaPrincipal>  busqueda;
        busqueda = sqlPrincipal.buscarPorGrado(itemSeleccionado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                ventanaPrincipal.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getGrado(),
                                    busqueda.get(i).getRegion(),
                                    busqueda.get(i).getCicloescolar(),
                                    busqueda.get(i).getSituacion(),
                                    busqueda.get(i).getEstado(),
                                    busqueda.get(i).getEstado_actual_final()  
            });
       }    
    }
    
    private void buscarCicloRegion(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        String itemCiclo = (String) ventanaPrincipal.boxCicloEscolar.getSelectedItem();
        String itemRegion = (String) ventanaPrincipal.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(1,itemRegion.length());
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        
        ArrayList <modeloTablaPrincipal>  busqueda;
        busqueda = sqlPrincipal.buscarCicloRegion(itemCiclo, itemRegion);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                ventanaPrincipal.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getGrado(),
                                    busqueda.get(i).getRegion(),
                                    busqueda.get(i).getCicloescolar(),
                                    busqueda.get(i).getSituacion(),
                                    busqueda.get(i).getEstado(),
                                    busqueda.get(i).getEstado_actual_final()  
            });
       }      
    }
    
    private void buscarCicloGrado(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        String itemCiclo = (String) ventanaPrincipal.boxCicloEscolar.getSelectedItem();
        int itemGrado = Integer.parseInt((String) ventanaPrincipal.boxGrado.getSelectedItem());
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        
        ArrayList <modeloTablaPrincipal>  busqueda;
        busqueda = sqlPrincipal.buscarCicloGrado(itemCiclo, itemGrado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                ventanaPrincipal.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getGrado(),
                                    busqueda.get(i).getRegion(),
                                    busqueda.get(i).getCicloescolar(),
                                    busqueda.get(i).getSituacion(),
                                    busqueda.get(i).getEstado(),
                                    busqueda.get(i).getEstado_actual_final()  
            });
       }      
    }
    
    private void buscarRegionGrado(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        int itemGrado = Integer.parseInt((String) ventanaPrincipal.boxGrado.getSelectedItem());
        String itemRegion = (String) ventanaPrincipal.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(1,itemRegion.length());
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        
        ArrayList <modeloTablaPrincipal>  busqueda;
        busqueda = sqlPrincipal.buscarRegionGrado(itemRegion, itemGrado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                ventanaPrincipal.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getGrado(),
                                    busqueda.get(i).getRegion(),
                                    busqueda.get(i).getCicloescolar(),
                                    busqueda.get(i).getSituacion(),
                                    busqueda.get(i).getEstado(),
                                    busqueda.get(i).getEstado_actual_final()  
            });
       }      
    }
    
    private void buscarCicloRegionGrado(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        String itemCiclo = (String) ventanaPrincipal.boxCicloEscolar.getSelectedItem();
        int itemGrado = Integer.parseInt((String) ventanaPrincipal.boxGrado.getSelectedItem());
        String itemRegion = (String) ventanaPrincipal.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(1,itemRegion.length());
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        
        ArrayList <modeloTablaPrincipal>  busqueda;
        busqueda = sqlPrincipal.buscarCicloRegionGrado(itemCiclo, itemRegion, itemGrado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                ventanaPrincipal.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getGrado(),
                                    busqueda.get(i).getRegion(),
                                    busqueda.get(i).getCicloescolar(),
                                    busqueda.get(i).getSituacion(),
                                    busqueda.get(i).getEstado(),
                                    busqueda.get(i).getEstado_actual_final()  
            });
       }      
    }
}
