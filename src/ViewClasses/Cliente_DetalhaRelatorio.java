package ViewClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BDConexao.Conectar;

public class Cliente_DetalhaRelatorio extends JFrame implements ActionListener {
	Connection conexao = Conectar.getConnection();
	JPanel pnPrincipal;
	JTable table;
	JScrollPane scrollTabel;
	String idrelatorio;
	JTextField lblIdRelatorio, lblSolicitante;
	private JTextField lblVisibilidade;
	private JTextField lblDataFinal;
	private JTextField lblDataInicial;
	private JTextField lblDptoSolicitante;
	private JScrollPane scrollTabel2;
	private JTable table2;
	JButton btnDetalhar;
	int Visibilidade;

	public Cliente_DetalhaRelatorio(String idrelatorio) throws SQLException {
		this.idrelatorio = idrelatorio;
		setTitle("BitWise - Relatorios");
		setBounds(100, 100, 900, 700);
		componentes();
		carregaPerguntas();
	}

	private void componentes() {
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new LineBorder(Color.GRAY, 1, true));
		pnPrincipal.setBackground(Color.WHITE);
		pnPrincipal.setBounds(0, 0, 900, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().add(pnPrincipal, BorderLayout.CENTER);
		pnPrincipal.setLayout(null);

		DefaultTableModel tableModel = new DefaultTableModel(
				new String[] { "Sequencia", "Pergunta", "Media", "Quantidade de respostas" }, 0) {
			public boolean isCellEdittable(int row, int col) {
				if (col == 3) {
					return false;
				}
				return true;
			}
		};
		DefaultTableModel tableModel2 = new DefaultTableModel(
				new String[] { "Usuario", "Observação", "Nota", "data da resposta" }, 0) {
			public boolean isCellEdittable(int row, int col) {
				if (col == 3) {
					return false;
				}
				return true;
			}
		};
		DefaultTableCellRenderer alinhaDireita = new DefaultTableCellRenderer();
		alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);

		scrollTabel = new JScrollPane();
		scrollTabel.setBounds(10, 110, 865, 119);
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(535);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(75);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollTabel.setViewportView(table);
		pnPrincipal.add(scrollTabel);

		btnDetalhar = new JButton("Detalhar");
		btnDetalhar.setHorizontalAlignment(SwingConstants.CENTER);
		btnDetalhar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnDetalhar.setBounds(340, 250, 185, 23);
		pnPrincipal.add(btnDetalhar);
		btnDetalhar.addActionListener(this);

		scrollTabel2 = new JScrollPane();
		scrollTabel2.setBounds(10, 300, 865, 319);
		table2 = new JTable(tableModel2);
		table2.getColumnModel().getColumn(0).setPreferredWidth(100);
		table2.getColumnModel().getColumn(0).setResizable(false);
		table2.getColumnModel().getColumn(1).setPreferredWidth(535);
//		table2.getColumnModel().getColumn(1).setResizable(false);
		table2.getColumnModel().getColumn(2).setPreferredWidth(75);
		table2.getColumnModel().getColumn(2).setResizable(false);
		table2.getColumnModel().getColumn(3).setPreferredWidth(150);
		table2.getColumnModel().getColumn(3).setResizable(false);
		table2.getTableHeader().setReorderingAllowed(false);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollTabel2.setViewportView(table2);
		pnPrincipal.add(scrollTabel2);

		lblDataInicial = new JTextField();
		lblDataInicial.setText("A campanha começou dia: " + idrelatorio);
		lblDataInicial.setColumns(4);
		lblDataInicial.setBounds(178, 75, 320, 23);
		lblDataInicial.setEditable(false);
		lblDataInicial.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrincipal.add(lblDataInicial);

		lblDataFinal = new JTextField();
		lblDataFinal.setText("A campanha termina dia: " + idrelatorio);
		lblDataFinal.setColumns(4);
		lblDataFinal.setBounds(548, 75, 320, 23);
		lblDataFinal.setEditable(false);
		lblDataFinal.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrincipal.add(lblDataFinal);

		lblIdRelatorio = new JTextField();
		lblIdRelatorio.setText("ID do relatorio: " + idrelatorio);
		lblIdRelatorio.setColumns(4);
		lblIdRelatorio.setBounds(29, 50, 120, 23);
		lblIdRelatorio.setEditable(false);
		lblIdRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrincipal.add(lblIdRelatorio);

		lblSolicitante = new JTextField();
		lblSolicitante.setText("Solicitado por: " + idrelatorio);
		lblSolicitante.setColumns(4);
		lblSolicitante.setBounds(178, 50, 320, 23);
		lblSolicitante.setEditable(false);
		lblSolicitante.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrincipal.add(lblSolicitante);

		lblDptoSolicitante = new JTextField();
		lblDptoSolicitante.setText("Departamento: " + idrelatorio);
		lblDptoSolicitante.setColumns(4);
		lblDptoSolicitante.setBounds(548, 50, 320, 23);
		lblDptoSolicitante.setEditable(false);
		lblDptoSolicitante.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrincipal.add(lblDptoSolicitante);

		lblVisibilidade = new JTextField();
		lblVisibilidade.setText("Visibilidade: " + idrelatorio);
		lblVisibilidade.setColumns(4);
		lblVisibilidade.setBounds(29, 75, 120, 23);
		lblVisibilidade.setEditable(false);
		lblVisibilidade.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrincipal.add(lblVisibilidade);

	}

	private void carregaPerguntas() throws SQLException {

		String sql = "select * from detalherelatorio where questionario='" + idrelatorio + "'";
		PreparedStatement tabela = conexao.prepareStatement(sql);
		ResultSet resultado = tabela.executeQuery();

		while (resultado.next()) {

			DefaultTableModel dtm = (DefaultTableModel) table.getModel();

			dtm.addRow(new Object[] { resultado.getString(1), resultado.getString(2), resultado.getString(3),
					resultado.getString(4) });

		}

		sql = "select * from questionario_dados where id =" + idrelatorio;
		tabela = conexao.prepareStatement(sql);
		resultado = tabela.executeQuery();

		resultado.next();

		Date dfinal = resultado.getDate("datafinal");
		String dataquestionariofinal = new SimpleDateFormat("dd/MM/yyyy").format(dfinal);		
		Date dinicio = resultado.getDate("datainicio");
		String dataquestionarioinicio = new SimpleDateFormat("dd/MM/yyyy").format(dinicio);
		
		lblDataInicial.setText("Data de Inicio da campanha: " + dataquestionarioinicio);
		
		if(dataquestionariofinal.contentEquals(dataquestionarioinicio)) {
		lblDataFinal.setText("Campanha nao possui data prevista para encerramento");
		}else {
		lblDataFinal.setText("Data de encerramento da campanha: " + dataquestionariofinal);	
		}
			
		int usuarioSolicitante = resultado.getInt("UsuarioSolicitante");
		int departamento = resultado.getInt("departamento");
		Visibilidade = resultado.getInt("sigilo");

		if (usuarioSolicitante == 0) {
			lblSolicitante.setText("Sem usuario solicitante");
		} else {
			sql = "select * from usuario where id =" + usuarioSolicitante;
			tabela = conexao.prepareStatement(sql);
			resultado = tabela.executeQuery();
			resultado.next();
			lblSolicitante.setText("Solicitado por: " + resultado.getString("nome"));
		}
		if (departamento == 0) {
			lblDptoSolicitante.setText("Sem departamento especifico");
		} else {
			sql = "select * from departamento where id =" + departamento;
			tabela = conexao.prepareStatement(sql);
			resultado = tabela.executeQuery();
			resultado.next();
			lblDptoSolicitante.setText("Solicitado para: " + resultado.getString("descricao"));
		}
		if (Visibilidade == 0) {
			lblVisibilidade.setText("Publico");
		} else {
			lblVisibilidade.setText("Sigiloso");
		}

	}

	private void detalhaPerguntas() throws SQLException {
		limpaTabela();

		int[] linhas = table.getSelectedRows();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (int i = (linhas.length - 1); i >= 0; --i) {
			String idquestionario = table.getValueAt(linhas[i], 0).toString();
			try {
				String sql = "select * from questionario_respondido a inner join usuario b on (a.usuario=b.id) where a.questionario = " + idrelatorio;
				PreparedStatement tabela = conexao.prepareStatement(sql);
				ResultSet resultado = tabela.executeQuery();

				while (resultado.next()) {
					if (Visibilidade == 0) {
						String sql2 = "select a.valor from questionario_respostas a inner join questionario_itens b "
								+ "on a.questionario_item=b.id where b.questionario = " + idrelatorio+" and b.sequencia="+idquestionario+
								" and a.usuario="+resultado.getInt("usuario");
						PreparedStatement tabela2 = conexao.prepareStatement(sql2);
						ResultSet resultado2 = tabela2.executeQuery();
						resultado2.next();

						DefaultTableModel dtm2 = (DefaultTableModel) table2.getModel();
						dtm2.addRow(new Object[] { resultado.getString("nome"), resultado.getString("obs"),
								resultado2.getString("valor"), resultado.getString("dataresposta") });
					} else {
						DefaultTableModel dtm2 = (DefaultTableModel) table2.getModel();
						dtm2.addRow(new Object[] { resultado.getString("nome"), resultado.getString("obs"),
								"Sigiloso", resultado.getString("dataresposta") });
					}

				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent acao) {
		// TODO Auto-generated method stub
		if (acao.getSource() == btnDetalhar) {
			try {
				detalhaPerguntas();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void limpaTabela() {
		while (table2.getModel().getRowCount() > 0)
			((DefaultTableModel) table2.getModel()).removeRow(0);

	}

}