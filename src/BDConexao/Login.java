package BDConexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ViewClasses.ViewTelaLogin;

public class Login extends ViewTelaLogin implements ActionListener {
	// Declara��o dos componentes

	Connection conexao = Conectar.getConnection();
	// Linha obrigat�ria (Connection)
	String status = Conectar.status;

	public Login() {
		super();

		btnNewButton.addActionListener(this);
		// JOptionPane.showMessageDialog(null, status);
		setLblBD(status, Color.gray);

	}

	String Consulta_Login() {
		String user = "";
		try {
			String sql;
			sql = "select tipo from Login_2019" + " where " + "usuario= '"
					+ getUsurio() + "' and senha='" + getSenha() + "'";
			// sql = inserir comandos
			PreparedStatement tabela = conexao.prepareStatement(sql);
			// preparar �rea de execu��o
			ResultSet resultado = tabela.executeQuery();
			// executar o que na �rea (CTRL+F9)
			if (resultado.next()) {
			user = resultado.getString(1);
			System.out.println(user);
			} else {
				user = "";
				System.out.println(user);
			}
		} catch (SQLException erro) {
			user = "";
		}
		return user;
	}

	public void actionPerformed(ActionEvent acao) {
		if (acao.getSource() == btnNewButton) {
			String ok;
			ok = Consulta_Login();
			System.out.println(ok);
			if (ok !="") {
				//new Menu().show();
				if(ok.equals("1")){
					setLblBD("Usu�rio Administrador", Color.green);
				}else if (ok.equals("2")){
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