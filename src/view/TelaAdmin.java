package view;

import javax.swing.*;
import java.awt.*;

public class TelaAdmin{

	private JTabbedPane tabbedPane = new JTabbedPane();
	private JFrame frame = new JFrame();
	private view.adminPanels.Times time = new view.adminPanels.Times();
	private view.adminPanels.Tecnicos tecnicos = new view.adminPanels.Tecnicos();
	private view.adminPanels.Jogador jogadores = new view.adminPanels.Jogador();

	public TelaAdmin() {
		frame.setTitle("Jogadores");
		tabbedPane.addTab("Times", time.pane());
		tabbedPane.addTab("Técnicos", tecnicos.pane());
		tabbedPane.addTab("Jogador", jogadores.pane());
		frame.add(tabbedPane);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}	
}