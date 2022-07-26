package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Database;

/**
*
* Responsável por criar a tela inicial
*
* @author Weslley Barros
* @version 1.0
*/

public class TelaInicial implements ActionListener {
	
	private JFrame janela = new JFrame("Tabela Brasileirão Série A");
	private JLabel titulo = new JLabel("Menu Principal");
	private static JButton tabela = new JButton("Tabela");
	private static JButton admin = new JButton("Admin");

	/**
	 *
	 * Responsável por criar a tela inicial
	 * @author Weslley Barros
	 * @version 1.0
	 */
	
	public TelaInicial() {
		model.Database db = Database.getInstance();
		db.init();
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 150, 30);
		admin.setBounds(140, 100, 100, 30);
		tabela.setBounds(140, 50, 100, 30);
		
		janela.setLayout(null);
		janela.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
		janela.add(titulo);
		janela.add(tabela);
		janela.add(admin);

		
		janela.setSize(400, 250);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	/**
	 *
	 * Responsável por fazer a chamada da tela inicial do sistema
	 * @param args - args
	 * @author Weslley Barros
	 * @version 1.0
	 */
	
	public static void main(String[] args) {
		TelaInicial menu = new TelaInicial();
		
		tabela.addActionListener(menu);
		admin.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == admin)
			new TelaAdmin();
			
		
		if(src == tabela)
			new TelaTabela();
		
		
	}
}