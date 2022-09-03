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

import view.TelaCadastrarTecnico;
import view.TelaEditarTecnico;

public class Tecnicos implements ActionListener {

	private JTable tabelaTecnicos = new JTable();
	private static controller.Tecnico contorllerTecnico = new controller.Tecnico();
	private static JButton btnAtualizarTecnico = new JButton("Atualizar");
	private static JButton btnCadastrarTecnico = new JButton("Cadastrar");
	private static JButton btnEditarTecnico = new JButton("Editar");

	public JComponent pane() {
		JPanel panelTecnicos = new JPanel();
		panelTecnicos.setLayout(null);
		this.tabelaTecnicos.setModel(contorllerTecnico.gerarLista());
		TableColumn colunauuid = this.tabelaTecnicos.getTableHeader().getColumnModel().getColumn(0);
		colunauuid.setPreferredWidth(0);
		colunauuid.setMinWidth(0);
		colunauuid.setMaxWidth(0);
		JLabel tituloTecnico = new JLabel("Técnicos");
		tabelaTecnicos.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(tabelaTecnicos);

		tituloTecnico.setFont(new Font("Calibri", Font.BOLD, 20));
		tituloTecnico.setBounds(250, 20, 80, 25);

		btnAtualizarTecnico.setBounds(446, 20, 91, 28);
		btnCadastrarTecnico.setBounds(446, 370, 91, 28);
		btnEditarTecnico.setBounds(350, 370, 91, 28);
		tabelaTecnicos.setFillsViewportHeight(true);
		scrollPane.setBounds(38, 60, 500, 300);
		btnCadastrarTecnico.addActionListener(this);
		btnEditarTecnico.addActionListener(this);
		btnAtualizarTecnico.addActionListener(this);

		panelTecnicos.add(tituloTecnico);
		panelTecnicos.add(scrollPane);
		panelTecnicos.add(btnAtualizarTecnico);
		panelTecnicos.add(btnEditarTecnico);
		panelTecnicos.add(btnCadastrarTecnico);
		return panelTecnicos;
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

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
			TableColumn colunauuid = this.tabelaTecnicos.getTableHeader().getColumnModel().getColumn(0);
			colunauuid.setPreferredWidth(0);
			colunauuid.setMinWidth(0);
			colunauuid.setMaxWidth(0);
		}

	}
}
