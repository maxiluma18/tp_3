package interfaz;


import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graficos {

	private JFrame frame;
    private JFreeChart _grafico;
	private double TiempoBT;
	private double TiempoFB;
	

	public Graficos( double TiempoBt, double TiempoFB) {
		this.TiempoBT = TiempoBt;
		this.TiempoFB = TiempoFB;
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_grafico = crear_grafico_lineal("Comparativa De Tiempo De Ejecucion De Algoritmos","Algoritmo","Tiempo De Ejecucion en ms");
	
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
	    	DefaultCategoryDataset  aux =new DefaultCategoryDataset ();
	    	aux.addValue(TiempoBT, "Backtracking", "BACKTRACKING");
	    	aux.addValue(TiempoFB, "Fuerza Bruta", "FUERZA BRUTA");
	    	return aux;
	    }


}
