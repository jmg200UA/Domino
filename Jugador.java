//74016116 MARTIN GOMEZ, JAVIER


import java.util.ArrayList;

public class Jugador {
	private ArrayList<Ficha> propias;
	private String nombre;
	
	public Jugador(String nom) throws ObjetoNoValidoException{
		if(nom==null || nom.equals("")) throw new ObjetoNoValidoException("No name");
		propias=new ArrayList<Ficha>();
		this.nombre=nom;
	}
	
	
	public boolean roba(Saco saquet) {
		Ficha ficheta=saquet.roba();
		boolean rob=false;
		
		if(saquet!=null && ficheta!=null) {
				rob=true;
				propias.add(ficheta);
			}
		return rob;
	}
	
	
	public Ficha elige(Tablero tab) {
		Ficha elegida=null;
		int suma,nuevasuma,p=propias.size();
		
		if(tab!=null && p>0) {  
			if(tab.getInicio()==-1) {
				suma = propias.get(0).getPrimera()+propias.get(0).getSegunda();
				elegida = propias.get(0);
				for(int i=1;i<p;i++) {
					nuevasuma= propias.get(i).getPrimera()+propias.get(i).getSegunda();
					if(suma<=nuevasuma) {
						nuevasuma=suma;
						elegida=propias.get(i);
					}
				}
			}
			else {
				suma=-1;
				for(int i=0;i<p;i++) {
					if(propias.get(i).getSegunda()==tab.getInicio() || propias.get(i).getSegunda()==tab.getFin() || propias.get(i).getPrimera()==tab.getInicio() || propias.get(i).getPrimera()==tab.getFin()){
						if(propias.get(i).getPrimera()+propias.get(i).getSegunda()>suma) {
							suma=propias.get(i).getPrimera()+propias.get(i).getSegunda();
							elegida=propias.get(i);
						}
					}
				}
			}
			propias.remove(elegida);
		}
		return elegida;
	}

		
		
		public Ficha juega(Tablero tab) throws PartidaGanadaException,CierreException,JugadaIncorrectaException,ObjetoNoValidoException{
			Ficha ficheta=null;
			boolean col;
			boolean colf=false;
			
			if(tab!= null) {
				ficheta=elige(tab);
				col=false;
				if(ficheta!=null) {
					try {
						col=tab.coloca(ficheta,0);
					}catch(CierreException e) {
						tab.fueraPrimera();
						col= tab.coloca(ficheta,1); 
					}
					catch(JugadaIncorrectaException e) {
					}
					if(col==colf) {
						try {
							col=tab.coloca(ficheta.creaInversa(),0);
							ficheta=ficheta.creaInversa();
						}
						catch(CierreException es) {
							col=tab.coloca(ficheta .creaInversa(), 1);
							ficheta=ficheta.creaInversa();
						}
						catch(JugadaIncorrectaException es) {
						}
					}
					if(col==colf) {
						try {
							col=tab.coloca(ficheta, 1);
						}
						catch(JugadaIncorrectaException e) {}
					}
					if(col==colf) {
							col=tab.coloca(ficheta.creaInversa(), 1);
							ficheta=ficheta.creaInversa();
					}
					
					if(col==colf) ficheta=null;
					else {
						if(propias.size()==0) throw new PartidaGanadaException(nombre);
					}
				}
			}
			return ficheta;	
		}
		
		
		public int valorMaximo() {
			int max=-1,p=propias.size();
			
			for(int i=0;i<p;i++) {
				if(propias.get(i).getPrimera()+propias.get(i).getSegunda()>max) max=propias.get(i).getPrimera()+propias.get(i).getSegunda();
			}
			return max;
		}
		
		
		
		public String getNombre() {
			return this.nombre;
		}
		
		
		
		public String toString() {
			String cad="";
			int p=propias.size();
			cad=this.nombre + "{";
			for(int i=0;i<p;i++) {
				cad=cad+propias.get(i);
				if(i!=p-1) cad=cad+ ",";
			}
			cad=cad+ "}";
			return cad;
		}


}
