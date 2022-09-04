package controller;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Tecnico;

public class Time {
	
	private model.Database db = model.Database.getInstance();
	private int saida = 0;
	private int qntJogosInt;
	private int qntVitoriasInt;
	private int qntEmpatesInt;
	private int qntDerrotasInt;
	private int qntGolsFeitosInt;
	private int qntGolsSofridosInt;
	private String idTecnicoAtual;
	private String idTecnicoNovo;
	
	public ArrayList<model.Time> getTimes() {
		this.db.ordenarTabela("ASC");
		return this.db.getTimes();  
	}
	
	public DefaultTableModel dadosTabela() {
		DefaultTableModel modeloTabelaTimes = new DefaultTableModel();
		
		modeloTabelaTimes.addColumn("UUID");
		modeloTabelaTimes.addColumn("TIMES");
		modeloTabelaTimes.addColumn("PONTOS");
		getTimes().forEach(time -> {
			modeloTabelaTimes.addRow(new Object[] { time.getUuid(), time.getNome(), time.getPontos() });
		});
		
		return modeloTabelaTimes; 
		 
	}
	
	public int editar(String timeid, String nome, String tecnicoAtual,String tecnicoNovo, String qntJogos, String qntVitorias, 
			String qntEmpates, String qntDerrotas, String qntGolsFeitos, String qntGolsSofridos) {
		
		int saida = 0;
		idTecnicoAtual = (tecnicoAtual != "null") ? null: tecnicoAtual;
		idTecnicoNovo = (tecnicoAtual != "null") ? null: tecnicoNovo;

		
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
			model.Time time = db.updateTime(timeid, nome, qntJogosInt, qntVitoriasInt, 
					qntEmpatesInt, qntDerrotasInt, qntGolsFeitosInt, qntGolsSofridosInt);
			
			if(idTecnicoAtual != idTecnicoNovo) {
				model.Tecnico tecnicoAntigo = db.getTecnico(idTecnicoAtual);
				tecnicoAntigo.setTime(null);
				time.setTecnico(tecnicoNovo);
			}
		}
		
		

		return saida;
	}
	
}
