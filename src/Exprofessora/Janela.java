package Exprofessora;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Janela extends JFrame{
	
	public Janela(String titulo,Dimension tamanho){
		setTitle(titulo);
		setSize(tamanho);
		getContentPane().setBackground
				(new Color(200,250,250));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
	}
	public static void main(String args[]){
		new Janela("",new Dimension(300,300)).show();
	}
	
}