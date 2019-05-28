package controlador;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloSesionUsuario;
import modelo.modeloTablaUsuarios;
import modelo.modeloUsuario;
import modeloSQL.sqlUsuario;
import vista.vistaAltaUsuario;
/**
 *
 * @author Dizan
 */
public class controlVistaUsuarios {
    modeloSesionUsuario modeloUsuario;
    vistaAltaUsuario vistaAltaUsuario;
    modeloUsuario modeloAltaUsuario;
    
    controlVistaUsuarios(vistaAltaUsuario vistaAltaUsuario, modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
        this.vistaAltaUsuario = vistaAltaUsuario;
        
        vistaAltaUsuario.btnactualizarusuario.addActionListener(this::btnactualizarusuario);
        vistaAltaUsuario.btnagregarusuario.addActionListener(this::btnagregarusuario);
        vistaAltaUsuario.btnbuscarusuario.addActionListener(this::btnbuscarusuario);
        vistaAltaUsuario.itemSeleccionar.addActionListener(this::itemSeleccionar);
        vistaAltaUsuario.itemEliminar.addActionListener(this::itemEliminar);
        llenarDatosInterfaz();
    }
    
    private void btnagregarusuario (ActionEvent e){
       
        sqlUsuario sqlUsuario = new sqlUsuario(modeloUsuario);
        modeloAltaUsuario = new modeloUsuario();
        
        String stringFiguraEducativa = String.valueOf(vistaAltaUsuario.cbxfiguraeducativa.getSelectedItem());
        String rol = stringFiguraEducativa.substring(2, stringFiguraEducativa.length());
        System.out.println("rol = " + rol);
        //Buscar idfigura_educativa
        int idfiguraEducativa = Integer.parseInt(String.valueOf(vistaAltaUsuario.cbxfiguraeducativa.getSelectedIndex()));
        System.out.println("idfiguraEducativa = " + idfiguraEducativa);
        modeloAltaUsuario.setFigura_educativa(idfiguraEducativa);
        modeloAltaUsuario.setIdusuario(Integer.parseInt(vistaAltaUsuario.txtnocontrolusuario.getText()));
        modeloAltaUsuario.setApe_paterno(vistaAltaUsuario.txtapellidopaterno.getText());
        modeloAltaUsuario.setApe_materno(vistaAltaUsuario.txtapellidomaternousuario.getText());
        modeloAltaUsuario.setNombre(vistaAltaUsuario.txtnombre.getText());
        modeloAltaUsuario.setSexo(String.valueOf(vistaAltaUsuario.cbxsexo.getSelectedItem()));
        modeloAltaUsuario.setUsuario(vistaAltaUsuario.txtnombreUser.getText());
        modeloAltaUsuario.setContraseña(vistaAltaUsuario.txtcontraseñausuario.getText());
        
        java.util.Date  fechaDateShooser =  vistaAltaUsuario.jDateChooserVigencia.getDate();
        DateFormat f=new SimpleDateFormat("yyy-MM-dd");
        String fecha=f.format(fechaDateShooser);
        System.out.println("fecha = " + fecha);
      
        modeloAltaUsuario.setVigencia(fecha);
        System.out.println("fecha objeto vigencia:" + modeloAltaUsuario.getVigencia());
        
        //-.-.-.-.-.-.-.-.-.Crear usuario en la tabla de usuarios-.-.-.-.-.-.-.-.-.-.
        try {
            sqlUsuario.altaUsuario(modeloAltaUsuario);
            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al crear el usuario");
        }
        
        //-.-.-.-.-.-.-..-.Crear usuario en la base de datos.-.-.-.-.-.-.-.-.-.-.-.
        if (idfiguraEducativa == 1) {
            try {
            sqlUsuario.crearCapacitadorTutor(modeloAltaUsuario.getUsuario(),
                    rol,
                    modeloAltaUsuario.getContraseña(),
                    fecha);
            
           JOptionPane.showMessageDialog(null, "Permisos asignados correctamente");
            
            } catch (SQLException ex) {
                Logger.getLogger(controlVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al asignar permisos");
            } 
        }
        
        if (idfiguraEducativa == 2) {
            //Crear asistente educativo
            try {
            sqlUsuario.crearAsistenteEducativo(modeloAltaUsuario.getUsuario(),
                    rol,
                    modeloAltaUsuario.getContraseña(),
                    fecha);
            
            JOptionPane.showMessageDialog(null, "Permisos asignados correctamente");
            
            } catch (SQLException ex) {
                Logger.getLogger(controlVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al asignar permisos");
            }   
            
        }
        
        if (idfiguraEducativa == 3) {
            //Crear Coordinador academico de seguimiento
            try {
            sqlUsuario.crearCoordinadorAcademicoDeSeguimiento(modeloAltaUsuario.getUsuario(),
                    rol,
                    modeloAltaUsuario.getContraseña(),
                    fecha);
            
            JOptionPane.showMessageDialog(null, "Permisos asignados correctamente");
            
            } catch (SQLException ex) {
                Logger.getLogger(controlVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al asignar permisos");
            } 
        }
        
         if (idfiguraEducativa == 4) {
            //Crear Coordinador academico
            try {
            sqlUsuario.crearCoordinadorAcademico(modeloAltaUsuario.getUsuario(),
                    rol,
                    modeloAltaUsuario.getContraseña(),
                    fecha);
            
            JOptionPane.showMessageDialog(null, "Permisos asignados correctamente");
            
            } catch (SQLException ex) {
                Logger.getLogger(controlVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al asignar permisos");
            } 
            
        }
       
    }
    
    private void btnactualizarusuario(ActionEvent e){
        
    }
    
    private void btnbuscarusuario(ActionEvent e){
        
    }
    
    private void btneliminarusuario(ActionEvent e){
    
    }
    
    private void llenarDatosInterfaz(){
        
        sqlUsuario sqlUsuario = new sqlUsuario(modeloUsuario);
        ArrayList <String> lista;
        lista = sqlUsuario.llenarFigurasEducativas();
        int iteraciones = lista.size();
         
        int idfiguraConectada = modeloUsuario.getIdfigura_educativa();
        System.out.println("idfiguraConectada = " + idfiguraConectada);
        
        if (idfiguraConectada == 1) {
            for (int i = 0; i < iteraciones - 5 ; i++) { 
                vistaAltaUsuario.cbxfiguraeducativa.addItem(lista.get(i));
            }
            vistaAltaUsuario.jDateChooserVigencia.setEnabled(false);
            llenarTablaCapacitadorTutor();
            vistaAltaUsuario.itemEliminar.setEnabled(false);
        }
        
        if (idfiguraConectada == 2) {
          
            for (int i = 0; i < iteraciones - 4 ; i++) { 
                vistaAltaUsuario.cbxfiguraeducativa.addItem(lista.get(i));
            }
            llenarTablaAsistenteEducativo();
        }
        
        if (idfiguraConectada == 3) {
            for (int i = 0; i < iteraciones - 3 ; i++) { 
                vistaAltaUsuario.cbxfiguraeducativa.addItem(lista.get(i));
            }
            llenarTablaCoordinadorAcademicoDeSeguimiento();
        }
        
        if (idfiguraConectada == 4) {
            for (int i = 0; i < iteraciones - 2 ; i++) { 
                vistaAltaUsuario.cbxfiguraeducativa.addItem(lista.get(i));
            }
            llenarTablaCoordinadorAcademico();
        }
        if (idfiguraConectada == 5) {
            for (int i = 0; i < iteraciones; i++) { 
                vistaAltaUsuario.cbxfiguraeducativa.addItem(lista.get(i));
            }
            llenarTablaAdministrador();
        } 
    } 
    
    private void llenarTablaAdministrador(){
        vistaAltaUsuario.modeloTabla.setRowCount(0);
        sqlUsuario sqlUsuario = new sqlUsuario(modeloUsuario);
        ArrayList <modeloTablaUsuarios>  busqueda;
        busqueda = sqlUsuario.tablaAdministrador();
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAltaUsuario.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getFigura_educativa(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getSexo(),
                                    busqueda.get(i).getUsuario(),
                                    busqueda.get(i).getContraseña(),
                                    busqueda.get(i).getVigencia(),
            });
       }    
    }
    
    private void llenarTablaCoordinadorAcademico(){
        vistaAltaUsuario.modeloTabla.setRowCount(0);
        sqlUsuario sqlUsuario = new sqlUsuario(modeloUsuario);
        ArrayList <modeloTablaUsuarios>  busqueda;
        busqueda = sqlUsuario.tablaCoordinadorAcademico();
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAltaUsuario.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getFigura_educativa(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getSexo(),
                                    busqueda.get(i).getUsuario(),
                                    busqueda.get(i).getContraseña(),
                                    busqueda.get(i).getVigencia(),
            });
       }    
    }
    
    private void llenarTablaCoordinadorAcademicoDeSeguimiento(){
        vistaAltaUsuario.modeloTabla.setRowCount(0);
        sqlUsuario sqlUsuario = new sqlUsuario(modeloUsuario);
        ArrayList <modeloTablaUsuarios>  busqueda;
        busqueda = sqlUsuario.tablaCoordinadorAcademicoDeSeguimiento();
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAltaUsuario.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getFigura_educativa(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getSexo(),
                                    busqueda.get(i).getUsuario(),
                                    busqueda.get(i).getContraseña(),
                                    busqueda.get(i).getVigencia(),
            });
       }    
    }
    
    private void llenarTablaAsistenteEducativo(){
        vistaAltaUsuario.modeloTabla.setRowCount(0);
        sqlUsuario sqlUsuario = new sqlUsuario(modeloUsuario);
        ArrayList <modeloTablaUsuarios>  busqueda;
        busqueda = sqlUsuario.tablaAsistenteEducativo();
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAltaUsuario.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getFigura_educativa(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getSexo(),
                                    busqueda.get(i).getUsuario(),
                                    busqueda.get(i).getContraseña(),
                                    busqueda.get(i).getVigencia(),
            });
       }    
    }
    
    private void llenarTablaCapacitadorTutor(){
        vistaAltaUsuario.modeloTabla.setRowCount(0);
        sqlUsuario sqlUsuario = new sqlUsuario(modeloUsuario);
        ArrayList <modeloTablaUsuarios>  busqueda;
        busqueda = sqlUsuario.tablaCapacitadorTutor(modeloUsuario.getIdusuario());
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAltaUsuario.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getNocontrol(),
                                    busqueda.get(i).getFigura_educativa(),
                                    busqueda.get(i).getApe_paterno(),
                                    busqueda.get(i).getApe_materno(),
                                    busqueda.get(i).getNombre(),
                                    busqueda.get(i).getSexo(),
                                    busqueda.get(i).getUsuario(),
                                    busqueda.get(i).getContraseña(),
                                    busqueda.get(i).getVigencia(),
            });
       }    
    }
    
    private void itemSeleccionar(ActionEvent e){
        sqlUsuario sqlUsuario=new sqlUsuario(modeloUsuario);
        int filaseleccionada = vistaAltaUsuario.tablaUsuarios.getSelectedRow();
        String stringNocontrol =  String.valueOf(vistaAltaUsuario.tablaUsuarios.getValueAt(filaseleccionada, 0));
        int idusuario = Integer.parseInt(stringNocontrol);
        String figura_educativa =  String.valueOf(vistaAltaUsuario.tablaUsuarios.getValueAt(filaseleccionada, 1));
             int idfigura_educativa = sqlUsuario.idfiguraeducativa(figura_educativa);
        String ape_paterno =  String.valueOf(vistaAltaUsuario.tablaUsuarios.getValueAt(filaseleccionada, 2));
        String ape_materno =  String.valueOf(vistaAltaUsuario.tablaUsuarios.getValueAt(filaseleccionada, 3));
        String nombre =  String.valueOf(vistaAltaUsuario.tablaUsuarios.getValueAt(filaseleccionada, 4));
        String sexo =  String.valueOf(vistaAltaUsuario.tablaUsuarios.getValueAt(filaseleccionada, 5));
        String usuario =  String.valueOf(vistaAltaUsuario.tablaUsuarios.getValueAt(filaseleccionada, 6));
        String contraseña =  String.valueOf(vistaAltaUsuario.tablaUsuarios.getValueAt(filaseleccionada, 7));
        String vigencia =  String.valueOf(vistaAltaUsuario.tablaUsuarios.getValueAt(filaseleccionada, 8));
        
        
        vistaAltaUsuario.txtnocontrolusuario.setText(stringNocontrol);
        vistaAltaUsuario.cbxfiguraeducativa.setSelectedItem(idfigura_educativa+" "+figura_educativa);
        vistaAltaUsuario.txtapellidopaterno.setText(ape_paterno);
        vistaAltaUsuario.txtapellidomaternousuario.setText(ape_materno);
        vistaAltaUsuario.txtnombre.setText(nombre);
        vistaAltaUsuario.cbxsexo.setSelectedItem(sexo);
        vistaAltaUsuario.txtnombreUser.setText(usuario);
        vistaAltaUsuario.txtcontraseñausuario.setText(contraseña);
        vistaAltaUsuario.jDateChooserVigencia.setDateFormatString(vigencia);
          
    }
    
    private void itemEliminar(ActionEvent e){
        
        
    }
}
