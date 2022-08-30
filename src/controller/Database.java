package controller;

import model.Tabela;
import model.Time;

public class Database {

	private Tabela tabela;

	public void init() {

		// Atualizado: 24ª RODADA

		this.tabela = Tabela.getInstance();
		tabela.setNome("Brasileirão");

		// América-MG

		Time americamg = new Time("América-MG");
		americamg.setQntJogos(24);
		americamg.setQntVitorias(9);
		americamg.setQntEmpates(5);
		americamg.setQntDerrotas(10);
		americamg.setQntGolsFeitos(20);
		americamg.setQntGolsSofridos(25);
		tabela.adicionarTime(americamg);

		// Athletico-PR

		Time athleticopr = new Time("Athletico-PR");
		athleticopr.setQntJogos(24);
		athleticopr.setQntVitorias(11);
		athleticopr.setQntEmpates(6);
		athleticopr.setQntDerrotas(7);
		athleticopr.setQntGolsFeitos(29);
		athleticopr.setQntGolsSofridos(28);
		tabela.adicionarTime(athleticopr);

		// Atlético-GO
		Time atlaticogo = new Time("Atlético-GO");
		atlaticogo.setQntJogos(24);
		atlaticogo.setQntVitorias(5);
		atlaticogo.setQntEmpates(7);
		atlaticogo.setQntDerrotas(12);
		atlaticogo.setQntGolsFeitos(23);
		atlaticogo.setQntGolsSofridos(36);
		tabela.adicionarTime(atlaticogo);

		// Atlético-MG
		Time atlaticomg = new Time("Atlético-MG");
		atlaticomg.setQntJogos(24);
		atlaticomg.setQntVitorias(9);
		atlaticomg.setQntEmpates(9);
		atlaticomg.setQntDerrotas(6);
		atlaticomg.setQntGolsFeitos(31);
		atlaticomg.setQntGolsSofridos(28);
		tabela.adicionarTime(atlaticomg);

		// Avaí
		Time avai = new Time("Avaí");
		avai.setQntJogos(24);
		avai.setQntVitorias(6);
		avai.setQntEmpates(5);
		avai.setQntDerrotas(13);
		avai.setQntGolsFeitos(23);
		avai.setQntGolsSofridos(37);
		tabela.adicionarTime(avai);

		// Botafogo
		Time botafogo = new Time("Botafogo");
		botafogo.setQntJogos(24);
		botafogo.setQntVitorias(7);
		botafogo.setQntEmpates(6);
		botafogo.setQntDerrotas(11);
		botafogo.setQntGolsFeitos(22);
		botafogo.setQntGolsSofridos(29);
		tabela.adicionarTime(botafogo);

		// Bragantino
		Time bragantino = new Time("Bragantino");
		bragantino.setQntJogos(23);
		bragantino.setQntVitorias(8);
		bragantino.setQntEmpates(7);
		bragantino.setQntDerrotas(8);
		bragantino.setQntGolsFeitos(33);
		bragantino.setQntGolsSofridos(29);
		tabela.adicionarTime(bragantino);

		// Ceará
		Time ceara = new Time("Ceará");
		ceara.setQntJogos(24);
		ceara.setQntVitorias(5);
		ceara.setQntEmpates(12);
		ceara.setQntDerrotas(7);
		ceara.setQntGolsFeitos(23);
		ceara.setQntGolsSofridos(24);
		tabela.adicionarTime(ceara);

		// Corinthians
		Time corinthians = new Time("Corinthians");
		corinthians.setQntJogos(23);
		corinthians.setQntVitorias(11);
		corinthians.setQntEmpates(6);
		corinthians.setQntDerrotas(6);
		corinthians.setQntGolsFeitos(26);
		corinthians.setQntGolsSofridos(22);
		tabela.adicionarTime(corinthians);

		// Coritiba
		Time coritiba = new Time("Coritiba");
		coritiba.setQntJogos(24);
		coritiba.setQntVitorias(7);
		coritiba.setQntEmpates(4);
		coritiba.setQntDerrotas(13);
		coritiba.setQntGolsFeitos(26);
		coritiba.setQntGolsSofridos(39);
		tabela.adicionarTime(coritiba);

		// Cuiabá
		Time cuiaba = new Time("Cuiabá");
		cuiaba.setQntJogos(24);
		cuiaba.setQntVitorias(6);
		cuiaba.setQntEmpates(7);
		cuiaba.setQntDerrotas(11);
		cuiaba.setQntGolsFeitos(16);
		cuiaba.setQntGolsSofridos(23);
		tabela.adicionarTime(cuiaba);

		// Flamengo
		Time flamengo = new Time("Flamengo");
		flamengo.setQntJogos(24);
		flamengo.setQntVitorias(13);
		flamengo.setQntEmpates(4);
		flamengo.setQntDerrotas(7);
		flamengo.setQntGolsFeitos(39);
		flamengo.setQntGolsSofridos(20);
		tabela.adicionarTime(flamengo);

		// Fluminense
		Time fluminense = new Time("Fluminense");
		fluminense.setQntJogos(24);
		fluminense.setQntVitorias(12);
		fluminense.setQntEmpates(6);
		fluminense.setQntDerrotas(6);
		fluminense.setQntGolsFeitos(38);
		fluminense.setQntGolsSofridos(28);
		tabela.adicionarTime(fluminense);

		// Fortaleza
		Time fortaleza = new Time("Fortaleza");
		fortaleza.setQntJogos(24);
		fortaleza.setQntVitorias(8);
		fortaleza.setQntEmpates(6);
		fortaleza.setQntDerrotas(10);
		fortaleza.setQntGolsFeitos(22);
		fortaleza.setQntGolsSofridos(23);
		tabela.adicionarTime(fortaleza);

		// Goiás
		Time goias = new Time("Goiás");
		goias.setQntJogos(24);
		goias.setQntVitorias(8);
		goias.setQntEmpates(8);
		goias.setQntDerrotas(8);
		goias.setQntGolsFeitos(26);
		goias.setQntGolsSofridos(30);
		tabela.adicionarTime(goias);

		// Internacional
		Time internacional = new Time("Internacional");
		internacional.setQntJogos(23);
		internacional.setQntVitorias(10);
		internacional.setQntEmpates(9);
		internacional.setQntDerrotas(4);
		internacional.setQntGolsFeitos(34);
		internacional.setQntGolsSofridos(23);
		tabela.adicionarTime(internacional);

		// Juventude
		Time juventude = new Time("Juventude");
		juventude.setQntJogos(23);
		juventude.setQntVitorias(3);
		juventude.setQntEmpates(8);
		juventude.setQntDerrotas(12);
		juventude.setQntGolsFeitos(18);
		juventude.setQntGolsSofridos(37);
		tabela.adicionarTime(juventude);

		// Palmeiras
		Time palmeiras = new Time("Palmeiras");
		palmeiras.setQntJogos(24);
		palmeiras.setQntVitorias(14);
		palmeiras.setQntEmpates(8);
		palmeiras.setQntDerrotas(2);
		palmeiras.setQntGolsFeitos(39);
		palmeiras.setQntGolsSofridos(16);
		tabela.adicionarTime(palmeiras);

		// Santos
		Time santos = new Time("Santos");
		santos.setQntJogos(24);
		santos.setQntVitorias(8);
		santos.setQntEmpates(10);
		santos.setQntDerrotas(6);
		santos.setQntGolsFeitos(27);
		santos.setQntGolsSofridos(20);
		tabela.adicionarTime(santos);

		// 
		Time saoPaulo = new Time("São Paulo");
		saoPaulo.setQntJogos(24);
		saoPaulo.setQntVitorias(6);
		saoPaulo.setQntEmpates(11);
		saoPaulo.setQntDerrotas(7);
		saoPaulo.setQntGolsFeitos(31);
		saoPaulo.setQntGolsSofridos(29);
		tabela.adicionarTime(saoPaulo);

	}
}
