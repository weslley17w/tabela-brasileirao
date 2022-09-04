package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Jogador {


	private boolean passaporteEuropeu;
	private float   salario;
	private float   multa;
	private int     qntGols;
	private model.Database db = model.Database.getInstance();
	
	public ArrayList<model.Jogador> getJogadores() {
		return this.db.getJogadores();  
	}

	public DefaultTableModel gerarLista() {
		this.db.ordenarJogadores("ASC");
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
	
	public int cadastrar(String nome, String nacionalidade,String dtNascimento, String salario, String multa, String qntGols, String passaporteEuropeu) {
		int saida = 0;


		if (passaporteEuropeu == "Sim") {
			this.passaporteEuropeu = true;
		} else {
			this.passaporteEuropeu = false;
		}


		try {
			this.salario = Float.parseFloat(salario);
			this.multa = Float.parseFloat(multa);
		} catch (NumberFormatException ex) {
			saida = 3;
		}

		try {
			this.qntGols = Integer.parseInt(qntGols);
		} catch (final NumberFormatException e) {
			saida = 4;
		}
		
		if (nome.isEmpty() || dtNascimento.isEmpty() || nacionalidade.isEmpty() || salario.isEmpty() || multa.isEmpty()
				|| multa.isEmpty() || qntGols.isEmpty() || passaporteEuropeu.isEmpty()) {
			saida = 2;
		}

		if (saida == 0) {
			model.Jogador jogador = new model.Jogador(nome,nacionalidade,dtNascimento, this.salario, this.multa, this.qntGols, this.passaporteEuropeu);
			this.db.adicionarJogador(jogador);
		}
		
		

		return saida;
	}
	
	public int editar(String id, String nome, String nacionalidade,String dtNascimento, String salario, String multa, String qntGols, String passaporteEuropeu) {
		int saida = 0;


		if (passaporteEuropeu == "Sim") {
			this.passaporteEuropeu = true;
		} else {
			this.passaporteEuropeu = false;
		}


		try {
			this.salario = Float.parseFloat(salario);
			this.multa = Float.parseFloat(multa);
		} catch (NumberFormatException ex) {
			saida = 3;
		}

		try {
			this.qntGols = Integer.parseInt(qntGols);
		} catch (final NumberFormatException e) {
			saida = 4;
		}
		
		if (nome.isEmpty() || dtNascimento.isEmpty() || nacionalidade.isEmpty() || salario.isEmpty() || multa.isEmpty()
				|| multa.isEmpty() || qntGols.isEmpty() || passaporteEuropeu.isEmpty()) {
			saida = 2;
		}

		if (saida == 0) {
			db.updateJogador(id, nome, nacionalidade,dtNascimento, this.salario, this.multa, this.qntGols, this.passaporteEuropeu);
		}
		
		

		return saida;
	}
	
	public DefaultTableModel tabelaJogadoresPorTime(String timeid) {
		this.db.ordenarJogadores("ASC");
		DefaultTableModel modeloTabelaTimes = new DefaultTableModel();
		
		modeloTabelaTimes.addColumn("UUID");
		if(timeid == null) {
			modeloTabelaTimes.addColumn("JOGADORES SEM TIME");
		}else {
			modeloTabelaTimes.addColumn("JOGADORES DO TIME");
		}
		
		getJogadores().forEach(jogador -> {
			if(jogador.getTime() == timeid) {
				modeloTabelaTimes.addRow(new Object[] { jogador.getUuid(), jogador.getNome()});
			}
		});
		
		return modeloTabelaTimes; 
		 
	}
	
	public int contratrar(String jogadorId, String timeId) {
		int saida = 0;
		model.Jogador jogador = db.getJogador(jogadorId);
		
		if(jogador.getTime() != null) {
			saida = 1;
		}else {
			jogador.setTime(timeId);
		}
		
		return saida;
	}
	
	public int demitir(String jogadorId, String timeId) {
		int saida = 0;
		model.Jogador jogador = db.getJogador(jogadorId);
		
		if(jogador.getTime() == timeId) {
			jogador.setTime(null);			
		}else {
			saida = 1;
		}
		
		return saida;
	}

	
}
