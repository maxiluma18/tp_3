package logica;


import java.util.Random;

public class RandomNumeros {

private Random random;

//Setear cant max posibles Para tablero
private int cant=10;

public RandomNumeros(){
	random = new Random();
	}

public int darNumeroAleatorio0ò1(int n) {
	return (random.nextInt(n));
}
public int darNumeroAleatorio() {
	return (random.nextInt(cant))+2;
}

public int darCaminoAleatorio(Integer cantCaminos) {
	return random.nextInt(cantCaminos+1);
}
}
