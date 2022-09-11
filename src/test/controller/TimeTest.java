package test.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import controller.Time;
import model.Database;

public class TimeTest {
	
	@Test
	void cadatrarTime() {
		Time time = new Time();
		int correto = time.cadastrar("Fluminense", "30", "12", "8", "10", "12", "2");
		int camposvazios = time.cadastrar("Fluminense 1", "", "12", "8", "10", "12", "2");
		int camposint = time.cadastrar("Fluminense 2", "30", "12", "8", "10 gols", "12", "2");
		Database db = Database.getInstance();
		model.Time fluminense = db.getTime("Fluminense");
		assertEquals(correto, 0);
		assertEquals(camposvazios, 2);
		assertEquals(camposint, 3);
		assertEquals(fluminense.getQntVitorias(), 12);	
	}
	
	@Test
	void editarTime() {
		Time time = new Time();
		int correto = time.cadastrar("Fluminense", "30", "12", "8", "10", "12", "2");
		int camposvazios = time.cadastrar("Fluminense 1", "", "12", "8", "10", "12", "2");
		int camposint = time.cadastrar("Fluminense 2", "30", "12", "8", "10 gols", "12", "2");
		Database db = Database.getInstance();
		model.Time fluminense = db.getTime("Fluminense");
		assertEquals(correto, 0);
		assertEquals(camposvazios, 2);
		assertEquals(camposint, 3);
		assertEquals(fluminense.getQntVitorias(), 12);	
	}
	
}
