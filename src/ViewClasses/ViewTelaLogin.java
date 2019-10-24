package ViewClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewTelaLogin extends JFrame {

	private JPanel contentPane;
	protected JTextField txtUsurio;
	
	protected String getUsurio() {
		return txtUsurio.getText();
	}

	protected String getSenha() {
		return txtSenha.getText();
	}

	private JTextField txtSenha;
	protected JButton btnNewButton;
	protected JLabel lblUsurio;
	private JLabel lblSenha;
	private JLabel lblNewLabel_1;
	private JLabel lblEsqueciMinhaSenha;
	private JLabel lblBD;
	private JLabel label;
	private JLabel lblSistemaGerenciadorAdministrativo;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ViewTelaLogin() {
		setTitle("BitWise - Seja Bem Vindo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(false);
		setLocationRelativeTo(null);
		setResizable(false);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ViewTelaLogin.class.getResource("/img/icon-usuario.png")));
		label.setBounds(190, 137, 106, 108);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaLogin.class.getResource("/img/logo-bitwise.png")));
		lblNewLabel.setBounds(91, 25, 250, 128);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(41, 185, 404, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsurio = new JTextField();
		txtUsurio.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsurio.setBackground(SystemColor.control);
		txtUsurio.setBounds(86, 121, 274, 40);
		panel.add(txtUsurio);
		txtUsurio.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setHorizontalAlignment(SwingConstants.LEFT);
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setBackground(SystemColor.control);
		txtSenha.setBounds(86, 172, 274, 40);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		btnNewButton = new JButton("ACESSAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(86, 231, 274, 50);
		panel.add(btnNewButton);
		
		lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsurio.setFont(new Font("Arial", Font.BOLD, 14));
		lblUsurio.setBounds(22, 134, 54, 14);
		panel.add(lblUsurio);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setBounds(22, 185, 54, 14);
		panel.add(lblSenha);
		
		lblNewLabel_1 = new JLabel("Bem-Vindo");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 73, 384, 27);
		panel.add(lblNewLabel_1);
		
		lblEsqueciMinhaSenha = new JLabel("Esqueci minha senha");
		lblEsqueciMinhaSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsqueciMinhaSenha.setForeground(Color.GRAY);
		lblEsqueciMinhaSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEsqueciMinhaSenha.setBounds(89, 293, 271, 27);
		panel.add(lblEsqueciMinhaSenha);
		
		
		lblBD = new JLabel("");
		lblBD.setHorizontalAlignment(SwingConstants.CENTER);
		lblBD.setForeground(Color.GRAY);
		lblBD.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBD.setBounds(89, 293, 271, 70);
		panel.add(lblBD);
		
		
		lblSistemaGerenciadorAdministrativo = new JLabel("Sistema Gerenciador Administrativo BitWise - Vers\u00E3o 1.0.0");
		lblSistemaGerenciadorAdministrativo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSistemaGerenciadorAdministrativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaGerenciadorAdministrativo.setBounds(20, 571, 435, 14);
		contentPane.add(lblSistemaGerenciadorAdministrativo);
		
		

	}

	public void setLblBD(String texto, Color cor) {
		
		this.lblBD.setForeground(cor);
		this.lblBD.setText(texto) ;
	}
}
