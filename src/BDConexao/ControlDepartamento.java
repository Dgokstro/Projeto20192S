package BDConexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ViewClasses.ViewCadDpto;
import ViewClasses.ViewCadQuestionario;
import ViewClasses.ViewRelatorio;

public class ControlDepartamento extends ViewCadDpto implements ActionListener {
	Connection conexao = ControlConectar.getConnection();
	String idempresa;
	String idusuario;

	public ControlDepartamento(String empresa, String idusuario) throws SQLException {
		this.idusuario = idusuario;
		String sql = "select cnpj from empresa where id='" + empresa + "'";
		PreparedStatement tabela = conexao.prepareStatement(sql);
		ResultSet resultado = tabela.executeQuery();
		resultado.next();
		setEmpresa(resultado.getString("cnpj"));
		this.idempresa = empresa;
		btnSalvar.addActionListener(this);

		btnCadFunc.addActionListener(this);
		btnCadQuestionario.addActionListener(this);
		btnRelatorio.addActionListener(this);
		btnSair.addActionListener(this);
		btnMenuDepartamento.addActionListener(this);
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
			if (!getNome().equals("")) {
				try {
					Salvar();
				} catch (SQLException e) {
					setRetorno(e.getMessage(), Color.red);
				}
			} else {
				setRetorno("Digite o nome do departamento", Color.red);
			}
		}
		if (acao.getSource() == btnCadFunc) {
			try {
				new ControlFuncionario(idempresa, idusuario).show();
				dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		if (acao.getSource() == btnMenuDepartamento) {

			try {
				new ControlDepartamento(idempresa, idusuario).show();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		if (acao.getSource() == btnCadQuestionario) {

			try {
				new ViewCadQuestionario(idempresa, idusuario).show();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		if (acao.getSource() == btnRelatorio) {

			try {
				new ViewRelatorio(idempresa, idusuario).show();
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

}
