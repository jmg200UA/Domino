//MARTIN GOMEZ, JAVIER


import java.io.*;


public class Juego {
	public static int quienEmpieza(Jugador [] jugadorazo) {
		int pos=0,p=jugadorazo.length;

		for(int i=1; i<p;i++) {
			if(jugadorazo[i].valorMaximo() > jugadorazo[pos].valorMaximo()) pos=i;
		}
		return pos;
	}
	
	
	public static int siguiente(int tuturno, int numjug) {
		int sig=tuturno+1;

		if(numjug==sig) sig=0;

		return sig;
		
	}

	
	public static void main(String [] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		int numjug=0, prim, seg, i;
		String linea;
		String [] trozos=null;
		Jugador [] jugadores=null;;
		Saco saco=null;
		Tablero tablero=null;
		Ficha ficha=null;
		
		try {
			fr=new FileReader(args[0]); 
			br=new BufferedReader(fr); 	
			fw=new FileWriter(args[1]);
			bw=new BufferedWriter(fw);	
			
			linea = br.readLine();
			numjug=Integer.parseInt(linea); 
			if(numjug>4 || numjug<2) numjug=2;
			jugadores=new Jugador [numjug];
			linea= br.readLine();
			i=0;
			while(linea.equals("saco")== false) {
				if(numjug>i) {
					jugadores[i]=new Jugador(linea);
					i++;
				}
				linea = br.readLine();	
			}
			if(numjug!=i) {
				jugadores[i]=new Jugador("");
			}

			saco = new Saco();
			linea = br.readLine();
			while(linea!=null) {
				try {
					trozos = linea.split(" ");
					prim=Integer.parseInt(trozos[0]);
					seg=Integer.parseInt(trozos[1]);
					ficha= new Ficha(prim, seg);
					bw.write("mete"+ficha.toString()+" "+saco.meteFicha(ficha));
					bw.newLine();
					bw.flush(); 
				}
				catch(Exception e) {
					String nombre = e.getClass().getName();
					bw.write(nombre+":"+e.getMessage());
					bw.newLine();
					bw.flush();
				}
				linea = br.readLine();
			}
			
			if(!saco.completado()) {
				bw.write("SacoIncompletoException: "+saco.Fichas());
				bw.newLine();
				bw.write(saco.toString());
				bw.newLine();
				bw.flush();
				throw new SacoIncompletoException(saco.Fichas());
			}

			for(i=1;i<=7;i++) {
				for(int j=0;j<jugadores.length;j++) {
					jugadores[j].roba(saco);
					bw.write(jugadores[j].getNombre()+"roba true");
					bw.newLine();
					bw.flush();
				}
			}


			boolean robada;
			tablero=new Tablero();
			int tetoca = quienEmpieza(jugadores);
			while(true) {
				bw.write(jugadores[tetoca].getNombre()+"juega"+jugadores[tetoca].juega(tablero));
				bw.newLine();
				bw.flush();
				if(ficha==null) {
					robada=jugadores[tetoca].roba(saco);
					bw.write(jugadores[tetoca]+"roba"+robada);
					bw.newLine();
					bw.flush();
				}
				tetoca=siguiente(tetoca, jugadores.length);
			}
		
			
		}
		catch(Exception e) {
			try {
				bw.write(e.getClass().getName()+":"+e.getMessage());
				bw.flush();
			}
			catch(IOException ne) {}
		}
		finally {
			try {
				if(fr!=null) {
					fr.close();
					fr=null;
				}
			}
			catch(IOException e) {}
			try {
				if(br!=null){
					br.close();
					br=null;
				}
			}
			catch(IOException e) {}	
		}
	}
}
