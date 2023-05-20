//MARTIN GOMEZ, JAVIER


public class FichaRepetidaException extends Exception{
	private String msg;
	public FichaRepetidaException(Ficha f) {
		if(f != null) {
			msg = f.toString();
		}
		else {
			msg = "";
		}
	}
	@Override
	public String getMessage() {
		return msg;
	}
}

