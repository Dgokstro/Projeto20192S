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
import ViewClasses.CLIENTE_Menu;
import ViewClasses.ViewTelaLogin;

public class Login extends ViewTelaLogin implements ActionListener {
	// Declaração dos componentes

	Connection conexao = Conectar.getConnection();
	// Linha obrigatória (Connection)
	String status = Conectar.status;
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
			sql = "select a.tipo,a.nome,b.nome as empresa,b.id as idempresa,a.id as idusuario from usuario a inner join empresa b on a.empresa=b.id where a.email= '" + getUsuario() + "' and a.senha='" + getSenha()
					+ "'";
			// sql = inserir comandos
			PreparedStatement tabela = conexao.prepareStatement(sql);
			// preparar área de execução
			ResultSet resultado = tabela.executeQuery();
			// executar o que na área (CTRL+F9)
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
					setLblBD("Usuário Administrador", Color.green);

					new ADM_Menu(nome).show();
					dispose();
				} else if (ok.equals("2")) {
					setLblBD("Usuário Usuario mesmo", Color.blue);

					new CLIENTE_Menu(nome,empresa,idempresa,idusuario).show();
					dispose();
				}

			} else {
				setLblBD("Usuário ou senha inválido", Color.red);
			}
		}

	}

	public static void main(String args[]) {
		new Login().show();
	}

}
