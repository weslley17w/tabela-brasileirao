package view;

import javax.swing.*;
import java.awt.*;

/**
*
* Responsável por criar a com todas tabelas
* @author Weslley Barros
* @version 1.0
*/

public class TelaTabela{

	private JTabbedPane tabbedPane = new JTabbedPane();
	private JFrame frame = new JFrame();
	private view.tabelasPanels.Tabela tabela = new view.tabelasPanels.Tabela();
	private view.tabelasPanels.Artilheiros artilheiros = new view.tabelasPanels.Artilheiros();
	private view.tabelasPanels.Tecnicos tecnicos = new view.tabelasPanels.Tecnicos();
	
	/**
	*
	* Responsável por fazer configurar a janela e chamar as classes dos painéis
	* @author Weslley Barros
	* @version 1.0
	*/
	
	public TelaTabela() {
		frame.setTitle("Jogadores");
		tabbedPane.addTab("Times", tabela.pane());
		tabbedPane.addTab("Artilheiros", artilheiros.pane());
		tabbedPane.addTab("Tecnicos", tecnicos.pane());
		frame.add(tabbedPane);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(800, 700);
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}	
}