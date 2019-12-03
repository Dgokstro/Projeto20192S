package BDConexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ViewClasses.ViewCadCliente;
import ViewClasses.ViewAdmMenu;
import ViewClasses.ViewClienteMenu;
import ViewClasses.ViewTelaLogin;

public class Login extends ViewTelaLogin implements ActionListener {
	// Declara��o dos componentes

	Connection conexao = ControlConectar.getConnection();
	// Linha obrigat�ria (Connection)
	String status = ControlConectar.status;
	private String nome;
	private String empresa;
	private String idempresa;
	private String idusuario;

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
			sql = "select a.tipo,a.nome,b.nome as empresa,b.id as idempresa,a.id as idusuario from usuario a left join empresa b on a.empresa=b.id where a.email= '" + getUsuario() + "' and a.senha='" + getSenha()
					+ "'";
			// sql = inserir comandos
			PreparedStatement tabela = conexao.prepareStatement(sql);
			// preparar �rea de execu��o
			ResultSet resultado = tabela.executeQuery();
			// executar o que na �rea (CTRL+F9)
			if (resultado.next()) {
				user = resultado.getString("tipo");
				nome = resultado.getString("nome");
				empresa = resultado.getString("empresa");
				idempresa = resultado.getString("idempresa");
				idusuario = resultado.getString("idusuario");

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

					new ViewAdmMenu(nome).show();
					dispose();
				} else if (ok.equals("2")) {
					setLblBD("Usu�rio Usuario mesmo", Color.blue);

					new ViewClienteMenu(nome,empresa,idempresa,idusuario).show();
					dispose();
				} else if (ok.equals("4")) {
					setLblBD("Usu�rio com acesso somente ao aplicativo", Color.red);

					
				} else if (ok.equals("3")) {
					
					new ViewClienteMenu(nome,empresa,idempresa,idusuario).show();
					dispose();
					
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
