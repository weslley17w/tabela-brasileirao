package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
*
* Responsável por criar a tela para cadastrar time
*
* @author  Weslley Barros
* @version 1.0
*/

public class TelaCadastrarTime implements ActionListener {

	private JFrame janela = new JFrame();
	private JLabel titulo = new JLabel();
	private JTextField inputNome = new JTextField();
	private JTextField inputQntJogos = new JTextField();
	private JTextField inputQntVitorias = new JTextField();
	private JTextField inputQntEmpates = new JTextField();
	private JTextField inputQntDerrotas = new JTextField();
	private JTextField inputQntGolsFeitos = new JTextField();
	private JTextField inputQntGolsSofridos = new JTextField();
	private JButton    btnCadastrar = new JButton("Cadastrar");
	private controller.Time controleTime = new controller.Time() ;
	
	/**
	*
	* Responsável por configurar a janela
	*
	* @author  Weslley Barros
	* @version 1.0
	*/

	public TelaCadastrarTime() {
		janela.setTitle("Cadastrar Time");
		titulo.setText("Cadastrar Time");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(200, 10, 150, 30);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setVerticalAlignment(SwingConstants.CENTER);
		janela.setLayout(null);
		janela.add(titulo);
		label();
		janela.setSize(560, 290);
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janela.setVisible(true);
	}
	
	/**
	*
	* Responsável por criar e alinhar os elementos da tela
	*
	* @author  Weslley Barros
	* @version 1.0
	*/
	
	private void label() {
		
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(10, 60, 40, 30);
		inputNome.setBounds(110, 65, 420, 20);
		
		JLabel qntGols = new JLabel("Qnt. Jogos:");
		qntGols.setBounds(10, 95, 80, 30);
		inputQntJogos.setBounds(110, 100, 140, 20);
		
		JLabel qntVitorias = new JLabel("Qnt. Vitórias");
		qntVitorias.setBounds(290, 100, 140, 20);
		inputQntVitorias.setBounds(390, 100, 140, 20);
		
		JLabel qntEmpates = new JLabel("Qnt. Empates:");
		qntEmpates.setBounds(10, 125, 80, 30);
		inputQntEmpates.setBounds(110, 130, 140, 20);
		
		JLabel qntDerrotas = new JLabel("Qnt. Derrotas");
		qntDerrotas.setBounds(290, 130, 140, 20);
		inputQntDerrotas.setBounds(390, 130, 140, 20);
		
		JLabel qntGolsFeitos = new JLabel("Gols Feitos:");
		qntGolsFeitos.setBounds(10, 155, 80, 30);
		inputQntGolsFeitos.setBounds(110, 160, 140, 20);
		
		JLabel qntGolsSofridos = new JLabel("Gols Sofridos:");
		qntGolsSofridos.setBounds(290, 160, 140, 20);
		inputQntGolsSofridos.setBounds(390, 160, 140, 20);
		
		btnCadastrar.setBounds(440, 210, 91, 28);
		btnCadastrar.addActionListener(this);
				
		janela.add(nome);
		janela.add(inputNome);
		janela.add(qntGols);
		janela.add(qntGols);
		janela.add(inputQntJogos);
		janela.add(qntVitorias);
		janela.add(inputQntVitorias);	
		janela.add(qntEmpates);
		janela.add(inputQntEmpates);
		janela.add(qntDerrotas);
		janela.add(inputQntDerrotas);
		janela.add(qntGolsFeitos);
		janela.add(inputQntGolsFeitos);
		janela.add(qntGolsSofridos);
		janela.add(inputQntGolsSofridos);
		janela.add(btnCadastrar);
		
	}
	
	/**
	*
	* Responsável por ler os eventos de clique dos botoes da tela
	*
	* @author  Weslley Barros
	* @version 1.0
	*/
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if(src == btnCadastrar) {
			
			int cadTime = controleTime.cadastrar(inputNome.getText(), inputQntJogos.getText(), inputQntVitorias.getText(), 
					inputQntEmpates.getText(), inputQntDerrotas.getText(), inputQntGolsFeitos.getText() , inputQntGolsSofridos.getText());
			
			if (cadTime == 0) {
				JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso", "Time Cadastrado",
						JOptionPane.INFORMATION_MESSAGE);
				janela.dispose();
			}

			if (cadTime == 2) {
				JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório!",
						"Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
			}


			if (cadTime == 3) {
				JOptionPane.showMessageDialog(null, "O campos Qnt. Jogos, Qnt. Vitórias, Qnt. Empates, Qnt. Derrotas, "
						+ "Gols Feitos e Gols Sofridos devem ser um inteiro", "Dados Inválidos",
						JOptionPane.WARNING_MESSAGE);
			}
		
		}
	
	}
}