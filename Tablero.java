//74016116 MARTIN GOMEZ, JAVIER


import java.util.ArrayList;

public class Tablero {
	private ArrayList<Ficha> fichas;
	
	public Tablero() { fichas=new ArrayList<Ficha>();}
	
	
	private boolean estanTodas(int num) {
		boolean todas=false;
		int cant=0;
		int p=fichas.size();
		
		for(int i=0;i<p; i++) {
			if(fichas.get(i).getSegunda()==num || fichas.get(i).getPrimera()==num) cant++;
		}
		if(cant==7) todas=true;
		return todas;
	}
	
	
	public boolean coloca(Ficha ficheta, int num) throws JugadaIncorrectaException, CierreException{
		boolean col=false;
				
		if(ficheta!=null) {
			if(fichas.size()!=0){
				if(num!=0){
					if(getFin()!=ficheta.getPrimera()) throw new JugadaIncorrectaException(ficheta,fichas.get(fichas.size()-1));
					fichas.add(ficheta); // al final
				}
				else { // al principio
					if(getInicio()!=ficheta.getSegunda()) throw new JugadaIncorrectaException(ficheta,fichas.get(0));
					fichas.add(0,ficheta); // al principio
				}
				if(getInicio()==getFin() && estanTodas(getInicio())==true) throw new CierreException(getInicio());
				col=true;
			}
			else { // la primera ficha no tiene que comprobar nada
				col=true;
				fichas.add(ficheta);
			}
		}
		return col;
	}
	
	
	
	public ArrayList<Integer> getSecuencia(){
		ArrayList<Integer> sec=new ArrayList<Integer>();
		int p=fichas.size();
		for(int i=0;i<p;i++) {
			sec.add(fichas.get(i).getPrimera());
			sec.add(fichas.get(i).getSegunda());
		}
		return sec;
	}
	
	
	public int getInicio() {
		int prim=-1;
		int p=fichas.size();
		//si hay ficha devuelvo el getPrimera de la primera ficha
		if(p!=0) prim=fichas.get(0).getPrimera();
		return prim;
	}
	
	
	
	public int getFin() {
		int seg=-1;
		int p=fichas.size();
		//si hay ficha devuelvo el getSegunda de la ultima ficha
		if(p!=0) seg=fichas.get(p-1).getSegunda();
		return seg;
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
	
	
	public void fueraPrimera() {
		fichas.remove(0);
	}

	
				
}
