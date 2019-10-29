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

public class CLIENTE_Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CLIENTE_Menu frame = new CLIENTE_Menu();
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
	public CLIENTE_Menu() {
		setTitle("BitWise - \u00C1rea do Cliente");
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
		label.setIcon(new ImageIcon(CLIENTE_Menu.class.getResource("/img/logo-bitwise-reduzido.png")));
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
				.setIcon(new ImageIcon(CLIENTE_Menu.class.getResource("/img/icon-cliente_menu_cadfunc_cinza.png")));
		lblCad_Cliente.setBounds(27, 216, 20, 25);
		contentPane.add(lblCad_Cliente);

		JButton btnCadFunc = new JButton("Cadastrar Funcion\u00E1rio");
		btnCadFunc.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadFunc.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadFunc.setBounds(57, 216, 185, 25);
		contentPane.add(btnCadFunc);

		JButton btnCadQuestionario = new JButton("Question\u00E1rio");
		btnCadQuestionario.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadQuestionario.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadQuestionario.setBounds(57, 254, 185, 23);
		contentPane.add(btnCadQuestionario);

		JPanel panel = new JPanel();
		panel.setBounds(277, 11, 478, 514);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_Boas_Vindas = new JLabel("Ol\u00E1, <nome> seja bem-vindo. ");
		lbl_Boas_Vindas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Boas_Vindas.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_Boas_Vindas.setBounds(88, 119, 306, 14);
		panel.add(lbl_Boas_Vindas);

		JLabel lblEscolhaOpcao = new JLabel("Escolha uma op\u00E7\u00E3o no menu ao lado. ");
		lblEscolhaOpcao.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaOpcao.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEscolhaOpcao.setBounds(88, 156, 306, 14);
		panel.add(lblEscolhaOpcao);

		JLabel lbl_engrenagem = new JLabel("");
		lbl_engrenagem.setIcon(new ImageIcon(CLIENTE_Menu.class.getResource("/img/engrenagem.png")));
		lbl_engrenagem.setBounds(167, 181, 150, 162);
		panel.add(lbl_engrenagem);

		JLabel lblSuporte = new JLabel("Suporte t\u00E9cnico: 011-1111-1111 - ramal: 11");
		lblSuporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuporte.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSuporte.setBounds(88, 375, 306, 14);
		panel.add(lblSuporte);

		JLabel lbl_Empresa = new JLabel("<EMPRESA>");
		lbl_Empresa.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Empresa.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_Empresa.setBounds(88, 86, 306, 14);
		panel.add(lbl_Empresa);

		JLabel lblCad_Questionario = new JLabel("");
		lblCad_Questionario.setIcon(
				new ImageIcon(CLIENTE_Menu.class.getResource("/img/icon-cliente_menu_cadquestionario_cinza.png")));
		lblCad_Questionario.setBounds(27, 252, 20, 25);
		contentPane.add(lblCad_Questionario);

		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setHorizontalAlignment(SwingConstants.LEFT);
		btnRelatrio.setFont(new Font("Verdana", Font.BOLD, 12));
		btnRelatrio.setBounds(57, 288, 185, 23);
		contentPane.add(btnRelatrio);

		JLabel lblRelatorio = new JLabel("");
		lblRelatorio
				.setIcon(new ImageIcon(CLIENTE_Menu.class.getResource("/img/icon-cliente_menu_relatorio_cinza.png")));
		lblRelatorio.setBounds(27, 286, 20, 25);
		contentPane.add(lblRelatorio);

		JButton btnSair = new JButton("Sair");
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSair.setBounds(57, 322, 185, 23);
		contentPane.add(btnSair);

		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon(CLIENTE_Menu.class.getResource("/img/iconsair.png")));
		lblSair.setBounds(27, 322, 20, 25);
		contentPane.add(lblSair);

		setResizable(false);
		setLocationRelativeTo(null);
	}
}
