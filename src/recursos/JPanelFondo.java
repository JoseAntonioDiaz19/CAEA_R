package recursos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelFondo extends JPanel {
    
    ImageIcon imagen;
    String nombre;
    
    public JPanelFondo(String nombre){
        this.nombre=nombre;
    }
    
    @Override
    public Insets getInsets(){
        Insets squeeze=new Insets(30,30,30,30);//(superior,izquierdo,inferior,derecho)
        return squeeze;
    }
    
    @Override
    public void paint (Graphics g){
        Dimension tamanio=getSize();
        imagen=new ImageIcon(getClass().getResource(nombre));
        g.drawImage(imagen.getImage(), 0,0, tamanio.width,tamanio.height,null);
        setOpaque(false);
        super.paint(g);
    }
    
}