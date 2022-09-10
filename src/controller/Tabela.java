package controller;

import javax.swing.table.DefaultTableModel;

/**
* Classe responsável validar e gerenciar dados da tabela e servir a views 
* @author  Weslley Barros
* @version 1.0
*/

public class Tabela {
	
	private model.Database tabela = model.Database.getInstance();
	private int contador;
	
	/**
	 * Gerar lista com o modelo de tabela do brasileirão
	 * @author Weslley Barros
	 * @return DefaultTableModel - tabela do brasileirão
	 */
	
	public DefaultTableModel dadosTabela() {
		this.contador = 1;
		tabela.ordenarTabela();
		DefaultTableModel modeloTabela = new DefaultTableModel();

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

		this.tabela.getTimes().forEach((time) -> {
			
			modeloTabela.addRow(new Object[] { contador + " - " + time.getNome(), time.getPontos(), time.getQntJogos(),
			time.getQntVitorias(), time.getQntEmpates(), time.getQntDerrotas(), time.getQntGolsFeitos(),
			time.getQntGolsSofridos(), time.getSaldoGols(), time.getAproveitamento() + "%" });
			contador++;

		});
		
		return modeloTabela;
	}
}
