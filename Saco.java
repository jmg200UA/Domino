//MARTIN GOMEZ, JAVIER


import java.util.ArrayList;

public class Saco {
	private ArrayList<Ficha> fichas;
	public boolean completo; 
	
	public Saco() {
		this.fichas=new ArrayList<Ficha>();
		this.completo=false;
	}
	
	public Ficha roba() {
		Ficha ficheta=null;
		int p=fichas.size();
		
		if(p!=0) {
			ficheta=fichas.get(0);
			fichas.remove(0); // las desplaza todas una posicion a la izquierda
		}
		return ficheta;
	}
	
	public boolean meteFicha(Ficha ficheta)throws FichaRepetidaException{
		boolean met=false;
		int p=fichas.size();
		
		if(p<28 && ficheta!=null) {
			for(int i=0;i<p;i++) {
				if(fichas.get(i).iguales(ficheta)) throw new FichaRepetidaException(ficheta);
			}
			fichas.add(ficheta);
			met=true;
			if(p<=28) completo=true;
		}
		return met;
	}
	
	
	public boolean completado() {
		return this.completo;
	}
		
		
	public String toString() {
		String cad="{";
		cad="{";
		int p=fichas.size();
		
		for(int i=0;i<p;i++) {
			cad=cad+fichas.get(i).toString();
			if(i!=p-1) cad=cad+",";
		}
		cad=cad+"}";
		return cad;
	}
	
	
	public int Fichas() {
		return fichas.size();
	}
}
