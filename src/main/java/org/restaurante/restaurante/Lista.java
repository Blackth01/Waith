package org.restaurante.restaurante;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.restaurante.restaurante.Pedidos;
import org.restaurante.restaurante.daos.NumeroDao;
import org.restaurante.restaurante.entities.NumeroEntity;
import org.restaurante.restaurante.utils.DaoFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Lista extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel lis;
	private JTable table;
	private NumeroDao numeroDao;
	
	
	public Lista() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 40, 183, 193);
		contentPane.add(scrollPane);
		
		numeroDao = DaoFactory.numeroInstance();
		
		lis = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"N\u00FAmero", "Valor Total"
				}
			);
		
		
		table = new JTable();
		table.setModel(lis);
		scrollPane.setViewportView(table);
		
		JLabel lblTodosOsPedidos = new JLabel("Todos os pedidos");
		lblTodosOsPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodosOsPedidos.setBounds(120, 11, 183, 14);
		contentPane.add(lblTodosOsPedidos);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int id = Integer.parseInt(lis.getValueAt(row, 0).toString());
				double total = Double.parseDouble(lis.getValueAt(row, 1).toString());
				Pedidos ped = new Pedidos(id, total);
				ped.setVisible(true);
				
			}
		});
		btnVer.setBounds(178, 239, 91, 23);
		contentPane.add(btnVer);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAtualizar.setBounds(10, 78, 91, 23);
		contentPane.add(btnAtualizar);
		
		adicionar();
		
	}
	
	public void adicionar() {
		while(lis.getRowCount() > 0)
		{
		    lis.removeRow(0);
		}
		
		List<NumeroEntity> numeros = numeroDao.findAll();
		
		for (NumeroEntity n : numeros) {
			if (n.getTotal() != null && n.getTotal() > 0) {
				lis.addRow(new String[] {String.valueOf(n.getId()), String.valueOf(n.getTotal())});
			}
		}
	}
}
