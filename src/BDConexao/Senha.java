package BDConexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ViewClasses.ADM_CadSenha;

public class Senha extends ADM_CadSenha implements ActionListener {
	Connection conexao = Conectar.getConnection();
	String status = Conectar.status;

	public Senha() throws SQLException {
		super();
		btnSalvar.addActionListener(this);
		btnCadCliente.addActionListener(this);
		btnSair.addActionListener(this);
	}

	private void Salvar() {
		try {
			String sql;
			sql = "select id from empresa where cnpj= '" + getCNPJ() + "'";

			PreparedStatement tabela = conexao.prepareStatement(sql);

			ResultSet resultado = tabela.executeQuery();

			if (resultado.next()) {

				String sqldpto = "select id from departamento  where  empresa= '" + resultado.getString("id") + "'";

				PreparedStatement tabeladpto = conexao.prepareStatement(sqldpto);

				ResultSet resultadodpto = tabeladpto.executeQuery();
				resultadodpto.next();

				sql = "insert into usuario (empresa,email,senha,departamento,nome,tipo,status) values ('";
				sql += resultado.getString("id") + "','";
				sql += getEmail() + "','";
				sql += getSenha() + "','";
				sql += resultadodpto.getString("id") + "','";
				sql += getNome() + "','";
				sql += "2','0')";

				try {
					tabela = conexao.prepareStatement(sql);
					tabela.executeUpdate();
					setRetorno("Usuario cadastrado com sucesso", Color.green);

				} catch (SQLException e) {
					setRetorno(e.getMessage(), Color.red);
					e.printStackTrace();
				}

			} else {
				setRetorno("Empresa nao localizada", Color.red);
			}
		} catch (SQLException erro) {
			setRetorno(erro.getMessage(), Color.red);
		}
	}

	@Override
	public void actionPerformed(ActionEvent acao) {
		// TODO Auto-generated method stub
		if (acao.getSource() == btnCadCliente) {
			new Cliente().show();
			dispose();
		}
		if (acao.getSource() == btnSair) {
			dispose();
		}
		if (acao.getSource() == btnSalvar) {
			Salvar();
		}

	}

}
