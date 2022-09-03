package view.adminPanels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import view.TelaCadastrarJogador;
import view.TelaEditarJogador;

public class Jogador implements ActionListener{
	
	private JTable tabelaJogador = new JTable();
	private static controller.Jogador contorllerJogador = new controller.Jogador();
	private static JButton btnAtualizarJogador = new JButton("Atualizar");
	private static JButton btnCadastrarJogador = new JButton("Cadastrar");
	private static JButton btnEditarJogador = new JButton("Editar");
	
	public JComponent pane() {
		JPanel panelTecnicos = new JPanel();
		panelTecnicos.setLayout(null);
		this.tabelaJogador.setModel(contorllerJogador.gerarLista());
		TableColumn colunauuid = this.tabelaJogador.getTableHeader().getColumnModel().getColumn(0);
		colunauuid.setPreferredWidth(0);
		colunauuid.setMinWidth(0);
		colunauuid.setMaxWidth(0);
		JLabel tituloJogador  = new JLabel("Jogador");
		tabelaJogador.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(tabelaJogador);
		
		
		tituloJogador.setFont(new Font("Calibri", Font.BOLD, 20));
		tituloJogador.setBounds(250, 20, 100, 25);
		
		btnAtualizarJogador.setBounds(446, 20, 91, 28);
		btnCadastrarJogador.setBounds(446, 370, 91, 28);
		btnEditarJogador.setBounds(350, 370, 91, 28);
		tabelaJogador.setFillsViewportHeight(true);
		scrollPane.setBounds(38, 60, 500, 300);
		btnCadastrarJogador.addActionListener(this);
		btnEditarJogador.addActionListener(this);
		btnAtualizarJogador.addActionListener(this);
		
		panelTecnicos.add(tituloJogador);
		panelTecnicos.add(scrollPane);
		panelTecnicos.add(btnAtualizarJogador);
		panelTecnicos.add(btnEditarJogador);
		panelTecnicos.add(btnCadastrarJogador);
		
		return panelTecnicos;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnAtualizarJogador) {
			this.tabelaJogador.setModel(contorllerJogador.gerarLista());
			TableColumn colunauuid = this.tabelaJogador.getTableHeader().getColumnModel().getColumn(0);
			colunauuid.setPreferredWidth(0);
			colunauuid.setMinWidth(0);
			colunauuid.setMaxWidth(0);
		}
		
		if(src == btnCadastrarJogador) {
			new TelaCadastrarJogador();
		}
		
		if(src == btnEditarJogador) {
			int row = tabelaJogador.getSelectedRow();
			String jogador = tabelaJogador.getModel().getValueAt(0, 0).toString();
			if(row >= 0) {
				new TelaEditarJogador(jogador);
			}else {
				JOptionPane.showMessageDialog(null, "Selecione um jogador para poder editar",
						"Selecione um jogador", JOptionPane.WARNING_MESSAGE);	
			}
		}
		
	}
}
