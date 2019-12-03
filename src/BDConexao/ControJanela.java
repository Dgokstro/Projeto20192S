package BDConexao;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ControJanela extends JFrame {

	public ControJanela(String titulo,Dimension tamanho){
		setTitle(titulo);//Definir título
		setSize(tamanho);//Definir tamanho
		
		//getContentPane().setBackground
		//				(new Color(30,40,50));
	
		getContentPane().setBackground
						(Color.WHITE);
		//Definir plano de fundo
		getContentPane().setLayout(null);
		//Definir como formato "formulário"
		setLocationRelativeTo(null);
		//Centralizar
		
		
	}
	

}
