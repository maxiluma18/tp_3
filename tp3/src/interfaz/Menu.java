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
		
		
		
		
		
		//ver la imagen de fondo menu y escalarla y corregirla :)
		contentPane = new Fondo("fondomenu.png");
	
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnGrillaAleatoria = new JButton("Tablero Aleatorio");
		btnGrillaAleatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TableroUI();
				setVisible(true);
				dispose();
			}
		});
		btnGrillaCargar  = new JButton("Cargar Tablero");
		btnGrillaCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGrillaAleatoria.setBounds(141, 79, 151, 23);
		contentPane.add(btnGrillaAleatoria);
		btnGrillaCargar.setBounds(141, 169, 151, 23);
		contentPane.add(btnGrillaCargar);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Optimización de la ruta de un robot");
		lblNewJgoodiesTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewJgoodiesTitle.setBounds(111, 46, 228, 13);
		contentPane.add(lblNewJgoodiesTitle);
		
		 btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(141, 218, 151, 23);
		contentPane.add(btnSalir);
		setContentPane(contentPane);
		
		JButton btnGraficoLineal = new JButton("Grafico Lineal ");
		btnGraficoLineal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GraficoLineal();
				setVisible(true);
			
			}
		});
		btnGraficoLineal.setBounds(141, 124, 151, 23);
		contentPane.add(btnGraficoLineal);
	}
}
