package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.BackTrack;
import logica.FuerzaBruta;
import logica.Posicion;
import logica.SolverRobot;
import logica.TableroElectronico;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableroUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Random random;
	private JButton[][] botones;
	private TableroElectronico tablero;
	private JPanel panelEstadisticas;
	private JLabel lblTiempoBT, lblLlamadasBT, lblCaminosBT, lblTiempoFB, lblLlamadasFB, lblCaminosFB;
	private JButton btnGraficar;
	private double TiempoBt, TiempoFB;
	private SolverRobot solver;
    private BackTrack backtrack;
    private FuerzaBruta fuerzaBruta;
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
		setBounds(Window.HEIGHT / 3, Window.WIDTH / 3, 700, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(4, 4, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//PANEL PARA LOS BOTONES DE ARRIBA 
		JPanel panelNORTH = new JPanel();
		panelNORTH.setLayout(null);
		
		
		//aca Seteamos para el tamaño del panel
		panelNORTH.setPreferredSize(new Dimension(700, 60)); 
		contentPane.add(panelNORTH, BorderLayout.NORTH);
		
		btnGraficar = new JButton("Graficar");
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Graficos(TiempoBt, TiempoFB);
				setVisible(true);
				dispose();
			}
		});
		btnGraficar.setBounds(68, 10, 85, 21);
		panelNORTH.add(btnGraficar);
		
		
		
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
		solver = new SolverRobot(tablero);
	    backtrack = new BackTrack();
	    fuerzaBruta = new FuerzaBruta();
	    solver.obtenerFuerzaBruta(fuerzaBruta);
	    solver.resolverFuerzaBruta();
	    solver.obtenerBackTrack(backtrack);
	    solver.resolveBacktrack();
	    TiempoBt = backtrack.obtenerTiempoEjecucionBackTrack();
	    TiempoFB = fuerzaBruta.obtenerTiempoEjecucionFuerzaBruta();
	    lblTiempoBT.setText("Tiempo de BT: " + TiempoBt  + " ms");
	    lblLlamadasBT.setText("Llamadas recursivas de BT: " + backtrack.getLlamadasRecursivas());
	    lblCaminosBT.setText("Caminos posibles de BT: " + backtrack.getCaminosPosibles());
	    lblTiempoFB.setText("Tiempo de FB: " + TiempoFB + " ms");
	    lblLlamadasFB.setText("Llamadas recursivas de FB: " + fuerzaBruta.getLlamadasRecursivas());
	    lblCaminosFB.setText("Caminos posibles de FB: " + fuerzaBruta.getCaminosPosibles());
	    
	    //Printear de color verde u otro, el correcto, SOLO el PRIMERO de FB(O BT)
	    Map<Integer, List<Posicion>> caminosValidosFB = fuerzaBruta.getCaminosValidos();
	    if(caminosValidosFB.size() > 0) {
	    	List<Posicion> primerCaminoValido = caminosValidosFB.get(random.nextInt(caminosValidosFB.size()));
	    	pintarCamino(primerCaminoValido);
	    }

	}
	private void pintarCamino(List<Posicion> caminoValido) {
		for(Posicion p : caminoValido) {
			int fila = p.getFila();
			int columna = p.getColumna();
			botones[fila][columna].setBackground(Color.GREEN);
		}
	}


}