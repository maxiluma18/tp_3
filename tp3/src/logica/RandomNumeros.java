package logica;

import java.util.List;
import java.util.Map;
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

public List<Posicion> darCaminoAleatorio(Map<Integer, List<Posicion>> caminosValidos) {
	return caminosValidos.get(random.nextInt(caminosValidos.size())+1);
}
}
