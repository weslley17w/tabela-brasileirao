package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaCadastrarTecnico implements ActionListener {
	private boolean trava;
	private static JFrame janela = new JFrame("Cadastrar Tecnico");
	private static JLabel titulo = new JLabel("Cadastrar Tecnico");
	private static String[] dataSelect = { "Sim", "Não" };
	private controller.Tecnico controleTecnico = new controller.Tecnico();
	private static JButton btnCadastrarTecnico = new JButton("Cadastrar");
	private static JTextField inputNome = new JTextField();
	private static JTextField inputdataNas = new JTextField();
	private static JTextField inputNacionalidade = new JTextField();
	private static JTextField inputSalario = new JTextField();
	private static JTextField inputMulta = new JTextField();
	private static JComboBox<String> inputLicencacbf = new JComboBox<String>(dataSelect);
	private static JComboBox<String> inputLicencaInternacional = new JComboBox<String>(dataSelect);
	private static JTextField inputQntVitorias = new JTextField();
	private static JTextField inputQntEmpates = new JTextField();
	private static JTextField inputQntDerrotas = new JTextField();

	public TelaCadastrarTecnico() {
		this.trava = false;
		janela.setLayout(null);
		tela();

		janela.setSize(350, 500);
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janela.setVisible(true);
	}

	private void tela() {

		JLabel nome = new JLabel("Nome:");
		JLabel dataNas = new JLabel("Data de Nascimento:");
		JLabel nacionalidade = new JLabel("Nacionalidade:");
		JLabel salario = new JLabel("Salario:");
		JLabel multa = new JLabel("Multa:");
		JLabel licencacbf = new JLabel("Licença CBF:");
		inputLicencacbf.setSelectedItem("Sim");
		JLabel licencaInternacional = new JLabel("Licença Internacional:");
		inputLicencaInternacional.setSelectedItem("Não");
		JLabel qntVitorias = new JLabel("Qtd. de Vitórias");
		JLabel qntEmpates = new JLabel("Qtd. de Empates");
		JLabel qntDerrotas = new JLabel("Qtd. de Derrotas");

		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(100, 10, 200, 30);

		nome.setBounds(10, 60, 40, 30);
		inputNome.setBounds(140, 65, 180, 20);
		inputNome.setText(null);

		dataNas.setBounds(10, 90, 120, 30);
		inputdataNas.setBounds(140, 95, 180, 20);
		inputdataNas.setText(null);

		nacionalidade.setBounds(10, 120, 120, 30);
		inputNacionalidade.setBounds(140, 125, 180, 20);
		inputNacionalidade.setText(null);

		salario.setBounds(10, 150, 120, 30);
		inputSalario.setBounds(140, 155, 180, 20);
		inputSalario.setText(null);

		multa.setBounds(10, 180, 120, 30);
		inputMulta.setBounds(140, 185, 180, 20);
		inputMulta.setText(null);

		licencacbf.setBounds(10, 210, 120, 30);
		inputLicencacbf.setBounds(140, 215, 180, 20);

		licencaInternacional.setBounds(10, 240, 140, 30);
		inputLicencaInternacional.setBounds(140, 245, 180, 20);

		qntVitorias.setBounds(10, 270, 120, 30);
		inputQntVitorias.setBounds(140, 275, 180, 20);
		inputQntVitorias.setText(null);

		qntEmpates.setBounds(10, 300, 120, 30);
		inputQntEmpates.setBounds(140, 305, 180, 20);
		inputQntEmpates.setText(null);

		qntDerrotas.setBounds(10, 330, 120, 30);
		inputQntDerrotas.setBounds(140, 335, 180, 20);
		inputQntDerrotas.setText(null);

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

		if (!this.trava) {
			if (src == btnCadastrarTecnico) {
				int cadTecnico = controleTecnico.Cadastrar(inputNome.getText(), inputdataNas.getText(),
						inputNacionalidade.getText(), inputSalario.getText(), inputMulta.getText(),
						inputLicencacbf.getSelectedItem().toString(),
						inputLicencaInternacional.getSelectedItem().toString(), inputQntVitorias.getText(),
						inputQntEmpates.getText(), inputQntDerrotas.getText());

				if (cadTecnico == 0) {
					this.trava = true;
					cadTecnico = -1;
					JOptionPane.showMessageDialog(null, "tecnico cadastrado com sucesso", "Tecnico cadastro",
							JOptionPane.INFORMATION_MESSAGE);
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
							"Os campos Salário e Multa devem ser um número real separado por um ponto",
							"Dados Inválidos", JOptionPane.WARNING_MESSAGE);
				}

				if (cadTecnico == 4) {
					cadTecnico = -1;
					JOptionPane.showMessageDialog(null,
							"Os campos Qnt. vitorias, empates e derrotas devem ser um inteiro", "Dados Inválidos",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		}

	}
}