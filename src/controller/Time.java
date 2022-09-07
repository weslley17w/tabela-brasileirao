package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Time {

	private model.Database db = model.Database.getInstance();
	private int qntJogosInt;
	private int qntVitoriasInt;
	private int qntEmpatesInt;
	private int qntDerrotasInt;
	private int qntGolsFeitosInt;
	private int qntGolsSofridosInt;
	private String idTecnicoNovo;

	public ArrayList<model.Time> getTimes() {
		this.db.ordenarTabela("ASC");
		return this.db.getTimes();
	}

	public DefaultTableModel dadosTabela() {
		DefaultTableModel modeloTabelaTimes = new DefaultTableModel();

		modeloTabelaTimes.addColumn("TIMES");
		modeloTabelaTimes.addColumn("PONTOS");
		getTimes().forEach(time -> {
			modeloTabelaTimes.addRow(new Object[] { time.getNome(), time.getPontos() });
		});

		return modeloTabelaTimes;

	}

	public int editar(model.Time timeid, String nome, String tecnicoNovo, String qntJogos, String qntVitorias,
			String qntEmpates, String qntDerrotas, String qntGolsFeitos, String qntGolsSofridos) {

		int saida = 0;
		this.idTecnicoNovo = (tecnicoNovo == "Sem Técnico") ? null : tecnicoNovo;

		try {
			qntJogosInt = Integer.parseInt(qntJogos);
			qntVitoriasInt = Integer.parseInt(qntVitorias);
			qntEmpatesInt = Integer.parseInt(qntEmpates);
			qntDerrotasInt = Integer.parseInt(qntDerrotas);
			qntGolsFeitosInt = Integer.parseInt(qntGolsFeitos);
			qntGolsSofridosInt = Integer.parseInt(qntGolsSofridos);
		} catch (NumberFormatException ex) {
			saida = 1;
		}

		if (nome.isEmpty() || qntJogos.isEmpty() || qntVitorias.isEmpty() || qntEmpates.isEmpty()
				|| qntDerrotas.isEmpty() || qntGolsFeitos.isEmpty() || qntGolsSofridos.isEmpty()) {
			saida = 2;
		}

		if (saida == 0) {
			timeid.update(nome, qntJogosInt, qntVitoriasInt, qntEmpatesInt, qntDerrotasInt, qntGolsFeitosInt,
					qntGolsSofridosInt);

			if (timeid.verificarTecnico()) {
				if(this.idTecnicoNovo != null) {
					timeid.getTecnico().setTime(null);
					timeid.setTecnico(null);
					model.Tecnico tecnico = db.getTecnico(this.idTecnicoNovo);
					tecnico.setTime(nome);
					timeid.setTecnico(tecnico);
				}
				
			} else {
				if (this.idTecnicoNovo != null) {
					model.Tecnico tecnico = db.getTecnico(this.idTecnicoNovo);
					tecnico.setTime(nome);
					timeid.setTecnico(tecnico);
				}
			}
		}

		return saida;
	}

	public int contrato(String nome, model.Time time) {

		model.Jogador jogador = db.getJogador(nome);
		jogador.setTime(time.getNome());
		time.contratarJogador(jogador);

		return 0;
	}

	public int demitir(String nomeJogador, model.Time time) {
		int saida = 0;
		model.Jogador jogador = db.getJogador(nomeJogador);
		jogador.setTime(null);
		time.dimitirJogador(jogador);
		return saida;
	}

}
