package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
* Responsável por validar,gerenciar dados dos tecnicos e servir a views 
* @author  Weslley Barros
* @version 1.0
*/
public class Tecnico {

	private float salario;
	private float multa;
	private int qntVitorias;
	private int qntEmpates;
	private int qntDerrotas;
	private Boolean licencaCBF;
	private Boolean licencaInternacional;
	private int contador;

	private model.Database db = model.Database.getInstance();
	
	/**
	 * Gera lista com todos técnicos
	 * @author Weslley Barros
	 * @return DefaultTableModel - Retorna o modelo de tabela com todos técnicos
	 */
	
	public DefaultTableModel dadosTabela() {
		this.db.ordenarTecnico("ASC");
		DefaultTableModel modeloTabelaTecnicos = new DefaultTableModel();
		modeloTabelaTecnicos.addColumn("NOME");
		modeloTabelaTecnicos.addColumn("APROVEITAMENTO");

		db.getTecnicos().forEach(tecnico -> {
			modeloTabelaTecnicos
					.addRow(new Object[] {tecnico.getNome(), tecnico.getAproveitamento() + "%" });
		});

		return modeloTabelaTecnicos;
	}
	
	/**
	 * cadastrar Tecnico
	 * @param nome - Nome do tecnico
	 * @param nacionalidade - Nacionalidade do técnico
	 * @param dataNas - Data de nascimento do técnico
	 * @param salario - Salario do jogador
	 * @param multa - Multa do jogador
	 * @param licencaCBF - licença CBF
	 * @param licencaInternacional - licença Internacional
	 * @param qntVitorias - Quantidade de vitórias
	 * @param qntEmpates - Quantidade de dmpates
	 * @param qntDerrotas - Quantidade de derrotas
	 * @return int - 0 = tecnico cadastrado com sucesso, 2 = erro: campos vazios,  
	 * 3 = salario é multa não são floats e 4 = erro: campo qntVitorias, qntEmpates e qntDerrotas não é inteiro
	 */
	
	public int cadastrar(String nome, String dataNas, String nacionalidade, String salario, String multa,
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
	
	/**
	 * editar Tecnico
	 * @param tecnico - Tecnico
	 * @param nome - Nome do tecnico
	 * @param nacionalidade - Nacionalidade do técnico
	 * @param dataNas - Data de nascimento do técnico
	 * @param salario - Salario do jogador
	 * @param multa - Multa do jogador
	 * @param licencaCBF - licença CBF
	 * @param licencaInternacional - licença Internacional
	 * @param qntVitorias - Quantidade de vitórias
	 * @param qntEmpates - Quantidade de dmpates
	 * @param qntDerrotas - Quantidade de derrotas
	 * @return int - 0 = tecnico cadastrado com sucesso, 2 = erro: campos vazios,  
	 * 3 = salario é multa não são floats e 4 = erro: campo qntVitorias, qntEmpates e qntDerrotas não é inteiro
	 */
	
	public int update(model.Tecnico tecnico, String nome, String dataNas, String nacionalidade, String salario, String multa,
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
			tecnico.update(nome, nacionalidade, dataNas, this.salario, this.multa, this.licencaCBF,
					this.licencaInternacional, this.qntVitorias, this.qntEmpates,this.qntDerrotas);
		}

		return saida;
	}
	
	/**
	 * deleta um técnico
	 * @author Weslley Barros
	 * @param nome - Nome do técnico
	 * @return int - 0 = técnico excluído com sucesso,  1 = técnico não encontrado e 2 = você não pode excluir um técnico com contrato vigente 
	 */
	
	public int deletar(String nome) {
		int saida = 0;
			if(db.getTecnicos(nome) == null) {
				saida = 1;
			}
			
			if(db.getTecnicos(nome).getTime() != null) {
				saida = 2;
			}
			
			if(saida == 0) {
				db.removeTecnico(db.getTecnicos(nome));
			}
			
			
		return saida;
	}
	
	/**
	 * Gerar lista com todos técnicso sem time + o tecnico do time
	 * @author Weslley Barros
	 * @param time - Time 
	 * @return String[] - Retorna um array de string com todos tecnicos sem time + o tecnico do time
	 */
	
	public String[] allNomesTecnicosSemtime(model.Time time) {
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add("Sem Técnico");
		for (model.Tecnico tecnico : db.getTecnicos()) {
			if(tecnico.getTime() == null) {
				nomes.add(tecnico.getNome());
			}
		}
		if(time.verificarTecnico()) {
			nomes.add(time.getTecnico().getNome());
		}
		String[] strings = nomes.stream().toArray(String[]::new);
		return strings;
	}
	
	/**
	 * Gerar lista com todos técnicso por ordem de aproveitamento
	 * @author Weslley Barros
	 * @return DefaultTableModel - Retorna o modelo de tabela com todos técnicso
	 */
	
	public DefaultTableModel dadosTecnicos() {

		db.ordenarTecnico();
		DefaultTableModel modeloTabela = new DefaultTableModel();
		this.contador = 1;

		modeloTabela.addColumn("CLASSIFICAÇÃO");
		modeloTabela.addColumn("JOGOS");
		modeloTabela.addColumn("VITÓRIAS");
		modeloTabela.addColumn("EMPARES");
		modeloTabela.addColumn("DERROTAS");
		modeloTabela.addColumn("APROVEITAMENTO");

		this.db.getTecnicos().forEach((tecnicos) -> {
			modeloTabela.addRow(new Object[] { contador + " - " + tecnicos.getNome(), tecnicos.getQntJogos(),
					tecnicos.getQntVitorias(), tecnicos.getQntEmpates(), tecnicos.getQntDerrotas(), tecnicos.getAproveitamento() + "%"});
			this.contador++;

		});
		
		return modeloTabela;
	}

}
