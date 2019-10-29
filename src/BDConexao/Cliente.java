package BDConexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ViewClasses.ADM_CadCliente;

public class Cliente extends ADM_CadCliente implements ActionListener {

	Connection conexao = Conectar.getConnection();
	String status = Conectar.status;
	
	public Cliente () {
		super();
		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnLocalizar.addActionListener(this);
	}

	
	private void Salvar() {
		
		String sql;
		sql = "insert into empresa (nome,endereco,CNPJ,cidade,uf,telefone,email) values ('";
		sql += getEmpresa() +"','";
		sql += getEndereco() +"','";
		sql += getCNPJ() +"','";
		sql += getCidade() +"','";
		sql += getUF() +"','";
		sql += getTelefone() +"','";
		sql += getEmail()+"')";
		
		PreparedStatement tabela;
		try {
			tabela = conexao.prepareStatement(sql);
			tabela.executeUpdate();
			setRetorno("Empresa cadastrada com sucesso",Color.green);
			
		} catch (SQLException e) {
			setRetorno(e.getMessage(),Color.red);
			e.printStackTrace();
		}
		
		
	}

	private void Consultar() {
	
		
		try {
			String sql;
			sql = "select nome,endereco,cidade,uf,telefone,email from empresa" + " where " + "cnpj= '" + getCNPJ() + "'";
	
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
				setRetorno("CNPJ não encontrado",Color.red);
				setTxtEmpresa("");
				setTxtEndereco("");
				setTxtCidade("");
				setTxtUF("");
				setTxtTelefone("");
				setTxtEmail("");
			}
		} catch (SQLException erro) {
			setRetorno(erro.getMessage(),Color.red);
		}
		
	}
	
	private void Alterar() {
		try {
			String sql;
			sql = "select nome,endereco,cidade,uf,telefone,email from empresa" + " where " + "cnpj= '" + getCNPJ() + "'";
	
			PreparedStatement tabela = conexao.prepareStatement(sql);

			ResultSet resultado = tabela.executeQuery();

			if (resultado.next()) {
				sql = "update empresa set ";
				if (!"".equals(getEmpresa())) {
					sql+="nome='"+getEmpresa()+"'";
				}if (!"".equals(getEndereco())) {
					sql+="endereco='"+getEndereco()+"'";
				}if (!"".equals(getCidade())) {
					sql+="cidade='"+getCidade()+"'";
				}if (!"".equals(getUF())) {
					sql+="uf='"+getUF()+"'";
				}if (!"".equals(getTelefone())) {
					sql+="telefone='"+getTelefone()+"'";
				}if (!"".equals(getEmail())) {
					sql+="email='"+getEmail()+"'";
				}
				sql+= "where cnpj = '"+getCNPJ()+"'";
				
				
				try {
					tabela = conexao.prepareStatement(sql);
					tabela.executeUpdate();
					setRetorno("Empresa Alterada com sucesso",Color.green);
					
				} catch (SQLException e) {
					setRetorno(e.getMessage(),Color.red);
					e.printStackTrace();
				}
				
			} else {
				setRetorno("CNPJ não encontrado",Color.red);

			}
		} catch (SQLException erro) {
			setRetorno(erro.getMessage(),Color.red);
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent acao) {
		// TODO Auto-generated method stub
		if ( acao.getSource()== btnSalvar) {
			Salvar();
		}if ( acao.getSource()== btnLocalizar) {
			Consultar();
		}if ( acao.getSource()== btnAlterar) {
			Alterar();
		}
		
		
	}

}
