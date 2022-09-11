package test.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import controller.Jogador;
import model.Database;

class JogadorTest {

	@Test
	void cadatrarJogador() {
		Jogador jogador = new Jogador();
		int correto = jogador.cadastrar("Weslley", "Brasileiro", "17/04/2020", "100000", "100000", "23", "Sim");
		int camposvazios = jogador.cadastrar("Weslley", "", "17/04/2020", "", "100000", "23", "Sim");
		int camposfloat = jogador.cadastrar("Weslley", "Brasileiro", "17/04/2020", "20 mil", "1 milhão", "23", "Sim");
		int camposint = jogador.cadastrar("Weslley", "Brasileiro", "17/04/2020", "100000", "100000", "gol", "Sim");
		assertEquals(correto, 0);
		assertEquals(camposvazios, 2);
		assertEquals(camposfloat, 3);
		assertEquals(camposint, 4);
	}

	@Test
	void editarJogador() {

		Jogador jogador = new Jogador();
		int cadastrar = jogador.cadastrar("Weslley", "Brasileiro", "17/04/2020", "100000", "100000", "23", "Sim");
		Database db = Database.getInstance();
		model.Jogador weslley = db.getJogadores("Weslley");
		int correto = jogador.editar(weslley, "José", "Brasileiro", "17/04/2020", "1234", "100000", "23", "Sim");
		int camposvazios = jogador.editar(weslley, "José", "", "17/04/2020", "", "1", "23", "Sim");
		int camposfloat = jogador.editar(weslley, "José", "Brasileiro", "17/04/2020", "20 mil", "1 milhão", "23",
				"Sim");
		int camposint = jogador.editar(weslley, "Jos", "Brasileiro", "17/04/2020", "100000", "12344", "gol", "Sim");
		model.Jogador jose = db.getJogadores("Jos");
		
		assertEquals(cadastrar, 0);
		assertEquals(correto, 0);
		assertEquals(camposvazios, 2);
		assertEquals(camposfloat, 3);
		assertEquals(camposint, 4);
		assertEquals(jose.getNome(), "Jos");

	}

	void deletarJogador() {

		Jogador jogador = new Jogador();
		jogador.cadastrar("Weslley", "Brasileiro", "17/04/2020", "100000", "100000", "23", "Sim");
		Database db = Database.getInstance();
		model.Jogador weslley = db.getJogadores("Weslley");

		assertEquals(weslley.getNome(), "Weslley");
		db.removeJogador(weslley);
		weslley = db.getJogadores("Weslley");
		assertEquals(weslley, null);
		
	}

}
