package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaCadastrarJogador implements ActionListener {
	
	private boolean trava;
	private static JFrame janela = new JFrame("Cadastrar Jogador");
	private static JLabel titulo = new JLabel("Cadastrar Jogador");
	private static JTextField inputNome = new JTextField();
	private static JTextField inputdataNas = new JTextField();
	private static JTextField inputNacionalidade = new JTextField();
	private static JTextField inputSalario = new JTextField();
	private static JTextField inputMulta = new JTextField();
	private static JTextField inputQntGols = new JTextField();
	private static String[] dataSelect = { "Sim", "Não" };
	private static JComboBox<String> inputPassaporteEuropeu = new JComboBox<String>(dataSelect);
	private static JButton btnCadastrarJogagor = new JButton("Cadastrar");
	private static controller.Jogador controleJogador = new controller.Jogador();

	public TelaCadastrarJogador() {
		this.trava = false;
		janela.setLayout(null);
		tela();

		janela.setSize(350, 380);
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janela.setVisible(true);
	}

	private void tela() {

		JLabel nome = new JLabel("Nome:");
		JLabel dataNas = new JLabel("Data de Nascimento:");
		JLabel nacionalidade = new JLabel("Nacionalidade:");
		JLabel salario = new JLabel("Salario:");
		JLabel multa = new JLabel("Multa:");
		JLabel qntGols = new JLabel("Qnt. de Gols:");
		JLabel passaporteEuropeu = new JLabel("Passaporte Europeu:");

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

		qntGols.setBounds(10, 210, 120, 30);
		inputQntGols.setBounds(140, 215, 180, 20);
		inputQntGols.setText(null);

		passaporteEuropeu.setBounds(10, 240, 120, 30);
		inputPassaporteEuropeu.setBounds(140, 245, 180, 20);
		inputPassaporteEuropeu.setSelectedItem("Não");

		btnCadastrarJogagor.setBounds(228, 290, 91, 28);

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
		janela.add(qntGols);
		janela.add(inputQntGols);
		janela.add(passaporteEuropeu);
		janela.add(inputPassaporteEuropeu);
		janela.add(btnCadastrarJogagor);
		btnCadastrarJogagor.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		

		if (!this.trava) {
			if (src == btnCadastrarJogagor) {
				
				int cadJogador = controleJogador.cadastrar(inputNome.getText(), inputNacionalidade.getText(),
						inputdataNas.getText(), inputSalario.getText(), inputMulta.getText(), inputQntGols.getText(),
						inputPassaporteEuropeu.getSelectedItem().toString());

				if (cadJogador == 0) {
					this.trava = true;
					JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso", "Jogador Cadastrado",
							JOptionPane.INFORMATION_MESSAGE);
					janela.dispose();
				}

				if (cadJogador == 2) {
					cadJogador = -1;
					JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório!",
							"Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
				}

				if (cadJogador == 3) {
					cadJogador = -1;
					JOptionPane.showMessageDialog(null,
							"Os campos Salário e Multa devem ser um número real separado por um ponto",
							"Dados Inválidos", JOptionPane.WARNING_MESSAGE);
				}

				if (cadJogador == 4) {
					cadJogador = -1;
					JOptionPane.showMessageDialog(null, "O campos Qnt. Gols deve ser um inteiro", "Dados Inválidos",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}