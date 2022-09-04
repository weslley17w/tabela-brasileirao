package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Tecnico {

	private float salario;
	private float multa;
	private int qntVitorias;
	private int qntEmpates;
	private int qntDerrotas;
	private Boolean licencaCBF;
	private Boolean licencaInternacional;

	private model.Database db = model.Database.getInstance();

	public DefaultTableModel gerarLista() {
		this.db.ordenarTecnico("ASC");
		DefaultTableModel modeloTabelaTecnicos = new DefaultTableModel();
		modeloTabelaTecnicos.addColumn("UUID");
		modeloTabelaTecnicos.addColumn("NOME");
		modeloTabelaTecnicos.addColumn("APROVEITAMENTO");

		db.getTecnicos().forEach(tecnico -> {
			modeloTabelaTecnicos
					.addRow(new Object[] { tecnico.getUuid(), tecnico.getNome(), tecnico.getAproveitamento() + "%" });
		});

		return modeloTabelaTecnicos;
	}

	public int Cadastrar(String nome, String dataNas, String nacionalidade, String salario, String multa,
			String licencaCBF, String licencaInternacional, String qntVitorias, String qntEmpates, String qntDerrotas) {
		int saida = 0;

		if (nome.isEmpty() || dataNas.isEmpty() || nacionalidade.isEmpty() || salario.isEmpty() || multa.isEmpty()
				|| qntVitorias.isEmpty() || qntEmpates.isEmpty() || qntDerrotas.isEmpty()) {
			saida = 2;
		}

		if (licencaCBF == "Sim") {
			this.licencaCBF = true;
		} else {
			this.licencaCBF = false;
		}

		if (licencaInternacional == "Sim") {
			this.licencaInternacional = true;
		} else {
			this.licencaInternacional = false;
		}

		try {
			this.salario = Float.parseFloat(salario);
			this.multa = Float.parseFloat(multa);
		} catch (NumberFormatException ex) {
			saida = 3;
		}

		try {
			this.qntVitorias = Integer.parseInt(qntVitorias);
			this.qntEmpates = Integer.parseInt(qntEmpates);
			this.qntDerrotas = Integer.parseInt(qntDerrotas);
		} catch (final NumberFormatException e) {
			saida = 4;
		}

		if (saida == 0) {
			model.Tecnico tenico = new model.Tecnico(nome, nacionalidade, dataNas, this.salario, this.multa,
					this.licencaCBF, this.licencaInternacional, this.qntVitorias, this.qntEmpates, this.qntDerrotas);
			this.db.adicionarTecnico(tenico);
		}

		return saida;
	}

	public int Editar(String id, String nome, String dataNas, String nacionalidade, String salario, String multa,
			String licencaCBF, String licencaInternacional, String qntVitorias, String qntEmpates, String qntDerrotas) {
		int saida = 0;

		if (nome.isEmpty() || dataNas.isEmpty() || nacionalidade.isEmpty() || salario.isEmpty() || multa.isEmpty()
				|| qntVitorias.isEmpty() || qntEmpates.isEmpty() || qntDerrotas.isEmpty()) {
			saida = 2;
		}

		if (licencaCBF == "Sim") {
			this.licencaCBF = true;
		} else {
			this.licencaCBF = false;
		}

		if (licencaInternacional == "Sim") {
			this.licencaInternacional = true;
		} else {
			this.licencaInternacional = false;
		}

		try {
			this.salario = Float.parseFloat(salario);
			this.multa = Float.parseFloat(multa);
		} catch (NumberFormatException ex) {
			saida = 3;
		}

		try {
			this.qntVitorias = Integer.parseInt(qntVitorias);
			this.qntEmpates = Integer.parseInt(qntEmpates);
			this.qntDerrotas = Integer.parseInt(qntDerrotas);
		} catch (final NumberFormatException e) {
			saida = 4;
		}

		if (saida == 0) {
			this.db.updateTecnico(id, nome, nacionalidade, dataNas, this.salario, this.multa, this.licencaCBF,
					this.licencaInternacional, this.qntVitorias, this.qntEmpates,this.qntDerrotas);
		}

		return saida;
	}
	
	public String[] allNomesTecnicosSemtime() {
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add("Sem Técnico");
		for (model.Tecnico tecnico : db.getTecnicos()) {
			if(tecnico.getTime() == null) {
				nomes.add(tecnico.getNome());
			}
		}
		String[] strings = nomes.stream().toArray(String[]::new);
		return strings;
	}

}
