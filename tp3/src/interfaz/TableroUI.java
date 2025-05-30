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
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.TableroElectronico;

public class TableroUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Random random;
	private JButton[][] botones;
	private TableroElectronico tablero;

	public TableroUI() {
									//CAMBIAR A LOGICA EL RANDOMIZER

		random = new Random();
		int x = 3;  //harcodeado aproposito para que siempre sume uno mas al X y sea par
		;// de 1 a 10
		int y = 3;
		;
		if ((x * y) % 2 != 0) { // ESTO TIENE QUE USAR VERIFICARPARIDADGRILLA, CAMBIAR!!!!!!!!!!!!!!!!!!!!!
			x++; // Suma una fila
		}
		tablero = new TableroElectronico(x, y);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Window.HEIGHT / 3, Window.WIDTH / 3, 500, 500);

		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		menuBar.setBorderPainted(false);

		setJMenuBar(menuBar);
		menuBar.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 1));

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(4, 4, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(x, y, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);

		contentPane.add(panel, BorderLayout.CENTER);

		setLocationRelativeTo(null);
		setVisible(true);
		botones = Comienzo(panel, tablero, x, y);

	}

	private JButton[][] Comienzo(JPanel panel, TableroElectronico tablero, int x, int y) {
		botones = new JButton[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int valor = random.nextInt(1) + 1;
				tablero.setearValorTablero(i, j, valor);

				botones[i][j] = new JButton("");
				botones[i][j].putClientProperty("x", i);
				botones[i][j].putClientProperty("y", j);
				botones[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				botones[i][j].setEnabled(false);
				panel.add(botones[i][j]);
			}
		}

		return botones;
	}
}