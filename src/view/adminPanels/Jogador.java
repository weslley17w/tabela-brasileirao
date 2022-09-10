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
import javax.swing.JTextField;

import view.TelaCadastrarJogador;
import view.TelaEditarJogador;

/**
* Responsável por criar o painel com lista de jogadores
* @author Weslley Barros
* @version 1.0
*/

public class Jogador implements ActionListener{
	
	private JTable tabelaJogador = new JTable();
	private controller.Jogador contorllerJogador = new controller.Jogador();
	private JButton btnAtualizarJogador = new JButton("Atualizar");
	private JButton btnCadastrarJogador = new JButton("Cadastrar");
	private JButton btnEditarJogador = new JButton("Editar");
	private JButton btnDeletarJogador = new JButton("Deletar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JTextField inputPesquisar = new JTextField();
	
	/**
	 * Responsável por criar e alinhar os elementos da tela
	 * @author Weslley Barros
	 * @return JPanel - Retorna um JPanel para outra classe consumir
	 * @version 1.0
	 */
	
	public JComponent pane() {
		JPanel panelJogadores = new JPanel();
		panelJogadores.setLayout(null);
		this.tabelaJogador.setModel(contorllerJogador.gerarLista());
		JLabel tituloJogador  = new JLabel("Jogador");
		tabelaJogador.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(tabelaJogador);	
		tituloJogador.setFont(new Font("Calibri", Font.BOLD, 20));
		tituloJogador.setBounds(250, 20, 100, 25);
		
		btnAtualizarJogador.setBounds(446, 50, 91, 28);
		btnPesquisar.setBounds(160, 50, 100, 27);
		inputPesquisar.setBounds(38, 50, 120, 28);
		btnCadastrarJogador.setBounds(446, 400, 91, 28);
		btnDeletarJogador.setBounds(253, 400, 91, 28);
		btnEditarJogador.setBounds(350, 400, 91, 28);
		tabelaJogador.setFillsViewportHeight(true);
		scrollPane.setBounds(38, 90, 500, 300);
		btnCadastrarJogador.addActionListener(this);
		btnEditarJogador.addActionListener(this);
		btnAtualizarJogador.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnDeletarJogador.addActionListener(this);
		
		panelJogadores.add(tituloJogador);
		panelJogadores.add(scrollPane);
		panelJogadores.add(btnDeletarJogador);
		panelJogadores.add(btnAtualizarJogador);
		panelJogadores.add(btnEditarJogador);
		panelJogadores.add(btnCadastrarJogador);
		panelJogadores.add(inputPesquisar);
		panelJogadores.add(btnPesquisar);
		
		
		return panelJogadores;
	}
	
	/**
	* Responsável por ler os eventos de clique dos botoes da tela
	* @author  Weslley Barros
	* @version 1.0
	*/
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnAtualizarJogador) {
			this.tabelaJogador.setModel(contorllerJogador.gerarLista());
		}
		
		if(src == btnCadastrarJogador) {
			new TelaCadastrarJogador();
		}
		
		if(src == btnPesquisar) {
			String nome = inputPesquisar.getText();
			this.tabelaJogador.setModel(contorllerJogador.gerarLista(nome));
		}
		
		if(src == btnDeletarJogador) {
			int row = tabelaJogador.getSelectedRow();
			if(row >= 0) {
				String jogador = tabelaJogador.getModel().getValueAt(row, 0).toString();
				int validar = contorllerJogador.deletar(jogador);
				
				if(validar == 1) {
					JOptionPane.showMessageDialog(null, "Jogador não encontrado, atualize a página!",
							"Jogador não encontrado", JOptionPane.WARNING_MESSAGE);
				}
				
				if(validar == 2) {
					JOptionPane.showMessageDialog(null, "Você não pode excluir jogador com contrato vigente",
							"Jogador com contrato vigente", JOptionPane.WARNING_MESSAGE);
				}
				
				if(validar == 0) {
					this.tabelaJogador.setModel(contorllerJogador.gerarLista());
					JOptionPane.showMessageDialog(null, "Jogador excluído com sucesso",
							"Jogador excluído", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
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
