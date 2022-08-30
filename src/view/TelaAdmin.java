package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Time;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAdmin implements ActionListener{

	JTabbedPane tabbedPane = new JTabbedPane();
	JFrame frame = new JFrame();
	private static JButton btnCadastrarTime = new JButton("Cadastrar");
	private static JButton btnEditarTime = new JButton("Editar");
	private static JLabel tituloTimes = new JLabel("Times");
	private JTable tabelaTimes = new JTable();
	private static controller.Times contorllerTimes = new controller.Times();

	public TelaAdmin() {
		frame.setTitle("Jogadores");
		tabbedPane.addTab("Times", times());
		tabbedPane.addTab("Técnicos", painel2());
		frame.add(tabbedPane);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
		btnCadastrarTime.addActionListener(this);
		btnEditarTime.addActionListener(this);
		

		//Add Screen
		
		panelTime.add(tituloTimes);
		panelTime.add(scrollPane);
		panelTime.add(btnEditarTime);
		panelTime.add(btnCadastrarTime);
		frame.setVisible(true);
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
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnCadastrarTime)
			new TelaCadastrarTime();
			
		
		if(src == btnEditarTime) {
			int row;
			row = tabelaTimes.getSelectedRow();
			String value = tabelaTimes.getModel().getValueAt(row, 0).toString();
			System.out.println(value);
		}
		
	}

	public JComponent painel2() {
		JPanel painel2 = new JPanel();
		JLabel label2;
		label2 = new JLabel("Técnicos");
		painel2.add(label2);
		return painel2;
	}
}