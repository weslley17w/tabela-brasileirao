package controller;

import java.util.ArrayList;

import model.Time;

public class Tabela {
	private model.Database tabela = model.Database.getInstance();
	
	public ArrayList<Time> getDados() {
		tabela.ordenarTabela();
		return tabela.getTimes();	
	}
}
