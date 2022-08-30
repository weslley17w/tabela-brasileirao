package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Time;

import java.awt.*;
import java.util.ArrayList;

public class TelaAdmin extends JFrame {

	private static final long serialVersionUID = -5547498367822791169L;
	JTabbedPane tabbedPane = new JTabbedPane();
	private static JButton btnCadastrarTime = new JButton("Cadastrar");
	private static JButton btnEditarTime = new JButton("Editar");
	private static JLabel tituloTimes = new JLabel("Times");
	private JTable tabelaTimes = new JTable();
	private static controller.Times contorllerTimes = new controller.Times();

	public TelaAdmin() {
		setTitle("Jogadores");
		tabbedPane.addTab("Times", times());
		tabbedPane.addTab("Técnicos", painel2());
		add(tabbedPane);
		setResizable(false);
		setVisible(true);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(getWidth(), getHeight()));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public JComponent times() {
		JPanel panelTime = new JPanel();
		panelTime.setLayout(null);
		dadosTabela();
		tabelaTimes.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(tabelaTimes);
		
		//Config
		tituloTimes.setFont(new Font("Calibri", Font.BOLD, 20));
		tituloTimes.setBounds(260, 20, 50, 25);
		btnCadastrarTime.setBounds(446, 370, 91, 28);
		btnEditarTime.setBounds(350, 370, 91, 28);
		tabelaTimes.setFillsViewportHeight(true);
		scrollPane.setBounds(38, 60, 500, 300);
		

		//Add Screen
		
		panelTime.add(tituloTimes);
		panelTime.add(scrollPane);
		panelTime.add(btnEditarTime);
		panelTime.add(btnCadastrarTime);
		setVisible(true);
		tituloTimes.setVisible(true);
		
		return panelTime;
	}

	private void dadosTabela() {
		DefaultTableModel modeloTabelaTimes = new DefaultTableModel();
		this.tabelaTimes.setModel(modeloTabelaTimes);
		
		modeloTabelaTimes.addColumn("TIMES");
		modeloTabelaTimes.addColumn("PONTOS");
		contorllerTimes.getTimes().forEach(time -> {
			modeloTabelaTimes.addRow(new Object[] { time.getNome(), time.getPontos() });
		});
		

	}

	public JComponent painel2() {
		JPanel painel2 = new JPanel();
		JLabel label2;
		label2 = new JLabel("Técnicos");
		painel2.add(label2);
		return painel2;
	}
}