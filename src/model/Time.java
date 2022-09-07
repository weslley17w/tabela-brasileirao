package model;

import java.util.ArrayList;

public class Time {
	private String nome;
	private Tecnico tecnico;
	ArrayList<Jogador> jogadores = new ArrayList<>();
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
	
	public Time update(String nome, int qntJogos, int qntVitorias, 
			int qntEmpates, int qntDerrotas, int qntGolsFeitos, int qntGolsSofridos) {
		Time saida = null;

				this.setNome(nome);
				this.setQntJogos(qntJogos);
				this.setQntVitorias(qntVitorias);
				this.setQntEmpates(qntEmpates);
				this.setQntDerrotas(qntDerrotas);
				this.setQntGolsFeitos(qntGolsFeitos);
				this.setQntGolsSofridos(qntGolsSofridos);
				saida = this;

		return saida;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}
	
	public boolean verificarTecnico() {
		boolean saida = true;
		if(getTecnico() == null) {
			saida = false;
		}
		return saida;
	}
	
	public void contratarJogador(model.Jogador jogador) {
		jogadores.add(jogador);
	}
	
	public void dimitirJogador(model.Jogador jogador) {
		jogadores.remove(jogador);
	}


	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
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
