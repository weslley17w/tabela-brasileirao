package model;

import java.util.ArrayList;
import java.util.Comparator;

public class Database {
	private static Database uniqueInstance = new Database();
	ArrayList<Time> times = new ArrayList<>();
	ArrayList<Tecnico> tecnicos = new ArrayList<>();
	ArrayList<Jogador> jogadores = new ArrayList<>();

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public Tecnico getTecnico(String id) {
		Tecnico saida = null;
		for (Tecnico tecnico : tecnicos) {

			if (tecnico.getUuid() == id) {
				saida = tecnico;
				break;
			}
		}

		return saida;

	}

	public Tecnico updateTecnico(String id, String nome, String nacionalidade, String dtNascimento, float salario,
			float multa, boolean licencaCBF, Boolean licencaInternacional, int qntVitorias, int qntEmpates,
			int qntDerrotas) {
		Tecnico saida = null;
		for (Tecnico tecnico : tecnicos) {

			if (tecnico.getUuid() == id) {
				tecnico.setNome(nome);
				tecnico.setNacionalidade(nacionalidade);
				tecnico.setDtNascimento(dtNascimento);
				tecnico.setSalario(salario);
				tecnico.setMulta(multa);
				tecnico.setLicencaCBF(licencaCBF);
				tecnico.setLicencaInternacional(licencaInternacional);
				tecnico.setQntVitorias(qntVitorias);
				tecnico.setQntEmpates(qntEmpates);
				tecnico.setQntDerrotas(qntDerrotas);
				saida = tecnico;
				break;
			}
		}

		return saida;
	}

	public Jogador getJogador(String id) {
		Jogador saida = null;
		for (Jogador jogador : jogadores) {

			if (jogador.getUuid() == id) {
				saida = jogador;
				break;
			}
		}

		return saida;

	}

	public Jogador updateJogador(String id, String nome, String nacionalidade, String dtNascimento, float salario,
			float multa, int qntGols, boolean passaporteEuropeu) {
		Jogador saida = null;
		for (Jogador jogador : jogadores) {

			if (jogador.getUuid() == id) {
				jogador.setNome(nome);
				jogador.setNacionalidade(nacionalidade);
				jogador.setDtNascimento(dtNascimento);
				jogador.setSalario(salario);
				jogador.setMulta(multa);
				jogador.setQntGols(qntGols);
				jogador.setPassaporteEuropeu(passaporteEuropeu);
				saida = jogador;
				break;
			}

		}

		return saida;

	}
	
	public Time updateTime(String timeid, String nome, int qntJogos, int qntVitorias, 
			int qntEmpates, int qntDerrotas, int qntGolsFeitos, int qntGolsSofridos) {
		Time saida = null;
		for (Time time : times) {

			if (time.getUuid() == timeid) {
				time.setNome(nome);
				time.setQntJogos(qntJogos);
				time.setQntVitorias(qntVitorias);
				time.setQntEmpates(qntEmpates);
				time.setQntDerrotas(qntDerrotas);
				time.setQntGolsFeitos(qntGolsFeitos);
				time.setQntGolsSofridos(qntGolsSofridos);
				saida = time;
				break;
			}

		}

		return saida;
	}

	public void adicionarTecnico(Tecnico tecnico) {
		tecnicos.add(tecnico);
	}

	public void adicionarJogador(Jogador jogador) {
		jogadores.add(jogador);
	}

	private Database() {
	}

	public static void setUniqueInstance(Database uniqueInstance) {
		Database.uniqueInstance = uniqueInstance;
	}

	public static Database getInstance() {
		return uniqueInstance;
	}

	public ArrayList<Time> getTimes() {
		return times;
	}
	
	public Time getTime(String id) {
		Time saida = null;
		for (Time time : times) {

			if (time.getUuid() == id) {
				saida = time;
				break;
			}
		}
		
		return saida;

	}

	public void adicionarTime(Time time) {
		times.add(time);
	}

	public void ordenarTabela() {
		times.sort(Comparator.comparing(Time::getQntGolsFeitos).reversed());
		times.sort(Comparator.comparing(Time::getSaldoGols).reversed());
		times.sort(Comparator.comparing(Time::getQntVitorias).reversed());
		times.sort(Comparator.comparing(Time::getPontos).reversed());
	}

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
	
	public void ordenarJogadores() {
		jogadores.sort(Comparator.comparing(Jogador::getQntGols).reversed());	
	}

	public void ordenarJogadores(String order) {
		if (order == "ASC") {
			jogadores.sort(Comparator.comparing(Jogador::getNome));
		} else if (order == "DESC") {
			jogadores.sort(Comparator.comparing(Jogador::getNome).reversed());
		} else {
			jogadores.sort(Comparator.comparing(Jogador::getQntGols).reversed());
		}
	}

	public void ordenarTecnico() {
		tecnicos.sort(Comparator.comparing(Tecnico::getQntJogos).reversed());
		tecnicos.sort(Comparator.comparing(Tecnico::getAproveitamento).reversed());
	}

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
