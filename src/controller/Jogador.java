package controller;

import javax.swing.table.DefaultTableModel;

public class Jogador {



	private model.Database db = model.Database.getInstance();

	public DefaultTableModel gerarLista() {
		this.db.ordenarTecnico("ASC");
		DefaultTableModel modeloTabelaTecnicos = new DefaultTableModel();
		modeloTabelaTecnicos.addColumn("UUID");
		modeloTabelaTecnicos.addColumn("NOME");
		modeloTabelaTecnicos.addColumn("QUANTIDADE DE GOLS");

		db.getJogadores().forEach(jogador -> {
			modeloTabelaTecnicos
					.addRow(new Object[] { jogador.getUuid(), jogador.getNome(), jogador.getQntGols()});
		});

		return modeloTabelaTecnicos;
	}

	
}
