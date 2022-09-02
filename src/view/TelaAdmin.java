package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class TelaAdmin implements ActionListener{

	JTabbedPane tabbedPane = new JTabbedPane();
	JFrame frame = new JFrame();
	private static JButton btnCadastrarTime = new JButton("Cadastrar");
	private static JButton btnEditarTime = new JButton("Editar");
	private static JButton btnAtualizarTecnico = new JButton("Atualizar");
	private static JButton btnCadastrarTecnico = new JButton("Cadastrar");
	private static JButton btnEditarTecnico = new JButton("Editar");
	private static JLabel tituloTimes = new JLabel("Times");
	private JTable tabelaTimes = new JTable();
	private JTable tabelaTecnicos = new JTable();
	private static controller.Times contorllerTimes = new controller.Times();
	private static controller.Tecnico contorllerTecnico = new controller.Tecnico();

	public TelaAdmin() {
		frame.setTitle("Jogadores");
		tabbedPane.addTab("Times", times());
		tabbedPane.addTab("Técnicos", tecnicos());
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
		
		if(src == btnCadastrarTime) {
			new TelaCadastrarTime();
		}
			
			
		
		if(src == btnEditarTime) {
			
			int row = tabelaTimes.getSelectedRow();
			
			if(row != -1) {
				String time = tabelaTimes.getModel().getValueAt(row, 0).toString();
				System.out.println(row);
			}else {
				String time = "erro";
				System.out.println(time);
			}

			
			
		}
		
		if(src == btnEditarTecnico) {
			int row = tabelaTecnicos.getSelectedRow();
			if(row >= 0) {
				String tecnico = tabelaTecnicos.getModel().getValueAt(row, 0).toString();
				System.out.println(tecnico);
				new TelaEditarTecnico(tecnico);
				
				//frame.dispose();

			}else {
				JOptionPane.showMessageDialog(null, "Selecione um tecnico para editar",
						"Selecione um tecnico", JOptionPane.WARNING_MESSAGE);	
			}
		}
		
		if(src == btnCadastrarTecnico) {
			new TelaCadastrarTecnico();
			frame.dispose();
		}
		
		if(src == btnAtualizarTecnico) {
			frame.repaint();
			this.tabelaTecnicos.setModel(contorllerTecnico.gerarLista());
			TableColumn colunauuid = this.tabelaTecnicos.getTableHeader().getColumnModel().getColumn(0);
			colunauuid.setPreferredWidth(0);
			colunauuid.setMinWidth(0);
			colunauuid.setMaxWidth(0);
		}
		
			

		
	}

	public JComponent tecnicos() {
		JPanel panelTecnicos 	  = new JPanel();
		panelTecnicos.setLayout(null);
		this.tabelaTecnicos.setModel(contorllerTecnico.gerarLista());
		TableColumn colunauuid = this.tabelaTecnicos.getTableHeader().getColumnModel().getColumn(0);
		colunauuid.setPreferredWidth(0);
		colunauuid.setMinWidth(0);
		colunauuid.setMaxWidth(0);
		JLabel tituloTecnico  = new JLabel("Técnicos");
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
		frame.setVisible(true);
		tituloTimes.setVisible(true);
		return panelTecnicos;
	}
}