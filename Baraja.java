import java.awt.*;
import java.applet.*;

public class Baraja{
	java.util.List<Carta> mazoPrincipal;			//creas una lista de la clase carta

    public Baraja(Image imagenes[]) {
		mazoPrincipal = new java.util.ArrayList();	//la instancias
		for(int i=0; i<imagenes.length; i++){
			mazoPrincipal.add(new Carta(imagenes[i], (i%13)+1, ((i/13)==0 || (i/13)==3)?Carta.NEGRO:Carta.ROJO , (i/13)));
				//metes las imagenes
		}
    }
	
	public void barajar(){
		Carta auxiliar;
		for(int i=0; i<100; i++){
			int p1 = (int)(Math.random() * 52);
			int p2 = (int)(Math.random() * 52);
			auxiliar = mazoPrincipal.get(p1);
			mazoPrincipal.set(p1, mazoPrincipal.get(p2));
			mazoPrincipal.set(p2, auxiliar);
		}
	}
	
	public Carta sacar(){
		Carta auxiliar = mazoPrincipal .get(0);
		mazoPrincipal.remove(0);
		return auxiliar;
	}
}