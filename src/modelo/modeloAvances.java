package modelo;
/**
 * @author Dizan
 */
public class modeloAvances {
    private int idgrado_alumno;
    private int nocontrol;
    private String nombre;
    private String ape_paterno;
    private String ape_materno;
    private int idgrado;
    private String idcicloescolar;
    private int idetapa;
    private int trimestre;   

    public modeloAvances() {
        
    }

    public modeloAvances(int idgrado_alumno, 
                         int nocontrol, 
                         String nombre, 
                         String ape_paterno, 
                         String ape_materno, 
                         int idgrado, 
                         String idcicloescolar, 
                         int idetapa, 
                         int trimestre) {
        
        this.idgrado_alumno = idgrado_alumno;
        this.nocontrol = nocontrol;
        this.nombre = nombre;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.idgrado = idgrado;
        this.idcicloescolar = idcicloescolar;
        this.idetapa = idetapa;
        this.trimestre = trimestre;
    }
    
    /**
     * @return the idgrado_alumno
     */
    public int getIdgrado_alumno() {
        return idgrado_alumno;
    }

    /**
     * @param idgrado_alumno the idgrado_alumno to set
     */
    public void setIdgrado_alumno(int idgrado_alumno) {
        this.idgrado_alumno = idgrado_alumno;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ape_paterno
     */
    public String getApe_paterno() {
        return ape_paterno;
    }

    /**
     * @param ape_paterno the ape_paterno to set
     */
    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    /**
     * @return the ape_materno
     */
    public String getApe_materno() {
        return ape_materno;
    }

    /**
     * @param ape_materno the ape_materno to set
     */
    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
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
     * @return the idetapa
     */
    public int getIdetapa() {
        return idetapa;
    }

    /**
     * @param idetapa the idetapa to set
     */
    public void setIdetapa(int idetapa) {
        this.idetapa = idetapa;
    }

    /**
     * @return the trimestre
     */
    public int getTrimestre() {
        return trimestre;
    }

    /**
     * @param trimestre the trimestre to set
     */
    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }
}
