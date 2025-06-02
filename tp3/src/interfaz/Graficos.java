package interfaz;


import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import logica.BackTrack;
import logica.FuerzaBruta;
import logica.SolverRobot;
import logica.TableroElectronico;

public class Graficos {

	private JFrame frame;
    private JFreeChart _grafico;
    private TableroElectronico _tablero;
	
	

	public Graficos( TableroElectronico tablero) {
		this._tablero = tablero;
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

		_grafico = crear_grafico_lineal("Comparativa De Tiempo De Ejecucion De Algoritmos","Algoritmo","Tiempo De Ejecucion");
	
		ChartPanel panel =new ChartPanel(_grafico);
		 frame.getContentPane().add(panel);
		 frame.pack();
	
		 frame.validate();
		 frame.repaint();
		 frame.setVisible(true);
	
	}
	
	    private JFreeChart crear_grafico_lineal(String titulo, String primer_variable, String segunda_variable) {
		DefaultCategoryDataset datos  = crear_datos();
		
		return ChartFactory.createBarChart(titulo, primer_variable, segunda_variable,datos, PlotOrientation.VERTICAL, true, true,false); 
	}

	    private DefaultCategoryDataset crear_datos() {

	    	//ACA esto Tengo dudas si va en la PARTE LOGICA
	    	DefaultCategoryDataset  aux =new DefaultCategoryDataset ();
	    	SolverRobot solver = new SolverRobot(_tablero);
	    	BackTrack backtrack = new BackTrack();
	    	FuerzaBruta fuerzaBruta = new FuerzaBruta();
	    	solver.obtenerFuerzaBruta(fuerzaBruta);
	    	solver.resolverFuerzaBruta();
	    	solver.obtenerBackTrack(backtrack);
	    	solver.resolveBacktrack();
	    
	    	
	    	aux.addValue(fuerzaBruta.obtenerTiempoEjecucionFuerzaBruta(), "Fuerza Bruta", "Algoritmo");
	    	aux.addValue(backtrack.obtenerTiempoEjecucionBackTrack(), "Backtracking", "Algoritmo");
	    	return aux;
	    }


}
