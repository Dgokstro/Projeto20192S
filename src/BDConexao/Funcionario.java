package BDConexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ViewClasses.CLIENTE_CadFunc;
import ViewClasses.CLIENTE_CadQuestionario;

public class Funcionario extends CLIENTE_CadFunc implements ActionListener {

	Connection conexao = Conectar.getConnection();
	String idempresa;
	String idusuario;

	public Funcionario(String empresa, String idusuario) throws SQLException {
		this.idusuario = idusuario;
		this.idempresa = empresa;

		String sql = "select cnpj from empresa where id='" + empresa + "'";
		PreparedStatement tabela = conexao.prepareStatement(sql);
		ResultSet resultado = tabela.executeQuery();
		resultado.next();
		setEmpresa(resultado.getString("cnpj"));
		addDpto(empresa);

		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnLozalizar.addActionListener(this);
		btnCadFunc.addActionListener(this);
		btnCadQuestionario.addActionListener(this);
		btnRelatrio.addActionListener(this);
		btnSair.addActionListener(this);
		btnMenuDepartamento.addActionListener(this);
	}

	private void Salvar() throws SQLException {

		String sql;
		sql = "insert into usuario (nome,empresa,Email,departamento,tipo,status,senha) values ('";
		sql += getNome() + "','";
		sql += idempresa + "','";
		sql += getEmail() + "','";
		sql += getiddpto(getSetor()) + "','";
		sql += getTipoUser() + "','";
		sql += getStatus() + "','";
		sql += getSenha() + "')";

		PreparedStatement tabela;
		try {
			tabela = conexao.prepareStatement(sql);
			tabela.executeUpdate();
			setRetorno("Colaborador cadastrado com sucesso", Color.green);
			setTxtEmail("");
			setTxtSenha("");
			settxtDepartamento("");
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
		if (acao.getSource() == btnLozalizar) {

			Consultar();

		}
		if (acao.getSource() == btnAlterar) {

			Alterar();

		}
		if (acao.getSource() == btnCadFunc) {
			try {
				new Funcionario(idempresa, idusuario).show();
				dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		if (acao.getSource() == btnMenuDepartamento) {

			try {
				new Departamento(idempresa, idusuario).show();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		if (acao.getSource() == btnCadQuestionario) {

			try {
				new CLIENTE_CadQuestionario(idempresa, idusuario).show();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		if (acao.getSource() == btnSair) {
			dispose();
		}
	}

	public void addDpto(String empresa) throws SQLException {
		String sql = "select descricao,id from departamento where empresa='" + empresa + "'";
		PreparedStatement tabela = conexao.prepareStatement(sql);
		ResultSet resultado = tabela.executeQuery();
		while (resultado.next()) {
			comboDepartamento.addItem(resultado.getString("descricao"));
		}

	}

	public String getiddpto(String dpto) throws SQLException {
		String sql = "select descricao,id from departamento where empresa='" + idempresa + "' and descricao = '" + dpto
				+ "'";
		PreparedStatement tabela = conexao.prepareStatement(sql);
		ResultSet resultado = tabela.executeQuery();
		resultado.next();
		return resultado.getString("id");

	}

	private void Consultar() {

		try {
			String sql;
			sql = "select a.nome,b.descricao,a.status,a.tipo from usuario a inner join departamento b on a.departamento = b.id"
					+ " where " + "a.email= '" + getEmail() + "' and a.empresa='" + idempresa + "'";

			PreparedStatement tabela = conexao.prepareStatement(sql);

			ResultSet resultado = tabela.executeQuery();

			if (resultado.next()) {
				setTxtNome(resultado.getString("nome"));
				setRetorno("", Color.red);
				settxtDepartamento(resultado.getString("descricao"));
				setTipoUser(resultado.getInt("tipo"));

			} else {
				setRetorno("Email não encontrado", Color.red);
				setTxtNome("");

			}
		} catch (SQLException erro) {
			setRetorno(erro.getMessage(), Color.red);
		}
	}

	private void Alterar() {
		try {
			String sql;
			sql = "select id from usuario  where  email= '" + getEmail() + "' and empresa='" + idempresa + "'";

			PreparedStatement tabela = conexao.prepareStatement(sql);

			ResultSet resultado = tabela.executeQuery();

			if (resultado.next()) {

				if (!"".equals(getNome())) {
					sql = "update usuario set nome='" + getNome() + "'where email = '" + getEmail() + "'";
					executasql(sql);
				}
				if (!"".equals(getSenha())) {
					sql = "update usuario set senha='" + getSenha() + "'where email = '" + getEmail() + "'";
					executasql(sql);
				}
				if (!"".equals(getiddpto(getSetor()))) {
					sql = "update usuario set departamento='" + getiddpto(getSetor()) + "'where email = '" + getEmail()
							+ "'";
					executasql(sql);
				}
				if (!"".equals(getStatus())) {
					sql = "update usuario set status='" + getStatus() + "'where email = '" + getEmail() + "'";
					executasql(sql);
				}
				if (!"".equals(getTipoUser())) {
					sql = "update usuario set tipo='" + getTipoUser() + "'where email = '" + getEmail() + "'";
					executasql(sql);
				}

				setRetorno("Colaborador Alterado com sucesso", Color.green);
				setTxtEmail("");
				setTxtSenha("");
				setTxtNome("");

			} else {
				setRetorno("CNPJ não encontrado", Color.red);

			}
		} catch (SQLException erro) {
			setRetorno(erro.getMessage(), Color.red);
		}

	}

	public void executasql(String sql) throws SQLException {

		PreparedStatement tabela = conexao.prepareStatement(sql);

		try {
			tabela = conexao.prepareStatement(sql);
			tabela.executeUpdate();
			setRetorno("Empresa Alterada com sucesso", Color.green);

		} catch (SQLException e) {
			setRetorno(e.getMessage(), Color.red);
			e.printStackTrace();
		}
	}

}
