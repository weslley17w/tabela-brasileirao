

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaInicial implements ActionListener {
	
	private static JFrame janela = new JFrame("Tabela Brasileirão Série A");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton aluno = new JButton("Tabela");
	private static JButton curso = new JButton("Admin");

	
	public TelaInicial() {

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 150, 30);
		curso.setBounds(140, 100, 100, 30);
		aluno.setBounds(140, 50, 100, 30);
		
		janela.setLayout(null);
		janela.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("")));
		janela.add(titulo);
		janela.add(aluno);
		janela.add(curso);

		
		janela.setSize(400, 250);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	

	public static void main(String[] args) {
		TelaInicial menu = new TelaInicial();
		
		aluno.addActionListener(menu);
		curso.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == aluno)
			//new TelaPessoa().mostrarDados(dados, 1);
		
		//if(src == prof)
			//new TelaPessoa().mostrarDados(dados, 2);
		
		if(src == curso)
			JOptionPane.showMessageDialog(null, 
					"Ainda precisam ser implementadas as funcionalidades\n"
					+ "relacionadas a curso e a matrícula", null, 
					JOptionPane.INFORMATION_MESSAGE);
	}
}