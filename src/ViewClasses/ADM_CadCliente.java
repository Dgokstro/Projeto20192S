package ViewClasses;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class ADM_CadCliente extends JFrame {

	private JPanel contentPane;

	protected String getCNPJ() {
		return txtCNPJ.getText();
	}

	protected String getEmpresa() {
		return txtEmpresa.getText();
	}

	protected String getEndereco() {
		return txtEndereco.getText();
	}

	protected String getCidade() {
		return txtCidade.getText();
	}

	protected String getUF() {
		return txtUF.getText();
	}

	protected String getTelefone() {
		return txtTelefone.getText();
	}

	protected String getEmail() {
		return txtEmail.getText();
	}

	protected void setRetorno(String msg, Color cor) {
		this.lblMensagemRetorno.setText(msg);
		this.lblMensagemRetorno.setForeground(cor);
	}

	public void setTxtCNPJeditable(boolean editavel) {
		this.txtCNPJ.setEditable(editavel);
	}

	public void setTxtEmpresa(String txtEmpresa) {
		this.txtEmpresa.setText(txtEmpresa);
	}

	public void setTxtEndereco(String txtEndereco) {
		this.txtEndereco.setText(txtEndereco);
	}

	public void setTxtCidade(String txtCidade) {
		this.txtCidade.setText(txtCidade);
	}

	public void setTxtUF(String txtUF) {
		this.txtUF.setText(txtUF);
	}

	public void setTxtTelefone(String txtTelefone) {
		this.txtTelefone.setText(txtTelefone);
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}

	private JTextField txtCNPJ;
	private JTextField txtEmpresa;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtUF;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	protected JButton btnSalvar;
	protected JButton btnSair;
	protected JButton btnLocalizar;
	protected JButton btnAlterar;
	private JLabel lblMensagemRetorno;
	protected JButton btnCadSenha;
	protected JButton btnCadCliente;
	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ADM_CadCliente frame = new
	 * ADM_CadCliente(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ADM_CadCliente() {
		setTitle("BitWise - Cadastramento Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblData = new JLabel();
		lblData.setText(new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format(new Date(System.currentTimeMillis())));
		lblData.setForeground(Color.GRAY);
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblData.setBounds(113, 87, 206, 14);
		contentPane.add(lblData);

		JLabel labelRodape = new JLabel("Sistema Gerenciador Administrativo BitWise - Vers\u00E3o 1.0.0");
		labelRodape.setHorizontalAlignment(SwingConstants.CENTER);
		labelRodape.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelRodape.setBounds(175, 536, 435, 14);
		contentPane.add(labelRodape);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ADM_CadCliente.class.getResource("/img/logo-bitwise-reduzido.png")));
		label.setBounds(27, 21, 200, 102);
		contentPane.add(label);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.GRAY);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMenu.setBounds(27, 167, 73, 29);
		contentPane.add(lblMenu);

		JLabel lblCad_Cliente = new JLabel("");
		lblCad_Cliente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCad_Cliente
				.setIcon(new ImageIcon(ADM_CadCliente.class.getResource("/img/icon-adm_menu_cad_cliente-azul.png")));
		lblCad_Cliente.setBounds(27, 207, 20, 34);
		contentPane.add(lblCad_Cliente);

		btnCadCliente = new JButton("Cadastrar Cliente");
		btnCadCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadCliente.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadCliente.setBounds(57, 216, 150, 25);
		contentPane.add(btnCadCliente);

		JLabel lblCadSenha = new JLabel("");
		lblCadSenha.setIcon(new ImageIcon(ADM_CadCliente.class.getResource("/img/icon-adm_menu_cad_senha.png")));
		lblCadSenha.setBounds(27, 252, 20, 25);
		contentPane.add(lblCadSenha);

		btnCadSenha = new JButton("Cadastrar Senha");
		btnCadSenha.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadSenha.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadSenha.setBounds(57, 254, 150, 23);
		contentPane.add(btnCadSenha);

		JPanel panel = new JPanel();
		panel.setForeground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel.setBounds(277, 11, 478, 514);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 22, 412, 469);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lbl_CadCliente = new JLabel("CADASTRAR CLIENTE");
		lbl_CadCliente.setBounds(77, 36, 287, 14);
		panel_1.add(lbl_CadCliente);
		lbl_CadCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CadCliente.setFont(new Font("Verdana", Font.BOLD, 14));

		JLabel label_2 = new JLabel("");
		label_2.setBounds(106, 25, 25, 34);
		panel_1.add(label_2);
		label_2.setIcon(new ImageIcon(ADM_CadCliente.class.getResource("/img/icon-adm_menu_cad_cliente-azul.png")));
		label_2.setFont(new Font("Verdana", Font.BOLD, 14));

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnpj.setForeground(Color.GRAY);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCnpj.setBounds(34, 91, 80, 20);
		panel_1.add(lblCnpj);

		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpresa.setForeground(Color.GRAY);
		lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpresa.setBounds(34, 131, 80, 20);
		panel_1.add(lblEmpresa);

		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setForeground(Color.GRAY);
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereco.setBounds(34, 172, 80, 20);
		panel_1.add(lblEndereco);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setForeground(Color.GRAY);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCidade.setBounds(34, 210, 80, 20);
		panel_1.add(lblCidade);

		JLabel lblUF = new JLabel("UF:");
		lblUF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUF.setForeground(Color.GRAY);
		lblUF.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUF.setBounds(34, 249, 80, 20);
		panel_1.add(lblUF);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setForeground(Color.GRAY);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(34, 287, 80, 20);
		panel_1.add(lblTelefone);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(34, 324, 80, 20);
		panel_1.add(lblEmail);

		// Aqui começa o bloco de campos do formulário

		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(118, 88, 246, 30);
		panel_1.add(txtCNPJ);
		txtCNPJ.setColumns(10);

		txtEmpresa = new JTextField();
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(118, 128, 246, 30);
		panel_1.add(txtEmpresa);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(118, 169, 246, 30);
		panel_1.add(txtEndereco);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(118, 207, 246, 30);
		panel_1.add(txtCidade);

		txtUF = new JTextField();
		txtUF.setColumns(10);
		txtUF.setBounds(118, 246, 246, 30);
		panel_1.add(txtUF);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(118, 284, 246, 30);
		panel_1.add(txtTelefone);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(118, 321, 246, 30);
		panel_1.add(txtEmail);

		// Aqui termina o bloco de campos do fomulário

		btnSalvar = new JButton("SALVAR");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(28, 380, 116, 23);
		panel_1.add(btnSalvar);

		btnAlterar = new JButton("ALTERAR");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(151, 380, 116, 23);
		panel_1.add(btnAlterar);

		btnLocalizar = new JButton("LOCALIZAR");
		btnLocalizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLocalizar.setBounds(272, 380, 116, 23);
		panel_1.add(btnLocalizar);

		lblMensagemRetorno = new JLabel("");
		lblMensagemRetorno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagemRetorno.setForeground(Color.RED);
		lblMensagemRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemRetorno.setBounds(52, 414, 330, 44);
		panel_1.add(lblMensagemRetorno);

		btnSair = new JButton("Sair");
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSair.setBounds(57, 288, 150, 23);
		contentPane.add(btnSair);

		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon(ADM_CadCliente.class.getResource("/img/iconsair.png")));
		lblSair.setBounds(27, 288, 20, 25);
		contentPane.add(lblSair);

		setResizable(false);
		setLocationRelativeTo(null);
	}
}
