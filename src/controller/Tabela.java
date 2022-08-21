package controller;

public class Tabela {
	private String nome;
	private Time times[];
	
	public Boolean adicionarTime(Time time) {
		
		return true;
	}
	
	public Boolean excluirTime(Time time) {
		
		return true;
	}
	
	public Time[] gerarTabela() {
		
		return times;
	}
	
//	public jogador[]  gerarArtilheiros() {
//		
//		return jogadores;
//	}
//	
//	public tecnico[]  gerarrankTecnicos() {
//		
//		return tecnicos;
//	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
