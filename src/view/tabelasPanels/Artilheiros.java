package view.tabelasPanels;

import javax.swing.*;
import java.awt.*;

/**
* Responsável por criar a tabela de artilheiros
* @author Weslley Barros
* @version 1.0
*/

public class Artilheiros{

	private JLabel titulo = new JLabel("ARTILHEIROS");
	private JPanel janela = new JPanel();
	private JTable tabelaBrasileirao = new JTable();
	private controller.Jogador controleJogadores = new controller.Jogador();
	
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
		titulo.setBounds(320, 20, 175, 30);
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

		this.tabelaBrasileirao.setModel(controleJogadores.dadosArtilheiros());
		janela.add(titulo);
		tabelaBrasileirao.setDefaultEditor(Object.class, null);
		tabelaBrasileirao.setBounds(0, 50, 500, 500);
		JScrollPane scrollPane = new JScrollPane(tabelaBrasileirao);
		tabelaBrasileirao.setFillsViewportHeight(true);
		scrollPane.setBounds(100, 50, 600, 400);
		janela.add(scrollPane);

	}

}
