package model;

import java.util.ArrayList;

/**
*
* Classe responsável por gerenciar os times
*
* @author  Weslley Barros
* @version 1.0
*/

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
	
	/**
	 * criar novo time
	 * @author Weslley Barros
	 * @param nome - nome do time  
	 * @param qntJogos - quantidade de jogos  
	 * @param qntVitorias - quantidade de vitórias   
	 * @param qntEmpates - quantidade de empates   
	 * @param qntDerrotas - quantidade de derrotas     
	 * @param qntGolsFeitos - quantidade de gols feitos  
	 * @param qntGolsSofridos - quantidade de gols sofridos    
	 */
	
	public Time(String nome, int qntJogos, int qntVitorias, int qntEmpates, int qntDerrotas, int qntGolsFeitos, int qntGolsSofridos) {
		this.setNome(nome);
		this.setQntJogos(qntJogos);
		this.setQntVitorias(qntVitorias);
		this.setQntEmpates(qntEmpates);
		this.setQntDerrotas(qntDerrotas);
		this.setQntGolsFeitos(qntGolsFeitos);
		this.setQntGolsSofridos(qntGolsSofridos);
	}
	
	/**
	 * editar o time
	 * @author Weslley Barros
	 * @param nome - nome do time  
	 * @param qntJogos - quantidade de jogos  
	 * @param qntVitorias - quantidade de vitórias   
	 * @param qntEmpates - quantidade de empates   
	 * @param qntDerrotas - quantidade de derrotas     
	 * @param qntGolsFeitos - quantidade de gols feitos  
	 * @param qntGolsSofridos - quantidade de gols sofridos    
	 * @return time - time
	 */
	
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
	
	/**
	 * get Tecnico
	 * @author Weslley Barros
	 * @return Tecnico - técnico
	 */
	
	public Tecnico getTecnico() {
		return tecnico;
	}
	/**
	 * verifica sem um time tem tecnico
	 * @author Weslley Barros
	 * @return boolean - true = tem técnico e false = não tem técnico 
	 */
	
	public boolean verificarTecnico() {
		boolean saida = true;
		if(getTecnico() == null) {
			saida = false;
		}
		return saida;
	}
	
	/**
	 * contratar jogadores 
	 * @author Weslley Barros
	 * @param jogador - nome do jogador
	 */
	
	public void contratarJogador(model.Jogador jogador) {
		jogadores.add(jogador);
	}
	
	/**
	 * exclui o jogador do time
	 * @author Weslley Barros
	 * @param jogador - nome do jogador
	 */
	
	public void demitirJogador(model.Jogador jogador) {
		jogadores.remove(jogador);
	}

	/**
	 * set Tecnico
	 * @author Weslley Barros
	 * @param tecnico - nome do tecnico
	 */
	
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	/**
	 * set Jogador
	 * @author Weslley Barros
	 * @return Jogador - jogadores do time 
	 */
	
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	/**
	 * set Time
	 * @author Weslley Barros
	 * @param nome - nome do site 
	 */
	
	public Time(String nome) {
		this.setNome(nome);
	}
	
	/**
	 * get qntVitorias
	 * @author Weslley Barros
	 * @return int - quantidades de vitórias
	 */
	
	public int getQntVitorias() {
		return qntVitorias;
	}
	
	/**
	 * set qntVitorias
	 * @author Weslley Barros
	 * @param qntVitorias - quantidades de vitórias
	 */
	
	public void setQntVitorias(int qntVitorias) {
		this.qntVitorias = qntVitorias;
	}
	
	/**
	 * get Empates
	 * @author Weslley Barros
	 * @return int - qntEmpates
	 */
	
	public int getQntEmpates() {
		return qntEmpates;
	}
	
	/**
	 * set qntEmpates
	 * @author Weslley Barros
	 * @param qntEmpates - quantidades de empates
	 */
	
	public void setQntEmpates(int qntEmpates) {
		this.qntEmpates = qntEmpates;
	}
	
	/**
	 * get SaldoGols
	 * @author Weslley Barros
	 * @return int - saldo de gols
	 */
	
	public int getSaldoGols() {
		return (this.qntGolsFeitos - this.qntGolsSofridos);
	}
	
	/**
	 * get Aproveitamento
	 * @author Weslley Barros
	 * @return int - Aproveitamento
	 */
	
	public int getAproveitamento() {
		if (this.getQntJogos() == 0) {
			return 0;
		}else {
			return ((this.getPontos() * 100) / (this.getQntJogos() * 3));
		}
	}
	
	/**
	 * get QntDerrotas
	 * @author Weslley Barros
	 * @return int - Derrotas
	 */
	
	public int getQntDerrotas() {
		return qntDerrotas;
	}
	
	/**
	 * set qntGolsFeitos
	 * @author Weslley Barros
	 * @param qntDerrotas - Quantidade de derrotas
	 */
	
	public void setQntDerrotas(int qntDerrotas) {
		this.qntDerrotas = qntDerrotas;
	}
	
	/**
	 * get QntGolsFeitos
	 * @author Weslley Barros
	 * @return int - quantidade de gols feitos
	 */
	
	public int getQntGolsFeitos() {
		return qntGolsFeitos;
	}
	
	/**
	 * set qntGolsFeitos
	 * @author Weslley Barros
	 * @param qntGolsFeitos - Quantidade de gols feitos
	 */
	
	public void setQntGolsFeitos(int qntGolsFeitos) {
		this.qntGolsFeitos = qntGolsFeitos;
	}
	
	/**
	 * get QntGolsSofridos
	 * @author Weslley Barros
	 * @return int - Gols sofridos
	 */
	
	public int getQntGolsSofridos() {
		return qntGolsSofridos;
	}
	
	/**
	 * set qntGolsSofridos
	 * @author Weslley Barros
	 * @param qntGolsSofridos - Quantidade de gols sofridos
	 */
	
	public void setQntGolsSofridos(int qntGolsSofridos) {
		this.qntGolsSofridos = qntGolsSofridos;
	}
	
	/**
	 * get QntJogos
	 * @author Weslley Barros
	 * @return int - Quantidade de jogos
	 */
	
	public int getQntJogos() {
		return qntJogos;
	}
	
	/**
	 * set qntJogos
	 * @author Weslley Barros
	 * @param qntJogos - Quantidade de jogos
	 */
	
	public void setQntJogos(int qntJogos) {
		this.qntJogos = qntJogos;
	}
	
	/**
	 * get Pontos
	 * @author Weslley Barros
	 * @return int - Quantidade de pontos
	 */
	
	public int getPontos() {

		return (qntVitorias * 3) + qntEmpates;
	}
	
	/**
	 * get Nome
	 * @author Weslley Barros
	 * @return String - nome
	 */
	
	public String getNome() {
		return nome;
	}
	
	/**
	 * set Nome
	 * @author Weslley Barros
	 * @param nome - nome do time
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
