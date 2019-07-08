package org.restaurante.restaurante;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.restaurante.restaurante.daos.ProdutoDao;
import org.restaurante.restaurante.entities.ProdutoEntity;
import org.restaurante.restaurante.utils.DaoFactory;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField valor;
	private JTextField nome;
	private JTextField ingredientes;


	public Cadastro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 252, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		valor = new JTextField();
		valor.setBounds(95, 143, 86, 20);
		contentPane.add(valor);
		valor.setColumns(10);
		
		nome = new JTextField();
		nome.setBounds(95, 82, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 85, 64, 14);
		contentPane.add(lblNome);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(20, 146, 46, 14);
		contentPane.add(lblValor);
		
		ingredientes = new JTextField();
		ingredientes.setBounds(95, 113, 86, 20);
		contentPane.add(ingredientes);
		ingredientes.setColumns(10);
		
		JLabel lblIngredientes = new JLabel("Ingredientes:");
		lblIngredientes.setBounds(20, 116, 76, 14);
		contentPane.add(lblIngredientes);
		
		JLabel lblProdutoCadastradoCom = new JLabel("");
		lblProdutoCadastradoCom.setEnabled(true);
		lblProdutoCadastradoCom.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutoCadastradoCom.setBounds(0, 237, 244, 14);
		contentPane.add(lblProdutoCadastradoCom);
		
		JButton Botao = new JButton("Cadastrar");
		Botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				cadastrar();
				lblProdutoCadastradoCom.setText("PRODUTO CADASTRADO COM SUCESSO!");
				}
				catch (Exception e) {
					lblProdutoCadastradoCom.setText("OCORREU UM ERRO NO CADASTRO!");
					System.out.println(e);
				}
			}
		});
		Botao.setBounds(79, 197, 91, 23);
		contentPane.add(Botao);
		
		JLabel lblCadastroDeProdutos = new JLabel("CADASTRO DE PRODUTOS");
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setBounds(0, 32, 244, 14);
		contentPane.add(lblCadastroDeProdutos);
		
	}
	
	public void cadastrar() {
		ProdutoEntity p = new ProdutoEntity();
		ProdutoDao pd = DaoFactory.produtoInstance();
		
		p.setNome(nome.getText());
		p.setIngredientes(ingredientes.getText());
		p.setValor(Double.parseDouble(valor.getText()));
		
		pd.save(p);
		
		nome.setText("");
		ingredientes.setText("");
		valor.setText("");
		
	}
}
