package interfaz;

import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import logica.GeneradorGrillaAleatoria;

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
    
    public GraficoLineal() {
        setTitle(tituloFrame);
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        XYDataset datos = crear_datos();
        _grafico = crear_grafico_lineal(titulo, etiqueta_horizontal, etiqueta_Vertical, datos);

        ChartPanel panel = new ChartPanel(_grafico);
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    private JFreeChart crear_grafico_lineal(String titulo, String etiqueta_horizontal, String etiqueta_vertical, XYDataset datos) {
        return ChartFactory.createXYLineChart( titulo, etiqueta_horizontal,  etiqueta_vertical,datos,PlotOrientation.VERTICAL,true,true,false );
    }

    private XYDataset crear_datos() {
        GeneradorGrillaAleatoria generador = new GeneradorGrillaAleatoria();

        XYSeries serieBT = new XYSeries(valor_Comparado1);
        XYSeries serieFB = new XYSeries(valor_Comparado2);

        List<Integer> tamanios = generador.getTamanios();
        List<Double> tiemposBT = generador.getTiemposBacktrack();
        List<Double> tiemposFB = generador.getTiemposFuerzaBruta();

        for (int i = 0; i < tamanios.size(); i++) {
            serieBT.add(tamanios.get(i), tiemposBT.get(i));
            serieFB.add(tamanios.get(i), tiemposFB.get(i));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serieBT);
        dataset.addSeries(serieFB);

        return dataset;
    }

   
}
