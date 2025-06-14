package logica;

import java.util.ArrayList;
import java.util.List;


public class GeneradorGrillaAleatoria {
    private List<Integer> tamanios;
    private List<Double> tiemposBacktrack;
    private List<Double> tiemposFuerzaBruta;
    
   //Parametro Para Random
    private int suma=2;
    //Parametro para Cant de Tableros
    private int cantTableros = 5;
    //Parametro para convertir el tiempo
    private double transforma=1000.0; //aca transforma los milisegunos en segundos
   
    public GeneradorGrillaAleatoria() {
        tamanios = new ArrayList<>();
        tiemposBacktrack = new ArrayList<>();
        tiemposFuerzaBruta = new ArrayList<>();

        
       
    }
   private  TableroElectronico unaAleatoria() {
	   RandomNumeros random = new RandomNumeros();
       int x = random.darNumeroAleatorio() + suma;
       int y = random.darNumeroAleatorio() + suma;
       

       TableroElectronico tablero = new TableroElectronico(x, y);
       tablero.GenerarYSetearValoresAleatorios(tablero.cantCaminosHorTablero(), tablero.cantCaminosVertTablero(), random);

       return tablero;
    }
    private void aleatorias() {
    	tamanios.clear();
    	tiemposFuerzaBruta.clear();
    	tiemposBacktrack.clear();
    	for (int i = 0; i < cantTableros; i++) {
            RandomNumeros random = new RandomNumeros();
            int x = random.darNumeroAleatorio() + suma;
            int y = random.darNumeroAleatorio() + suma;

            TableroElectronico tablero = new TableroElectronico(x, y);
            tablero.GenerarYSetearValoresAleatorios(tablero.cantCaminosHorTablero(), tablero.cantCaminosVertTablero(), random);

            // Fuerza Bruta
            SolverRobot solverFB = new SolverRobot(tablero);
            solverFB.resolverFuerzaBruta();
            double tiempoFB = solverFB.obtenerSolver().obtenerTiempoEjecucionAlgoritmo()/transforma;

            // Backtracking
            SolverRobot solverBT = new SolverRobot(tablero);
            solverBT.resolverBacktrack();
            double tiempoBT = solverBT.obtenerSolver().obtenerTiempoEjecucionAlgoritmo()/transforma;

            int tamanio = x + y;

            tamanios.add(tamanio);
            tiemposFuerzaBruta.add(tiempoFB);
            tiemposBacktrack.add(tiempoBT);
            }
    }
    public void generarGrillasAleatorias() {
    	aleatorias();
    }
    public TableroElectronico generarUnaGrillaAleatoria() {
    	return unaAleatoria();
    }
    public Integer getTamanios(int i) {
        return tamanios.get(i);
    }

    public Double getTiemposBacktrack(int i) {
        return tiemposBacktrack.get(i);
    }

    public Double getTiemposFuerzaBruta(int i) {
        return tiemposFuerzaBruta.get(i);
    }
	public int longuitud() {
		
		return tamanios.size() ;
	}
}
