package controller;

import javax.swing.table.DefaultTableModel;

public class Jogador {



	private model.Database db = model.Database.getInstance();

	public DefaultTableModel gerarLista() {
		this.db.ordenarTecnico("ASC");
		DefaultTableModel modeloTabelaJogador = new DefaultTableModel();
		modeloTabelaJogador.addColumn("UUID");
		modeloTabelaJogador.addColumn("NOME");
		modeloTabelaJogador.addColumn("QUANTIDADE DE GOLS");

		db.getJogadores().forEach(jogador -> {
			modeloTabelaJogador
					.addRow(new Object[] { jogador.getUuid(), jogador.getNome(), jogador.getQntGols()});
		});

		return modeloTabelaJogador;
	}

	
}
