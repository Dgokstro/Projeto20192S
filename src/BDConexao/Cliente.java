package BDConexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ViewClasses.ADM_CadCliente;
import ViewClasses.ADM_CadSenha;

public class Cliente extends ADM_CadCliente implements ActionListener {

	Connection conexao = Conectar.getConnection();
	String status = Conectar.status;

	public Cliente() {
		super();
		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnLocalizar.addActionListener(this);
		btnCadCliente.addActionListener(this);
		btnCadSenha.addActionListener(this);
		btnSair.addActionListener(this);
	}

	private void Salvar() {

		String sql;
		sql = "insert into empresa (nome,endereco,CNPJ,cidade,uf,telefone,email) values ('";
		sql += getEmpresa() + "','";
		sql += getEndereco() + "','";
		sql += getCNPJ() + "','";
		sql += getCidade() + "','";
		sql += getUF() + "','";
		sql += getTelefone() + "','";
		sql += getEmail() + "')";

		PreparedStatement tabela;
		try {
			tabela = conexao.prepareStatement(sql);
			tabela.executeUpdate();
			setRetorno("Empresa cadastrada com sucesso", Color.green);
			CadastrarDpto() ;
			setTxtEmpresa("");
			setTxtEndereco("");
			setTxtCidade("");
			setTxtUF("");
			setTxtTelefone("");
			setTxtEmail("");
			setTxtCNPJ("");
			
		} catch (SQLException e) {
			setRetorno(e.getMessage(), Color.red);
			e.printStackTrace();
		}

	}

	private void Consultar() {

		try {
			String sql;
			sql = "select nome,endereco,cidade,uf,telefone,email from empresa" + " where " + "cnpj= '" + getCNPJ()
					+ "'";

			PreparedStatement tabela = conexao.prepareStatement(sql);

			ResultSet resultado = tabela.executeQuery();

			if (resultado.next()) {
				setTxtEmpresa(resultado.getString("nome"));
				setTxtEndereco(resultado.getString("endereco"));
				setTxtCidade(resultado.getString("cidade"));
				setTxtUF(resultado.getString("uf"));
				setTxtTelefone(resultado.getString("telefone"));
				setTxtEmail(resultado.getString("email"));

			} else {
				setRetorno("CNPJ não encontrado", Color.red);
				setTxtEmpresa("");
				setTxtEndereco("");
				setTxtCidade("");
				setTxtUF("");
				setTxtTelefone("");
				setTxtEmail("");
			}
		} catch (SQLException erro) {
			setRetorno(erro.getMessage(), Color.red);
		}

	}

	private void Alterar() {
		try {
			String sql;
			sql = "select nome,endereco,cidade,uf,telefone,email from empresa" + " where " + "cnpj= '" + getCNPJ()
					+ "'";

			PreparedStatement tabela = conexao.prepareStatement(sql);

			ResultSet resultado = tabela.executeQuery();

			if (resultado.next()) {

				if (!"".equals(getEmpresa())) {
					sql = "update empresa set nome='" + getEmpresa() + "'where cnpj = '" + getCNPJ() + "'";
					executasql(sql);
				}
				if (!"".equals(getEndereco())) {
					sql = "update empresa set endereco='" + getEndereco() + "'where cnpj = '" + getCNPJ() + "'";
					executasql(sql);
				}
				if (!"".equals(getCidade())) {
					sql = "update empresa set Cidade='" + getCidade() + "'where cnpj = '" + getCNPJ() + "'";
					executasql(sql);
				}
				if (!"".equals(getUF())) {
					sql = "update empresa set uf='" + getUF() + "'where cnpj = '" + getCNPJ() + "'";
					executasql(sql);
				}
				if (!"".equals(getTelefone())) {
					sql = "update empresa set telefone='" + getTelefone() + "'where cnpj = '" + getCNPJ() + "'";
					executasql(sql);
				}
				if (!"".equals(getEmail())) {
					sql = "update empresa set email='" + getEmail() + "'where cnpj = '" + getCNPJ() + "'";
					executasql(sql);
				}

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

	@Override
	public void actionPerformed(ActionEvent acao) {
		// TODO Auto-generated method stub
		if (acao.getSource() == btnSalvar) {
			Salvar();
		}
		if (acao.getSource() == btnLocalizar) {
			Consultar();
		}
		if (acao.getSource() == btnAlterar) {
			Alterar();
		}
		if (acao.getSource() == btnCadCliente) {
			
		}
		if (acao.getSource() == btnCadSenha) {
			new Senha().show();
			dispose();
		}
		if (acao.getSource() == btnSair) {
			dispose();
		}

	}
	public void CadastrarDpto() {
		
		try {
			String sql;
			sql = "select id from empresa" + " where " + "cnpj= '" + getCNPJ() + "'";

			PreparedStatement tabela = conexao.prepareStatement(sql);

			ResultSet resultado = tabela.executeQuery();

			if (resultado.next()) {				
				sql = "insert into departamento (empresa,descricao) values ('";
				sql += resultado.getString("id") + "','";
				sql += "Recursos Humanos')";

				
				try {
					tabela = conexao.prepareStatement(sql);
					tabela.executeUpdate();					

				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}else {
				setRetorno("Empresa nao localizada", Color.red);
			}
		} catch (SQLException erro) {
			setRetorno("Empresa nao cadastrada",Color.red);
		}
		
		
	}

}
