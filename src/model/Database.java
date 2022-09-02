package model;

import java.util.ArrayList;
import java.util.Comparator;

public class Tabela {
	private static Tabela uniqueInstance = new Tabela();
	private String nome;
	ArrayList<Time> times = new ArrayList<>();

	private Tabela() {
	}

	public static Tabela getInstance() {
		return uniqueInstance;
	}

	public void adicionarTime(Time time) {
		times.add(time);
	}

	public Boolean excluirTime(Time time) {

		return true;
	}

	public void ordenarTabela() {
		times.sort(Comparator.comparing(Time::getQntGolsFeitos).reversed());
		times.sort(Comparator.comparing(Time::getSaldoGols).reversed());
		times.sort(Comparator.comparing(Time::getQntVitorias).reversed());
		times.sort(Comparator.comparing(Time::getPontos).reversed());
	}

	public void ordenarTabela(String order) {
		if (order == "ASC") {
			times.sort(Comparator.comparing(Time::getNome));
		} else if (order == "DESC") {
			times.sort(Comparator.comparing(Time::getNome).reversed());	
		} else {
			times.sort(Comparator.comparing(Time::getQntGolsFeitos).reversed());
			times.sort(Comparator.comparing(Time::getSaldoGols).reversed());
			times.sort(Comparator.comparing(Time::getQntVitorias).reversed());
			times.sort(Comparator.comparing(Time::getPontos).reversed());		
		}
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

	public ArrayList<Time> getTimes() {
		return times;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static void setUniqueInstance(Tabela uniqueInstance) {
		Tabela.uniqueInstance = uniqueInstance;
	}
}
