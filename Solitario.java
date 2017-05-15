import java.awt.*;
import java.applet.*;
import java.net.*;

public class Solitario extends Applet{
	public static final int NUM_CARTAS=52;
	public static final int NUM_PALOS=4;
	public static final int CCPP=13;
	Image imagen;
	Image imagenes[];
	Graphics noseve;
	Image reversoimg;
	Rectangle reverso;
	Carta activo;
	MazoSecundario mazoB;		
	Baraja baraja;
	MazoPalo mPalos[];
	MazoJuego mazoJuego[];
	public String palos[]={"_of_clubs","_of_diamonds","_of_hearts","_of_spades"};
    public void init() {
    	imagenes = new Image[NUM_CARTAS];
    	for(int a=0;a<4;a++)
    		for(int i=0;i<13;i++)
    			imagenes[(a*CCPP)+i]= getImage( getCodeBase(), "cartas/" +(i+1)+ palos[a] + ".png");
    	
    	reversoimg=getImage( getCodeBase(), "cartas/reverso.png");
    	mazoB=new MazoSecundario();
    	reverso=new Rectangle(20,20,Carta.ANCHURA,Carta.ALTURA);
    	baraja=new Baraja(imagenes);
    	mPalos=new MazoPalo[NUM_PALOS];
    	mazoJuego=new MazoJuego[7];
    	for(int i=0;i<NUM_PALOS;i++)
    		mPalos[i]=new MazoPalo(300+(i*100));
    	for(int i=0;i<7;i++)
    		mazoJuego[i]=new MazoJuego(100+(i*100));
    	baraja.barajar();
    	imagen = createImage(900, 700);
    	noseve = imagen.getGraphics();
    }
    
    public void paint(Graphics g){
    	noseve.setColor(Color.green);
    	noseve.fillRect(0,0,900,700);
    	for(int i=0;i<NUM_PALOS;i++)
			mPalos[i].mostrar(noseve,this);
    	for(int i=0;i<7;i++)
    		mazoJuego[i].mostrar(noseve,this);
    	noseve.drawImage(reversoimg,20,20,Carta.ANCHURA,Carta.ALTURA,this);
		mazoB.mostrar(noseve,this);
		
		g.drawImage(imagen, 0, 0, this);	
    }
     public void update(Graphics g){
    	paint(g);
    }

    
   	public boolean mouseDown(Event ev,int x,int y){
			if(reverso.contains(x,y)){
				mazoB.anadir(baraja.sacar());
				mazoB.recolocar();
				
				mazoB.anadir(baraja.sacar());
				mazoB.recolocar();
				repaint();
			}
    		if(mazoB.extraer().contains(x,y)){
    			activo=mazoB.extraer();
    			
    		}
		return true;
	}
     
    public boolean mouseDrag(Event ev,int x,int y){
    	if(activo!=null){
    		activo.setPosx(x-35);
			activo.setPosy(y-35);
    		repaint();
    	}
    	return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
    	if(activo!=null){
    		boolean encontrado=false;
    		for(int i=0;i<NUM_PALOS;i++)
	    		if(mPalos[i].intersects(activo)){
		    		if(mPalos[i].anadir(mazoB.extraer())){
		    			mazoB.eliminar();
		    			encontrado=true;
		    			break;
	    		}
    		}
    		for(int i=0;i<7;i++)
	    		if(mazoJuego[i].intersects(activo)){
		    		if(mazoJuego[i].anadir(mazoB.extraer())){
		    			mazoB.eliminar();
		    			encontrado=true;
		    			break;
	    		}
    	}
    		
    	if(!encontrado)
    		mazoB.recolocar();
    		
		activo=null;
		repaint();
    	
    	}
    	
    	
    	
    	return true;
    }


	
}