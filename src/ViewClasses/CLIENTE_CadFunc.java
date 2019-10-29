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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.JMenu;
import javax.swing.JProgressBar;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class CLIENTE_CadFunc extends JFrame {

	private JPanel contentPane;

	protected String getEmpresa() {
		return txtEmpresa.getText();
	}

	protected String getNome() {
		return txtNome.getText();
	}

	protected String getSetor() {
		return txtSetor.getText();
	}

	protected String getEmail() {
		return txtEmail.getText();
	}

	protected String getSenha() {
		return txtSenha.getText();
	}

	protected String getStatus() {
		return comboBoxStatus.getActionCommand();
	}

	private JTextField txtEmpresa;
	private JTextField txtNome;
	private JTextField txtSetor;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JComboBox comboBoxStatus;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CLIENTE_CadFunc frame = new CLIENTE_CadFunc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CLIENTE_CadFunc() {
		setTitle("BitWise - Cadastramento Funcion\u00E1rio");
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
		label.setIcon(new ImageIcon(CLIENTE_CadFunc.class.getResource("/img/logo-bitwise-reduzido.png")));
		label.setBounds(27, 21, 200, 102);
		contentPane.add(label);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.GRAY);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMenu.setBounds(27, 167, 73, 29);
		contentPane.add(lblMenu);

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

		JLabel lbl_CadFuncionario = new JLabel("CADASTRAR FUNCIONARIO");
		lbl_CadFuncionario.setBounds(118, 36, 246, 14);
		panel_1.add(lbl_CadFuncionario);
		lbl_CadFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CadFuncionario.setFont(new Font("Verdana", Font.BOLD, 14));

		JLabel label_2 = new JLabel("");
		label_2.setBounds(106, 25, 25, 34);
		panel_1.add(label_2);
		label_2.setIcon(new ImageIcon(CLIENTE_CadFunc.class.getResource("/img/icon-cliente_menu_cadfunc_azul.png")));
		label_2.setFont(new Font("Verdana", Font.BOLD, 14));

		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpresa.setForeground(Color.GRAY);
		lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpresa.setBounds(34, 91, 80, 20);
		panel_1.add(lblEmpresa);

		JLabel lblFuncionario = new JLabel("Nome:");
		lblFuncionario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuncionario.setForeground(Color.GRAY);
		lblFuncionario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFuncionario.setBounds(34, 131, 80, 20);
		panel_1.add(lblFuncionario);

		JLabel lblDepartamento = new JLabel("Setor:");
		lblDepartamento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartamento.setForeground(Color.GRAY);
		lblDepartamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartamento.setBounds(34, 172, 80, 20);
		panel_1.add(lblDepartamento);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(34, 210, 80, 20);
		panel_1.add(lblEmail);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setForeground(Color.GRAY);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(34, 249, 80, 20);
		panel_1.add(lblSenha);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setForeground(Color.GRAY);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(34, 291, 80, 20);
		panel_1.add(lblStatus);

		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(118, 88, 246, 30);
		panel_1.add(txtEmpresa);
		txtEmpresa.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(118, 128, 246, 30);
		panel_1.add(txtNome);

		JTextField txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(118, 169, 246, 30);
		panel_1.add(txtDepartamento);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(118, 207, 246, 30);
		panel_1.add(txtEmail);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(118, 246, 246, 30);
		panel_1.add(txtSenha);

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(28, 380, 116, 23);
		panel_1.add(btnSalvar);

		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(151, 380, 116, 23);
		panel_1.add(btnAlterar);

		JButton btnLozalizar = new JButton("LOCALIZAR");
		btnLozalizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLozalizar.setBounds(272, 380, 116, 23);
		panel_1.add(btnLozalizar);

		JLabel lblMensagemRetorno = new JLabel("Cadastro realizado com sucesso");
		lblMensagemRetorno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagemRetorno.setForeground(Color.RED);
		lblMensagemRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemRetorno.setBounds(52, 414, 330, 44);
		panel_1.add(lblMensagemRetorno);

		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setBounds(118, 288, 246, 30);
		panel_1.add(comboBoxStatus);
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

		JLabel lblCadFuncionario = new JLabel("");
		lblCadFuncionario
				.setIcon(new ImageIcon(CLIENTE_CadFunc.class.getResource("/img/icon-cliente_menu_cadfunc_azul.png")));
		lblCadFuncionario.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCadFuncionario.setBounds(27, 217, 20, 25);
		contentPane.add(lblCadFuncionario);

		JButton btnCadFunc = new JButton("Cadastrar Funcion\u00E1rio");
		btnCadFunc.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadFunc.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadFunc.setBounds(57, 217, 185, 25);
		contentPane.add(btnCadFunc);

		JLabel lblQuestionario = new JLabel("");
		lblQuestionario.setIcon(
				new ImageIcon(CLIENTE_CadFunc.class.getResource("/img/icon-cliente_menu_cadquestionario_cinza.png")));
		lblQuestionario.setBounds(27, 253, 20, 25);
		contentPane.add(lblQuestionario);

		JButton btnCadQuestionario = new JButton("Question\u00E1rio");
		btnCadQuestionario.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadQuestionario.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadQuestionario.setBounds(57, 255, 185, 23);
		contentPane.add(btnCadQuestionario);

		JLabel lblRelatorio = new JLabel("");
		lblRelatorio.setIcon(
				new ImageIcon(CLIENTE_CadFunc.class.getResource("/img/icon-cliente_menu_relatorio_cinza.png")));
		lblRelatorio.setBounds(27, 287, 20, 25);
		contentPane.add(lblRelatorio);

		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setHorizontalAlignment(SwingConstants.LEFT);
		btnRelatrio.setFont(new Font("Verdana", Font.BOLD, 12));
		btnRelatrio.setBounds(57, 289, 185, 23);
		contentPane.add(btnRelatrio);

		JButton btnSair = new JButton("Sair");
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSair.setBounds(57, 323, 185, 23);
		contentPane.add(btnSair);

		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon(CLIENTE_CadFunc.class.getResource("/img/iconsair.png")));
		lblSair.setBounds(27, 323, 20, 25);
		contentPane.add(lblSair);

		setResizable(false);
		setLocationRelativeTo(null);
	}
}
