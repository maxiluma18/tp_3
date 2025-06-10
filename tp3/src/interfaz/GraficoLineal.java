package interfaz;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import logica.GeneradorGrillaAleatoria;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GraficoLineal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFreeChart _grafico;
	private GraficoBarra grafico;
	
	private String botonVolver="back";
	private String botonVolverHover="backOscuro";
	// Nombres JFrame
	private String tituloFrame = "Grafico Lineal";
	// Nombre del titulo y etiquetas
	private String titulo = "Backtracking vs Fuerza Bruta";
	private String etiqueta_horizontal = "Tamaño del Tablero (x + y)";
	private String etiqueta_Vertical = "Tiempo De Ejecucion";
	// Nombre de las comparaciones (vs)
	private String valor_Comparado1 = "Backtracking";
	private String valor_Comparado2 = "Fuerza Bruta";

	public GraficoLineal() {
		setTitle(tituloFrame);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		XYDataset datos = crear_datos();
		_grafico = crear_grafico_lineal(titulo, etiqueta_horizontal, etiqueta_Vertical, datos);

		ChartPanel panel = new ChartPanel(_grafico);
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		crearBotonVolver(panel);

		pack(); // lo que hace es q modifica el tamaño segun el grafico
		setLocationRelativeTo(null);
		setVisible(true);
	}

	

	private JFreeChart crear_grafico_lineal(String titulo, String etiqueta_horizontal, String etiqueta_vertical,
			XYDataset datos) {
		JFreeChart chart = ChartFactory.createXYLineChart(titulo, etiqueta_horizontal, etiqueta_vertical, datos,
				PlotOrientation.VERTICAL, true, true, false);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		// Mostrar líneas y puntos (círculos) en ambas series
		renderer.setSeriesLinesVisible(0, true);
		renderer.setSeriesShapesVisible(0, true);

		renderer.setSeriesLinesVisible(1, true);
		renderer.setSeriesShapesVisible(1, true);

		renderer.setSeriesPaint(0, Color.BLUE);
		renderer.setSeriesPaint(1, Color.RED);

		chart.getXYPlot().setRenderer(renderer);

		return chart;
	}

	private XYDataset crear_datos() {

		GeneradorGrillaAleatoria generador = new GeneradorGrillaAleatoria();
		generador.generarGrillasAleatorias();
		XYSeries serieBT = new XYSeries(valor_Comparado1);
		XYSeries serieFB = new XYSeries(valor_Comparado2);

		

		for (int i = 0; i < generador.longuitud(); i++) {
			serieBT.add(generador.getTamanios(i), generador.getTiemposBacktrack(i));
			serieFB.add(generador.getTamanios(i), generador.getTiemposFuerzaBruta(i));
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(serieBT);
		dataset.addSeries(serieFB);

		return dataset;
	}
	private void crearBotonVolver(ChartPanel panel) {
		JButton btnVolver = new JButton("Volver");
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setRolloverIcon(CargarYObtenerImagen(botonVolver));
		btnVolver.setIcon(CargarYObtenerImagen(botonVolverHover));
		btnVolver.setPressedIcon(CargarYObtenerImagen(botonVolver));

		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVolver.setVerticalAlignment(SwingConstants.BOTTOM);

		btnVolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (grafico != null) {
					grafico.dispose();
				}
				Menu frame = new Menu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(-12, 360, 85,60 );
		panel.add(btnVolver);
	}
	
	//CARGAR ICONOS EN BOTONES
		private ImageIcon CargarYObtenerImagen(String nombre) {
			return new ImageIcon(TableroUI.class.getResource("/imagenes/" + nombre + ".png"));
		}
}
