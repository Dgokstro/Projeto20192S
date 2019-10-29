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

public class ADM_CadSenha extends JFrame {

	private JPanel contentPane;

	protected String getCNPJ() {
		return txtCNPJ.getText();
	}

	protected String getNome() {
		return txtNome.getText();
	}

	protected String getEmail() {
		return txtEmail.getText();
	}

	protected String getSenha() {
		return txtSenha.getText();
	}

	private JTextField txtCNPJ;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtSenha;
	protected JButton btnCadCliente;
	protected JButton btnSalvar;
	protected JButton btnSair;
	private JLabel lblMensagemRetorno;
	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ADM_CadSenha frame = new
	 * ADM_CadSenha(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public ADM_CadSenha() {
		setTitle("BitWise - Cadastramento Senha");
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
		label.setIcon(new ImageIcon(ADM_CadSenha.class.getResource("/img/logo-bitwise-reduzido.png")));
		label.setBounds(27, 21, 200, 102);
		contentPane.add(label);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.GRAY);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMenu.setBounds(27, 167, 73, 29);
		contentPane.add(lblMenu);

		JLabel lblCadCliente = new JLabel("");
		lblCadCliente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCadCliente.setIcon(new ImageIcon(ADM_CadSenha.class.getResource("/img/icon-adm_menu_cad_cliente.png")));
		lblCadCliente.setBounds(27, 207, 20, 34);
		contentPane.add(lblCadCliente);

		btnCadCliente = new JButton("Cadastrar Cliente");
		btnCadCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadCliente.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadCliente.setBounds(57, 216, 150, 25);
		contentPane.add(btnCadCliente);

		JButton btnCadSenha = new JButton("Cadastrar Senha");
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

		JLabel lbl_CadSenha = new JLabel("CADASTRAR SENHA");
		lbl_CadSenha.setBounds(88, 36, 292, 14);
		panel_1.add(lbl_CadSenha);
		lbl_CadSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CadSenha.setFont(new Font("Verdana", Font.BOLD, 14));

		JLabel label_2 = new JLabel("");
		label_2.setBounds(125, 25, 25, 34);
		panel_1.add(label_2);
		label_2.setIcon(new ImageIcon(ADM_CadSenha.class.getResource("/img/icon-adm_menu_cad_senha-azul.png")));
		label_2.setFont(new Font("Verdana", Font.BOLD, 14));

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnpj.setForeground(Color.GRAY);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCnpj.setBounds(34, 91, 80, 20);
		panel_1.add(lblCnpj);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(Color.GRAY);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(34, 131, 80, 20);
		panel_1.add(lblNome);

		JLabel lblEmail = new JLabel("EMail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(34, 172, 80, 20);
		panel_1.add(lblEmail);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setForeground(Color.GRAY);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(34, 210, 80, 20);
		panel_1.add(lblSenha);

		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(118, 88, 246, 30);
		panel_1.add(txtCNPJ);
		txtCNPJ.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(118, 128, 246, 30);
		panel_1.add(txtNome);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(118, 169, 246, 30);
		panel_1.add(txtEmail);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(118, 207, 246, 30);
		panel_1.add(txtSenha);

		btnSalvar = new JButton("SALVAR");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(166, 260, 116, 23);
		panel_1.add(btnSalvar);

		lblMensagemRetorno = new JLabel("");
		lblMensagemRetorno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagemRetorno.setForeground(Color.RED);
		lblMensagemRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemRetorno.setBounds(77, 294, 292, 44);
		panel_1.add(lblMensagemRetorno);

		JLabel lblCadSenha = new JLabel("");
		lblCadSenha.setIcon(new ImageIcon(ADM_CadSenha.class.getResource("/img/icon-adm_menu_cad_senha-azul.png")));
		lblCadSenha.setBounds(27, 252, 20, 25);
		contentPane.add(lblCadSenha);

		btnSair = new JButton("Sair");
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSair.setBounds(57, 288, 150, 23);
		contentPane.add(btnSair);

		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon(ADM_CadSenha.class.getResource("/img/iconsair.png")));
		lblSair.setBounds(27, 288, 20, 25);
		contentPane.add(lblSair);

		setResizable(false);
		setLocationRelativeTo(null);
	}

	public void setRetorno(String msg, Color cor) {
		this.lblMensagemRetorno.setText(msg);
		this.lblMensagemRetorno.setForeground(cor);
	}
}
