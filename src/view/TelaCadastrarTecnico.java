package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class TelaCadastrarTecnico implements ActionListener {
	
	private static JFrame janela = new JFrame("Cadastrar Tecnico");
	private static JLabel titulo = new JLabel("Cadastrar Tecnico");
	private static JButton btnCadastrarTecnico = new JButton("Cadastrar");


	
	public TelaCadastrarTecnico() {
		
		janela.setLayout(null);
		tela();
		

		
		janela.setSize(350, 500);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

	private void tela() {
		String[] dataSelect = { "Sim", "Não"};
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
		
		JLabel licencacbf = new JLabel("Licença CBF:");
		JComboBox<String> inputLicencacbf = new JComboBox<String>(dataSelect);
		inputLicencacbf.setSelectedItem("Sim");
		
		JLabel licencaInternacional = new JLabel("Licença Internacional:");
		JComboBox<String> inputLicencaInternacional = new JComboBox<String>(dataSelect);
		inputLicencaInternacional.setSelectedItem("Não");
		
		JLabel qntVitorias = new JLabel("Qtd. de Vitórias");
		JTextField inputQntVitorias = new JTextField();
		
		JLabel qntEmpates = new JLabel("Qtd. de Empates");
		JTextField inputQntEmpates = new JTextField();
		
		JLabel qntDerrotas = new JLabel("Qtd. de Derrotas");
		JTextField inputQntDerrotas = new JTextField();


		
		
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(100, 10, 200, 30);		
		
		
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
		
		licencacbf.setBounds(10, 210, 120, 30);	
		inputLicencacbf.setBounds(140, 215, 180, 20);
		
		licencaInternacional.setBounds(10, 240, 140, 30);	
		inputLicencaInternacional.setBounds(140, 245, 180, 20);
		
		qntVitorias.setBounds(10, 270, 120, 30);	
		inputQntVitorias.setBounds(140, 275, 180, 20);	
		
		qntEmpates.setBounds(10, 300, 120, 30);	
		inputQntEmpates.setBounds(140, 305, 180, 20);	
		
		qntDerrotas.setBounds(10, 330, 120, 30);	
		inputQntDerrotas.setBounds(140, 335, 180, 20);	
		
		btnCadastrarTecnico.setBounds(228, 370, 91, 28);
		
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
		janela.add(licencacbf);
		janela.add(inputLicencacbf);
		janela.add(licencaInternacional);
		janela.add(inputLicencaInternacional);
		janela.add(qntVitorias);
		janela.add(inputQntVitorias);
		janela.add(qntEmpates);
		janela.add(inputQntEmpates);
		janela.add(qntDerrotas);
		janela.add(inputQntDerrotas);
		janela.add(btnCadastrarTecnico);
		btnCadastrarTecnico.addActionListener(this);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnCadastrarTecnico)
			System.out.println("btnCadastrarTecnico");
	}
}