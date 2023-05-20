//MARTIN GOMEZ, JAVIER


public class SacoIncompletoException 
extends Exception {
	public SacoIncompletoException(int i) {
		//int->String
		super(String.valueOf(i)); //inicializo el mensaje
		//que lanza elmetodo heredado getMessage
		
	}
}
