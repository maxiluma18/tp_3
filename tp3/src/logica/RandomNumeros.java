package logica;


import java.util.Random;

public class RandomNumeros {

private Random random;
public RandomNumeros(){
	random = new Random();
	}

public int darNumeroAleatorio0ò1(int n) {
	return (random.nextInt(n));
}
public int darNumeroAleatorio() {
	return (random.nextInt(10))+2;
}

public int darCaminoAleatorio(Integer cantCaminos) {
	return random.nextInt(cantCaminos+1);
}
}
