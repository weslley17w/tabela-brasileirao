package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class TelaCadastrarTime implements ActionListener {
	
	private static JFrame janela = new JFrame("Editar");
	private static JLabel titulo = new JLabel("Menu Principal");


	
	public TelaCadastrarTime() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 150, 30);		
		janela.setLayout(null);

		janela.add(titulo);

		
		janela.setSize(800, 800);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//if(src == admin)
			//new TelaAdmin();
	}
}