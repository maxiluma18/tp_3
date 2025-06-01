package interfaz;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JButton btnGrillaAleatoria = new JButton("Tablero Aleatorio");
		btnGrillaAleatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TableroUI();
				setVisible(true);
				dispose();
			}
		});
		JButton btnGrillaCargar = new JButton("Cargar Tablero");
		btnGrillaCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGrillaAleatoria.setBounds(141, 41, 151, 23);
		contentPane.add(btnGrillaAleatoria);
		btnGrillaCargar.setBounds(141, 91, 145, 23);
		contentPane.add(btnGrillaCargar);
	}
}
