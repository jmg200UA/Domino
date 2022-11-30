//74016116 MARTIN GOMEZ, JAVIER


public class Ficha {
private int primera;
private int segunda;

	public Ficha(int prim,int seg) throws ObjetoNoValidoException{
		if(prim>=0 && prim<=6 && seg>=0 && seg<=6) {
			this.primera=prim;
			this.segunda=seg;
		}
		else throw new ObjetoNoValidoException(prim,seg);
	}
	
	
	public int getPrimera() {
		return this.primera;
	}
	
	
	public int getSegunda() {
		return this.segunda;
	}
	
	public Ficha creaInversa() throws ObjetoNoValidoException{
		Ficha fichainversa= new Ficha(segunda,primera);
		return fichainversa;
		
	}
	
	public boolean iguales(Ficha ficheta) {
		boolean equals=false;
		if(primera==ficheta.primera && segunda==ficheta.segunda || segunda==ficheta.primera && primera==ficheta.segunda) equals=true;
		return equals;
	}
	
	public String toString() {
		String devficha=("["+this.primera+","+this.segunda+"]");
		return devficha;	
	}

	
}
