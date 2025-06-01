package logica;

public class Posicion {
    int fila;
    int columna;
    
    //capaz no sirve tanto esta clase, deberiamos ver si la sacamos o no
    
    public Posicion(int f, int c) { 
    	this.fila = f; 
    	this.columna = c; 
    }
    
    //despues borrar, solo sirve para ParaProbar
    
    @Override
	public String toString() {
		return "(" + fila + "," + columna + ")";
	}

	public int getX() {
		
		return fila;
	}

	public int getY() {
		// TODO Apéndice de método generado automáticamente
		return columna;
	}
}

