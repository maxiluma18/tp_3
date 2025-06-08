package interfaz;

import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import logica.GeneradorGrillaAleatoria;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GraficoLineal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFreeChart _grafico;
    //Nombres JFrame
    private String tituloFrame="Grafico Lineal";
    // Nombre  del titulo y etiquetas
    private String titulo="Backtracking vs Fuerza Bruta";
    private String etiqueta_horizontal="Tamaño del Tablero (x + y)";
    private String etiqueta_Vertical="Tiempo De Ejecucion";
    //Nombre de las comparaciones (vs)
    private String valor_Comparado1="Backtracking";
    private String valor_Comparado2="Fuerza Bruta";
    private List<Integer> tamanios;
    private List<Double> tiemposBT, tiemposFB;
    private MostrarGrillasAleatorias mg;
    public GraficoLineal() {
        setTitle(tituloFrame);       
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setAlwaysOnTop(true); 
      

        XYDataset datos = crear_datos();
        _grafico = crear_grafico_lineal(titulo, etiqueta_horizontal, etiqueta_Vertical, datos);

        ChartPanel panel = new ChartPanel(_grafico);
        getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(null);
        
        JButton btnMostrarGrillas = new JButton("Mostrar Grillas Comparadas");
        btnMostrarGrillas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(mg == null) {
        			mg = new MostrarGrillasAleatorias(tamanios, tiemposBT, tiemposFB);
        		}
        		mg.setVisible(true);
        	}
        });
        btnMostrarGrillas.setBounds(0, 397, 209, 23);
        panel.add(btnMostrarGrillas);
        pack(); //lo que hace es q modifica el tamaño segun el grafico 
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JFreeChart crear_grafico_lineal(String titulo, String etiqueta_horizontal, String etiqueta_vertical, XYDataset datos) {
    	JFreeChart chart = ChartFactory.createXYLineChart(titulo, etiqueta_horizontal, etiqueta_vertical, datos,
                PlotOrientation.VERTICAL, true, true, false);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Mostrar líneas y puntos (círculos) en ambas series
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, true);

        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(1, true);

       
        renderer.setSeriesPaint(0, Color.BLACK); 
        renderer.setSeriesPaint(1, Color.CYAN);  

  
        chart.getXYPlot().setRenderer(renderer);

        return chart;
  }
    

    private XYDataset crear_datos() {
    	
        GeneradorGrillaAleatoria generador = new GeneradorGrillaAleatoria();
        generador.generarGrillasAleatorias();
        XYSeries serieBT = new XYSeries(valor_Comparado1);
        XYSeries serieFB = new XYSeries(valor_Comparado2);

         tamanios = generador.getTamanios();
         tiemposBT = generador.getTiemposBacktrack();
         tiemposFB = generador.getTiemposFuerzaBruta();

        for (int i = 0; i < tamanios.size(); i++) {
            serieBT.add(tamanios.get(i), tiemposBT.get(i));
            serieFB.add(tamanios.get(i), tiemposFB.get(i));
            System.out.println(tamanios.get(i));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serieBT);
        dataset.addSeries(serieFB);

        return dataset;
    }

   
}
