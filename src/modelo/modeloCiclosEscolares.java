package modelo;

/**
 *
 * @author Dizan
 */
public class modeloCiclosEscolares {
    private String cicloescolar;
    private String fechaInicio;
    private String fechaFin;

    public modeloCiclosEscolares() {
    }

    public modeloCiclosEscolares(String cicloescolar, String fechaInicio, String fechaFin) {
        this.cicloescolar = cicloescolar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
   
    /**
     * @return the cicloescolar
     */
    public String getCicloescolar() {
        return cicloescolar;
    }

    /**
     * @param cicloescolar the cicloescolar to set
     */
    public void setCicloescolar(String cicloescolar) {
        this.cicloescolar = cicloescolar;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
            
}
