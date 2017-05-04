import java.awt.*;
import java.applet.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
public class Solitario extends Applet{
	public static final int NUM_CARTAS=52;
	public static final int CCPP=13;
	public String palos[]={"_of_clubs","_of_diamonds","_of_hearts","_of_spades"};
	Image imagenes[];
	Image reversoi;
	Baraja baraja;
	Rectangle reverso;
	boolean toca;
	Carta activo;
	List <Carta> cartaextraida;
    public void init() {
    	cartaextraida = new ArrayList<Carta>();
    	imagenes = new Image[NUM_CARTAS];
    	for(int a=0;a<4;a++)
    		for(int i=0;i<13;i++)
    			imagenes[(a*CCPP)+i]= getImage( getCodeBase(), "cartas/" +(i+1)+ palos[a] + ".png");
    	reversoi = getImage(getCodeBase(),"cartas/reverso.png");
  		reverso =  new Rectangle(20,20,70,130);
    	baraja=new Baraja(imagenes);
    	baraja.barajar();	
    }
    
    public void paint(Graphics g){
    	g.fillRect(0,0,900,700);
    	g.drawImage(reversoi, 20 ,20,Carta.ANCHURA,Carta.ALTURA , this);
    	for(int i=0;i < cartaextraida.size();i++)
    		cartaextraida.get(i).dibujar(g,this);

    }
    public boolean mouseDown(Event ev, int x, int y){
    	
    		if(reverso.contains(x,y)){
    			cartaextraida.add(baraja.sacar());
	    		cartaextraida.get(cartaextraida.size()-1).setPosx(110);
	    		cartaextraida.get(cartaextraida.size()-1).setPosy(20);
    			repaint();
    		}
    		for(int i=0;i<cartaextraida.size();i++)
    				activo=cartaextraida.get(i);
    	return true;    			
    }
    public boolean mouseDrag(Event ev,int x,int y){		//Al hacer drag, mueve solo la ficha ACTIVA
		if(activo!=null){
	    	activo.actualizar(x,y);						//al meter el puntero de la ficha,  llama a actualizar con el valor de esa ficha
	    	repaint();
		}
    	return true;
    }
   public boolean mouseUp(Event ev, int x, int y){
    	
		activo=null;
    	return true;
    }
    

}