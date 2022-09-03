package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Database;
import model.Time;

public class TelaEditarTime implements ActionListener {
	
	private static JFrame janela     = new JFrame("Editar Time");
	private static JLabel titulo     = new JLabel();
	private static model.Database db = model.Database.getInstance();
	private static model.Time time;

	public TelaEditarTime(String id) {
		this.time = db.getTime(id);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 150, 30);		
		janela.setLayout(null);

		janela.add(titulo);

		
		janela.setSize(800, 800);
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//if(src == admin)
			//new TelaAdmin();
	}
}