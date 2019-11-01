package BDConexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ViewClasses.CLIENTE_CadDpto;

public class Departamento extends CLIENTE_CadDpto implements ActionListener {
	Connection conexao = Conectar.getConnection();
	String idempresa;

	public Departamento(String empresa) throws SQLException {
		String sql = "select cnpj from empresa where id='" + empresa + "'";
		PreparedStatement tabela = conexao.prepareStatement(sql);
		ResultSet resultado = tabela.executeQuery();
		resultado.next();
		setEmpresa(resultado.getString("cnpj"));
		this.idempresa=empresa;
		btnSalvar.addActionListener(this);
	}

	private void Salvar() throws SQLException {

		String sql;
		sql = "insert into departamento (descricao,empresa) values ('";
		sql += getNome() + "','";
		sql += idempresa + "')";

		PreparedStatement tabela;
		try {
			tabela = conexao.prepareStatement(sql);
			tabela.executeUpdate();
			setRetorno("Departamento cadastrado com sucesso", Color.green);
			setTxtNome("");

		} catch (SQLException e) {
			setRetorno(e.getMessage(), Color.red);
		}

	}

	@Override
	public void actionPerformed(ActionEvent acao) {
		// TODO Auto-generated method stub
		if (acao.getSource() == btnSalvar) {
			try {
				Salvar();
			} catch (SQLException e) {
				setRetorno(e.getMessage(), Color.red);
			}
		}
	}

}
