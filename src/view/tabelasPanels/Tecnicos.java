package view.tabelasPanels;

import javax.swing.*;
import java.awt.*;

/**
* Responsável por criar a tabela de desempenho dos técnicos
* @author Weslley Barros
* @version 1.0
*/

public class Tecnicos{

	private JLabel titulo = new JLabel("TECNICOS");
	private JPanel janela = new JPanel();
	private JTable tabelaBrasileirao = new JTable();
	private controller.Tecnico controleTecnicos = new controller.Tecnico();
	
	/**
	 * Responsável por criar e alinhar os elementos da tela
	 * @author Weslley Barros
	 * @return JPanel - Retorna um JPanel para outra classe consumir
	 * @version 1.0
	 */
	
	public JPanel pane() {
		
		janela.setSize(800, 700);
		janela.setLayout(null);
		titulo.setFont(new Font("Calibri", Font.BOLD, 20));
		titulo.setBounds(330, 20, 175, 30);
		titulo.setVisible(true);

		this.gerarTabela();
		
		return janela; 
	}

	private void gerarTabela() {

		this.tabelaBrasileirao.setModel(controleTecnicos.dadosTecnicos());
		janela.add(titulo);
		tabelaBrasileirao.setDefaultEditor(Object.class, null);
		tabelaBrasileirao.setBounds(0, 50, 500, 500);
		JScrollPane scrollPane = new JScrollPane(tabelaBrasileirao);
		tabelaBrasileirao.setFillsViewportHeight(true);
		scrollPane.setBounds(50, 50, 650, 400);
		janela.add(scrollPane);

	}

}
