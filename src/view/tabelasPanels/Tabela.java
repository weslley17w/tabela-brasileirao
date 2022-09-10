package view.tabelasPanels;

import javax.swing.*;

import java.awt.*;

/**
* Responsável por criar a tabela de classificação dos times
* @author Weslley Barros
* @version 1.0
*/

public class Tabela{

	private JLabel titulo = new JLabel("BRASILEIRÃO SÉRIE A");
	private JPanel janela = new JPanel();
	private JTable tabelaBrasileirao = new JTable();
	private controller.Tabela controleTabela = new controller.Tabela();
	
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
		titulo.setBounds(290, 20, 175, 30);
		titulo.setVisible(true);

		this.gerarTabela();
		
		return janela; 
	}

	/**
	 * Responsável por criar e alinhar os elementos da tela
	 * @author Weslley Barros
	 * @return JPanel - Retorna um JPanel para outra classe consumir
	 * @version 1.0
	 */
	
	private void gerarTabela() {

		this.tabelaBrasileirao.setModel(controleTabela.dadosTabela());
		janela.add(titulo);
		tabelaBrasileirao.setDefaultEditor(Object.class, null);
		tabelaBrasileirao.setBounds(0, 50, 500, 500);
		JScrollPane scrollPane = new JScrollPane(tabelaBrasileirao);
		tabelaBrasileirao.setFillsViewportHeight(true);
		scrollPane.setBounds(0, 50, 800, 800);
		janela.add(scrollPane);
	}
}
