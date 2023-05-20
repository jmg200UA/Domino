//MARTIN GOMEZ, JAVIER


public class JugadaIncorrectaException extends Exception{
	private String msg;
	public JugadaIncorrectaException(Ficha f1, Ficha f2) {
		msg = f1.toString() + "!=" + f2.toString();
	}
	public String getMessage() {
		return msg;
	}
}

