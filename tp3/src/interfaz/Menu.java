package interfaz;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import logica.Archivo;

import java.awt.Font;


public class Menu extends JFrame {
	private JButton btnGrillaAleatoria, btnGrillaCargar, btnSalir;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane = new Fondo("fondomenu2.jpg");
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		setearTitutoloFrame();
		
		crearBotonGrillaAleatoria();
		crearBotonGrillaCargar();
		crearBotonSalir();
		crearBotonGraficoLineal();
	}

	private void crearBotonGraficoLineal() {
		JButton btnGraficoLineal = new JButton("Grafico Lineal ");
		btnGraficoLineal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GraficoLineal();
				setVisible(true);
			
			}
		});
		btnGraficoLineal.setBounds(277, 109, 128, 23);
		contentPane.add(btnGraficoLineal);
	}

	private void crearBotonSalir() {
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(10, 230, 134, 23);
		contentPane.add(btnSalir);
		setContentPane(contentPane);
	}

	private void crearBotonGrillaAleatoria() {
		btnGrillaAleatoria = new JButton("Tablero Aleatorio");
		btnGrillaAleatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TableroUI();
				setVisible(true);
				dispose();
			}
		});
        btnGrillaAleatoria.setBounds(202, 69, 128, 23);
		contentPane.add(btnGrillaAleatoria);
	}

	private void crearBotonGrillaCargar() {
		btnGrillaCargar  = new JButton("Cargar Tablero");
		btnGrillaCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ruta = Archivo.elegirArchivoDesdeCarpeta("src/archivos");
				if (ruta != null) {
					new TableroArchivo(ruta); // pasamos la ruta elegida
					setVisible(false);
					dispose();
				}
			}
		});

		btnGrillaCargar.setBounds(348, 69, 128, 23);
		contentPane.add(btnGrillaCargar);
	}

	private void setearTitutoloFrame() {
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Optimización de la ruta de un robot");
		lblNewJgoodiesTitle.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblNewJgoodiesTitle.setBounds(27, -11, 476, 49);
		contentPane.add(lblNewJgoodiesTitle);
	}
}
