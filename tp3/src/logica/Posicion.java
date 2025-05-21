package logica;

public class Posicion {
    int fila;
    int columna;
    public Posicion(int f, int c) { 
    	this.fila = f; 
    	this.columna = c; 
    }
    @Override
	public String toString() {
		return "(" + fila + "," + columna + ")";
	}
}

