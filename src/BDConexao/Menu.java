package BDConexao;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;




public class Menu extends Janela implements ActionListener{
	//Declarar os componentes
	JMenuBar Barra = new JMenuBar();
	JMenu Cadastro = new JMenu("Cadastro...");
	JMenuItem Alunos =new JMenuItem("Alunos");
	JMenuItem Sair = new JMenuItem("Sair");
	
	public Menu(){

 super("Menu Principal",new Dimension(600,600));
 		//Instanciar componentes
 		setJMenuBar(Barra);
		Barra.add(Cadastro);
		Cadastro.add(Alunos);
		Cadastro.addSeparator();
		Cadastro.add(Sair);
		Alunos.addActionListener(this);
		Sair.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent acao){
		if (acao.getSource()==Alunos){
			JOptionPane.showMessageDialog
			(null, "Em construção");
		}
		else if(acao.getSource()==Sair){
			System.exit(0);
		}
	}
	
	public static void main(String args[]){
		new Menu().show();
	}
	
	
	

}



