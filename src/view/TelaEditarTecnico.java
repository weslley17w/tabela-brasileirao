package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.Database;
import model.Tecnico;

/**
*
* Responsável por criar a tela para editar o técnico
*
* @author  Weslley Barros
* @version 1.0
*/

public class TelaEditarTecnico implements ActionListener {

	private model.Database db = Database.getInstance();
	private model.Tecnico tecnico;
	private JFrame janela = new JFrame("Editar Tecnico");
	private JLabel titulo = new JLabel("Editar Tecnico");
	private String[] dataSelect = { "Sim", "Não" };
	private controller.Tecnico controleTecnico = new controller.Tecnico();
	private JButton btnEditarTecnico = new JButton("Editar");
	private JTextField inputNome = new JTextField();
	private JTextField inputdataNas = new JTextField();
	private JTextField inputNacionalidade = new JTextField();
	private JTextField inputSalario = new JTextField();
	private JTextField inputMulta = new JTextField();
	private JComboBox<String> inputLicencacbf = new JComboBox<String>(dataSelect);
	private JComboBox<String> inputLicencaInternacional = new JComboBox<String>(dataSelect);
	private JTextField inputQntVitorias = new JTextField();
	private JTextField inputQntEmpates = new JTextField();
	private JTextField inputQntDerrotas = new JTextField();
	
	/**
	*
	* Responsável por criar a tela para editar o técnico
	* @param nome - Nome do técnico a ser editado
	* @author  Weslley Barros
	* @version 1.0
	*/
	
	public TelaEditarTecnico(String nome) {
		tecnico = db.getTecnicos(nome);
		janela.setLayout(null);
		tela();

		janela.setSize(350, 500);
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
	
	private void tela() {

		JLabel nome = new JLabel("Nome:");
		JLabel dataNas = new JLabel("Data de Nascimento:");
		JLabel nacionalidade = new JLabel("Nacionalidade:");
		JLabel salario = new JLabel("Salario:");
		JLabel multa = new JLabel("Multa:");
		JLabel licencacbf = new JLabel("Licença CBF:");
		JLabel licencaInternacional = new JLabel("Licença Internacional:");
		JLabel qntVitorias = new JLabel("Qtd. de Vitórias");
		JLabel qntEmpates = new JLabel("Qtd. de Empates");
		JLabel qntDerrotas = new JLabel("Qtd. de Derrotas");

		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(120, 10, 200, 30);

		nome.setBounds(10, 60, 40, 30);
		inputNome.setBounds(140, 65, 180, 20);
		inputNome.setText(tecnico.getNome());

		dataNas.setBounds(10, 90, 120, 30);
		inputdataNas.setBounds(140, 95, 180, 20);
		inputdataNas.setText(this.tecnico.getDtNascimento());

		nacionalidade.setBounds(10, 120, 120, 30);
		inputNacionalidade.setBounds(140, 125, 180, 20);
		inputNacionalidade.setText(this.tecnico.getNacionalidade());

		salario.setBounds(10, 150, 120, 30);
		inputSalario.setBounds(140, 155, 180, 20);
		String salarioString = Float.toString(this.tecnico.getSalario());
		inputSalario.setText(salarioString);

		multa.setBounds(10, 180, 120, 30);
		inputMulta.setBounds(140, 185, 180, 20);
		String multaString = Float.toString(this.tecnico.getMulta());
		inputMulta.setText(multaString);

		licencacbf.setBounds(10, 210, 120, 30);
		inputLicencacbf.setBounds(140, 215, 180, 20);
		String stingLicencacbf = (this.tecnico.getLicencaCBF()) ? "Sim" : "Não";
		inputLicencacbf.setSelectedItem(stingLicencacbf);

		licencaInternacional.setBounds(10, 240, 140, 30);
		inputLicencaInternacional.setBounds(140, 245, 180, 20);
		String stingLicencaInternacional = (this.tecnico.getLicencaInternacional()) ? "Sim" : "Não";
		inputLicencaInternacional.setSelectedItem(stingLicencaInternacional);

		qntVitorias.setBounds(10, 270, 120, 30);
		inputQntVitorias.setBounds(140, 275, 180, 20);
		String vitoriasString = Integer.toString(this.tecnico.getQntVitorias());
		inputQntVitorias.setText(vitoriasString);

		qntEmpates.setBounds(10, 300, 120, 30);
		inputQntEmpates.setBounds(140, 305, 180, 20);
		String empatesString = Integer.toString(this.tecnico.getQntEmpates());
		inputQntEmpates.setText(empatesString);

		qntDerrotas.setBounds(10, 330, 120, 30);
		inputQntDerrotas.setBounds(140, 335, 180, 20);
		String derrotas = Integer.toString(this.tecnico.getQntDerrotas());
		inputQntDerrotas.setText(derrotas);

		btnEditarTecnico.setBounds(228, 370, 91, 28);

		janela.add(titulo);
		janela.add(nome);
		janela.add(inputNome);
		janela.add(dataNas);
		janela.add(inputdataNas);
		janela.add(nacionalidade);
		janela.add(inputNacionalidade);
		janela.add(inputSalario);
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
		janela.add(btnEditarTecnico);
		btnEditarTecnico.addActionListener(this);
	}
	
	/**
	*
	* Responsável por ler os eventos de clique dos botões da tela
	*
	* @author  Weslley Barros
	* @version 1.0
	*/
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnEditarTecnico) {
			int cadTecnico = controleTecnico.update(this.tecnico, inputNome.getText(), inputdataNas.getText(),
					inputNacionalidade.getText(), inputSalario.getText(), inputMulta.getText(),
					inputLicencacbf.getSelectedItem().toString(),
					inputLicencaInternacional.getSelectedItem().toString(), inputQntVitorias.getText(),
					inputQntEmpates.getText(), inputQntDerrotas.getText());

			if (cadTecnico == 0) {
				JOptionPane.showMessageDialog(null, "Tecnico Editado com sucesso!",
						"Tecnico Editado", JOptionPane.INFORMATION_MESSAGE);
				janela.dispose();
			}

			if (cadTecnico == 2) {
				cadTecnico = -1;
				JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório!",
						"Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
			}

			if (cadTecnico == 3) {
				cadTecnico = -1;
				JOptionPane.showMessageDialog(null,
						"Os campos Salário e Multa devem ser um número real separado por um ponto", "Dados Inválidos",
						JOptionPane.WARNING_MESSAGE);
			}

			if (cadTecnico == 4) {
				cadTecnico = -1;
				JOptionPane.showMessageDialog(null, "Os campos Qnt. vitorias, empates e derrotas devem ser um inteiro",
						"Dados Inválidos", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}