package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.BackTrack;
import logica.FuerzaBruta;
import logica.SolverRobot;
import logica.TableroElectronico;

public class TableroUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Random random;
	private JButton[][] botones;
	private TableroElectronico tablero;
	private JPanel panelEstadisticas;
	private JLabel lblTiempoBT, lblLlamadasBT, lblCaminosBT, lblTiempoFB, lblLlamadasFB, lblCaminosFB;

	public TableroUI() {
									//CAMBIAR A LOGICA EL RANDOMIZER

		random = new Random();
		int x = (random.nextInt(10))+2;
		int y = (random.nextInt(10))+2;  
		if ((x * y) % 2 != 0) { // ESTO TIENE QUE USAR VERIFICARPARIDADGRILLA, CAMBIAR!!!!!!!!!!!!!!!!!!!!!
			x++; // Suma una fila
		}
		tablero = new TableroElectronico(x, y);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Window.HEIGHT / 3, Window.WIDTH / 3, 500, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(4, 4, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//GRILLA CREACION
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(x, y, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		setVisible(true);
		
		//BLOQUE ESTADISTICAS CREACION
		panelEstadisticas = new JPanel(new GridLayout(3, 1));
		lblTiempoBT = new JLabel("Tiempo de BackTracking: ");
		lblCaminosBT = new JLabel("Caminos posibles de BackTracking: ");
		lblCaminosFB = new JLabel("Caminos posibles de FuerzaBruta: ");

		panelEstadisticas.add(lblTiempoBT);
		lblTiempoFB = new JLabel("Tiempo de FuerzaBruta: ");
		panelEstadisticas.add(lblTiempoFB);
		lblLlamadasBT = new JLabel("Llamadas recursivas de BackTracking: ");
		panelEstadisticas.add(lblLlamadasBT);
		lblLlamadasFB = new JLabel("Llamadas recursivas de FuerzaBruta: ");
		panelEstadisticas.add(lblLlamadasFB);
		panelEstadisticas.add(lblCaminosBT);
		panelEstadisticas.add(lblCaminosFB);
		contentPane.add(panelEstadisticas, BorderLayout.SOUTH);

		
		
		
		
		botones = crearTablero(panel, tablero, x, y);
	}
			//ESTE METODO DEBERIA SER LOGICA, O GRAN PARTE DE EL.
	private JButton[][] crearTablero(JPanel panel, TableroElectronico tablero, int x, int y) {
	    botones = new JButton[x][y];

	    for (int i = 0; i < x; i++) {
	        for (int j = 0; j < y; j++) {
	            int valor = random.nextInt(2); // genera 0 o 1
	            if (valor == 0) {
	                valor = -1;
	            }
	            tablero.setearValorTablero(i, j, valor);
	            botones[i][j] = new JButton(String.valueOf(valor)); // muestra -1 o 1 como texto
	            botones[i][j].putClientProperty("x", i); 
	            botones[i][j].putClientProperty("y", j); 
	            botones[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	            botones[i][j].setEnabled(false);
	            botones[i][j].setOpaque(true);
	            botones[i][j].setContentAreaFilled(true);

	            panel.add(botones[i][j]);
	        }
	    }
	    resolverTablero(tablero);
	    return botones;
	}
	
	private void resolverTablero(TableroElectronico tablero) {
	    SolverRobot solver = new SolverRobot(tablero);
	    BackTrack backtrack = new BackTrack();
	    FuerzaBruta fuerzaBruta = new FuerzaBruta();
	    solver.obtenerFuerzaBruta(fuerzaBruta);
	    solver.resolverFuerzaBruta();
	    solver.obtenerBackTrack(backtrack);
	    solver.resolveBacktrack();
	    
	    lblTiempoBT.setText("Tiempo de BT: " + backtrack.obtenerTiempoEjecucionBackTrack() + " ms");
	    lblLlamadasBT.setText("Llamadas recursivas de BT: " + backtrack.getLlamadasRecursivas());
	    lblCaminosBT.setText("Caminos posibles de BT: " + backtrack.getCaminosPosibles());
	    lblTiempoFB.setText("Tiempo de FB: " + fuerzaBruta.obtenerTiempoEjecucionFuerzaBruta() + " ms");
	    lblLlamadasFB.setText("Llamadas recursivas de FB: " + fuerzaBruta.getLlamadasRecursivas());
	    lblCaminosFB.setText("Caminos posibles de FB: " + fuerzaBruta.getCaminosPosibles());
	
	
	}


}