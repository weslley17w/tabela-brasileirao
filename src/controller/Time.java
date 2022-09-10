package controller;

import javax.swing.table.DefaultTableModel;

/**
* Responsável por validar,gerenciar dados dos times e servir as views 
* @author  Weslley Barros
* @version 1.0
*/

public class Time {

	private model.Database db = model.Database.getInstance();
	private int qntJogosInt;
	private int qntVitoriasInt;
	private int qntEmpatesInt;
	private int qntDerrotasInt;
	private int qntGolsFeitosInt;
	private int qntGolsSofridosInt;
	int QntGolsSofridos; 
	private String idTecnicoNovo;

	/**
	 * Gera lista com todos os time, coms campos TIMES, PONTOS em irdem alfabetica
	 * @author Weslley Barros
	 * @return DefaultTableModel - Gera lista com todos os times, com os campos TIMES, PONTOS em ordem alfabética
	 */
	
	public DefaultTableModel dadosTabela() {
		this.db.ordenarTabela("ASC");
		DefaultTableModel modeloTabelaTimes = new DefaultTableModel();

		modeloTabelaTimes.addColumn("TIMES");
		modeloTabelaTimes.addColumn("PONTOS");
		db.getTimes().forEach(time -> {
			modeloTabelaTimes.addRow(new Object[] { time.getNome(), time.getPontos() });
		});

		return modeloTabelaTimes;

	}
	
	/**
	 * editar Time
	 * @param timeid - Time
	 * @param nome - Nome do time
	 * @param tecnicoNovo - Nome do técnico
	 * @param qntJogos - Quantidade de jogos
	 * @param qntVitorias - Quantidade de vitórias
	 * @param qntEmpates - Quantidade de empates
	 * @param qntDerrotas - Quantidade de Derrotas
	 * @param qntGolsFeitos - Quantidade de Feitos
	 * @param qntGolsSofridos - Quantidade de Sofridos
	 * @return int - 0 = time editado com sucesso, 1 = campos qntJogos, qntVitorias, qntEmpates, qntDerrotas, qntGolsFeitos e qntGolsSofridos devem ser um inteiro,
	 * 3 = todos campos são obrigatórios
	 */
	
	public int editar(model.Time timeid, String nome, String tecnicoNovo, String qntJogos, String qntVitorias,
			String qntEmpates, String qntDerrotas, String qntGolsFeitos, String qntGolsSofridos) {

		int saida = 0;
		this.idTecnicoNovo = (tecnicoNovo == "Sem Técnico") ? null : tecnicoNovo;

		try {
			this.qntJogosInt = Integer.parseInt(qntJogos);
			this.qntVitoriasInt = Integer.parseInt(qntVitorias);
			this.qntEmpatesInt = Integer.parseInt(qntEmpates);
			this.qntDerrotasInt = Integer.parseInt(qntDerrotas);
			this.qntGolsFeitosInt = Integer.parseInt(qntGolsFeitos);
			this.qntGolsSofridosInt = Integer.parseInt(qntGolsSofridos);
		} catch (NumberFormatException ex) {
			saida = 1;
		}

		if (nome.isEmpty() || qntJogos.isEmpty() || qntVitorias.isEmpty() || qntEmpates.isEmpty()
				|| qntDerrotas.isEmpty() || qntGolsFeitos.isEmpty() || qntGolsSofridos.isEmpty()) {
			saida = 2;
		}

		if (saida == 0) {
			timeid.update(nome, this.qntJogosInt, this.qntVitoriasInt, this.qntEmpatesInt, this.qntDerrotasInt, this.qntGolsFeitosInt,
					this.qntGolsSofridosInt);

			if (timeid.verificarTecnico()) {
				
				if(this.idTecnicoNovo != null) {
					timeid.getTecnico().setTime(null);
					timeid.setTecnico(null);
					model.Tecnico tecnico = db.getTecnicos(this.idTecnicoNovo);
					tecnico.setTime(nome);
					timeid.setTecnico(tecnico);
				}else {
					timeid.getTecnico().setTime(null);
					timeid.setTecnico(null);
				}
				
			} else {
				if (this.idTecnicoNovo != null) {
					model.Tecnico tecnico = db.getTecnicos(this.idTecnicoNovo);
					tecnico.setTime(nome);
					timeid.setTecnico(tecnico);
				}
			}
		}

		return saida;
	}
	
	/**
	 * contratar um jogador do time
	 * @param nome - Nome do jogador
	 * @param time - time
	 * @return int - 0 = jogador contratado com sucesso
	 */
	
	public int contrato(String nome, model.Time time) {

		model.Jogador jogador = db.getJogadores(nome);
		jogador.setTime(time.getNome());
		time.contratarJogador(jogador);

		return 0;
	}
	
	/**
	 * cadastrar Time
	 * @param nome - Nome do time
	 * @param qntJogos - Quantidade de jogos
	 * @param inputQntVitorias - Quantidade de vitórias
	 * @param inputQntEmpates - Quantidade de empates
	 * @param inputQntDerrotas - Quantidade de Derrotas
	 * @param inputQntGolsFeitos - Quantidade de Feitos
	 * @param inputQntGolsSofridos - Quantidade de Sofridos
	 * @return int - 0 = time cadastrado com sucesso, 1 = campos qntJogos, qntVitorias, qntEmpates, qntDerrotas, qntGolsFeitos e qntGolsSofridos devem ser um inteiro,
	 * 3 = todos campos são obrigatórios
	 */
	
	public int cadastrar(String nome, String qntJogos,String inputQntVitorias, String inputQntEmpates, String inputQntDerrotas, 
			String inputQntGolsFeitos, String inputQntGolsSofridos) {
		int saida = 0;
		
		try {
			this.qntJogosInt     = Integer.parseInt(qntJogos);
			this.qntVitoriasInt  = Integer.parseInt(inputQntVitorias);
			this.qntEmpatesInt      = Integer.parseInt(inputQntEmpates);
			this.qntDerrotasInt     = Integer.parseInt(inputQntDerrotas);
			this.qntGolsFeitosInt   = Integer.parseInt(inputQntGolsFeitos);
			this.qntGolsSofridosInt = Integer.parseInt(inputQntGolsSofridos);
		} catch (final NumberFormatException e) {
			saida = 3;
		}
		
		if (nome.isEmpty() || nome.isEmpty() || qntJogos.isEmpty() || inputQntVitorias.isEmpty() || inputQntEmpates.isEmpty()
				|| inputQntDerrotas.isEmpty() || inputQntGolsFeitos.isEmpty() || inputQntGolsSofridos.isEmpty()) {
			saida = 2;
		}

		if (saida == 0) {
			model.Time time = new model.Time(nome, this.qntJogosInt, this.qntVitoriasInt, this.qntEmpatesInt, 
					this.qntDerrotasInt, this.qntGolsFeitosInt, this.qntGolsSofridosInt);
			db.adicionarTime(time);
		}

		return saida;
	}
	
	/**
	 * demitir um jogador do time
	 * @param nomeJogador - Nome do jogador
	 * @param time - time
	 * @return int - 0 = jogador demitido com sucesso
	 */
	
	public int demitir(String nomeJogador, model.Time time) {
		int saida = 0;
		model.Jogador jogador = db.getJogadores(nomeJogador);
		jogador.setTime(null);
		time.demitirJogador(jogador);
		return saida;
	}

}
