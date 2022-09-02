package controller;
import model.Time;

import java.util.ArrayList;

public class Times {
	
	private model.Database tabela = model.Database.getInstance();
	
	public ArrayList<Time> getTimes() {
		this.tabela.ordenarTabela("ASC");
		return this.tabela.getTimes();  
	}
}
