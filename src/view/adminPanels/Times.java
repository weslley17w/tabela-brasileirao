package view.adminPanels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableColumn;

import view.TelaCadastrarTime;
import view.TelaEditarTime;

public class Times implements ActionListener{
	
	private static controller.Time controlerTime = new controller.Time();
	private JTable tabelaTimes = new JTable();
	private static JLabel tituloTimes = new JLabel("Times");
	private static JButton btnCadastrarTime = new JButton("Cadastrar");
	private static JButton btnEditarTime = new JButton("Editar");

	
	public JComponent pane() {
		JPanel panelTime = new JPanel();
		panelTime.setLayout(null);

		this.tabelaTimes.setModel(controlerTime.dadosTabela());
		TableColumn colunauuid = this.tabelaTimes.getTableHeader().getColumnModel().getColumn(0);
		colunauuid.setPreferredWidth(0);
		colunauuid.setMinWidth(0);
		colunauuid.setMaxWidth(0);
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
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnCadastrarTime) {
			new TelaCadastrarTime();
		}
			
		if(src == btnEditarTime) {
			
			int row = tabelaTimes.getSelectedRow();
			
			if(row > -1) {
				String id = tabelaTimes.getModel().getValueAt(row, 0).toString();
				new TelaEditarTime(id);
			}else {
				JOptionPane.showMessageDialog(null, "Selecione um time para poder editar",
						"Selecione um time", JOptionPane.WARNING_MESSAGE);
			}
	
		}
		
	}
}
