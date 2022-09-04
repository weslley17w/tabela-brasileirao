package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import model.Database;
import model.Time;

public class TelaCadastrarTime implements ActionListener {

	private static JFrame janela = new JFrame();
	private static JLabel titulo = new JLabel();
	private static JTextField inputNome = new JTextField();
	private static JComboBox<String> inputTecnico;
	private static JTextField inputQntJogos = new JTextField();
	private static JTextField inputQntVitorias = new JTextField();
	private static JTextField inputQntEmpates = new JTextField();
	private static JTextField inputQntDerrotas = new JTextField();
	private static JTextField inputQntGolsFeitos = new JTextField();
	private static JTextField inputQntGolsSofridos = new JTextField();
	

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
		janela.setSize(560, 600);
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janela.setVisible(true);
	}

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

		
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		// if(src == admin)
		// new TelaAdmin();
	}
}