package controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.modeloAvances;
import modelo.modeloDatosAlumno;
import modelo.modeloGrado_Alumno;
import modelo.modeloSesionUsuario;
import modelo.modeloTablaPrincipal;
import modeloSQL.sqlDatosAlumno;
import modeloSQL.sqlPrincipal;
import vista.*;

/**
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
        ventanaPrincipal.botonRegistrar.addActionListener(this::botonRegistrar);
        ventanaPrincipal.botonBuscar.addActionListener(this::botonBuscar);
        ventanaPrincipal.boxCicloEscolar.addItemListener(this::boxCicloEscolar);
        ventanaPrincipal.boxRegion.addItemListener(this::boxRegion);
        ventanaPrincipal.boxGrado.addItemListener(this::boxGrado);
        ventanaPrincipal.itemEditar.addActionListener(this::itemEditar);
        ventanaPrincipal.itemAvances.addActionListener(this::itemAvances);
        ventanaPrincipal.itemReinscribir.addActionListener(this::itemReinscribir);
        
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
        controlVistaUsuarios controlVistaUsuarios = new controlVistaUsuarios(vistaAltaUsuario, modeloUsuario);
        vistaAltaUsuario.setVisible(true);
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
        String nocontrol =  ventanaPrincipal.fieldNumerocontrol.getText();
        String ape_paterno = ventanaPrincipal.fieldApePaterno.getText();
        System.out.println("ape_paterno = " + ape_paterno);
        String ape_materno = ventanaPrincipal.fieldApeMaterno.getText();
        System.out.println("ape_materno = " + ape_materno);
        String nombre = ventanaPrincipal.fieldNombre.getText();
        System.out.println("nombre = " + nombre);
        
        if (!"Numero de control".equals(nocontrol)) {
             buscarPorNocontrol();
        }
        
        if (!"Apellido Paterno".equals(ape_paterno) && 
                !"Apellido Materno".equals(ape_materno) &&
                    !"Nombre".equals(nombre) && "Numero de control".equals(nocontrol)) {
            buscarApellidosNombre();
        }
        if (!"Apellido Paterno".equals(ape_paterno) && 
                "Apellido Materno".equals(ape_materno) &&
                    "Nombre".equals(nombre) && "Numero de control".equals(nocontrol)) {
            JOptionPane.showMessageDialog(null, "¿Escriba el apellido materno y el nombre");
        }
        
        if (!"Apellido Paterno".equals(ape_paterno) && 
                !"Apellido Materno".equals(ape_materno) &&
                    "Nombre".equals(nombre) && "Numero de control".equals(nocontrol)) {
            JOptionPane.showMessageDialog(null, "¿Escriba el nombre");
        }
        
        if (!"Apellido Paterno".equals(ape_paterno) && 
                "Apellido Materno".equals(ape_materno) &&
                    !"Nombre".equals(nombre) && "Numero de control".equals(nocontrol)) {
            JOptionPane.showMessageDialog(null, "¿Escriba el apellido materno");
        }
        
        if ("Apellido Paterno".equals(ape_paterno) && 
                !"Apellido Materno".equals(ape_materno) &&
                    !"Nombre".equals(nombre) && "Numero de control".equals(nocontrol)) {
            JOptionPane.showMessageDialog(null, "¿Escriba el apellido paterno");
        }
   }
   
   private void buscarPorNocontrol(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <modeloTablaPrincipal>  busquedaNocontrol;
        String nocontrol = ventanaPrincipal.fieldNumerocontrol.getText();
        busquedaNocontrol = sqlPrincipal.buscarPorNocontrol(nocontrol);
       
        int iteraciones =  busquedaNocontrol.size();
        System.out.println("iteraciones = " + iteraciones);
        if (iteraciones == 0) {
            JOptionPane.showMessageDialog(null, "¡No existe el numero el numero de control!");
       }
       
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
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") 
                && !itemRegion.equals("- Seleccione Region -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloRegionGrado();
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
       if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") 
                && !itemRegion.equals("- Seleccione Region -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloRegionGrado();
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
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") 
                && !itemRegion.equals("- Seleccione Region -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloRegionGrado();
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
    
    private void buscarApellidosNombre(){
        ventanaPrincipal.modeloTabla.setRowCount(0);
        String ape_paterno = ventanaPrincipal.fieldApePaterno.getText().toUpperCase();
        String ape_materno = ventanaPrincipal.fieldApeMaterno.getText().toUpperCase();
        String nombre = ventanaPrincipal.fieldNombre.getText().toUpperCase();
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        
        ArrayList <modeloTablaPrincipal>  busqueda;
        busqueda = sqlPrincipal.buscarApellidosNombre(ape_paterno, ape_materno, nombre);
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
    
    private void itemEditar(ActionEvent e){
        
        String fecha;
        String año;
        String mes;
        String dia;
        
        int filaseleccionada = ventanaPrincipal.tablaPrincipal.getSelectedRow();
        String stringNocontrol =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 0));
        String cicloEscolar =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 6));
        System.out.println("cicloEscolar = " + cicloEscolar);
        int nocontrol = Integer.parseInt(stringNocontrol);
        
        modeloDatosAlumno modeloDatosAlumno;
        sqlDatosAlumno sqlDatosAlumno = new sqlDatosAlumno(modeloUsuario);
        modeloDatosAlumno = sqlDatosAlumno.datosAlumno(nocontrol, cicloEscolar);
        
        vistaDatosAlumno vistaDatosAlumno = new vistaDatosAlumno(ventanaPrincipal, true);
        controlVistaDatosAlumno controlVistaDatosAlumno = new controlVistaDatosAlumno(ventanaPrincipal, 
                                                                                      modeloUsuario, 
                                                                                      vistaDatosAlumno, modeloDatosAlumno);
        
        //Llenar ciclos escolares
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        
        //ciclo escolar seleccionado
        vistaDatosAlumno.boxCicloEscolar.addItem(cicloEscolar);
         
        
        //llenar regiones
        ArrayList <String> regiones;
        regiones = sqlPrincipal.regiones();
        int iteracionesRegiones = regiones.size();
        for (int i = 0; i < iteracionesRegiones; i++) {
           vistaDatosAlumno.boxRegion.addItem(regiones.get(i));
        }
        
        //Llenar situaciones
        ArrayList <String>  situacion;
        situacion = sqlDatosAlumno.situacion();
        int iteracionesSituacion = situacion.size();
        for (int i = 0; i < iteracionesSituacion; i++) {
            vistaDatosAlumno.boxSituacion.addItem(situacion.get(i));
        }
        
        //Llenar grados
        ArrayList <String>  grados;
        grados = sqlPrincipal.grados();
        int iteraciones = grados.size();
        for (int i = 0; i < iteraciones; i++) {
           vistaDatosAlumno.boxGrado.addItem(grados.get(i));
       }
        
        //llenar situacion final
        ArrayList <String>  situacionFinal;
        situacionFinal = sqlDatosAlumno.situacionFinal();
        int iteracionesSituacionFinal = situacionFinal.size();
        for (int i = 0; i < iteracionesSituacionFinal; i++) {
            vistaDatosAlumno.boxSituacionFinal.addItem(situacionFinal.get(i));
        }
        
        //Agregar datos de alumno
        vistaDatosAlumno.fieldNombre.setText(modeloDatosAlumno.getNombre());
        vistaDatosAlumno.fieldApe_paterno.setText(modeloDatosAlumno.getApe_paterno());
        vistaDatosAlumno.fieldApe_materno.setText(modeloDatosAlumno.getApe_materno());
        vistaDatosAlumno.boxSexo.setSelectedItem(modeloDatosAlumno.getSexo());
            fecha = modeloDatosAlumno.getFecha_nacimiento();
            año =  fecha.substring(0, 4);
            mes = fecha.substring(5, 7);
            dia = fecha.substring(8, 10);
        vistaDatosAlumno.boxAño.setSelectedItem(año);
        vistaDatosAlumno.boxMes.setSelectedItem(mes);
        vistaDatosAlumno.boxDia.setSelectedItem(dia);
        vistaDatosAlumno.fieldNumeroControl.setText("" + modeloDatosAlumno.getNocontrol());
        vistaDatosAlumno.boxCicloEscolar.setSelectedItem(modeloDatosAlumno.getCicloescolar());
        vistaDatosAlumno.boxRegion.setSelectedItem(modeloDatosAlumno.getRegion());
        vistaDatosAlumno.boxGrado.setSelectedItem(""+modeloDatosAlumno.getGrado());
        System.out.println("" + modeloDatosAlumno.getGrado());
        vistaDatosAlumno.boxSituacion.setSelectedItem(modeloDatosAlumno.getSituacion());
        vistaDatosAlumno.boxSituacionFinal.setSelectedItem(modeloDatosAlumno.getSituacion_final());
       
        vistaDatosAlumno.setVisible(true);
    }
    
    private void itemAvances(ActionEvent e){
        vistaAvances vistaAvancesMenuTabla = new vistaAvances(ventanaPrincipal, true);
        sqlPrincipal sqlPrincipal=new sqlPrincipal(modeloUsuario);
        
       
        int filaseleccionada = ventanaPrincipal.tablaPrincipal.getSelectedRow();
        String stringNocontrol =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 0));
        String ape_paterno =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 1));
        String ape_materno =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 2));
        String nombre =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 3));
        String stringGrado =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 4));
        String cicloEscolar =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 6));
        System.out.println("cicloEscolar = " + cicloEscolar);
        int nocontrol = Integer.parseInt(stringNocontrol);
        int grado = Integer.parseInt(stringGrado);
        
        //Mostrar datos en la ventana
        vistaAvancesMenuTabla.fieldApe_paterno.setText(ape_paterno);
        vistaAvancesMenuTabla.fieldApe_paterno.setEditable(false);
        vistaAvancesMenuTabla.fieldApe_materno.setText(ape_materno);
        vistaAvancesMenuTabla.fieldApe_materno.setEditable(false);
        vistaAvancesMenuTabla.fieldNombre.setText(nombre);
        vistaAvancesMenuTabla.fieldNombre.setEditable(false);
        vistaAvancesMenuTabla.fieldNumeroControl.setText(stringNocontrol);
        vistaAvancesMenuTabla.fieldNumeroControl.setEditable(false);
        vistaAvancesMenuTabla.boxCicloEscolar.addItem(cicloEscolar);
        vistaAvancesMenuTabla.boxCicloEscolar.setEnabled(false);
        vistaAvancesMenuTabla.boxCicloEscolar.setSelectedItem(cicloEscolar);
        vistaAvancesMenuTabla.boxGrado.addItem(stringGrado);
        vistaAvancesMenuTabla.boxGrado.setEnabled(false);
        vistaAvancesMenuTabla.boxGrado.setSelectedItem(stringGrado);
        //Colores del texto en los fields
        vistaAvancesMenuTabla.fieldApe_paterno.setForeground(Color.BLACK); 
        vistaAvancesMenuTabla.fieldApe_materno.setForeground(Color.BLACK); 
        vistaAvancesMenuTabla.fieldNombre.setForeground(Color.BLACK);
        vistaAvancesMenuTabla.fieldNumeroControl.setForeground(Color.BLACK);
        
        modeloAvances modeloAvances = new modeloAvances();
        modeloAvances.setNocontrol(nocontrol);
        modeloAvances.setApe_paterno(ape_paterno);
        modeloAvances.setApe_materno(ape_materno);
        modeloAvances.setNombre(nombre);
        modeloAvances.setIdcicloescolar(cicloEscolar);
        modeloAvances.setIdgrado(grado);
        
        
        controlVistaAvances controlVistaAvances = new controlVistaAvances(vistaAvancesMenuTabla, modeloUsuario, ventanaPrincipal,modeloAvances);
        vistaAvancesMenuTabla.setVisible(true);
         
    }
    
    private void itemReinscribir(ActionEvent e){
        vistaReinscripcion vistaReinscripcion = new vistaReinscripcion(ventanaPrincipal, true);
        
        int filaseleccionada = ventanaPrincipal.tablaPrincipal.getSelectedRow();
        String stringNocontrol =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 0));
        String ape_paterno =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 1));
        String ape_materno =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 2));
        String nombre =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 3));
        String stringGrado =  String.valueOf(ventanaPrincipal.modeloTabla.getValueAt(filaseleccionada, 4));
        int grado = Integer.parseInt(stringGrado);
        int nocontrol = Integer.parseInt(stringNocontrol);

        vistaReinscripcion.jLabel1.setText("Nombre: "+ape_paterno+" "+ape_materno+" "+nombre);
       
        //llenar ciclo nuevo
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <String> ciclosEscolares;
        ciclosEscolares = sqlPrincipal.ciclosEscolares();
        int iteraciones = ciclosEscolares.size();
        vistaReinscripcion.boxCicloEscolar.addItem(ciclosEscolares.get(iteraciones - 1));
        vistaReinscripcion.boxCicloEscolar.setSelectedItem(ciclosEscolares.get(iteraciones - 1));
        
        //llenar grados
        ArrayList <String>  grados;
        grados = sqlPrincipal.grados();
        int iteracionesGrados = grados.size();
        for (int i = grado - 1; i < iteracionesGrados; i++) {
           vistaReinscripcion.boxGrado.addItem(grados.get(i));
        }
        
        //Datos modelo grado_alumno
        modeloGrado_Alumno modeloGrado_Alumno = new modeloGrado_Alumno();
        modeloGrado_Alumno.setNocontrol(nocontrol);
        modeloGrado_Alumno.setIdsituacion(1);
        modeloGrado_Alumno.setIdestado(2);
        modeloGrado_Alumno.setIdestado_actual_final(0);
        
        controlVistaReinscripcion controlVistaReinscripcion = new controlVistaReinscripcion(vistaReinscripcion, 
                modeloUsuario, ventanaPrincipal, modeloGrado_Alumno);
        
        vistaReinscripcion.setVisible(true);
    }
}
