package org.restaurante.restaurante;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class App extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 225, 450, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botao1 = new JButton("Lista de pedidos");
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lista lis = new Lista();
				lis.setVisible(true);
			}
		});
		botao1.setBounds(139, 53, 163, 73);
		contentPane.add(botao1);
		
		JButton btnNewButton = new JButton("Fazer pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cardapio car = new Cardapio();
				car.setVisible(true);
			}
		});
		btnNewButton.setBounds(139, 137, 163, 73);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Prato");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cad = new Cadastro();
				cad.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(139, 221, 163, 73);
		contentPane.add(btnNewButton_1);
	}
}