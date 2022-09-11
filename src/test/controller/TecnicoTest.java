package test.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.Database;
import controller.Tecnico;

public class TecnicoTest {
	
	@Test
	void cadatrarTime() {
		controller.Tecnico tecnico = new controller.Tecnico();
		int correto = tecnico.cadastrar("Weslley", "xx/xx/xxxx", "Brasileiro", "2000000.12", "100000000000",
				"Sim", "Não", "12","32", "1");
		int camposvazios = tecnico.cadastrar("Weslley", "", "Brasileiro", "2000000.12", "100000000000",
				"Sim", "Não", "12","32", "1");
		int camposfloat = tecnico.cadastrar("Weslley", "", "Brasileiro", "vinte mil", "100000000000",
				"Sim", "Não", "12","32", "1");
		
		int camposint = tecnico.cadastrar("Weslley", "xx/xx/xxxx", "Brasileiro", "2000000.12", "100000000000",
				"Sim", "Não", "duas","32", "1");
		
		model.Database db = model.Database.getInstance();
		model.Tecnico weslley = db.getTecnicos("Weslley");
		assertEquals(correto, 0);
		assertEquals(camposvazios, 2);
		assertEquals(camposfloat, 3);
		assertEquals(camposfloat, 3);
		assertEquals(camposint, 4);
	}
	

	@Test
	void editarTime() {
		model.Database db = model.Database.getInstance();
		controller.Tecnico tecnico = new controller.Tecnico();
		int correto = tecnico.cadastrar("Weslley", "xx/xx/xxxx", "Brasileiro", "2000000.12", "100000000000",
				"Sim", "Não", "12","32", "1");
		assertEquals(correto, 0);
		model.Tecnico weslley = db.getTecnicos("Weslley");
		assertEquals(weslley.getNacionalidade(), "Brasileiro");	
		tecnico.update(weslley, "Weslley", "xx/xx/xxxx", "Argentino", "2000000.12", "100000000000",
				"Sim", "Não", "12","32", "1");
		assertEquals(weslley.getNacionalidade(), "Argentino");	
	}
}
