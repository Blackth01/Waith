package org.restaurante.restaurante;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.restaurante.restaurante.daos.NumeroDao;
import org.restaurante.restaurante.daos.PedidoDao;
import org.restaurante.restaurante.entities.NumeroEntity;
import org.restaurante.restaurante.entities.PedidoEntity;
import org.restaurante.restaurante.entities.ProdutoEntity;
import org.restaurante.restaurante.utils.DaoFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class Pedidos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField total;
	private PedidoDao pedidoDao;
	private NumeroDao numeroDao;
	private DefaultTableModel lis;

	
	public Pedidos(int numero, double tot) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 556, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 36, 548, 175);
		contentPane.add(scrollPane);
		
		pedidoDao = DaoFactory.pedidoInstance();
		numeroDao = DaoFactory.numeroInstance();
		
		lis = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Valor", "Quantidade"
				}
			);
		table = new JTable();
		table.setModel(lis);
		scrollPane.setViewportView(table);
		
		JButton btnEntregue = new JButton("Entregar");
		btnEntregue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entregar(numero);
			}
		});
		btnEntregue.setBounds(57, 239, 91, 23);
		contentPane.add(btnEntregue);
		
		JLabel lblPedidosDe = new JLabel("Pedidos do n�mero" + numero);
		lblPedidosDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidosDe.setBounds(0, 11, 548, 14);
		contentPane.add(lblPedidosDe);
		
		JLabel lblValor = new JLabel("Valor total:");
		lblValor.setBounds(199, 243, 91, 14);
		contentPane.add(lblValor);
		
		total = new JTextField();
		total.setBounds(278, 240, 86, 20);
		contentPane.add(total);
		total.setColumns(10);
		
		adicionar(numero, tot);
	}
	
	public void adicionar(int id, Double tot) {
		
		List<PedidoEntity> pedidos = pedidoDao.getPedidos(Long.valueOf(id));
		
		for (PedidoEntity p : pedidos) {
			ProdutoEntity produto = p.getProduto();
			lis.addRow(new String[] {String.valueOf(p.getId()), produto.getNome(), String.valueOf(produto.getValor()), String.valueOf(p.getQuantidade())});
		}
		
		total.setText(String.valueOf(tot));
	}
	
	public void entregar(int id) {
		NumeroEntity n = new NumeroEntity();
		n = numeroDao.findById(Long.valueOf(id));
		n.setTotal(0.0);
		numeroDao.update(n);
		dispose();
	}
}
