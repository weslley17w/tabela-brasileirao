package model;

import java.util.ArrayList;
import java.util.Comparator;

/**
*
* Classe responsável por gerenciar times, jogadores e técnicos
*
* @author  Weslley Barros
* @version 1.0
*/

public class Database {
	
	private static Database uniqueInstance = new Database();
	ArrayList<Time> times = new ArrayList<>();
	ArrayList<Tecnico> tecnicos = new ArrayList<>();
	ArrayList<Jogador> jogadores = new ArrayList<>();

	
	private Database() {}
	
	/**
	 * set UniqueInstance
	 * @author Weslley Barros
	 * @param uniqueInstance - uniqueInstance
	 */
	public static void setUniqueInstance(Database uniqueInstance) {
		Database.uniqueInstance = uniqueInstance;
	}
	
	/**
	 * get UniqueInstance
	 * @author Weslley Barros
	 * @return uniqueInstance
	 */
	public static Database getInstance() {
		return uniqueInstance;
	}
	
	/**Obter todos jogadores
	 * @author Weslley Barros
	 * @return ArrayList - Lista de contendo todos jogadores
	 */
	
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	/**Oobter todos tecnicos
	 * @author Weslley Barros
	 * @return ArrayList - Lista de contendo todos técnicos
	 */
	
	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}
	
	/**Obter um tecnico pelo nome
	 * @author Weslley Barros
	 * @param nome String - Nome do técnico.
	 * @return Tecnico - técnico 
	 */
	
	public Tecnico getTecnicos(String nome) {
		Tecnico saida = null;
		for (Tecnico tecnico : tecnicos) {

			if (tecnico.getNome() == nome) {
				saida = tecnico;
				break;
			}
		}

		return saida;

	}
	
	/**Obter um jogador pelo nome
	 * @author Weslley Barros
	 * @param nome String - Nome do técnico.
	 * @return Jogador - jogador 
	 */
	
	public Jogador getJogadores(String nome) {
		Jogador saida = null;
		for (Jogador jogador : jogadores) {

			if (jogador.getNome() == nome) {
				saida = jogador;
				break;
			}
		}

		return saida;

	}
	
	/**
	 * Pesquisar um jogador pelo nome
	 * @author Weslley Barros
	 * @param nome String - Nome do jogador.
	 * @return Jogador - jogador
	 */
	
	public ArrayList<Jogador> findJogador(String nome) {
		ArrayList<Jogador> listPesquisa = new ArrayList<>();
		this.ordenarJogadores("ASC");
		
		for (Jogador jogador : jogadores) {
			boolean cotains = jogador.getNome().indexOf(nome) !=-1? true: false;
			if (cotains) {
				listPesquisa.add(jogador);
			}
		}
		
		return listPesquisa;

	}
	
	/**
	 * Remove o jogador
	 * @author Weslley Barros
	 * @param jogador Jogador - jogador.
	 */
	
	public void removeJogador(model.Jogador jogador) {
		jogadores.remove(jogador);
	}
	
	/**
	 * Remove o técnico
	 * @author Weslley Barros
	 * @param tecnico Tecnico - tecnico.
	 */
	
	public void removeTecnico(model.Tecnico tecnico) {
		tecnicos.remove(tecnico);
	}
	
	/**
	 * Adiciona um técnico
	 * @author Weslley Barros
	 * @param tecnico Tecnico - tecnico.
	 */
	
	public void adicionarTecnico(Tecnico tecnico) {
		tecnicos.add(tecnico);
	}
	
	/**
	 * Adiciona um jogador
	 * @author Weslley Barros
	 * @param jogador Jogador - jogador.
	 */
	
	public void adicionarJogador(Jogador jogador) {
		jogadores.add(jogador);
	}
	
	/**Obter todos time
	 * @author Weslley Barros
	 * @return ArrayList - times 
	 */
	
	public ArrayList<Time> getTimes() {
		return times;
	}
	
	/**Obter um time pelo nome
	 * @author Weslley Barros
	 * @param nome String - Nome do técnico.
	 * @return Jogador - jogador 
	 */
	
	public Time getTime(String nome) {
		Time saida = null;
		for (Time time : times) {

			if (time.getNome() == nome) {
				saida = time;
				break;
			}
		}
		
		return saida;
	}
	
	/**Adiciona um time
	 * @author Weslley Barros
	 * @param time Time - Nome do time.
	 */
	public void adicionarTime(Time time) {
		times.add(time);
	}

	/**Ordena os times com o seguinte critério: mais pontos, Qnt. de vitórias, Saldo de gols e Qnt de gols feitos.
	 * @author Weslley Barros
	 */
	public void ordenarTabela() {
		times.sort(Comparator.comparing(Time::getQntGolsFeitos).reversed());
		times.sort(Comparator.comparing(Time::getSaldoGols).reversed());
		times.sort(Comparator.comparing(Time::getQntVitorias).reversed());
		times.sort(Comparator.comparing(Time::getPontos).reversed());
	}
	
	/**Ordena os times em ordem alfabética, alfabética-invertida  ou pelo cristeiro do brasileirão
	 * @author Weslley Barros
	 * @param order String - ASC = ordem alfabetica e DESC = ordem alfabética-invertida.
	 */
	public void ordenarTabela(String order) {
		if (order == "ASC") {
			tecnicos.sort(Comparator.comparing(Tecnico::getNome));
		} else if (order == "DESC") {
			tecnicos.sort(Comparator.comparing(Tecnico::getNome).reversed());
		} else {
			tecnicos.sort(Comparator.comparing(Tecnico::getQntJogos).reversed());
			tecnicos.sort(Comparator.comparing(Tecnico::getAproveitamento).reversed());
		}
	}
	
	/**
	 * Ordena os jogadores em ordem alfabética
	 * @author Weslley Barros
	 */
	public void ordenarJogadores() {
		jogadores.sort(Comparator.comparing(Jogador::getQntGols).reversed());	
	}
	
	/**
	 * Ordena os jogadores em ordem alfabética ou alfabética-invertida 
	 * @author Weslley Barros
	 * @param order String - ASC = ordem alfabetica e DESC = ordem alfabética-invertida.
	 */
	public void ordenarJogadores(String order) {
		if (order == "ASC") {
			jogadores.sort(Comparator.comparing(Jogador::getNome));
		} else if (order == "DESC") {
			jogadores.sort(Comparator.comparing(Jogador::getNome).reversed());
		} else {
			jogadores.sort(Comparator.comparing(Jogador::getQntGols).reversed());
		}
	}
	
	/**
	 * Ordena os tecnicos em ordem alfabética
	 * @author Weslley Barros
	 */
	
	public void ordenarTecnico() {
		tecnicos.sort(Comparator.comparing(Tecnico::getQntJogos).reversed());
		tecnicos.sort(Comparator.comparing(Tecnico::getAproveitamento).reversed());
	}
	
	/**
	 * Ordena os tecnicos em ordem alfabética ou alfabética-invertida 
	 * @author Weslley Barros
	 * @param order String - ASC = ordem alfabetica e DESC = ordem alfabética-invertida.
	 */
	public void ordenarTecnico(String order) {
		if (order == "ASC") {
			times.sort(Comparator.comparing(Time::getNome));
		} else if (order == "DESC") {
			times.sort(Comparator.comparing(Time::getNome).reversed());
		} else {
			tecnicos.sort(Comparator.comparing(Tecnico::getQntJogos).reversed());
			tecnicos.sort(Comparator.comparing(Tecnico::getAproveitamento).reversed());
		}
	}
	
	/**
	 * povoar o banco de dados com dados para desenvolvimento
	 * @author Weslley Barros
	 * @deprecated
	 */
	
	public void init() {

		model.Jogador cano = new Jogador("Cano", "Argentino", "xx/xx/xxxx", 500000f, 300000000f, 13, false);
		model.Jogador raul = new Jogador("Pedro Raul", "Brasileiro", "xx/xx/xxxx", 50000f, 300000f, 12, true);
		model.Jogador bissoli = new Jogador("Bissoli", "Brasileiro", "xx/xx/xxxx", 50000f, 300000f, 11, false);
		model.Jogador calleri = new Jogador("Calleri", "Argentino", "xx/xx/xxxx", 50000f, 300000f, 11, false);

		this.adicionarJogador(cano);
		this.adicionarJogador(raul);
		this.adicionarJogador(bissoli);
		this.adicionarJogador(calleri);

		model.Tecnico weslley = new model.Tecnico("Jose", "Brasileiro", "14/04/1998", 10333f, 333333.4f, true,
				false, 10, 10, 0);

		model.Tecnico vagner = new model.Tecnico("Vagner Mancini", "Brasileiro", "24/08/1966", 100333f, 11333333.4f,
				true, false, 4, 0, 1);

		model.Tecnico diniz = new model.Tecnico("Fernando Diniz", "Brasileiro", "27/03/1974", 1222233f, 1132233333.4f,
				true, true, 12, 0, 0);

		model.Tecnico dorival = new model.Tecnico("Dorival Júnior", "Brasileiro", "25/04/1962", 122233f,
				113226554333.4f, true, false, 3, 0, 0);

		this.adicionarTecnico(weslley);
		this.adicionarTecnico(vagner);
		this.adicionarTecnico(diniz);
		this.adicionarTecnico(dorival);

		// Atualizado: 24ª RODADA

		Time americamg = new Time("América-MG", 24, 9, 5, 10, 20, 25);
		this.adicionarTime(americamg);

		Time athleticopr = new Time("Athletico-PR", 24, 11, 6, 7, 29, 28);
		this.adicionarTime(athleticopr);

		Time atlaticogo = new Time("Atlético-GO", 24, 5, 7, 12, 23, 36);
		this.adicionarTime(atlaticogo);

		Time atlaticomg = new Time("Atlético-MG", 24, 9, 9, 6, 31, 28);
		this.adicionarTime(atlaticomg);

		Time avai = new Time("Avaí", 24, 6, 5, 13, 23, 37);
		this.adicionarTime(avai);

		Time botafogo = new Time("Botafogo", 24, 7, 6, 11, 22, 29);
		this.adicionarTime(botafogo);

		Time bragantino = new Time("Bragantino", 23, 8, 7, 8, 33, 29);
		this.adicionarTime(bragantino);

		Time ceara = new Time("Ceará", 24, 5, 12, 7, 23, 24);
		this.adicionarTime(ceara);

		Time corinthians = new Time("Corinthians", 23, 11, 6, 6, 26, 22);
		this.adicionarTime(corinthians);

		Time coritiba = new Time("Coritiba", 24, 7, 4, 13, 26, 39);
		this.adicionarTime(coritiba);

		Time cuiaba = new Time("Cuiabá", 24, 6, 7, 11, 16, 23);
		this.adicionarTime(cuiaba);

		Time flamengo = new Time("Flamengo", 24, 13, 4, 7, 39, 20);
		this.adicionarTime(flamengo);

		Time fluminense = new Time("Fluminense", 24, 12, 6, 6, 38, 28);
		this.adicionarTime(fluminense);

		Time fortaleza = new Time("Fortaleza", 24, 8, 6, 10, 22, 23);
		this.adicionarTime(fortaleza);

		Time goias = new Time("Goiás", 24, 8, 8, 8, 26, 30);
		this.adicionarTime(goias);

		Time internacional = new Time("Internacional", 23, 10, 9, 4, 34, 23);
		this.adicionarTime(internacional);

		Time juventude = new Time("Juventude", 23, 3, 8, 12, 18, 37);
		this.adicionarTime(juventude);

		Time palmeiras = new Time("Palmeiras", 24, 14, 8, 2, 39, 16);
		this.adicionarTime(palmeiras);

		Time santos = new Time("Santos", 24, 8, 10, 6, 27, 20);
		this.adicionarTime(santos);

		Time saoPaulo = new Time("São Paulo", 24, 6, 11, 7, 31, 29);
		this.adicionarTime(saoPaulo);

	}
}
