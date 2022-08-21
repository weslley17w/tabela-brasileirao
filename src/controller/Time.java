package controller;

public class Time {
 private String nome;
 private Tecnico tecnico;
 private Jogador jogadores[];
 private int qntVitorias;
 private int qntEmpates;
 private int qntDerrotas;
 private int qntGolsFeitos;
 private int qntGolsSofridos;
 
 boolean demitirJogador(Jogador jogador) {
	 
	 return true;
 }
 
 boolean demitirTecnico(Tecnico tecnico) {
	 
	 return true;
 }
 
 boolean contratarJogador(Jogador jogador) {
	 
	 return true;
 }
 
boolean contratarTecnico(Tecnico tecnico) {
	 
	 return true;
 }

void gerarArtilheiros(Tecnico tecnico) {
	 

}

boolean jogo() {
	 
	 return true;
}

int getPontos() {
	
	return (qntVitorias * 3) + qntEmpates; 
}
 
 
 
 
}
