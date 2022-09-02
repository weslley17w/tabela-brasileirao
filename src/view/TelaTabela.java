package view;

import javax.swing.*;
import model.Time;

import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;

public class TelaTabela extends JFrame {

	private static final long serialVersionUID = -5547498367822791169L;
	private JLabel titulo = new JLabel("BRASILEIRÃO SÉRIE A");
	private JTable tabelaBrasileirao = new JTable();
	private int contador;

	public TelaTabela() {
		setTitle("Tabela Brasileirão Série A");
		setResizable(false);
		setVisible(true);
		setSize(800, 700);
		setLayout(null);
		titulo.setFont(new Font("Calibri", Font.BOLD, 20));
		titulo.setBounds(290, 20, 175, 30);
		titulo.setVisible(true);

		this.Tabela();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	private void Tabela() {

		this.dadosTabela();
		add(titulo);
		tabelaBrasileirao.setDefaultEditor(Object.class, null);
		tabelaBrasileirao.setBounds(0, 50, 500, 500);
		JScrollPane scrollPane = new JScrollPane(tabelaBrasileirao);
		tabelaBrasileirao.setFillsViewportHeight(true);
		scrollPane.setBounds(0, 50, 800, 800);
		add(scrollPane);

		setVisible(true);

	}

	private void dadosTabela() {
		contador = 1;
		DefaultTableModel modeloTabela = new DefaultTableModel();
		this.tabelaBrasileirao.setModel(modeloTabela);
		controller.Tabela controlerTabela = new controller.Tabela();

		modeloTabela.addColumn("CLASSIFICAÇÃO");
		modeloTabela.addColumn("P");
		modeloTabela.addColumn("J");
		modeloTabela.addColumn("V");
		modeloTabela.addColumn("E");
		modeloTabela.addColumn("D");
		modeloTabela.addColumn("GP");
		modeloTabela.addColumn("GC");
		modeloTabela.addColumn("SG");
		modeloTabela.addColumn("%");

		ArrayList<Time> times = controlerTabela.getDados();

		times.forEach((time) -> {

			modeloTabela.addRow(new Object[] { contador + " - " + time.getNome(), time.getPontos(), time.getQntJogos(),
			time.getQntVitorias(), time.getQntEmpates(), time.getQntDerrotas(), time.getQntGolsFeitos(),
			time.getQntGolsSofridos(), time.getSaldoGols(), time.getAproveitamento() + "%" });
			contador++;

		});

	}

}