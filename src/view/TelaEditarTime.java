package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.TableColumn;

/**
 *
 * Responsável por criar a tela para editar os times
 *
 * @author Weslley Barros
 * @version 1.0
 */

public class TelaEditarTime implements ActionListener {

	private boolean trava;
	private JFrame janela = new JFrame();
	private JLabel titulo = new JLabel();
	private JLabel titulo2 = new JLabel("Jogadores");
	private JButton btnDemitir = new JButton("=========>");
	private JButton btnAtualizar = new JButton();
	private JButton btnContratar = new JButton("<=========");
	private JButton btnSalvar = new JButton("Salvar");
	private model.Database db = model.Database.getInstance();
	private model.Time time;
	private controller.Jogador controleJogadores = new controller.Jogador();
	private controller.Tecnico controleTecnico = new controller.Tecnico();
	private controller.Time controleTime = new controller.Time();
	private String[] nomesTecnicos;
	private JComboBox<String> inputTecnico;
	private JTextField inputNome = new JTextField();
	private JTextField inputQntJogos = new JTextField();
	private JTextField inputQntVitorias = new JTextField();
	private JTextField inputQntEmpates = new JTextField();
	private JTextField inputQntDerrotas = new JTextField();
	private JTextField inputQntGolsFeitos = new JTextField();
	private JTextField inputQntGolsSofridos = new JTextField();
	private JTable jogadoresDotime = new JTable();
	private JTable jogadoresSemtime = new JTable();

	/**
	 *
	 * Responsável por criar a tela para editar edita o times
	 * @param nome - Nome do técnico a ser editado
	 * @author Weslley Barros
	 * @version 1.0
	 */

	public TelaEditarTime(String nome) {
		this.trava = false;
		this.time = db.getTime(nome);
		janela.setTitle(time.getNome());
		btnAtualizar.addActionListener(this);
		btnAtualizar.doClick();
		titulo.setText(this.time.getNome());
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(200, 10, 150, 30);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setVerticalAlignment(SwingConstants.CENTER);
		janela.setLayout(null);
		janela.add(titulo);
		label();
		jogadores();
		janela.setSize(560, 600);
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.jogadoresDotime.setModel(controleJogadores.tabelaJogadoresPorTime(time));

		this.jogadoresSemtime.setModel(controleJogadores.tabelaJogadoresPorTime(null));
		janela.setVisible(true);

	}

	/**
	 *
	 * Responsável por criar e alinhar os elementos da tela
	 * @param nome - Nome do time a ser editado
	 * @author Weslley Barros
	 * @version 1.0
	 */

	private void label() {

		JLabel nome = new JLabel("Nome:");
		nome.setBounds(10, 60, 40, 30);
		inputNome.setBounds(110, 65, 140, 20);
		inputNome.setText(time.getNome());

		JLabel tecnico = new JLabel("Tecnico:");
		tecnico.setBounds(290, 60, 60, 30);
		janela.revalidate();
		janela.dispose();

		String nomeTecnico = (!time.verificarTecnico()) ? "Sem Técnico" : time.getTecnico().getNome();
		nomesTecnicos = controleTecnico.allNomesTecnicosSemtime(time);
		inputTecnico = new JComboBox<String>(nomesTecnicos);
		inputTecnico.setSelectedItem(nomeTecnico);
		inputTecnico.setBounds(390, 65, 140, 20);

		JLabel qntGols = new JLabel("Qnt. Jogos:");
		qntGols.setBounds(10, 95, 80, 30);
		inputQntJogos.setBounds(110, 100, 140, 20);
		String qntJogosString = Integer.toString(time.getQntJogos());
		inputQntJogos.setText(qntJogosString);

		JLabel qntVitorias = new JLabel("Qnt. Vitórias");
		qntVitorias.setBounds(290, 100, 140, 20);
		inputQntVitorias.setBounds(390, 100, 140, 20);
		String qntVitoriasString = Integer.toString(time.getQntVitorias());
		inputQntVitorias.setText(qntVitoriasString);

		JLabel qntEmpates = new JLabel("Qnt. Empates:");
		qntEmpates.setBounds(10, 125, 80, 30);
		inputQntEmpates.setBounds(110, 130, 140, 20);
		String qntEmpatesString = Integer.toString(time.getQntEmpates());
		inputQntEmpates.setText(qntEmpatesString);

		JLabel qntDerrotas = new JLabel("Qnt. Derrotas");
		qntDerrotas.setBounds(290, 130, 140, 20);
		inputQntDerrotas.setBounds(390, 130, 140, 20);
		String qntDerrotasString = Integer.toString(time.getQntDerrotas());
		inputQntDerrotas.setText(qntDerrotasString);

		JLabel qntGolsFeitos = new JLabel("Gols Feitos:");
		qntGolsFeitos.setBounds(10, 155, 80, 30);
		inputQntGolsFeitos.setBounds(110, 160, 140, 20);
		String qntGolsProString = Integer.toString(time.getQntGolsFeitos());
		inputQntGolsFeitos.setText(qntGolsProString);

		JLabel qntGolsSofridos = new JLabel("Gols Sofridos:");
		qntGolsSofridos.setBounds(290, 160, 140, 20);
		inputQntGolsSofridos.setBounds(390, 160, 140, 20);
		String qntGolsContraString = Integer.toString(time.getQntGolsSofridos());
		inputQntGolsSofridos.setText(qntGolsContraString);

		titulo2.setFont(new Font("Arial", Font.BOLD, 20));
		titulo2.setBounds(200, 200, 150, 30);
		titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		titulo2.setVerticalAlignment(SwingConstants.CENTER);

		janela.add(nome);
		janela.add(inputNome);
		janela.add(qntGols);
		janela.add(tecnico);
		janela.add(inputTecnico);
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
		janela.add(titulo2);

	}

	private void jogadores() {
		this.jogadoresDotime.setModel(controleJogadores.tabelaJogadoresPorTime(time));
		TableColumn colunauuid = this.jogadoresDotime.getTableHeader().getColumnModel().getColumn(0);
		colunauuid.setPreferredWidth(0);
		colunauuid.setMinWidth(0);
		colunauuid.setMaxWidth(0);
		jogadoresDotime.setDefaultEditor(Object.class, null);
		JScrollPane dotime = new JScrollPane(jogadoresDotime);

		this.jogadoresSemtime.setModel(controleJogadores.tabelaJogadoresPorTime(null));
		jogadoresSemtime.setDefaultEditor(Object.class, null);
		JScrollPane semtime = new JScrollPane(jogadoresSemtime);

		dotime.setBounds(40, 270, 150, 200);
		semtime.setBounds(355, 270, 150, 200);

		btnContratar.setBounds(220, 340, 110, 20);
		btnContratar.addActionListener(this);
		btnDemitir.setBounds(220, 370, 110, 20);
		btnDemitir.addActionListener(this);
		btnSalvar.setBounds(413, 500, 91, 28);
		btnSalvar.addActionListener(this);

		janela.add(dotime);
		janela.add(semtime);
		janela.add(btnContratar);
		janela.add(btnDemitir);
		janela.add(btnSalvar);
	}
	
	/**
	*
	* Responsável por ler os eventos de clique dos botões da tela
	*
	* @author  Weslley Barros
	* @version 1.0
	*/

	public void actionPerformed(ActionEvent e) {
		if (!this.trava) {
			Object src = e.getSource();

			if (src == btnAtualizar) {
				this.jogadoresDotime.setModel(controleJogadores.tabelaJogadoresPorTime(time));

				this.jogadoresSemtime.setModel(controleJogadores.tabelaJogadoresPorTime(null));
			}

			if (src == btnContratar) {

				int row = jogadoresSemtime.getSelectedRow();

				if (row >= 0) {
					String jogador = jogadoresSemtime.getModel().getValueAt(row, 0).toString();
					model.Time time = this.time;
					int validar = controleTime.contrato(jogador, time);

					if (validar == 0) {

						btnAtualizar.doClick();
						JOptionPane.showMessageDialog(null, "Jogador contratado com sucesso", "Jogador Contratado",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "O jogador tem contrato vigente com outro clube de futebol",
								"Contrato Vigente", JOptionPane.WARNING_MESSAGE);
					}

				}

			}

			if (src == btnSalvar) {
				int validar = controleTime.editar(time, inputNome.getText(), inputTecnico.getSelectedItem().toString(),
						inputQntJogos.getText(), inputQntVitorias.getText(), inputQntEmpates.getText(),
						inputQntDerrotas.getText(), inputQntGolsFeitos.getText(), inputQntGolsSofridos.getText());

				if (validar == 0) {
					this.trava = true;
					janela.dispose();
				}

				if (validar == 2) {
					JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório!",
							"Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
				}

				if (validar == 1) {
					JOptionPane.showMessageDialog(null,
							"Os campos Qnt. Jogos, Qnt. Vitórias, Qnt. Empates, Qnt. Derrotas, Gols Feitos e Gols Sofridos devem "
									+ "ser um inteiro",
							"Dados Inválidos", JOptionPane.WARNING_MESSAGE);
				}
			}

			if (src == btnDemitir) {
				int row = jogadoresDotime.getSelectedRow();
				if (row >= 0) {
					String jogador = jogadoresDotime.getModel().getValueAt(row, 0).toString();
					int validar = controleTime.demitir(jogador, time);

					if (validar == 0) {
						btnAtualizar.doClick();
						JOptionPane.showMessageDialog(null, "Jogador demitido com sucesso", "Jogador Demitido",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "O jogador não pertence ao seu time", "Contrato Vigente",
								JOptionPane.WARNING_MESSAGE);
					}

				}
			}

		}
	}
}