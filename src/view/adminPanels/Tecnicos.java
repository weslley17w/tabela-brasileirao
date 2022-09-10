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

import view.TelaCadastrarTecnico;
import view.TelaEditarTecnico;

/**
*
* Responsável por criar o painel com lista de tecnicos
* @author Weslley Barros
* @version 1.0
*/

public class Tecnicos implements ActionListener {

	private JTable tabelaTecnicos = new JTable();
	private static controller.Tecnico contorllerTecnico = new controller.Tecnico();
	private static JButton btnAtualizarTecnico = new JButton("Atualizar");
	private static JButton btnCadastrarTecnico = new JButton("Cadastrar");
	private static JButton btnEditarTecnico = new JButton("Editar");
	private JButton btnDeletarTecnico = new JButton("Deletar");
	
	/**
	 *
	 * Responsável por criar e alinhar os elementos da tela
	 * @author Weslley Barros
	 * @return JPanel - Retorna um JPanel para outra classe consumir
	 * @version 1.0
	 */
	
	public JComponent pane() {
		JPanel panelTecnicos = new JPanel();
		panelTecnicos.setLayout(null);
		this.tabelaTecnicos.setModel(contorllerTecnico.gerarLista());
		JLabel tituloTecnico = new JLabel("Técnicos");
		tabelaTecnicos.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(tabelaTecnicos);

		tituloTecnico.setFont(new Font("Calibri", Font.BOLD, 20));
		tituloTecnico.setBounds(250, 20, 80, 25);

		btnDeletarTecnico.setBounds(253, 370, 91, 28);
		btnAtualizarTecnico.setBounds(446, 20, 91, 28);
		btnCadastrarTecnico.setBounds(446, 370, 91, 28);
		btnEditarTecnico.setBounds(350, 370, 91, 28);
		tabelaTecnicos.setFillsViewportHeight(true);
		scrollPane.setBounds(38, 60, 500, 300);
		btnDeletarTecnico.addActionListener(this);
		btnCadastrarTecnico.addActionListener(this);
		btnEditarTecnico.addActionListener(this);
		btnAtualizarTecnico.addActionListener(this);

		panelTecnicos.add(tituloTecnico);
		panelTecnicos.add(scrollPane);
		panelTecnicos.add(btnDeletarTecnico);
		panelTecnicos.add(btnAtualizarTecnico);
		panelTecnicos.add(btnEditarTecnico);
		panelTecnicos.add(btnCadastrarTecnico);
		return panelTecnicos;
	}
	
	/**
	* Responsável por ler os eventos de clique dos botoes da tela
	* @author  Weslley Barros
	* @version 1.0
	*/
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == btnDeletarTecnico) {
			int row = tabelaTecnicos.getSelectedRow();
			if (row >= 0) {
				String tecnico = tabelaTecnicos.getModel().getValueAt(row, 0).toString();

				int validar = contorllerTecnico.deletar(tecnico);

				if (validar == 1) {
					JOptionPane.showMessageDialog(null, "Tecnico não encontrado, atualize a página!",
							"Tecnico não encontrado", JOptionPane.WARNING_MESSAGE);
				}

				if (validar == 2) {
					JOptionPane.showMessageDialog(null, "Você não pode excluir Tecnico com contrato vigente",
							"Tecnico com contrato vigente", JOptionPane.WARNING_MESSAGE);
				}

				if (validar == 0) {
					this.tabelaTecnicos.setModel(contorllerTecnico.gerarLista());
					JOptionPane.showMessageDialog(null, "Tecnico excluído com sucesso", "Tecnico excluído",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Selecione um tecnico para poder excluir", "Selecione um tecnico",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		if (src == btnEditarTecnico) {
			int row = tabelaTecnicos.getSelectedRow();

			if (row >= 0) {
				String tecnico = tabelaTecnicos.getModel().getValueAt(row, 0).toString();
				new TelaEditarTecnico(tecnico);

			} else {
				JOptionPane.showMessageDialog(null, "Selecione um tecnico para editar", "Selecione um tecnico",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		if (src == btnCadastrarTecnico) {
			new TelaCadastrarTecnico();
		}

		if (src == btnAtualizarTecnico) {
			this.tabelaTecnicos.setModel(contorllerTecnico.gerarLista());
		}

	}
}
