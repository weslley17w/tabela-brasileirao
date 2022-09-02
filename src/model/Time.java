package model;

import java.util.ArrayList;
import java.util.Collections;


public class Time {
	private String nome;
	private String tecnico;
	ArrayList<String> jogadores;
	private int qntJogos = 0;
	private int qntVitorias = 0;
	private int qntEmpates = 0;
	private int qntDerrotas = 0;
	private int qntGolsFeitos = 0;
	private int qntGolsSofridos = 0;
	
	
	public Time(String nome, int qntJogos, int qntVitorias, int qntEmpates, int qntDerrotas, int qntGolsFeitos, int qntGolsSofridos) {
		this.setNome(nome);
		this.setQntJogos(qntJogos);
		this.setQntVitorias(qntVitorias);
		this.setQntEmpates(qntEmpates);
		this.setQntDerrotas(qntDerrotas);
		this.setQntGolsFeitos(qntGolsFeitos);
		this.setQntGolsSofridos(qntGolsSofridos);
	}
	
	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public Time(String nome) {
		this.setNome(nome);
	}
	

	boolean demitirJogador(Jogador jogador) {

		return true;
	}

	boolean demitirTecnico(Tecnico tecnico) {

		return true;
	}

	
	public int getQntVitorias() {
		return qntVitorias;
	}

	public void setQntVitorias(int qntVitorias) {
		this.qntVitorias = qntVitorias;
	}

	public int getQntEmpates() {
		return qntEmpates;
	}

	public void setQntEmpates(int qntEmpates) {
		this.qntEmpates = qntEmpates;
	}
	
	public int getSaldoGols() {
		return (this.qntGolsFeitos - this.qntGolsSofridos);
	}
	
	public int getAproveitamento() {
		if (this.getQntJogos() == 0) {
			return 0;
		}else {
			return ((this.getPontos() * 100) / (this.getQntJogos() * 3));
		}
	}

	public int getQntDerrotas() {
		return qntDerrotas;
	}

	public void setQntDerrotas(int qntDerrotas) {
		this.qntDerrotas = qntDerrotas;
	}

	public int getQntGolsFeitos() {
		return qntGolsFeitos;
	}

	public void setQntGolsFeitos(int qntGolsFeitos) {
		this.qntGolsFeitos = qntGolsFeitos;
	}

	public int getQntGolsSofridos() {
		return qntGolsSofridos;
	}

	public void setQntGolsSofridos(int qntGolsSofridos) {
		this.qntGolsSofridos = qntGolsSofridos;
	}

	public void gerarArtilheiros(Tecnico tecnico) {

	}

	public void jogo(int golsPro, int golsContra) {
		this.qntJogos++; 
		this.qntGolsFeitos   += golsPro;
		this.qntGolsSofridos += golsContra;
		
		if(golsPro > golsContra){
			qntVitorias++;
		}else if(golsPro < golsContra){
			qntDerrotas++;
		}else {
			qntEmpates++;
		}
	}

	public int getQntJogos() {
		return qntJogos;
	}

	public void setQntJogos(int qntJogos) {
		this.qntJogos = qntJogos;
	}

	public int getPontos() {

		return (qntVitorias * 3) + qntEmpates;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
