package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TableroUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton[][] botones;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroUI frame = new TableroUI();
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
	public TableroUI() {
		 botones = new JButton[4][3];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Window.HEIGHT / 3, Window.WIDTH / 3, 500, 500);

		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		menuBar.setBorderPainted(false);

		setJMenuBar(menuBar);
		menuBar.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, 60, 1));

		

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		menuBar.add(btnNewButton);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(null); 
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				dispose();
			}
		});
		

		JButton btnNewButton_2 = new JButton("Salir   ");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		menuBar.add(btnNewButton_2);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(null); 
		btnNewButton_2.setBorderPainted(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(4, 4, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0)); 
		setContentPane(contentPane);

		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 4, 0, 0)); 
		contentPane.add(panel, BorderLayout.CENTER);
		
	  

	    contentPane.add(panel, BorderLayout.CENTER);
	
	    
        setLocationRelativeTo(null);
        setVisible(true);
		Comienzo( panel);
	}

	private void Comienzo( JPanel panel) {

		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				
				botones[i][j] = new JButton("");
				botones[i][j].putClientProperty("x", i); 
				botones[i][j].putClientProperty("y", j); 
				botones[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				botones[i][j].setEnabled(false);
				panel.add(botones[i][j]);
			}
		}
	}}