package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class TelaCadastrarJogador implements ActionListener {
	
	private static JFrame janela = new JFrame("Cadastrar Tecnico");
	private static JLabel titulo = new JLabel("Cadastrar Tecnico");


	
	public TelaCadastrarJogador() {
		
		janela.setLayout(null);
		tela();
		

		
		janela.setSize(350, 500);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	//  multa
	// licencaCBF licencaInternacional qntVitorias qntEmpates qntDerrotas
	private void tela() {
		JLabel nome = new JLabel("Nome:");
		JTextField inputNome = new JTextField();
		
		JLabel dataNas = new JLabel("Data de Nascimento:");
		JTextField inputdataNas = new JTextField();
		
		JLabel nacionalidade = new JLabel("Nacionalidade:");
		JTextField inputNacionalidade = new JTextField();
		
		JLabel salario = new JLabel("Salario:");
		JTextField inputSalario = new JTextField();
		
		JLabel multa = new JLabel("Multa:");
		JTextField inputMulta = new JTextField();
		
		
		
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(80, 10, 200, 30);		
		
		
		nome.setBounds(10, 60, 40, 30);	
		inputNome.setBounds(140, 65, 180, 20);	
		
		dataNas.setBounds(10, 90, 120, 30);	
		inputdataNas.setBounds(140, 95, 180, 20);	
		
		nacionalidade.setBounds(10, 120, 120, 30);	
		inputNacionalidade.setBounds(140, 125, 180, 20);	
		
		salario.setBounds(10, 150, 120, 30);	
		inputSalario.setBounds(140, 155, 180, 20);	
		
		multa.setBounds(10, 180, 120, 30);	
		inputMulta.setBounds(140, 185, 180, 20);	
		
		janela.add(titulo);
		janela.add(nome);
		janela.add(inputNome);
		janela.add(dataNas);
		janela.add(inputdataNas);
		janela.add(nacionalidade);
		janela.add(inputNacionalidade);
		janela.add(salario);
		janela.add(inputSalario);
		janela.add(multa);
		janela.add(inputMulta);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//if(src == admin)
			//new TelaAdmin();
	}
}