package modelo;
/**
 * @author Dizan
 */
public class modeloGrado_Alumno {
    
    private int nocontrol;
    private int idgrado;
    private int idsituacion;
    private String idcicloescolar;
    private int idestado;
    private int idestado_actual_final;

    public modeloGrado_Alumno() {
        
    }

    public modeloGrado_Alumno(int nocontrol, int idgrado, int idsituacion, String idcicloescolar, int idestado, int idestado_actual_final) {
        this.nocontrol = nocontrol;
        this.idgrado = idgrado;
        this.idsituacion = idsituacion;
        this.idcicloescolar = idcicloescolar;
        this.idestado = idestado;
        this.idestado_actual_final = idestado_actual_final;
    }

    /**
     * @return the nocontrol
     */
    public int getNocontrol() {
        return nocontrol;
    }

    /**
     * @param nocontrol the nocontrol to set
     */
    public void setNocontrol(int nocontrol) {
        this.nocontrol = nocontrol;
    }

    /**
     * @return the idgrado
     */
    public int getIdgrado() {
        return idgrado;
    }

    /**
     * @param idgrado the idgrado to set
     */
    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    /**
     * @return the idsituacion
     */
    public int getIdsituacion() {
        return idsituacion;
    }

    /**
     * @param idsituacion the idsituacion to set
     */
    public void setIdsituacion(int idsituacion) {
        this.idsituacion = idsituacion;
    }

    /**
     * @return the idcicloescolar
     */
    public String getIdcicloescolar() {
        return idcicloescolar;
    }

    /**
     * @param idcicloescolar the idcicloescolar to set
     */
    public void setIdcicloescolar(String idcicloescolar) {
        this.idcicloescolar = idcicloescolar;
    }

    /**
     * @return the idestado
     */
    public int getIdestado() {
        return idestado;
    }

    /**
     * @param idestado the idestado to set
     */
    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    /**
     * @return the idestado_actual_final
     */
    public int getIdestado_actual_final() {
        return idestado_actual_final;
    }

    /**
     * @param idestado_actual_final the idestado_actual_final to set
     */
    public void setIdestado_actual_final(int idestado_actual_final) {
        this.idestado_actual_final = idestado_actual_final;
    }
    
}
