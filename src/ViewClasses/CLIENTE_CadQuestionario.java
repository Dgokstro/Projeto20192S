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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.mysql.jdbc.Statement;

import BDConexao.Conectar;
import BDConexao.Departamento;
import BDConexao.Funcionario;

public class CLIENTE_CadQuestionario extends JFrame implements ActionListener {

	Connection conexao = Conectar.getConnection();
	JPanel pnPrincipal, pnTable;
	JButton btRemover, btAdicionar;
	JScrollPane scrollTabel;
	JTable table;
	JLabel lblPergunta;
	JTextField txtPergunta;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lbl_CadQuestionario;
	private JLabel label_1;
	private JLabel lblDescricao;
	private JLabel lblSolicitante;
	private JTextField txtDescricao;
	private JComboBox comboBoxSolicitante;
	private JLabel lblSetor;
	private JComboBox comboBoxSetor;
	private JFormattedTextField txtDataInicio;
	private JLabel label_5;
	private JFormattedTextField txtDataFim;
	private JLabel lblVigencia;
	private JLabel lblVisbilidade;
	private JComboBox comboVisibilidade;
	private JButton btnGravar;
	private JLabel lblMensagemRetorno;
	private String idempresa;
	private String idusuario;
	private JButton btnCadFunc;
	private JButton btnCadQuestionario;
	private JButton btnRelatorio;
	private JButton btnMenuDepartamento;
	private JButton btnSair;

	public CLIENTE_CadQuestionario(String idempresa, String idusuario) throws SQLException {
		this.idempresa = idempresa;
		this.idusuario = idusuario;
		setTitle("BitWise - Cadastramento Questionario");
		setBounds(100, 100, 900, 700);
		componentes();
		Eventos();
		listaSolicitante();
		addDpto(idempresa);
	}

	public void componentes() {
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new EmptyBorder(5, 0, 0, 5));
		pnPrincipal.setBackground(Color.WHITE);
		pnPrincipal.setBounds(0, 0, 900, 700);

		setResizable(false);
		setLocationRelativeTo(null);
		DefaultTableModel tableModel = new DefaultTableModel(new String[] { "Perguntas inseridas" }, 0) {
			public boolean isCellEdittable(int row, int col) {
				if (col == 3) {
					return false;
				}
				return true;
			}
		};
		DefaultTableCellRenderer alinhaDireita = new DefaultTableCellRenderer();
		alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(pnPrincipal, BorderLayout.CENTER);
		pnPrincipal.setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel.setBounds(263, 22, 596, 609);
		pnPrincipal.add(panel);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 22, 536, 511);
		panel.add(panel_1);

		lbl_CadQuestionario = new JLabel("CADASTRAR QUESTIONARIO");
		lbl_CadQuestionario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CadQuestionario.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_CadQuestionario.setBounds(155, 22, 246, 14);
		panel_1.add(lbl_CadQuestionario);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(
				CLIENTE_CadQuestionario.class.getResource("/img/icon-cliente_menu_cadquestionario_cinza.png")));
		label_1.setFont(new Font("Verdana", Font.BOLD, 14));
		label_1.setBounds(137, 11, 25, 34);
		panel_1.add(label_1);

		lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao.setForeground(Color.GRAY);
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescricao.setBounds(24, 149, 80, 20);
		panel_1.add(lblDescricao);

		lblSolicitante = new JLabel("Solicitante:");
		lblSolicitante.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSolicitante.setForeground(Color.GRAY);
		lblSolicitante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSolicitante.setBounds(24, 64, 80, 20);
		panel_1.add(lblSolicitante);

		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(118, 146, 397, 30);
		panel_1.add(txtDescricao);

		comboBoxSolicitante = new JComboBox();
		comboBoxSolicitante.setBounds(118, 61, 162, 30);
		panel_1.add(comboBoxSolicitante);
		comboBoxSolicitante.setModel(new DefaultComboBoxModel(new String[] { "Sem solicitante" }));

		lblSetor = new JLabel("Setor:");
		lblSetor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetor.setForeground(Color.GRAY);
		lblSetor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSetor.setBounds(280, 64, 59, 20);
		panel_1.add(lblSetor);

		comboBoxSetor = new JComboBox();
		comboBoxSetor.setBounds(349, 61, 166, 30);
		panel_1.add(comboBoxSetor);
		comboBoxSetor.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));

		txtDataInicio = new JFormattedTextField(Mascara("##/##/####"));
		txtDataInicio.setBounds(118, 102, 76, 30);
		panel_1.add(txtDataInicio);
		txtDataInicio.setText(new SimpleDateFormat("dd'/'MM'/'yyyy").format(new Date(System.currentTimeMillis())));

		label_5 = new JLabel("at\u00E9");
		label_5.setBounds(204, 102, 18, 25);
		panel_1.add(label_5);

		txtDataFim = new JFormattedTextField(Mascara("##/##/####"));
		txtDataFim.setBounds(232, 102, 76, 30);
		panel_1.add(txtDataFim);

		lblVigencia = new JLabel("Vig\u00EAncia");
		lblVigencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVigencia.setForeground(Color.GRAY);
		lblVigencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVigencia.setBounds(24, 107, 80, 20);
		panel_1.add(lblVigencia);

		lblVisbilidade = new JLabel("Visibilidade:");
		lblVisbilidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisbilidade.setForeground(Color.GRAY);
		lblVisbilidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVisbilidade.setBounds(307, 107, 97, 20);
		panel_1.add(lblVisbilidade);

		comboVisibilidade = new JComboBox();
		comboVisibilidade.setBounds(414, 102, 101, 30);
		panel_1.add(comboVisibilidade);
		comboVisibilidade.setModel(new DefaultComboBoxModel(new String[] { "Publico", "Privado" }));

		lblPergunta = new JLabel("Pergunta:");
		lblPergunta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPergunta.setForeground(Color.GRAY);
		lblPergunta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPergunta.setBounds(24, 185, 80, 25);
		panel_1.add(lblPergunta);
		txtPergunta = new JTextField();
		txtPergunta.setBounds(118, 187, 397, 30);
		panel_1.add(txtPergunta);
		btAdicionar = new JButton("Adicionar");
		btAdicionar.setBounds(204, 232, 100, 22);
		panel_1.add(btAdicionar);
		btAdicionar.setToolTipText("Adicionar uma pergunta");
		btRemover = new JButton("Remover");
		btRemover.setBounds(314, 232, 100, 22);
		panel_1.add(btRemover);
		btRemover.setToolTipText("Remover um item ao pedido");
		pnTable = new JPanel(new BorderLayout());
		pnTable.setBounds(24, 281, 491, 219);
		panel_1.add(pnTable);
		pnTable.setBorder(new TitledBorder("Quadro de perguntas"));
		scrollTabel = new JScrollPane();
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(478);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollTabel.setViewportView(table);
		pnTable.add(scrollTabel);

		btnGravar = new JButton("GRAVAR");
		btnGravar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGravar.setBounds(224, 544, 140, 23);
		panel.add(btnGravar);
		btnGravar.addActionListener(this);

		lblMensagemRetorno = new JLabel("");
		lblMensagemRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemRetorno.setForeground(Color.RED);
		lblMensagemRetorno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagemRetorno.setBounds(130, 576, 330, 23);
		panel.add(lblMensagemRetorno);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(CLIENTE_CadQuestionario.class.getResource("/img/logo-bitwise-reduzido.png")));
		label_8.setBounds(27, 23, 200, 102);
		pnPrincipal.add(label_8);

		JLabel lblData = new JLabel();
		lblData.setText(new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format(new Date(System.currentTimeMillis())));
		lblData.setForeground(Color.GRAY);
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblData.setBounds(117, 88, 206, 14);
		pnPrincipal.add(lblData);

		JLabel label_11 = new JLabel("Menu");
		label_11.setForeground(Color.GRAY);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_11.setBounds(27, 157, 73, 29);
		pnPrincipal.add(label_11);

		btnCadFunc = new JButton("Cadastrar Funcion\u00E1rio");
		btnCadFunc.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadFunc.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadFunc.setBounds(57, 207, 185, 25);
		pnPrincipal.add(btnCadFunc);
		btnCadFunc.addActionListener(this);

		JLabel lblCadFuncionario = new JLabel("");
		lblCadFuncionario.setIcon(
				new ImageIcon(CLIENTE_CadQuestionario.class.getResource("/img/icon-cliente_menu_cadfunc_cinza.png")));
		lblCadFuncionario.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCadFuncionario.setBounds(27, 207, 20, 25);
		pnPrincipal.add(lblCadFuncionario);

		JLabel lblQuestionario = new JLabel("");
		lblQuestionario.setIcon(
				new ImageIcon(CLIENTE_CadQuestionario.class.getResource("/img/icon-cliente_menu_cadfunc_cinza.png")));
		lblQuestionario.setBounds(27, 243, 20, 25);
		pnPrincipal.add(lblQuestionario);

		btnCadQuestionario = new JButton("Question\u00E1rio");
		btnCadQuestionario.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadQuestionario.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadQuestionario.setBounds(57, 245, 185, 23);
		pnPrincipal.add(btnCadQuestionario);
		btnCadQuestionario.addActionListener(this);

		btnRelatorio = new JButton("Relat\u00F3rio");
		btnRelatorio.setHorizontalAlignment(SwingConstants.LEFT);
		btnRelatorio.setFont(new Font("Verdana", Font.BOLD, 12));
		btnRelatorio.setBounds(57, 279, 185, 23);
		pnPrincipal.add(btnRelatorio);
		btnRelatorio.addActionListener(this);

		JLabel lblRelatorio = new JLabel("");
		lblRelatorio.setIcon(
				new ImageIcon(CLIENTE_CadQuestionario.class.getResource("/img/icon-cliente_menu_relatorio_cinza.png")));
		lblRelatorio.setBounds(27, 277, 20, 25);
		pnPrincipal.add(lblRelatorio);

		JLabel lblMenuDepartamento = new JLabel("");
		lblMenuDepartamento
				.setIcon(new ImageIcon(CLIENTE_CadQuestionario.class.getResource("/img/icon-departamento-cinza.png")));
		lblMenuDepartamento.setBounds(27, 313, 20, 25);
		pnPrincipal.add(lblMenuDepartamento);

		btnMenuDepartamento = new JButton("Departamento");
		btnMenuDepartamento.setHorizontalAlignment(SwingConstants.LEFT);
		btnMenuDepartamento.setFont(new Font("Verdana", Font.BOLD, 12));
		btnMenuDepartamento.setBounds(57, 313, 185, 23);
		pnPrincipal.add(btnMenuDepartamento);
		btnMenuDepartamento.addActionListener(this);

		JButton btnSair = new JButton("Sair");
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSair.setBounds(57, 347, 185, 23);
		pnPrincipal.add(btnSair);
		btnSair.addActionListener(this);

		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon(CLIENTE_CadQuestionario.class.getResource("/img/iconsair.png")));
		lblSair.setBounds(27, 347, 20, 25);
		pnPrincipal.add(lblSair);
	}

	public void Eventos() {
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPergunta.getText().equals("")) {
					JOptionPane.showMessageDialog(pnTable, "Preencha todos os campos");
					return;
				}

				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.addRow(new Object[] { txtPergunta.getText() });
				limpar();

			}
		});
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] linhas = table.getSelectedRows();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				for (int i = (linhas.length - 1); i >= 0; --i) {
					dtm.removeRow(linhas[i]);

				}

			}
		});

	}

	private void limpar() {
		txtPergunta.setText("");
		txtPergunta.requestFocus();
	}



	private void listaSolicitante() throws SQLException {
		String sql = "select email from usuario where empresa='" + idempresa + "' and tipo = '3'";
		PreparedStatement tabela = conexao.prepareStatement(sql);
		ResultSet resultado = tabela.executeQuery();
		while (resultado.next()) {
			comboBoxSolicitante.addItem(resultado.getString("email"));
		}

	}

	private void addDpto(String empresa) throws SQLException {
		String sql = "select descricao,id from departamento where empresa='" + empresa + "'";
		PreparedStatement tabela = conexao.prepareStatement(sql);
		ResultSet resultado = tabela.executeQuery();
		while (resultado.next()) {
			comboBoxSetor.addItem(resultado.getString("descricao"));
		}

	}

	private MaskFormatter Mascara(String Mascara) {

		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask(Mascara); // Atribui a mascara
			F_Mascara.setPlaceholderCharacter(' '); // Caracter para preencimento
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return F_Mascara;
	}
	


	private void Gravar() throws SQLException, ParseException {
		int idquestionario;
		String sql;
		
		if (table.getRowCount() > 0 && !txtDescricao.getText().equals("")&& validardata()) {
			sql = "insert into questionario_dados (usuario,descricao,status,usuariosolicitante,datainicio,sigilo,datafinal,departamento) values ('";
			sql += idusuario + "','";
			sql += txtDescricao.getText() + "'," + getstatus() + ",'";
			sql += getusuariosolicitante() + "','";

			sql += getdata(txtDataInicio.getText()) + "','";

			sql += comboVisibilidade.getSelectedIndex() + "','";

			if (txtDataFim.getText().equals("  /  /    ")) {
				sql += getdata(txtDataInicio.getText()) + "','";

			} else {
				sql += getdata(txtDataFim.getText()) + "','";
			}

			sql += getDepartamento() + "')";

			PreparedStatement tabela;
			try {
				tabela = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				tabela.executeUpdate();
				ResultSet keys = tabela.getGeneratedKeys();
				keys.next();
				idquestionario = keys.getInt(1);
				gravaItens(idquestionario);
				lblMensagemRetorno.setText("Questionario cadastrado com sucesso ID = " + idquestionario);
				lblMensagemRetorno.setForeground(Color.green);
				txtDescricao.setText("");
				txtDataInicio.setText("");
				txtDataFim.setText("");

			} catch (SQLException e) {
				lblMensagemRetorno.setText(e.getMessage());
				lblMensagemRetorno.setForeground(Color.red);
			}
		} else {
			JOptionPane.showMessageDialog(pnTable, "Preencha todos os campos corretamente");
		}

	}

	private String getusuariosolicitante() throws SQLException {

		if (comboBoxSolicitante.getSelectedIndex() == 0) {
			return "0";
		} else {

			String solicitante;
			solicitante = comboBoxSolicitante.getSelectedItem().toString();

			String sql = "select id from usuario where empresa='" + idempresa + "' and email = '" + solicitante + "'";
			PreparedStatement tabela = conexao.prepareStatement(sql);
			ResultSet resultado = tabela.executeQuery();
			resultado.next();
			return resultado.getString("id");
		}

	}

	private String getDepartamento() throws SQLException {
		if (comboBoxSetor.getSelectedIndex() == 0) {
			return "0";
		} else {

			String dpto;
			dpto = comboBoxSetor.getSelectedItem().toString();

			String sql = "select id from departamento where empresa='" + idempresa + "' and descricao = '" + dpto + "'";
			PreparedStatement tabela = conexao.prepareStatement(sql);
			ResultSet resultado = tabela.executeQuery();
			resultado.next();
			return resultado.getString("id");
		}

	}

	private String getdata(String data) throws ParseException {
		if (data.equals("  /  /    ")) {
			Date d = new Date();
			String formato = new SimpleDateFormat("yyyy/MM/dd").format(d);
			return formato;
		} else {

			Date d;
			d = (new SimpleDateFormat("dd'/'MM'/'yyyy").parse(data));
			String formato = new SimpleDateFormat("yyyy/MM/dd").format(d);
			return formato;
		}
	}

	public void gravaItens(int idquestionario) throws SQLException {
		for (int linha = 0; linha < table.getRowCount(); linha++) {
			String sql;

			sql = "insert into questionario_itens (questionario,sequencia,descricao,tipo) values (";
			sql += idquestionario + ",";
			sql += (linha + 1) + ",'";
			sql += table.getValueAt(linha, 0);
			sql += "',0)";
			PreparedStatement tabela = conexao.prepareStatement(sql);
			tabela.executeUpdate();
		}

		limpaTabela();
	}
	
	   public void limpaTabela(){
		   while (table.getModel().getRowCount() > 0)
			   ((DefaultTableModel) table.getModel()).removeRow(0);

	    }

	@Override
	public void actionPerformed(ActionEvent acao) {
		// TODO Auto-generated method stub

		if (acao.getSource() == btnGravar) {
			try {
				Gravar();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (acao.getSource() == btnCadFunc) {
			try {
				new Funcionario(idempresa, idusuario).show();
				dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		if (acao.getSource() == btnMenuDepartamento) {

			try {
				new Departamento(idempresa, idusuario).show();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		if (acao.getSource() == btnCadQuestionario) {

			try {
				new CLIENTE_CadQuestionario(idempresa, idusuario).show();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		if (acao.getSource() == btnSair) {
			dispose();
		}
	}

	public int getstatus() {
		int status = 0;

		if (comboBoxSolicitante.getSelectedIndex() == 0) {
			status = 1;
		}

		return status;

	}

	public boolean validardata() throws ParseException {
		
		boolean datavalida= false;
		
		Date inicio = new SimpleDateFormat("yyyy/MM/dd").parse(getdata(txtDataInicio.getText()));
		Date datafinal;
		
		if (txtDataFim.getText().equals("  /  /    ")) {
			datafinal=new SimpleDateFormat("yyyy/MM/dd").parse(getdata(txtDataInicio.getText()));

		} else {
			datafinal=new SimpleDateFormat("yyyy/MM/dd").parse(getdata(txtDataFim.getText()));
		}
		
		if(inicio.compareTo(datafinal)<1) {
			datavalida=true;
		}
		
		return datavalida;
		
	}
}