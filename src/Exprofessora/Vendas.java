package Exprofessora;

import javax.swing.*;
import javax.swing.table.*;

import BDConexao.Conectar;

import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Vendas extends Janela {
	Connection conexao = Conectar.getConnection();

	JPanel pnPrincipal, pnTable;
	JButton btRemover, btAdicionar, btConsultar, btgravar;
	JScrollPane scrollTabel;
	JTable table;
	JLabel lblNumero, lblTotal, lblProduto, lblPrecoUnitario, lblQuantidade;
	JTextField txtNumero, txtTotal, txtProduto, txtPrecoUnitario, txtQuantidade;
	DecimalFormat df = new DecimalFormat("#,###.00");

	public Vendas() {
		super("Vendas", new Dimension(500, 440));
		componentes();
		Eventos();
	}

	public void componentes() {

		lblProduto = new JLabel("Produto");
		lblQuantidade = new JLabel("Quantidade");
		lblPrecoUnitario = new JLabel("Preço Unitário");
		lblNumero = new JLabel("Código do Produto");
		lblTotal = new JLabel("Total do Pedido");
		txtProduto = new JTextField();
		txtPrecoUnitario = new JTextField();
		txtQuantidade = new JTextField();
		txtNumero = new JTextField();
		txtTotal = new JTextField();
		txtTotal.setEnabled(false);
		txtTotal.setHorizontalAlignment(JTextField.RIGHT);
		btAdicionar = new JButton("Adicionar");
		btAdicionar.setToolTipText("Adicionar um item ao pedido");
		btRemover = new JButton("Remover");
		btRemover.setToolTipText("Remover um item ao pedido");
		btConsultar = new JButton("...");
		btConsultar.setToolTipText("Procurar o produto");

		btgravar = new JButton("Gravar");
		btgravar.setToolTipText("Gravar Vendas");
		lblProduto.setBounds(15, 40, 60, 25);
		lblQuantidade.setBounds(255, 40, 200, 25);
		lblPrecoUnitario.setBounds(350, 40, 100, 25);
		lblNumero.setBounds(15, 10, 120, 25);
		lblTotal.setBounds(278, 360, 100, 25);
		txtProduto.setBounds(15, 65, 200, 25);
		txtQuantidade.setBounds(255, 65, 50, 25);
		txtPrecoUnitario.setBounds(350, 65, 80, 25);
		txtNumero.setBounds(130, 10, 50, 25);
		txtTotal.setBounds(375, 360, 100, 25);
		btAdicionar.setBounds(15, 100, 100, 22);
		btRemover.setBounds(125, 100, 100, 22);
		btConsultar.setBounds(200, 10, 50, 22);
		btgravar.setBounds(120, 365, 100, 22);
		pnPrincipal = new JPanel();
		pnPrincipal.setLayout(null);
		pnPrincipal.setBounds(0, 0, 500, 400);
		pnPrincipal.add(lblNumero);
		pnPrincipal.add(lblTotal);
		pnPrincipal.add(txtNumero);
		pnPrincipal.add(txtTotal);
		pnPrincipal.add(lblProduto);
		pnPrincipal.add(txtProduto);
		pnPrincipal.add(lblQuantidade);
		pnPrincipal.add(txtQuantidade);
		pnPrincipal.add(lblPrecoUnitario);
		pnPrincipal.add(txtPrecoUnitario);
		pnPrincipal.add(btConsultar);
		pnPrincipal.add(btgravar);
		pnTable = new JPanel(new BorderLayout());
		pnTable.setBorder(new TitledBorder("Itens de Vendas"));
		scrollTabel = new JScrollPane();
		df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(2);
		pnPrincipal.add(btAdicionar);
		pnPrincipal.add(btRemover);
		DefaultTableModel tableModel = new DefaultTableModel(
				new String[] { "Produto", "Quantidade", "Preço Unitário", "Total" }, 0) {
			public boolean isCellEdittable(int row, int col) {
				if (col == 3) {
					return false;
				}
				return true;
			}
		};
		table = new JTable(tableModel);
		DefaultTableCellRenderer alinhaDireita = new DefaultTableCellRenderer();
		alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setCellRenderer(alinhaDireita);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setCellRenderer(alinhaDireita);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setCellRenderer(alinhaDireita);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollTabel.setViewportView(table);
		pnTable.add(scrollTabel);
		pnTable.setBounds(10, 130, 470, 230);
		pnPrincipal.add(pnTable);
		add(pnPrincipal);
	}

	public void Eventos() {
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtProduto.getText().equals("") || txtQuantidade.getText().equals("")
						|| txtPrecoUnitario.getText().equals("")) {
					JOptionPane.showMessageDialog(pnTable, "Preencha todos os campos");
					return;
				}
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.addRow(new Object[] { txtProduto.getText(), txtQuantidade.getText(), txtPrecoUnitario.getText(),
						"" + df.format(Integer.parseInt(txtQuantidade.getText())
								* Double.parseDouble(txtPrecoUnitario.getText())) });
				limpar();
				calcular();
			}
		});
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNumero.getText().equals("")) {
					JOptionPane.showMessageDialog(pnTable, "Preencha todos os campos");
					return;
				}
				consultaprodutos();
				txtNumero.setText("");
			}
		});
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] linhas = table.getSelectedRows();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				for (int i = (linhas.length - 1); i >= 0; --i) {
					dtm.removeRow(linhas[i]);
					txtTotal.setText("");
				}
				calcular();
				txtNumero.setText("");
			}
		});
		btgravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gravarvendas();

			}
		});

	}

	private void calcular() {
		double total = 0;
		for (int linha = 0; linha < table.getRowCount(); linha++) {
			String valor = "" + table.getValueAt(linha, 3);
			valor = valor.replace(".", "");
			valor = valor.replace(",", ".");
			total += Double.parseDouble(valor);
		}
		txtTotal.setText("" + df.format(total));
	}

	private void limpar() {
		txtProduto.setText("");
		txtQuantidade.setText("");
		txtPrecoUnitario.setText("");
		txtProduto.requestFocus();
	}

	public void consultaprodutos() {
		boolean ok = true;
		int vCodigo = Integer.parseInt(txtNumero.getText());
		String sql;

		sql = "SELECT * FROM Produtos WHERE codigo=" + vCodigo;
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				txtProduto.setText(rs.getString("Produto"));
				txtPrecoUnitario.setText(String.valueOf(rs.getInt("unitario")));
				txtQuantidade.requestFocus();
			} else {
				JOptionPane.showMessageDialog(null, "Código não encontrado");
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ERRO");
		}

	}

	public void gravarvendas() {
		double total = 0;
		String sql;
		for (int linha = 0; linha < table.getRowCount(); linha++) {
			String valor = "" + table.getValueAt(linha, 3);
			String quantidade = "" + table.getValueAt(linha, 2);
			String produto = "" + table.getValueAt(linha, 1);
			valor = valor.replace(".", "");
			valor = valor.replace(",", ".");
			String vSql;
			vSql = sql = "insert into itens values(" + txtNumero.getText() + "," + produto + "," + quantidade + ")";

			try {
				Statement st = conexao.createStatement();
				st.executeUpdate(vSql);
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "ERRO");
			}

		}

	}

	public static void main(String[] args) {
		Vendas tela = new Vendas();
		tela.show();

		tela.setVisible(true);
	}

}