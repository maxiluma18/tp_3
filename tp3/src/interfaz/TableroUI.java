package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import logica.SolverAlgoritmos;
import logica.Archivo;
import logica.GeneradorGrillaAleatoria;
import logica.RandomNumeros;
import logica.SolverRobot;
import logica.TableroElectronico;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TableroUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelEstadisticas, PanelArriba;
	private RandomNumeros random;
	private JButton[][] botones;
	private TableroElectronico tablero;
	private JLabel lblTiempoBT, lblLlamadasBT, lblCaminosBT, lblTiempoFB, lblLlamadasFB, lblCaminosFB;
	private JButton btnGraficar, btnVolver;
	private double TiempoBt, TiempoFB;
	private SolverRobot solverPoda, solverNoPoda;
	private SolverAlgoritmos algoritmoPoda, algoritmoNoPoda;
	private Graficos grafico;
	private Fondo robotComienzo, robotDestino;
//Imagenes 
	private String rutaImagenComienzo="robotComienzo.png";
	private String rutaImagenFinal="robotFinal.png";
	private String pasos="huellas";
	private String pasosDerecha="huellasDerecha";
	private String botonVolver="back";
	private String botonVolverHover="backOscuro";
	private String botonGraficar="grafico";
	private String botonGraficarHover="graficoOscuro";
	public TableroUI(String rutaArchivo) {
		random = new RandomNumeros();
		if (rutaArchivo == null) {
			GeneradorGrillaAleatoria aleatoria = new GeneradorGrillaAleatoria();
			tablero = aleatoria.generarUnaGrillaAleatoria();
		} else {
			tablero = Archivo.cargarDesdeArchivo(rutaArchivo);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Window.HEIGHT / 3, Window.WIDTH / 3, 700, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(4, 4, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// PANEL PARA LOS BOTONES DE ARRIBA
		PanelArriba = new JPanel();
		PanelArriba.setLayout(null);

		// aca Seteamos para el tamaño del panel
		PanelArriba.setPreferredSize(new Dimension(700, 60));
		contentPane.add(PanelArriba, BorderLayout.NORTH);

		btnGraficar = new JButton("Graficar");

		btnGraficar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGraficar.setRolloverIcon(CargarYObtenerImagen(botonGraficar));
		btnGraficar.setIcon(CargarYObtenerImagen(botonGraficarHover));
		btnGraficar.setPressedIcon(CargarYObtenerImagen(botonGraficar));
		btnGraficar.setContentAreaFilled(false);
		btnGraficar.setBorderPainted(false);
		btnGraficar.setFocusPainted(false);
		btnGraficar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGraficar.setVerticalAlignment(SwingConstants.BOTTOM);

		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grafico == null) {
					grafico = new Graficos(TiempoBt, TiempoFB);
				}
				grafico.setVisible(true);

			}
		});
		btnGraficar.setBounds(264, 0, 85, 60);
		PanelArriba.add(btnGraficar);

		btnVolver = new JButton("Volver");

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
		btnVolver.setBounds(350, 0, 85, 60);
		PanelArriba.add(btnVolver);

		JLabel CantFilas = new JLabel();
		CantFilas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CantFilas.setBounds(571, 11, 94, 21);
		CantFilas.setText("Filas:" + tablero.cantCaminosHorTablero());
		PanelArriba.add(CantFilas);

		JLabel CantCol = new JLabel("");
		CantCol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CantCol.setBounds(571, 41, 94, 19);
		CantCol.setText("Columnas:" + tablero.cantCaminosVertTablero());
		PanelArriba.add(CantCol);

		robotComienzo = new Fondo(rutaImagenComienzo);
		robotComienzo.setBounds(-9, 0, 70, 60);

		PanelArriba.add(robotComienzo);

		// GRILLA CREACION
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(tablero.cantCaminosHorTablero(), tablero.cantCaminosVertTablero(), 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		setVisible(true);

		// BLOQUE ESTADISTICAS CREACION
		panelEstadisticas = new JPanel();
		panelEstadisticas.setPreferredSize(new Dimension(700, 60));
		contentPane.add(panelEstadisticas, BorderLayout.SOUTH);

		botones = crearTablero(panel, tablero.cantCaminosHorTablero(), tablero.cantCaminosVertTablero());

	}

	private JButton[][] crearTablero(JPanel panel, int x, int y) {
		botones = new JButton[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				botones[i][j] = new JButton(String.valueOf(tablero.obtenerValorTablero(i, j)));
				botones[i][j].setFont(new Font("Arial", Font.BOLD, 13));
				botones[i][j].setForeground(Color.BLACK);
				botones[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				botones[i][j].setEnabled(false);
				botones[i][j].setOpaque(true);
				botones[i][j].setContentAreaFilled(true);
				panel.add(botones[i][j]);
			}
		}
		resolverTablero(panelEstadisticas);
		return botones;
	}

	private void resolverTablero(JPanel estadisticas) {
		solverNoPoda = new SolverRobot(tablero);
		solverNoPoda.resolverFuerzaBruta();
		algoritmoNoPoda = solverNoPoda.obtenerSolver();
		TiempoFB = algoritmoNoPoda.obtenerTiempoEjecucionAlgoritmo();

		lblTiempoFB = new JLabel("⏰ Tiempo de FuerzaBruta: " + TiempoFB + " ms");
		lblTiempoFB.setBounds(325, 5, 246, 14);
		estadisticas.add(lblTiempoFB);

		lblLlamadasFB = new JLabel("Llamadas recursivas de FuerzaBruta: " + algoritmoNoPoda.getLlamadasRecursivas());
		lblLlamadasFB.setBounds(325, 21, 288, 14);
		estadisticas.add(lblLlamadasFB);

		lblCaminosFB = new JLabel("Caminos posibles de FuerzaBruta: " + algoritmoNoPoda.getCaminosPosibles());
		lblCaminosFB.setBounds(325, 35, 251, 14);
		estadisticas.add(lblCaminosFB);

		solverPoda = new SolverRobot(tablero);
		solverPoda.resolverBacktrack();
		algoritmoPoda = solverPoda.obtenerSolver();
		TiempoBt = algoritmoPoda.obtenerTiempoEjecucionAlgoritmo();
		estadisticas.setLayout(null);

		lblTiempoBT = new JLabel("⏰ Tiempo de BackTracking: " + TiempoBt + " ms");
		lblTiempoBT.setBounds(23, 5, 265, 14);
		estadisticas.add(lblTiempoBT);

		lblLlamadasBT = new JLabel("Llamadas recursivas de BackTracking: " + algoritmoPoda.getLlamadasRecursivas());
		lblLlamadasBT.setBounds(23, 21, 307, 14);
		estadisticas.add(lblLlamadasBT);

		lblCaminosBT = new JLabel("Caminos posibles de BackTracking: " + algoritmoPoda.getCaminosPosibles());
		lblCaminosBT.setBounds(23, 35, 307, 14);
		estadisticas.add(lblCaminosBT);

		// Printear de color verde u otro, el correcto, SOLO el PRIMERO de FB(O BT)
		if (algoritmoPoda.getCaminosPosibles() > 0) {
			tablero.elegirCaminoActual(random.darCaminoAleatorio(algoritmoPoda.getCaminosPosibles()));
			pintarCamino(tablero.CaminoActualTamaño());
		}

	}

	private void pintarCamino(int CaminoSize) {
		int fila_Anterior = 0;
		int columna_Anterior = 0;
		for (int posicion = 0; posicion < CaminoSize; posicion++) {
			int fila = tablero.obtenerCoordenaX(posicion);
			int columna = tablero.obtenerCoordenaY(posicion);

			if (posicion + 1 < CaminoSize) {
				int filaSig = tablero.obtenerCoordenaX(posicion + 1);
				int columnaSig = tablero.obtenerCoordenaY(posicion + 1);

				if ((fila == fila_Anterior && columna_Anterior < columna && columna != columnaSig)
						|| (fila == filaSig || columna != columnaSig)) {

					botones[fila][columna].setIcon(CargarYObtenerImagen(pasosDerecha));
				} else {
					botones[fila][columna].setIcon(CargarYObtenerImagen(pasos));
				}
			} else {
				botones[fila][columna].setIcon(CargarYObtenerImagen(pasos));
			}

			columna_Anterior = columna;
			fila_Anterior = fila;
		}
		robotDestino = new Fondo(rutaImagenFinal);
		robotDestino.setBounds(605, 0, 70, 60);
		panelEstadisticas.add(robotDestino);
	}

	private ImageIcon CargarYObtenerImagen(String nombre) {
		return new ImageIcon(TableroUI.class.getResource("/imagenes/" + nombre + ".png"));
	}
}