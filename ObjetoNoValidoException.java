//MARTIN GOMEZ, JAVIER


public class ObjetoNoValidoException extends Exception{
	public ObjetoNoValidoException(int p, int s) {
		super("[" + p + "," + s + "]"); 
	}
	public ObjetoNoValidoException(String m) {
		super(m);
	}
	
}

