package interfaz;


import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFreeChart _grafico;
	private double TiempoBT;
	private double TiempoFB;
	
	//setear titulos:
	private String titulo ="Comparativa De Tiempo De Ejecucion De Algoritmos";
	private String texto_Vertical ="Tiempo De Ejecucion en ms";
	private String texto_Inferior="Algoritmos";
	
	//Nombre De Comparaciones: 
	private String nombre_1 ="Backtracking";
	private String nombre_2 ="Fuerza Bruta";
	
	
	public GraficoBarra( double TiempoBt, double TiempoFB) {
		this.TiempoBT = TiempoBt;
		this.TiempoFB = TiempoFB;
		new JFrame();
		setBounds(100, 100, 200, 200);
		setAlwaysOnTop(true); 
		toFront();            
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		_grafico = crear_grafico_lineal(titulo,texto_Inferior,texto_Vertical);
		
		ChartPanel panel =new ChartPanel(_grafico);
		getContentPane().add(panel);
		pack();
		validate();
		repaint();
		setVisible(true);
		
	}

	    private JFreeChart crear_grafico_lineal(String titulo, String primer_variable, String segunda_variable) {
		DefaultCategoryDataset datos  = crear_datos();
		
		return ChartFactory.createBarChart(titulo, primer_variable, segunda_variable,datos, PlotOrientation.VERTICAL, true, true,false); 
	}

	    private DefaultCategoryDataset crear_datos() {
	    	DefaultCategoryDataset  aux =new DefaultCategoryDataset ();
	    	aux.addValue(TiempoBT, nombre_1, nombre_1);
	    	aux.addValue(TiempoFB, nombre_2, nombre_2);
	    	return aux;
	    }
	    

}
