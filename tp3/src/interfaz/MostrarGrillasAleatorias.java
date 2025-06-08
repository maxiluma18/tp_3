package interfaz;

import java.awt.Window;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MostrarGrillasAleatorias extends JFrame {
	private JPanel contentPane;
	private int num = 20;

	public MostrarGrillasAleatorias(List<Integer> tamanios, List<Double> TiemposBT, List<Double> TiemposFB) {
		contentPane = new JPanel();
		setBounds(Window.HEIGHT / 3, Window.WIDTH / 3, 700, 300);
		getContentPane().setLayout(null);

		for (int i = 0; i < tamanios.size(); i++) {
			String texto = String.format("Datos de la grilla %d: Longitud de la grilla (x+y): %d; Su tiempo de BT fue de: %.5f; Su tiempo de FB fue de: %.5f",
					i+1, tamanios.get(i), TiemposBT.get(i), TiemposFB.get(i));

			JLabel lblNewLabel = new JLabel(texto);
			lblNewLabel.setBounds(20, 20 + num, 700, 14);
			getContentPane().add(lblNewLabel);
			num = num + 30;
		}

	}
}
