import java.awt.*;
import java.applet.*;

public class Carta extends Rectangle{
	public static final int ANCHURA = 70;
	public static final int ALTURA = 120;
	public static final int ROJO = 1;
	public static final int NEGRO = 2;
	public static final int PICAS = 0;
	public static final int ROMBOS = 1;
	public static final int CORAZONES = 2;
	public static final int TREBOLES = 3;
	public static final int REVERSO = 4;
	
	private Image imagen;
	private int valor;
	private int color;
	private int palo;

    public Carta(Image img, int v, int c, int p) {
    	super(200, 200, ANCHURA, ALTURA);
    	imagen = img;		//Le pasas una imagen y se guarda en IMAGEN
		valor = v;
		color = c;
		palo = p;
    }
    public void actualizar(int posx, int posy){
    	x=posx-30;
    	y=posy-30;
    }
    
    public Image getImagen(){
    	return imagen;		//devuelves la imagen para poder llamarla desde otro objeto de la clase CARTA 
    }

    public int getValor(){
    	return valor;
    }
    
    public int getColor(){
    	return color;
    }
    
    public int getPalo(){
    	return palo;
    }
    
    public void dibujar(Graphics g, Applet a){
		g.drawImage(imagen, x, y, width, height, a);
    }
    
    public void setPosx(int px){
    	x = px;
    }
    
    public void setPosy(int py){
    	y = py;
    }
}