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
import java.awt.Window.Type;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;

public class ADM_Menu extends JFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADM_Menu frame = new ADM_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ADM_Menu() {
		setTitle("BitWise - \u00C1rea do Administrador");
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
		label.setIcon(new ImageIcon(ADM_Menu.class.getResource("/img/logo-bitwise-reduzido.png")));
		label.setBounds(27, 21, 200, 102);
		contentPane.add(label);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.GRAY);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMenu.setBounds(27, 167, 73, 29);
		contentPane.add(lblMenu);
		
		JLabel lblCad_Cliente = new JLabel("");
		lblCad_Cliente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCad_Cliente.setIcon(new ImageIcon(ADM_Menu.class.getResource("/img/icon-adm_menu_cad_cliente.png")));
		lblCad_Cliente.setBounds(27, 207, 20, 34);
		contentPane.add(lblCad_Cliente);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrarCliente.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadastrarCliente.setBounds(57, 216, 150, 25);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnCadastrarSenha = new JButton("Cadastrar Senha");
		btnCadastrarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrarSenha.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadastrarSenha.setBounds(57, 254, 150, 23);
		contentPane.add(btnCadastrarSenha);
		
		JPanel panel = new JPanel();
		panel.setBounds(277, 11, 478, 514);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Boas_Vindas = new JLabel("Ol\u00E1, <nome> seja bem-vindo. ");
		lbl_Boas_Vindas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Boas_Vindas.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_Boas_Vindas.setBounds(88, 74, 306, 14);
		panel.add(lbl_Boas_Vindas);
		
		JLabel lblEscolhaOpcao = new JLabel("Escolha uma op\u00E7\u00E3o no menu ao lado. ");
		lblEscolhaOpcao.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaOpcao.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEscolhaOpcao.setBounds(88, 156, 306, 14);
		panel.add(lblEscolhaOpcao);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ADM_Menu.class.getResource("/img/engrenagem.png")));
		label_2.setBounds(167, 181, 150, 162);
		panel.add(label_2);
		
		JLabel lblSuporte = new JLabel("Suporte t\u00E9cnico: 011-1111-1111 - ramal: 11");
		lblSuporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuporte.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSuporte.setBounds(88, 375, 306, 14);
		panel.add(lblSuporte);
		
		JLabel lblCadSenha = new JLabel("");
		lblCadSenha.setIcon(new ImageIcon(ADM_Menu.class.getResource("/img/icon-adm_menu_cad_senha.png")));
		lblCadSenha.setBounds(27, 252, 20, 25);
		contentPane.add(lblCadSenha);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSair.setBounds(57, 288, 150, 23);
		contentPane.add(btnSair);
		
		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon(ADM_Menu.class.getResource("/img/iconsair.png")));
		lblSair.setBounds(27, 288, 20, 25);
		contentPane.add(lblSair);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		
		
	}
}
