package BDConexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ViewClasses.ADM_CadCliente;
import ViewClasses.ADM_Menu;
import ViewClasses.ViewTelaLogin;

public class Login extends ViewTelaLogin implements ActionListener {
	// Declara��o dos componentes
	
	

	Connection conexao = Conectar.getConnection();
	// Linha obrigat�ria (Connection)
	String status = Conectar.status;
	private String nome;

	public Login() {
		super();

		btnLogin.addActionListener(this);
		// JOptionPane.showMessageDialog(null, status);
		setLblBD(status, Color.gray);

	}

	private String Consulta_Login() {
		String user = "";
		try {
			String sql;
			sql = "select tipo,nome from usuario" + " where " + "email= '" + getUsuario() + "' and senha='" + getSenha()
					+ "'";
			// sql = inserir comandos
			PreparedStatement tabela = conexao.prepareStatement(sql);
			// preparar �rea de execu��o
			ResultSet resultado = tabela.executeQuery();
			// executar o que na �rea (CTRL+F9)
			if (resultado.next()) {
				user = resultado.getString("tipo");
				nome =resultado.getString("nome");
				
			} else {
				user = "";
				
			}
		} catch (SQLException erro) {
			user = "";
		}
		return user;
	}

	public void actionPerformed(ActionEvent acao) {
		if (acao.getSource() == btnLogin) {
			String ok;
			ok = Consulta_Login();
			
			if (ok != "") {
				// new Menu().show();
				if (ok.equals("1")) {
					setLblBD("Usu�rio Administrador", Color.green);
					
					new ADM_Menu(nome).show();
					dispose();
				} else if (ok.equals("2")) {
					setLblBD("Usu�rio Usuario mesmo", Color.blue);
				}

			} else {
				setLblBD("Usu�rio ou senha inv�lido", Color.red);
			}
		}

	}

	public static void main(String args[]) {
		new Login().show();
	}

}
