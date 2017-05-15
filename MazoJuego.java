import java.awt.*;
import java.applet.*;
public class MazoJuego extends Rectangle{
	java.util.List<Carta> mazo;
	public static final int POSICIONY=200;
	int palo;
    public MazoJuego(int px) {
    	super(px,POSICIONY,70,120);
    	mazo=new java.util.ArrayList();
    }
   public boolean anadir(Carta c){
   		if(mazo.size()==0){
				mazo.add(c);
				recolocar();
				return true;
		}
		else if(c.getColor() != mazo.get(mazo.size()-1).getColor())
				if(c.getValor()+1 == mazo.get(mazo.size()-1).getValor()){	
					mazo.add(c);
					recolocar();
					return true;	
		}
	return false;
   }
	public Carta extraer(){
		return mazo.get(mazo.size()-1);
	}
	public void eliminar(){
		mazo.remove(mazo.size()-1);
	}
	public void mostrar(Graphics g, Applet a){
		g.setColor(Color.white);
		g.drawRect(x,y,width,height);
		for(int i=0;i<mazo.size();i++)
			mazo.get(i).dibujar(g,a);
	}
	public void recolocar(){
		if(mazo.size()==0)
			mazo.get(mazo.size()-1).setPosy(y);
		else
			mazo.get(mazo.size()-1).setPosy(y + (mazo.size()*20));
		mazo.get(mazo.size()-1).setPosx(x);
	}
	

}