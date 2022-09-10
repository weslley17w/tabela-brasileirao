package view.adminPanels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import view.TelaCadastrarTime;
import view.TelaEditarTime;

/**
* Responsável por criar o painel com lista de times
* @author Weslley Barros
* @version 1.0
*/

public class Times implements ActionListener{
	
	private model.Database db = model.Database.getInstance();
	private controller.Time controlerTime = new controller.Time();
	private JTable tabelaTimes = new JTable();
	private JLabel tituloTimes = new JLabel("Times");
	private JButton btnCadastrarTime = new JButton("Cadastrar");
	private JButton btnEditarTime = new JButton("Editar");
	private JButton btnAtualizarTime = new JButton("Atualizar");
	private JButton btnDeletarTime = new JButton("Deletar");

	/**
	 * Responsável por criar e alinhar os elementos da tela
	 * @author Weslley Barros
	 * @return JPanel - Retorna um JPanel para outra classe consumir
	 * @version 1.0
	 */
	
	public JComponent pane() {
		JPanel panelTime = new JPanel();
		panelTime.setLayout(null);
		this.tabelaTimes.setModel(controlerTime.dadosTabela());
		tabelaTimes.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(tabelaTimes);
		
		//Config
		tituloTimes.setFont(new Font("Calibri", Font.BOLD, 20));
		tituloTimes.setBounds(260, 20, 50, 25);
		btnDeletarTime.setBounds(253, 370, 91, 28);
		btnAtualizarTime.setBounds(446, 20, 91, 28);
		btnCadastrarTime.setBounds(446, 370, 91, 28);
		btnEditarTime.setBounds(350, 370, 91, 28);
		tabelaTimes.setFillsViewportHeight(true);
		scrollPane.setBounds(38, 60, 500, 300);
		btnDeletarTime.addActionListener(this);
		btnCadastrarTime.addActionListener(this);
		btnEditarTime.addActionListener(this);
		btnAtualizarTime.addActionListener(this);
		
		//Add Screen

		panelTime.add(tituloTimes);
		panelTime.add(btnAtualizarTime);
		panelTime.add(scrollPane);
		panelTime.add(btnDeletarTime);
		panelTime.add(btnEditarTime);
		panelTime.add(btnCadastrarTime);
		tituloTimes.setVisible(true);
		
		return panelTime;
	}
	
	/**
	* Responsável por ler os eventos de clique dos botoes da tela
	* @author  Weslley Barros
	* @version 1.0
	*/
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnDeletarTime) {
			
			int row = tabelaTimes.getSelectedRow();
			if(row >= 0) {
				String time = tabelaTimes.getModel().getValueAt(row, 0).toString();
				System.out.println(time);
				
			}else {
				JOptionPane.showMessageDialog(null, "Selecione um time para poder excluir",
						"Selecione um time", JOptionPane.WARNING_MESSAGE);	
			}
			
		}
		
		if(src == btnCadastrarTime) {
			new TelaCadastrarTime();
		}
		
		if(src == btnAtualizarTime) {
			this.tabelaTimes.setModel(controlerTime.dadosTabela());
		}
		
			
		if(src == btnEditarTime) {
			
			int row = tabelaTimes.getSelectedRow();
			
			if(row > -1) {
				String id = tabelaTimes.getModel().getValueAt(row, 0).toString();
				if(db.getTime(id) == null) {
					JOptionPane.showMessageDialog(null, "Time não encontrado, atualize a página",
							"Time não encontrado", JOptionPane.WARNING_MESSAGE);
				}else {
					new TelaEditarTime(id);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Selecione um time para poder editar",
						"Selecione um time", JOptionPane.WARNING_MESSAGE);
			}
	
		}
		
	}
	
}
