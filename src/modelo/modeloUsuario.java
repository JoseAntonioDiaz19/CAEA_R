package modelo;
/**
 * @author Dizan
 */
public class modeloUsuario {
    
    private int figura_educativa;
    private int idusuario;
    private String ape_paterno;
    private String ape_materno;
    private String nombre;
    private String sexo;
    private String usuario;
    private String contraseña;
    private String vigencia;

    public modeloUsuario() {
    }

    /**
     * @return the figura_educativa
     */
    public int getFigura_educativa() {
        return figura_educativa;
    }

    /**
     * @param figura_educativa the figura_educativa to set
     */
    public void setFigura_educativa(int figura_educativa) {
        this.figura_educativa = figura_educativa;
    }

    /**
     * @return the idusuario
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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
        this.nombre = nombre.toUpperCase();
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
        this.ape_paterno = ape_paterno.toUpperCase();
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
        this.ape_materno = ape_materno.toUpperCase();
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario.toLowerCase();
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the vigencia
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * @param vigencia the vigencia to set
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }
}
    

   