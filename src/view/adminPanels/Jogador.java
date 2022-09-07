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

import view.TelaCadastrarJogador;
import view.TelaEditarJogador;

public class Jogador implements ActionListener{
	
	private JTable tabelaJogador = new JTable();
	private controller.Jogador contorllerJogador = new controller.Jogador();
	private JButton btnAtualizarJogador = new JButton("Atualizar");
	private JButton btnCadastrarJogador = new JButton("Cadastrar");
	private JButton btnEditarJogador = new JButton("Editar");
	private JButton btnDeletarJogador = new JButton("Deletar");
	
	public JComponent pane() {
		JPanel panelJogadores = new JPanel();
		panelJogadores.setLayout(null);
		this.tabelaJogador.setModel(contorllerJogador.gerarLista());
		JLabel tituloJogador  = new JLabel("Jogador");
		tabelaJogador.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(tabelaJogador);
		
		
		tituloJogador.setFont(new Font("Calibri", Font.BOLD, 20));
		tituloJogador.setBounds(250, 20, 100, 25);
		
		btnAtualizarJogador.setBounds(446, 20, 91, 28);
		btnCadastrarJogador.setBounds(446, 370, 91, 28);
		btnDeletarJogador.setBounds(253, 370, 91, 28);
		btnEditarJogador.setBounds(350, 370, 91, 28);
		tabelaJogador.setFillsViewportHeight(true);
		scrollPane.setBounds(38, 60, 500, 300);
		btnCadastrarJogador.addActionListener(this);
		btnEditarJogador.addActionListener(this);
		btnAtualizarJogador.addActionListener(this);
		btnDeletarJogador.addActionListener(this);
		
		panelJogadores.add(tituloJogador);
		panelJogadores.add(scrollPane);
		panelJogadores.add(btnDeletarJogador);
		panelJogadores.add(btnAtualizarJogador);
		panelJogadores.add(btnEditarJogador);
		panelJogadores.add(btnCadastrarJogador);
		
		return panelJogadores;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnAtualizarJogador) {
			this.tabelaJogador.setModel(contorllerJogador.gerarLista());
		}
		
		if(src == btnCadastrarJogador) {
			new TelaCadastrarJogador();
		}
		
		if(src == btnDeletarJogador) {
			int row = tabelaJogador.getSelectedRow();
			if(row >= 0) {
				String jogador = tabelaJogador.getModel().getValueAt(row, 0).toString();
				System.out.println(jogador);
				
			}else {
				JOptionPane.showMessageDialog(null, "Selecione um jogador para poder excluir",
						"Selecione um jogador", JOptionPane.WARNING_MESSAGE);	
			}
			
		}
		
		if(src == btnEditarJogador) {
			int row = tabelaJogador.getSelectedRow();
			if(row >= 0) {
				String jogador = tabelaJogador.getModel().getValueAt(row, 0).toString();
				new TelaEditarJogador(jogador);
			}else {
				JOptionPane.showMessageDialog(null, "Selecione um jogador para poder editar",
						"Selecione um jogador", JOptionPane.WARNING_MESSAGE);	
			}
		}
		
	}
}
