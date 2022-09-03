package view.adminPanels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import view.TelaCadastrarTime;
import view.TelaEditarTime;

public class Times implements ActionListener{
	
	private JTable tabelaTimes = new JTable();
	private static JLabel tituloTimes = new JLabel("Times");
	private static JButton btnCadastrarTime = new JButton("Cadastrar");
	private static JButton btnEditarTime = new JButton("Editar");
	private static controller.Times contorllerTimes = new controller.Times();
	
	public JComponent pane() {
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
		
		if(src == btnCadastrarTime) {
			new TelaCadastrarTime();
		}
			
		if(src == btnEditarTime) {
			
			int row = tabelaTimes.getSelectedRow();
			
			if(row != -1) {
				String id = tabelaTimes.getModel().getValueAt(row, 0).toString();
				new TelaEditarTime(id);
			}else {
				String time = "erro";
				System.out.println(time);
			}
	
		}
		
	}
}
