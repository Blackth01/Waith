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
import org.restaurante.restaurante.daos.ProdutoDao;
import org.restaurante.restaurante.entities.NumeroEntity;
import org.restaurante.restaurante.entities.PedidoEntity;
import org.restaurante.restaurante.entities.ProdutoEntity;
import org.restaurante.restaurante.utils.DaoFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class Cardapio extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel pesquisa;
	private DefaultTableModel lista;
	private JTable table;
	private JTextField pesquisar;
	private JTextField quantidade;
	private JTable table_1;
	private JTextField total;
	private Long numero;

	private NumeroDao numeroDao;
	private ProdutoDao produtoDao;
	private PedidoDao pedidoDao;


	public Cardapio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 37, 547, 76);
		contentPane.add(scrollPane);
		
		numeroDao = DaoFactory.numeroInstance();
		produtoDao = DaoFactory.produtoInstance();
		pedidoDao = DaoFactory.pedidoInstance();
		
		NumeroEntity n = new NumeroEntity();
		n.setTotal(0.0);
		numeroDao.save(n);
		numero = n.getId();
		
		pesquisa = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Valor"
				}
			);
		table = new JTable();
		table.setModel(pesquisa);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Pesquisar: ");
		lblNewLabel.setBounds(72, 11, 87, 14);
		contentPane.add(lblNewLabel);
		
		pesquisar = new JTextField();
		pesquisar.setBounds(152, 8, 135, 20);
		contentPane.add(pesquisar);
		pesquisar.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnNewButton.setBounds(310, 7, 122, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(132, 127, 87, 14);
		contentPane.add(lblQuantidade);
		
		quantidade = new JTextField();
		quantidade.setBounds(208, 124, 35, 20);
		contentPane.add(quantidade);
		quantidade.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnNewButton_1.setBounds(281, 119, 91, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 166, 537, 81);
		contentPane.add(scrollPane_1);
		
		lista = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Valor", "Quantidade"
				}
			);
		table_1 = new JTable();
		table_1.setModel(lista);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setBounds(20, 258, 77, 14);
		contentPane.add(lblValorTotal);
		
		total = new JTextField();
		total.setBounds(84, 255, 77, 20);
		contentPane.add(total);
		total.setColumns(10);
		
		JButton finalizar = new JButton("Finalizar");
		finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizar();
			}
		});
		finalizar.setBounds(171, 254, 91, 23);
		contentPane.add(finalizar);
		
		JButton btnExcluirPedido = new JButton("Excluir pedido");
		btnExcluirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		btnExcluirPedido.setBounds(324, 258, 118, 23);
		contentPane.add(btnExcluirPedido);
		
		JLabel lblPedidosFeitosPara = new JLabel("Pedidos feitos para o n\u00FAmero: " + numero);
		lblPedidosFeitosPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidosFeitosPara.setBounds(10, 148, 422, 14);
		contentPane.add(lblPedidosFeitosPara);
	}
	
	public void pesquisar() {
		while(pesquisa.getRowCount() > 0)
		{
		    pesquisa.removeRow(0);
		}
		List<ProdutoEntity> produtos = produtoDao.pesquisaProdutos(pesquisar.getText());
		
		for (ProdutoEntity p : produtos) {
			pesquisa.addRow(new String[] {String.valueOf(p.getId()), p.getNome(), String.valueOf(p.getValor())});
		}
	}
	
	public void adicionar() {
		PedidoEntity p = new PedidoEntity();
		ProdutoEntity prod = new ProdutoEntity();
		NumeroEntity num = new NumeroEntity();
						
		int row = table.getSelectedRow();
		int id_produto = Integer.parseInt(table.getValueAt(row, 0).toString());
		int qtd = Integer.parseInt(quantidade.getText());
		
		System.out.println("flag1");
		prod = produtoDao.findById(Long.valueOf(id_produto));
		System.out.println("flag2");
		num = numeroDao.findById(Long.valueOf(numero));
		System.out.println("flag3");
		
		p.setNumero(num);
		p.setProduto(prod);
		p.setQuantidade(qtd);
		
		pedidoDao.save(p);
		System.out.println("flag4");
		
		atualizar();
	}
	
	public void atualizar() {
		System.out.println("flag5");
		while(lista.getRowCount() > 0)
		{
		    lista.removeRow(0);
		}
				
		List<PedidoEntity> pedidos = pedidoDao.getPedidos(numero);
		
		for (PedidoEntity p : pedidos) {
			ProdutoEntity prod = p.getProduto();
			lista.addRow(new String[] {String.valueOf(p.getId()), prod.getNome(), String.valueOf(prod.getValor()), String.valueOf(p.getQuantidade())});
		}
		
		setTotal();
	}
	
	public void setTotal() {
		int x = 0;
		double tot= 0;
		int qtd = 0;
		double valor = 0;
		while(x < lista.getRowCount()) {
			valor = Double.parseDouble(lista.getValueAt(x, 2).toString());
			qtd = Integer.parseInt(lista.getValueAt(x, 3).toString());
			valor = valor*qtd;
			tot += valor;
			x++;
		}
		
		total.setText(String.valueOf(tot));
	}
	
	public void finalizar() {
		NumeroEntity n = new NumeroEntity();
		
		n = numeroDao.findById(numero);
		
		n.setTotal(Double.parseDouble(total.getText()));
		
		numeroDao.update(n);
		
		dispose();
	}
	
	public void deletar() {
		int row = table_1.getSelectedRow();
		int id = Integer.parseInt(lista.getValueAt(row, 0).toString());
		PedidoEntity p = pedidoDao.findById(Long.valueOf(id));
		
		pedidoDao.delete(p);
		atualizar();
	}
}
